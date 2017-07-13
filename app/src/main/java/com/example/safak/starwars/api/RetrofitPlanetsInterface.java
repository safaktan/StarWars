package com.example.safak.starwars.api;

import com.example.safak.starwars.pojos.RequestBodyPeople;
import com.example.safak.starwars.pojos.RequestBodyPlanets;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Koray on 13.07.2017.
 */

public interface RetrofitPlanetsInterface {
    @GET("planets/")
    Call<RequestBodyPlanets> getPlanets();

}
