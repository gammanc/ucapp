package com.team.ucapp.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;

import java.util.ArrayList;

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
        for (int i = 1; i <= 2; i++) {
            ArrayList<Object> sectionItems = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                sectionItems.add(new EventDummy(
                        "Event "+j,"dd/MONTH/aaaa",
                        "Describing event",1));
            }
            sections.add(new Section("Section " + i, sectionItems));
        }
        Log.d(TAG, "populateRecycler: sections size "+sections.size());
        HomeAdapter adapter = new HomeAdapter(getContext(), sections);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "populateRecycler: Datos añadidos");
    }

}
