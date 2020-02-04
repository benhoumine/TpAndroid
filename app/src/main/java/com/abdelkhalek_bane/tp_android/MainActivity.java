package com.abdelkhalek_bane.tp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

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
        List<User> users = model.getUsers();

       label.setText(users.get(0).name);

    }



}
