package com.team.ucapp.ui.grades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class GradesFragment extends Fragment implements AdapterView.OnItemSelectedListener, GradesAdapter.GradesAdapterListener {

    Activity activity;
    GradesAdapter gradesAdapter;
    RecyclerView gradesListView;
    LinearLayoutManager lManager;
    List<SubjectExpedient> gradesList;
    Spinner semesterSpinner;


    public GradesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grades, container, false);
        semesterSpinner= (Spinner) view.findViewById(R.id.semester_options_spinner);
        ArrayAdapter<CharSequence> semesterAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semester_options_array, android.R.layout.simple_spinner_item);

        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(semesterAdapter);
        semesterSpinner.setOnItemSelectedListener(this);

        gradesListView = (RecyclerView) view.findViewById(R.id.subject_grades_list);
         gradesListView.setHasFixedSize(true);


        //aqui tendria que llamarse la tabla que contiene las notes
        setList();

        gradesAdapter = new GradesAdapter(this,gradesList);
        Log.d("GradesFragment", "Creo adapter ");
        gradesListView.setAdapter(gradesAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        gradesListView.setLayoutManager(lManager);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("GradesFragment", "onItemSelected: "+i);
        //Object option = adapterView.getItemAtPosition(i);
        if(i == 2)  {Log.d("GradesFragment", "selecciono 2 ");
            /*gradesList.clear();
            gradesAdapter.notifyDataSetChanged(); */setNewList();
        }
        else  setList();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

   private void setList() {
        //SubjectExpedient note1 = new SubjectExpedient("Programacion de Dispositivos Moviles","P","Primera Evaluación Parcial","19/04/18 - %15","N/A");
        //SubjectExpedient note2 = new SubjectExpedient("Analisis de Sistemas","A","Primera Evaluación Parcial","19/04/18 - %15","N/A");

        SubjectExpedient note1 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note2 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note3 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note4 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note5 = new SubjectExpedient("A","Analisis Numerico","N/A");
        SubjectExpedient note6 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note7 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note8 = new SubjectExpedient("A","Analisis de Sistemas","N/A");
        SubjectExpedient note9 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note10 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");

        gradesList = new ArrayList<SubjectExpedient>();
        gradesList.add(note1);
        gradesList.add(note2);
        gradesList.add(note3);
        gradesList.add(note4);
        gradesList.add(note5);
        gradesList.add(note6);
        gradesList.add(note7);
        gradesList.add(note8);
        gradesList.add(note9);
        gradesList.add(note10);
    }

    private void setNewList() {
        gradesList.clear();
        //SubjectExpedient note1 = new SubjectExpedient("Programacion de Dispositivos Moviles","P","Primera Evaluación Parcial","19/04/18 - %15","N/A");
        //SubjectExpedient note2 = new SubjectExpedient("Analisis de Sistemas","A","Primera Evaluación Parcial","19/04/18 - %15","N/A");
        Log.d("GradesFragment", "setNewList: Updating");
        SubjectExpedient note1 = new SubjectExpedient("A","Analisis de Sistemas","N/A");
        SubjectExpedient note2 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note3 = new SubjectExpedient("P","Redes de Computadoras","N/A");
        SubjectExpedient note4 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note5 = new SubjectExpedient("A","Analisis Numerico","N/A");
        SubjectExpedient note6 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note7 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        SubjectExpedient note8 = new SubjectExpedient("A","Analisis de Sistemas","N/A");
        SubjectExpedient note9 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note10 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        gradesList = new ArrayList<SubjectExpedient>();
        gradesList.add(note1);
        gradesList.add(note2);
        gradesList.add(note3);
        gradesList.add(note4);
        gradesList.add(note5);
        gradesList.add(note6);
        gradesList.add(note7);
        gradesList.add(note8);
        gradesList.add(note9);
        gradesList.add(note10);
        gradesAdapter.setList(gradesList);
        gradesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSubjectSelected(String subject) {
        Log.d("GradesFragment", "Subject" + subject);
        Bundle bundle = new Bundle(); //procesa la info que se enviara a traves del intent
        Intent newIntent = new Intent(getActivity().getApplicationContext(), SubjectGradesDetailActivity.class);
        bundle.putString("SUBJECT", subject);
        newIntent.putExtras(bundle);
        startActivity(newIntent);

        /*SubjectGradesDetailActivity frag = new SubjectGradesDetailActivity();
        frag.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.main_content, frag);
        fragmentTransaction.addToBackStack("option");
        fragmentTransaction.commit();*/
    }
}
