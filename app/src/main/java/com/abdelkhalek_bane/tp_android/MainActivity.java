package com.abdelkhalek_bane.tp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<User> users ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.forcast_list);

        // layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // adapter

        MyViewModel model;
        model = new ViewModelProvider(this).get(MyViewModel.class);
        users = new ArrayList<>() ;
        model.loadUsers(
                new Observable(){
            @Override
            public void onDataReceivedFromWS(List<User> listUsers) {
                MainActivity.this.users  = listUsers ;
                RecyclerView.Adapter adapter = new MyAdapter(users);
                recyclerView.setAdapter(adapter);
            }
        }) ;



    }



}
