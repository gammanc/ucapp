package com.team.ucapp.ui.calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;
import com.team.ucapp.data.database.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalCalendarFragment extends Fragment {

    private static final String TAG = "PersonalCalendarFragment";

    CalendarAdapter calendarAdapter;
    RecyclerView personalListView;
    LinearLayoutManager lManager;
    List<Event> personalList;
    public PersonalCalendarFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personal, container, false);

        personalListView = v.findViewById(R.id.personal_calendar_list);
        personalListView.setHasFixedSize(true);

        setList();

        calendarAdapter = new CalendarAdapter(this, personalList);
        personalListView.setAdapter(calendarAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        personalListView.setLayoutManager(lManager);

        return v;
    }

    private void setList() {
        personalList = new ArrayList<>();
        for (int i=1;i<=10;i++){
            personalList.add(new Event(i,"Title "+i,new Date(),"This is a description",1));
        }
    }


}
