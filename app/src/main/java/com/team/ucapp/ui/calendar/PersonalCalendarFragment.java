package com.team.ucapp.ui.calendar;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.SubjectExpedient;
import com.team.ucapp.ui.grades.GradesAdapter;

import java.util.ArrayList;
import java.util.List;

public class PersonalCalendarFragment extends Fragment {

    private static final String TAG = "PersonalCalendarFragment";

    Activity activity;
    CalendarAdapter calendarAdapter;
    RecyclerView personalListView;
    LinearLayoutManager lManager;
    List<EventDummy> personalList;
    public PersonalCalendarFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personal, container, false);

        personalListView = (RecyclerView) v.findViewById(R.id.personal_calendar_list);
        personalListView.setHasFixedSize(true);

        setList();

        calendarAdapter = new CalendarAdapter(this, personalList);
        Log.d("GradesFragment", "Creo adapter ");
        personalListView.setAdapter(calendarAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        personalListView.setLayoutManager(lManager);

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

        personalList = new ArrayList<EventDummy>();
        personalList.add(event1);
        personalList.add(event2);
        personalList.add(event3);
        personalList.add(event4);
        personalList.add(event5);
        personalList.add(event6);
        personalList.add(event7);

        //calendarAdapter.setList(personalList);
        //calendarAdapter.notifyDataSetChanged();
    }


}
