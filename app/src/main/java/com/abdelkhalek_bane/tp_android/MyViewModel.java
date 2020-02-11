package com.abdelkhalek_bane.tp_android;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel{
    private List<User> users;
    public List<User> getUsers(Observable observable) {
        return users;
    }

    public void loadUsers(Observable observable) {
        Retrofit2Client  client = new Retrofit2Client() ;
        Call<List<User>> call = client.getService().getUser("rlc5o");
        users = new ArrayList<User>();

        /*try {
            Response<User> response = call.execute();
            User user = response.body();
            users.add(user);
        } catch (IOException e ){
             //handle error
        }
*/
            call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                int statusCode = response.code();
                users.addAll(response.body());
                observable.onDataReceivedFromWS(users);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                users.add(new User("null"));
            }
        });



    }


}
