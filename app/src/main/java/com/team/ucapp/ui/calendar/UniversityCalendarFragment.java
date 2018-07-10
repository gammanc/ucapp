package com.team.ucapp.ui.calendar;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;
import com.team.ucapp.data.database.Event;
import com.team.ucapp.utils.DependencyContainer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UniversityCalendarFragment extends Fragment {
    CalendarAdapter calendarAdapter;
    RecyclerView universityListView;
    List<Event> universityList = new ArrayList<>();
    EventsViewModel eventsViewModel;

    public UniversityCalendarFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_university, container, false);

        universityListView = v.findViewById(R.id.university_calendar_list);
        universityListView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        universityListView.setHasFixedSize(true);

        calendarAdapter = new CalendarAdapter(this, universityList);
        universityListView.setAdapter(calendarAdapter);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventsViewModelFactory factory = DependencyContainer.getEventViewModelFactory(getContext());
        eventsViewModel = ViewModelProviders.of(this, factory).get(EventsViewModel.class);

        eventsViewModel.getLatestEvents().observe(this, this::setList);
    }

    private void setList(List<Event> events) {
        universityList.clear();
        universityList.addAll(events);

        calendarAdapter.notifyDataSetChanged();
    }


}