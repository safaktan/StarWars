package com.example.safak.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.safak.starwars.adapters.PeopleInformationAdapter;
import com.example.safak.starwars.pojos.PeopleInfo;

import java.util.HashMap;

public class PeopleInformationPage extends AppCompatActivity {

    public PeopleInformationAdapter peopleInformationAdapter;
    HashMap<String,String> map=new HashMap<>();
    public RecyclerView informationRV;
    PeopleInfo peopleInfo=new PeopleInfo();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_information_page);


        informationRV=(RecyclerView)findViewById(R.id.infoRV);
        peopleInformationAdapter=new PeopleInformationAdapter(map);
        informationRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        informationRV.setAdapter(peopleInformationAdapter);


        map.put("FULL NAME",peopleInfo.name);
        map.put("",peopleInfo.height);
        map.put("mass",peopleInfo.mass);
        map.put("hair_color",peopleInfo.hair_color);
        map.put("skin_color",peopleInfo.skin_color);
        map.put("eye_color",peopleInfo.eye_color);
        map.put("birth_year",peopleInfo.birth_year);
        map.put("gender",peopleInfo.gender);


    }
}
