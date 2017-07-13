package com.example.safak.starwars;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.safak.starwars.api.RetrofitPeopleInterface;
import com.example.safak.starwars.api.RetrofitPlanetsInterface;
import com.example.safak.starwars.pojos.PlanetsInfoEvent;
import com.example.safak.starwars.pojos.RequestBodyPlanets;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Koray on 13.07.2017.
 */

public class PlanetsTask {
    public void getPlanetsRequest(){

        RetrofitPlanetsInterface client =  ApiClient.getClient().create(RetrofitPlanetsInterface.class);

        Call<RequestBodyPlanets> call = client.getPlanets();

        call.enqueue(new Callback<RequestBodyPlanets>() {

            @Override
            public void onResponse(@Nullable Call<RequestBodyPlanets> call, @Nullable Response<RequestBodyPlanets> response) {

                try {
                    RequestBodyPlanets requestBodyPlanets = response.body();
                    EventBus.getDefault().post(new PlanetsInfoEvent(requestBodyPlanets.results));



                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<RequestBodyPlanets> call, Throwable t) {
                Log.e("MyApp", "getPlanetsRequest Error:"+t.toString());
            }
        });
    }


}

