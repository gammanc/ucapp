package com.team.ucapp.ui.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;
import com.team.ucapp.ui.grades.SubjectGradesDetailActivity;

public class CalendarFragment extends Fragment {

    public static final String ARG_ITEM_ID = "tab_game_list";

    private View view;
    private TabLayout main_tab;
    private ViewPager viewpager;
    private CalendarViewPagerAdapter adapter;

    //declaracion del fragmentos que se ocuparan en los tabs
    private PersonalCalendarFragment personalCalendarFragment;
    private UniversityCalendarFragment universityCalendarFragment;

    public CalendarFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getActivity(), CalendarEventActivity.class);
                startActivity(newIntent);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        prepareTabs();
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void prepareTabs(){
        main_tab = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        adapter = new CalendarViewPagerAdapter(getChildFragmentManager());

        personalCalendarFragment = new PersonalCalendarFragment();
        universityCalendarFragment = new UniversityCalendarFragment();

        adapter.addFragment(personalCalendarFragment,getResources().getString(R.string.personal));
        adapter.addFragment(universityCalendarFragment, getResources().getString(R.string.university));

        viewpager.setAdapter(adapter);
        main_tab.setupWithViewPager(viewpager);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment fragment = adapter.getFragment(position);
                if(fragment != null) fragment.onResume();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}