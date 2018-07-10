package com.team.ucapp.utils;

import android.content.Context;

import com.team.ucapp.data.EventRepository;
import com.team.ucapp.data.database.AppDatabase;
import com.team.ucapp.data.network.NetworkDataSource;
import com.team.ucapp.ui.calendar.EventsViewModelFactory;

public class DependencyContainer {

    public static EventRepository getRepository(Context context){
        AppDatabase database = AppDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();

        NetworkDataSource networkDataSource =
                NetworkDataSource.getInstance(context.getApplicationContext(), executors);
        return EventRepository.getInstance(database.eventDao(),networkDataSource,executors);
    }

    public static NetworkDataSource getNetworkDataSource(Context context){
        AppExecutors executors = AppExecutors.getInstance();
        return NetworkDataSource.getInstance(context.getApplicationContext(), executors);
    }

    public static EventsViewModelFactory getEventViewModelFactory(Context context){
        EventRepository repository = getRepository(context.getApplicationContext());
        return new EventsViewModelFactory(repository);
    }
}
