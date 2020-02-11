package com.abdelkhalek_bane.tp_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GerritAPI {

    @GET("bins/{id}")
    Call<List<User>> getUser(@Path("id") String id);
}