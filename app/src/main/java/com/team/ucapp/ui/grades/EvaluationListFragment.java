package com.team.ucapp.ui.grades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.SubjectExpedient;

import java.util.ArrayList;
import java.util.List;

public class EvaluationListFragment extends Fragment {
    Activity activity;
    SubjectGradesDetailAdapter adapter;
    RecyclerView evaluationListView;
    LinearLayoutManager lManager;
    List<SubjectGrades> evaluationList;
    String subject;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) subject = getArguments().getString("SUBJECT");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluation_list, container, false);

        evaluationListView = (RecyclerView) view.findViewById(R.id.evaluation_list);
        evaluationListView.setHasFixedSize(true);


        //aqui tendria que llamarse la tabla que contiene las notes
        if(subject.equals("Redes de Computadoras")) setList();
        else setNewList();
       //setList();

        adapter = new SubjectGradesDetailAdapter(getContext(),evaluationList);
        Log.d("GradesFragment", "Creo adapter ");
        evaluationListView.setAdapter(adapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        evaluationListView.setLayoutManager(lManager);

        return view;
    }


    private void setList() {
        //if(evaluationList.isEmpty()) {
            SubjectGrades note1 = new SubjectGrades("Primera Evaluación Parcial", "19/04/18 - %15", "N/A");
            SubjectGrades note2 = new SubjectGrades("Segunda Evaluación Parcial", "19/04/18 - %15", "N/A");
            SubjectGrades note3 = new SubjectGrades("Corto 1", "19/04/18 - %15", "N/A");
            SubjectGrades note4 = new SubjectGrades("Corto 2", "19/04/18 - %15", "N/A");
            SubjectGrades note5 = new SubjectGrades("Corto 3", "19/04/18 - %15", "N/A");
            SubjectGrades note6 = new SubjectGrades("Parcial Final", "19/04/18 - %15", "N/A");
            SubjectGrades note7 = new SubjectGrades("Proyecto", "19/04/18 - %15", "N/A");

            evaluationList = new ArrayList<SubjectGrades>();
            evaluationList.add(note1);
            evaluationList.add(note2);
            evaluationList.add(note3);
            evaluationList.add(note4);
            evaluationList.add(note5);
            evaluationList.add(note6);
            evaluationList.add(note7);
        /*}else { evaluationList.clear();

            SubjectGrades note1 = new SubjectGrades("Primera Evaluación Parcial", "19/04/18 - %15", "N/A");
            SubjectGrades note2 = new SubjectGrades("Segunda Evaluación Parcial", "19/04/18 - %15", "N/A");
            SubjectGrades note3 = new SubjectGrades("Corto 1", "19/04/18 - %15", "N/A");
            SubjectGrades note4 = new SubjectGrades("Corto 2", "19/04/18 - %15", "N/A");
            SubjectGrades note5 = new SubjectGrades("Corto 3", "19/04/18 - %15", "N/A");
            SubjectGrades note6 = new SubjectGrades("Parcial Final", "19/04/18 - %15", "N/A");
            SubjectGrades note7 = new SubjectGrades("Proyecto", "19/04/18 - %15", "N/A");

            evaluationList = new ArrayList<SubjectGrades>();
            evaluationList.add(note1);
            evaluationList.add(note2);
            evaluationList.add(note3);
            evaluationList.add(note4);
            evaluationList.add(note5);
            evaluationList.add(note6);
            evaluationList.add(note7);

            adapter.setList(evaluationList);
            adapter.notifyDataSetChanged();
        }*/
    }

    private void setNewList() {

            SubjectGrades note1 = new SubjectGrades("Primera Evaluación Parcial","19/04/18 - (%15)","N/A");
            SubjectGrades note2 = new SubjectGrades("Segunda Evaluación Parcial","19/04/18 - (%15)","N/A");
            SubjectGrades note3 = new SubjectGrades("Corto 1","19/04/18 - (%15)","N/A");
            SubjectGrades note4 = new SubjectGrades("Corto 2","19/04/18 - (%15)","N/A");
            SubjectGrades note5 = new SubjectGrades("Corto 3","19/04/18 - (%15)","N/A");
            SubjectGrades note6 = new SubjectGrades("Lectura 1","19/04/18 - (%15)","N/A");
            SubjectGrades note7 = new SubjectGrades("Lectura 2","19/04/18 - (%15)","N/A");
            SubjectGrades note8 = new SubjectGrades("Parcial Final","19/04/18 - (%15)","N/A");
            SubjectGrades note9 = new SubjectGrades("Proyecto","19/04/18 - (%15)","N/A");

            evaluationList = new ArrayList<SubjectGrades>();
            evaluationList.add(note1);
            evaluationList.add(note2);
            evaluationList.add(note3);
            evaluationList.add(note4);
            evaluationList.add(note5);
            evaluationList.add(note6);
            evaluationList.add(note7);
            evaluationList.add(note8);
            evaluationList.add(note9);
    }

}
