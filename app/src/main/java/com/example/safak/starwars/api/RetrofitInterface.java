package com.example.safak.starwars.api;

import com.example.safak.starwars.pojos.RequestBodyPeople;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Safak on 12.07.2017.
 */

public interface RetrofitInterface {

    @GET("people/")
    Call<RequestBodyPeople> getPeople();


}
