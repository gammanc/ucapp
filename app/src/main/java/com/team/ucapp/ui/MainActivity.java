package com.team.ucapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.ExpedientFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationViewEx.OnNavigationItemSelectedListener{

    BottomNavigationViewEx bottomnavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViews();
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    private void findViews(){
        bottomnavigationView = findViewById(R.id.bottom_nav);
        bottomnavigationView.enableAnimation(false);
        bottomnavigationView.enableShiftingMode(false);
        bottomnavigationView.enableItemShiftingMode(false);
        bottomnavigationView.setTextVisibility(false);
        bottomnavigationView.setPadding(5,5,5,5);
        bottomnavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.item_home:
                //selectedFragment = new ExpedientFragment();
                break;
            case R.id.item_calendar:
                break;
            case R.id.item_grades:
                break;
        }
        /*if (selectedFragment!=null){
         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
         transaction.replace(R.id.main_content, selectedFragment);
         transaction.commit();
         return true;
         }*/
        return true;
    }


    public void startFragment(String title, Fragment frag){
        setTitle(title);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_content, frag);
        fragmentTransaction.commit();
    }
}
