package com.example.safak.starwars;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Safak on 12.07.2017.
 */

public class ApiClient {

    private static String API_BASE_URL = "http://swapi.co/api/";

    private static Retrofit retrofit ;

    public static Retrofit getClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        retrofit =  new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create()
                        ).build();
        return retrofit;
    }
}
