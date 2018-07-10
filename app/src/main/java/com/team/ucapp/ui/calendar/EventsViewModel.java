package com.team.ucapp.ui.calendar;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.team.ucapp.data.EventRepository;
import com.team.ucapp.data.database.Event;

import java.util.List;

public class EventsViewModel extends ViewModel {
    private LiveData<List<Event>> eventList;
    private final EventRepository repository;

    public EventsViewModel( EventRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Event>> getLatestEvents(){
        eventList = repository.getEvents();
        return eventList;
    }

    public void refreshEvents(){
        eventList = repository.getEvents();
    }
}
