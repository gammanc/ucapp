package com.team.ucapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.ExpedientFragment;
import com.team.ucapp.ui.grades.GradesFragment;
import com.team.ucapp.ui.home.HomeFragment;
import com.team.ucapp.ui.calendar.CalendarFragment;

/**
 * Activity Principal
 * Maneja las operaciones con fragments del BottomNavigation
 * La navegación funciona de siguiente manera: Inicialmente se muestra al usuario
 * el fragment Home. Al tocar algún otro item, se cambia el fragment acorde a lo seleccionado.
 * Sólo los fragment que no son Home se agregan al backstack, así cuando el usuario esté en
 * alguna opción y presione atrás, lo retorne al fragment Home y al dar atrás de nuevo, salga
 * de la app.
 * Se trabajó así ya que Material se recomienda este comportamiento.
 **/
public class MainActivity extends AppCompatActivity
        implements BottomNavigationViewEx.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";

    BottomNavigationViewEx bottomnavigationView;

    private FragmentManager fragmentManager;
    private Fragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViews();

        fragmentManager = getSupportFragmentManager();
        // Manejando rotación
        // Se comprueba si el bundle contiene información, de ser así
        // es porque el dispositivo se ha girado
        if (savedInstanceState != null){
            if(savedInstanceState.containsKey("content")){
                String content = savedInstanceState.getString("content");
                //Se determina qué pantalla estaba activa, para volverla a mostrar
                if (content.equals("home") && fragmentManager.findFragmentByTag("home")!=null)
                    bottomnavigationView.setSelectedItemId(R.id.item_home);
                else if(content.equals("expedient") &&
                        fragmentManager.findFragmentByTag("expedient")!=null)
                    bottomnavigationView.setSelectedItemId(R.id.item_expedient);

            }
        }
        // Si el bundle está vacío, es porque se está inciando la aplicación
        // entonces se muestra la pantalla de inicio
        else {
            bottomnavigationView.setSelectedItemId(R.id.item_home);
        }
    }

    @Override
    //Invocada cuando la aplicación es girada
    public void onSaveInstanceState(Bundle outState) {
        // Se envía en el bundle información de qué pantalla estaba mostrándose
        if(contentFragment instanceof HomeFragment)
            outState.putString("content","home");
        else if(contentFragment instanceof ExpedientFragment)
            outState.putString("content","expedient");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        navigate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    // Invocada al hacer click en un elemento del BottomNavigation
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        String tag = "";
        switch (item.getItemId()){
            case R.id.item_home:
                selectedFragment = new HomeFragment();
                tag = "home";
                while (fragmentManager.popBackStackImmediate()); //clear the backstack
                break;
            case R.id.item_calendar:
                selectedFragment = new CalendarFragment();
                tag = "calendar";
                break;
            case R.id.item_expedient:
                selectedFragment = new ExpedientFragment();
                tag = "option";
                break;
            case R.id.item_grades:
                selectedFragment = new GradesFragment();
                tag = "grades";
                break;
        }
        if (selectedFragment!=null){
            switchContent(selectedFragment,tag);
            return true;
        }
        return true;
    }

    // Sirve como filtro para las operaciones de fragments
    public void switchContent(Fragment fragment, String tag) {
        // Cuando se lanza la aplicación, no hay contenido principal
        // Entonces se procede a mostrar el fragment dado por parámetro
        // que es la pantalla de inicio (HomeFragment)
        if(contentFragment == null){
            operateContent(fragment, tag);
        }
        // Si ya hay algún contenido y se hace clic en la misma opción
        // no se reemplaza para evitar volver a cargar.
        else if (!contentFragment.getClass().getName().equals(fragment.getClass().getName())){
            if(fragmentManager.findFragmentByTag(tag)==null){
                operateContent(fragment, tag);
            }
            else {
                operateContent(fragmentManager.findFragmentByTag(tag),tag);
            }
        } else Log.d(TAG, "switchContent: not replacing: there´s already or same");
    }

    // Realiza las operaciones de fragmentos
    private void operateContent(Fragment fragment, String tag){
        if (fragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            //transaction.setCustomAnimations(R.anim.slide_in_down, R.anim.slide_out_up,
            //      R.anim.slide_in_down, R.anim.slide_out_up);
            transaction.replace(R.id.main_content, fragment, tag);

            // Se agrega al backstack únicamente si no es pantalla de inicio
            if(!(fragment instanceof HomeFragment))
                transaction.addToBackStack(tag);

            transaction.commit();
            contentFragment = fragment;
        }
    }

    // Invocada al hacer click en el boton Atrás del dispositivo
    public void navigate(){
        //Si hay contenido se elimina del backstack para dejar solo la pantalla de inicio
        if (fragmentManager.getBackStackEntryCount() > 0) {
            super.onBackPressed();
            while (fragmentManager.popBackStackImmediate()); //limpiando el backstack
            bottomnavigationView.setSelectedItemId(R.id.item_home);
        }
        // Si ya no hay contenido, o la pantalla inicio está activa, se cierra la aplicación
        else if (contentFragment instanceof HomeFragment ||
                fragmentManager.getBackStackEntryCount() == 0) {
            finish();
        }
    }

   /* public void setTitle(int resource){
        getSupportActionBar().setTitle(getResources().getString(resource));
    }*/
}
