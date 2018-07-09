package com.team.ucapp.ui.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;

import java.util.ArrayList;
import java.util.List;

public class UniversityCalendarFragment extends Fragment {

    Activity activity;
    CalendarAdapter calendarAdapter;
    RecyclerView universityListView;
    LinearLayoutManager lManager;
    List<EventDummy> universityList;
    public UniversityCalendarFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_university, container, false);

        universityListView = (RecyclerView) v.findViewById(R.id.university_calendar_list);
        universityListView.setHasFixedSize(true);

        setList();

        calendarAdapter = new CalendarAdapter(this, universityList);
        Log.d("GradesFragment", "Creo adapter ");
        universityListView.setAdapter(calendarAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        universityListView.setLayoutManager(lManager);

        return v;
    }

    private void setList() {

        EventDummy event1 = new EventDummy("Title1","19","MRZ","Description",1);
        EventDummy event2 = new EventDummy("Title2","21","JUN","Description",1);
        EventDummy event3 = new EventDummy("Title3","12","MAY","Description",1);
        EventDummy event4 = new EventDummy("Title4","1","ENE","Description",1);
        EventDummy event5 = new EventDummy("Title5","8","ABR","Description",1);
        EventDummy event6 = new EventDummy("Title6","23","MRZ","Description",1);
        EventDummy event7 = new EventDummy("Title7","14","MRZ","Description",1);

        universityList = new ArrayList<EventDummy>();
        universityList.add(event1);
        universityList.add(event2);
        universityList.add(event3);
        universityList.add(event4);
        universityList.add(event5);
        universityList.add(event6);
        universityList.add(event7);

        //calendarAdapter.setList(universityList);
        //calendarAdapter.notifyDataSetChanged();
    }


}
