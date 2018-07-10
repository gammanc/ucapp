package com.team.ucapp.ui.calendar;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.team.ucapp.data.EventRepository;

public class EventsViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private final EventRepository repository;

    public EventsViewModelFactory(EventRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new EventsViewModel(repository);
    }
}
