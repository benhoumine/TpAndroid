package com.abdelkhalek_bane.tp_android;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {

    private static Retrofit retrofit = null;
    private static final String BASE_URL ="https://api.myjson.com/";

    public static GerritAPI getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(GerritAPI.class);
    }


}