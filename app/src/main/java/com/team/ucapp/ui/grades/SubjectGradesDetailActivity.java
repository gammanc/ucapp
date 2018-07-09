package com.team.ucapp.ui.grades;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.ucapp.R;

public class SubjectGradesDetailActivity extends AppCompatActivity {

    String gradesDetail, subject, grade;
    LinearLayout header;
    TextView txtGrade;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_grades_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        header = (LinearLayout) findViewById(R.id.total_grade_header);
        txtGrade = findViewById(R.id.txt_grade);

        Bundle bundle = getIntent().getExtras();
        gradesDetail = bundle.getString("SUBJECT");
        subject= gradesDetail.split("-")[0];
        Log.d("SubjectDEtail", "se obtuvo string:" + subject);
        grade= gradesDetail.split("-")[1];

        //txtGrade.setText(grade);

       EvaluationListFragment frag = new EvaluationListFragment();
        frag.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.detail_content, frag);
        //fragmentTransaction.addToBackStack("option");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        setTitle(subject);
        super.onResume();
    }

}
