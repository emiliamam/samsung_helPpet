package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.myapplication.Fragment_bottom_nav.SearchFragment;
import com.example.myapplication.Model.model;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_find;
import com.example.myapplication.model_animal.animal_lost;
import com.huxq17.swipecardsview.BaseCardAdapter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CardAdapter extends BaseCardAdapter {
    private List<animal_find> modellist;
    Context context;

    public CardAdapter(List<animal_find> modellist, Context context) {
        this.modellist = modellist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.carditem_test;
    }

    @Override
    public void onBindData(int position, View cardview) {
        ImageView imageView = (ImageView)cardview.findViewById(R.id.img_card_item);
        TextView name = (TextView) cardview.findViewById(R.id.name);
        TextView street = (TextView) cardview.findViewById(R.id.street_card_item);

        animal_find animal_find = modellist.get(position);
        name.setText(animal_find.getView());
        street.setText((animal_find.getMetro()+ " " + animal_find.getStreet_home()));
        Picasso.get().load(animal_find.getUpload_uri()).into(imageView);


    }
}
