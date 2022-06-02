package com.example.myapplication.Adapter;

//import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import java.util.List;

public class Animal_adapter extends RecyclerView.Adapter<Animal_adapter.MyViewHolder> {
    String name[], street[];
    Context context;

    public Animal_adapter(String[] name, String[] street, Context context) {
        this.name = name;
        this.street = street;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.advertcarditem, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(name[position]);
        holder.street.setText(street[position]);

    }

    @Override
    public int getItemCount() {
        System.out.println(name.length + "lenght");
        return name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,street;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_anim);
            street = itemView.findViewById(R.id.street_anim);
        }
    }
}
