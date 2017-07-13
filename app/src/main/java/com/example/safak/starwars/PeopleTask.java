package com.example.safak.starwars;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.safak.starwars.api.RetrofitPeopleInterface;
import com.example.safak.starwars.pojos.PeopleInfoEvent;
import com.example.safak.starwars.pojos.RequestBodyPeople;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Safak on 12.07.2017.
 */

public class PeopleTask {

    public void getPeopleRequest(){

    RetrofitPeopleInterface client =  ApiClient.getClient().create(RetrofitPeopleInterface.class);

    Call<RequestBodyPeople> call = client.getPeople();

        call.enqueue(new Callback<RequestBodyPeople>() {

            @Override
            public void onResponse(@Nullable Call<RequestBodyPeople> call, @Nullable  Response<RequestBodyPeople> response) {

                try {
                    RequestBodyPeople requestBodyPeople = response.body();
                    EventBus.getDefault().post(new PeopleInfoEvent(requestBodyPeople.results));



                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<RequestBodyPeople> call, Throwable t) {
                Log.e("MyApp", "getPeopleRequest Error:"+t.toString());
            }
        });
    }


}
