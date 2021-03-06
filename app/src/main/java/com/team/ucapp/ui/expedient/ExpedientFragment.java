package com.team.ucapp.ui.expedient;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;

import java.util.ArrayList;
import java.util.List;

public class ExpedientFragment extends Fragment {
    SubjectExpedientAdapter subjectExpedientAdapter;
    RecyclerView subjectExpedientListView;
    LinearLayoutManager lManager;
    List<SubjectExpedient> subjectsExpedient;
    private static final String TAG = "ExpedientFragment";

    public ExpedientFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expedient, container, false);

        subjectExpedientListView = view.findViewById(R.id.subject_expedient_list);
        subjectExpedientListView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(container.getContext());
        subjectExpedientListView.setLayoutManager(lManager);

        //aqui tendria que llamarse la tabla que contiene las notes
        setList();

        Log.d(TAG, "onCreateView: list size:"+subjectsExpedient.size());
        subjectExpedientAdapter = new SubjectExpedientAdapter(getContext(),subjectsExpedient);
        subjectExpedientListView.setAdapter(subjectExpedientAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        subjectExpedientListView.setNestedScrollingEnabled(false);
        return view;
    }

    private void setList() {
        SubjectExpedient note1 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","10");
        SubjectExpedient note2 = new SubjectExpedient("A","Analisis de Sistemas","9");
        SubjectExpedient note3 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note4 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","8");
        SubjectExpedient note5 = new SubjectExpedient("A","Analisis Numerico","N/A");
        SubjectExpedient note6 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note7 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note8 = new SubjectExpedient("A","Analisis de Sistemas","N/A");
        SubjectExpedient note9 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note10 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");

        subjectsExpedient = new ArrayList<>();
        subjectsExpedient.add(note1);
        subjectsExpedient.add(note2);
        subjectsExpedient.add(note3);
        subjectsExpedient.add(note4);
        subjectsExpedient.add(note5);
        subjectsExpedient.add(note6);
        subjectsExpedient.add(note7);
        subjectsExpedient.add(note8);
        subjectsExpedient.add(note9);
        subjectsExpedient.add(note10);
        Log.d(TAG, "setList: list size:"+subjectsExpedient.size());
    }

   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_settings, menu);
    }*/
}
