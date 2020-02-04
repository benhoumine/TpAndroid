package com.abdelkhalek_bane.tp_android;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    private List<User> users;
    public List<User> getUsers() {

        if (users == null) {
            users = new ArrayList<User>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        String username = "2";
        Retrofit2Client  client = new Retrofit2Client() ;
        Call<User> call = client.getService().getUser(username);

        /*try {
            Response<User> response = call.execute();
            User user = response.body();
            users.add(user);
        } catch (IOException e ){
             //handle error
        }
*/
            call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int statusCode = response.code();
                Log.wtf("LoadUsers","stutus code "+statusCode);
                User user = response.body();
                users.add(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                users.add(new User("null"));
            }
        });



    }
}
