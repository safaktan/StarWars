package com.example.safak.starwars;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safak.starwars.pojos.PeopleInfo;
import com.example.safak.starwars.pojos.PeopleInfoEvent;
import com.example.safak.starwars.pojos.PlanetsInfo;
import com.example.safak.starwars.pojos.PlanetsInfoEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class StarWarsMain extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        public RecyclerView peopleRV;
        public PeopleAdapter peopleAdapter;
        public RecyclerView planetsRV;
        public PlanetsAdapter planetsAdapter;


        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.people_page, container, false);
            View rootView2 = inflater.inflate(R.layout.planet_page, container, false);
            peopleRV = (RecyclerView) rootView.findViewById(R.id.peopleRV);
            planetsRV=(RecyclerView) rootView2.findViewById(R.id.planetsRV);
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    PeopleTask peopleTask=new PeopleTask();
                    peopleTask.getPeopleRequest();

                    return rootView;
                case 2:
                    PlanetsTask planetsTask=new PlanetsTask();
                    planetsTask.getPlanetsRequest();
                    return rootView2;
            }

            return rootView;
        }

        @Subscribe
        public void getEventPeople(PeopleInfoEvent event) {
            Log.d("MyApp", "getEventPeople: " + event.getPeopleInfoEventList().size());
            peopleAdapter=new PeopleAdapter(event.getPeopleInfoEventList());
            peopleRV.setLayoutManager(new LinearLayoutManager(getContext()));
            peopleRV.setAdapter(peopleAdapter);
        }
        @Subscribe
        public void getEventPlanets(PlanetsInfoEvent event) {
            Log.d("MyApp", "getEventPlanets: " + event.getPlanetsInfoEventList().size());
            planetsAdapter=new PlanetsAdapter(event.getPlanetsInfoEventList());
            planetsRV.setLayoutManager(new LinearLayoutManager(getContext()));
            planetsRV.setAdapter(planetsAdapter);
        }

        @Override
        public void onStart() {
            super.onStart();
            EventBus.getDefault().register(this);
        }


        @Override
        public void onStop() {
            super.onStop();
            EventBus.getDefault().unregister(this);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PEOPLE";
                case 1:
                    return "PLANETS";

            }
            return null;
        }
    }
}
