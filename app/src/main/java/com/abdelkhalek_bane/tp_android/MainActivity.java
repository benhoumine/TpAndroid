package com.abdelkhalek_bane.tp_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView label = findViewById(R.id.id_label);
        /*
         Create a ViewModel the first time the system calls an activity's onCreate() method.
         Re-created activities receive the same MyViewModel instance created by the first activity.
        */

        MyViewModel model;
        model = new ViewModelProvider(this).get(MyViewModel.class);
        List<User> users = new ArrayList<>() ;
        model.loadUsers(
                new Observable(){
            @Override
            public void onDataReceivedFromWS(List<User> listUsers) {
                    label.setText("Hello "+listUsers.get(0).first_name);
            }
        }) ;



    }



}
