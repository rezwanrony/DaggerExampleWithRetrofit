package com.friendroid.daggerexamplewithretrofit.api;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by gleb on 8/16/17.
 */

public class RestClient {

    public static final String BASE_URL = "https://api.github.com/";

    private final API service;

    @Inject
    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(API.class);
    }

    public API getService() {
        return service;
    }
}
