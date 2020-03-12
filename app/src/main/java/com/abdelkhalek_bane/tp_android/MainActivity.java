package com.abdelkhalek_bane.tp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener{
    private RecyclerView recyclerView;

    private List<User> users ;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.forcast_list);
        this.context = this.getApplicationContext();
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
                RecyclerView.Adapter adapter = new MyAdapter(MainActivity.this.context, MainActivity.this::recyclerViewListClicked, users);
                recyclerView.setAdapter(adapter);
            }
        }) ;



    }


    public void navigation(View view) {
        Intent intent = new Intent().setClass(this, DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Gson gson = new Gson();
        User userCliked = this.users.get(position);
        String userJson = gson.toJson(userCliked);
        Intent intent = new Intent().setClass(this, DetailActivity.class);
        intent.putExtra("USER_JSON", userJson);
        startActivity(intent);
    }
}
