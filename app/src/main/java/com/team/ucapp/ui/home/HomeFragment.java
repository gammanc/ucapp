package com.team.ucapp.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;
import com.team.ucapp.data.database.News;

import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {

    public HomeFragment() { }

    private static final String TAG = "HomeFragment";
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = v.findViewById(R.id.home_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        Log.d(TAG, "onCreateView: recycler setup");
        populateRecycler();

        return v;
    }

    private void populateRecycler(){
        ArrayList<Section> sections = new ArrayList<>();

        ArrayList<Object> news = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            news.add(new News(j+"",
                    "New "+j,
                    "This is a body",
                    "no_image","This is a description",
                    new Date()));
        }
        sections.add(new Section(1,"Noticias", news));

        ArrayList<Object> events = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            events.add(new EventDummy(
                    "Event "+j,"dd/MONTH/aaaa",
                    "Describing event",1));
        }
        sections.add(new Section(2,"Próximas actividades", events));

        HomeAdapter adapter = new HomeAdapter(getContext(), sections);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "populateRecycler: Datos añadidos");
    }

}
