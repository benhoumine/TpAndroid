package com.abdelkhalek_bane.tp_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AffichageImageActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_image);

        String imageUrl = getIntent().getExtras().getString("IMAGE_URL");
        imageView = (ImageView) findViewById(R.id.imageView);

        //Mis à jour de la taille de l'image
        Picasso.get().load(imageUrl)
                .fit().centerCrop().into(imageView);
    }
}
