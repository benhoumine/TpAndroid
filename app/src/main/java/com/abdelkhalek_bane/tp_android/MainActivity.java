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
        MyViewModel model;
        model = new ViewModelProvider(this).get(MyViewModel.class);
        List<User> users = new ArrayList<>() ;
        model.loadUsers(
                new Observable(){
            @Override
            public void onDataReceivedFromWS(List<User> listUsers) {
                    label.setText("Go --> "+listUsers.get(1).first_name+ " "+listUsers.get(1).last_name);
            }
        }) ;



    }



}
