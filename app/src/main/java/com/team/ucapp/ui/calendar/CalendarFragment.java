package com.team.ucapp.ui.calendar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.ucapp.R;

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