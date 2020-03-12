package com.abdelkhalek_bane.tp_android;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private User user;
    private TextView textViewPrenom;
    private TextView textViewNom;
    private TextView textViewEmail;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String userJSON = getIntent().getExtras().getString("USER_JSON");
        Gson gson = new Gson();
        this.user = gson.fromJson(userJSON, User.class);

        //Récupération des vues
        View detailsView = (View)findViewById(R.id.details);
        textViewPrenom = (TextView)detailsView.findViewById(R.id.textViewPrenom);
        textViewNom = (TextView)detailsView.findViewById(R.id.textViewNom);
        textViewEmail = (TextView)detailsView.findViewById(R.id.textViewEmail);
        imageView = (ImageView)detailsView.findViewById(R.id.imageView);

        //Mis à jour des vues
        textViewPrenom.setText(textViewPrenom.getText()+this.user.first_name);
        textViewNom.setText(textViewNom.getText()+this.user.last_name);
        textViewEmail.setText(textViewEmail.getText()+this.user.email);
        Picasso.get().load(this.user.avatar).resize(1100,1100).centerCrop().into(imageView);
    }

    public void onClickAvater(View view) {
        Intent intent = new Intent().setClass(this, AffichageImageActivity.class);
        intent.putExtra("IMAGE_URL", this.user.avatar);
        startActivity(intent);
    }
}
