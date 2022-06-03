package com.example.myapplication.Adapter;

//import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.example.myapplication.more_card_item;
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
        holder.learn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new more_card_item(model.getName_anim(), model.getView(), model.getUpload_uri(),model.getMetro(), model.getEmail_user(), model.getStreet_home())).addToBackStack(null).commit();
            }
        });
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
            }
        });

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
        Button learn_more;
        ImageButton favorite;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_anim);
            street = itemView.findViewById(R.id.street_anim);
            img_uri = itemView.findViewById(R.id.img_uri_lost);
            learn_more = itemView.findViewById(R.id.learn_more);
            favorite = itemView.findViewById(R.id.favorite);

        }
    }

}