package com.example.myapplication.Adapter;

//import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Animal_adapter extends FirebaseRecyclerAdapter<animal_lost, Animal_adapter.myviewholder> {

    public Animal_adapter(@NonNull FirebaseRecyclerOptions<animal_lost> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull animal_lost model) {
        holder.name.setText(model.getName_anim());
        holder.street.setText((model.getMetro()+", "+model.getStreet_home()));
        Picasso.get().load(model.getUpload_uri()).into(holder.img_uri);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertcarditem, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView name, street;
        ImageView img_uri;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_anim);
            street = itemView.findViewById(R.id.street_anim);
            img_uri = itemView.findViewById(R.id.img_uri_lost);
        }
    }

}