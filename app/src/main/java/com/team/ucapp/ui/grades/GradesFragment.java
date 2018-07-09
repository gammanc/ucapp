package com.team.ucapp.ui.grades;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.SubjectExpedient;

import java.util.ArrayList;
import java.util.List;

public class GradesFragment extends Fragment implements AdapterView.OnItemSelectedListener, GradesAdapter.GradesAdapterListener {

    GradesAdapter gradesAdapter;
    RecyclerView gradesListView;
    LinearLayoutManager lManager;
    List<SubjectExpedient> gradesList;
    Spinner semesterSpinner;
    LinearLayout header;
    TextView txtSubject,txtGrade;


    public GradesFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grades, container, false);

        //Agregando opciones de ciclo
        semesterSpinner = view.findViewById(R.id.semester_options_spinner);
        ArrayAdapter<CharSequence> semesterAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semester_options_array, android.R.layout.simple_spinner_item);
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(semesterAdapter);
        semesterSpinner.setOnItemSelectedListener(this);

        header = view.findViewById(R.id.total_grade_header);
        txtSubject = view.findViewById(R.id.txt_subject);
        txtGrade = view.findViewById(R.id.txt_grade);

        gradesListView = view.findViewById(R.id.subject_grades_list);
        gradesListView.setHasFixedSize(true);

        //Se colocan las materias cursadas
        setList();

        gradesAdapter = new GradesAdapter(this,getResources(),gradesList);
        gradesListView.setAdapter(gradesAdapter); //se le asigna al recycler lo que procesa el adapter de la informacion
        lManager = new LinearLayoutManager(container.getContext());
        gradesListView.setLayoutManager(lManager);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         //header.setVisibility(View.VISIBLE);
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
        SubjectExpedient note2 = new SubjectExpedient("A","Análisis de sistemas","N/A");
        SubjectExpedient note3 = new SubjectExpedient("P","Probabilidad y Estadística","N/A");
        SubjectExpedient note4 = new SubjectExpedient("P","Programación de Dispositivos Móviles","N/A");
        SubjectExpedient note5 = new SubjectExpedient("A","Analisis Numérico","N/A");

        gradesList = new ArrayList<>();
        gradesList.add(note1);
        gradesList.add(note2);
        gradesList.add(note3);
        gradesList.add(note4);
        gradesList.add(note5);
    }

    private void setNewList() {
        gradesList.clear();
        Log.d("GradesFragment", "setNewList: Updating");
        SubjectExpedient note1 = new SubjectExpedient("A","Analisis de Sistemas","N/A");
        SubjectExpedient note2 = new SubjectExpedient("R","Redes de Computadoras","N/A");
        SubjectExpedient note3 = new SubjectExpedient("P","Redes de Computadoras","N/A");
        SubjectExpedient note4 = new SubjectExpedient("P","Programacion de Dispositivos Moviles","N/A");
        gradesList = new ArrayList<SubjectExpedient>();
        gradesList.add(note1);
        gradesList.add(note2);
        gradesList.add(note3);
        gradesList.add(note4);
        gradesAdapter.setList(gradesList);
        gradesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSubjectSelected(String subject, int position) {

        Bundle bundle = new Bundle(); //procesa la info que se enviara a traves del intent
        bundle.putString("SUBJECT", subject + "-" +  gradesList.get(position).getGrade());

        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE)) {

            txtSubject.setText(subject);
            txtGrade.setText(gradesList.get(position).getGrade());

            EvaluationListFragment frag = new EvaluationListFragment();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.detail_content, frag);
            fragmentTransaction.commit();
        } else {
            Log.d("GradesFragment", "Subject" + subject);
            Intent newIntent = new Intent(getActivity(), SubjectGradesDetailActivity.class);
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }
    }
}
