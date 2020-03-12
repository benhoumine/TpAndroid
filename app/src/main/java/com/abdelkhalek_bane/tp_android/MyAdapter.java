package com.abdelkhalek_bane.tp_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<User> users;
    private static RecyclerViewClickListener itemListener;

    // constructor
    public MyAdapter(Context context, RecyclerViewClickListener itemListener, List<User> users){
        this.users = users;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflate item_layout
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, null);

        MyViewHolder vh = new MyViewHolder(itemLayoutView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Picasso.get().load(users.get(position).avatar).into(holder.itemIcon);
        holder.itemTitle.setText("Nom " +users.get(position).first_name);
        holder.itemUrl.setText("Prenom "+users.get(position).last_name);
    }

    @Override
    public int getItemCount() {
        if(users != null)
            return users.size();
        else
            return 0;
    }

    // inner static class
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView itemTitle;
        public TextView itemUrl;
        public ImageView itemIcon;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemTitle = itemLayoutView.findViewById(R.id.item_title);
            itemUrl = itemLayoutView.findViewById(R.id.item_url);
            itemIcon = itemLayoutView.findViewById(R.id.item_icon);
            itemLayoutView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getPosition());

        }
    }

    public Bitmap getBitmap(String bitmapUrl) {
        try {
            URL url = new URL(bitmapUrl);
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }
        catch(Exception ex) {return null;}
    }
}