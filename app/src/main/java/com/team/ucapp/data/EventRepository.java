package com.team.ucapp.data;


import android.arch.lifecycle.LiveData;

import com.team.ucapp.data.database.Event;
import com.team.ucapp.data.database.EventDao;
import com.team.ucapp.data.network.NetworkDataSource;
import com.team.ucapp.utils.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {
    private static final String TAG = "EventRepository";

    private static EventRepository instance;
    private static final Object LOCK = new Object();

    private final EventDao eventDao;
    private final NetworkDataSource networkDataSource;
    private final AppExecutors executors;

    private EventRepository(EventDao eventDao,
                            NetworkDataSource networkDataSource,
                            AppExecutors executors){
        this.eventDao = eventDao;
        this.networkDataSource = networkDataSource;
        this.executors = executors;

        LiveData<ArrayList<Event>> updatedEvents = networkDataSource.getLatestsEvents();
        updatedEvents.observeForever(
                events -> this.executors.diskIO().execute(()->{
                    eventDao.deleteAll();
                    eventDao.insertEvents(events);
                })
        );
    }

    public synchronized static EventRepository getInstance(EventDao eventDao,
                                                           NetworkDataSource networkDataSource,
                                                           AppExecutors executors){
        if(instance == null){
            synchronized (LOCK){
                instance = new EventRepository(eventDao,networkDataSource, executors);
            }
        }
        return instance;
    }

    private synchronized void initializeData(){
        //networkDataSource.fetchUserDetails();
        networkDataSource.fetchEvents();
    }

    public LiveData<List<Event>> getEvents(){
        initializeData();
        return eventDao.getAll();
    }
}
