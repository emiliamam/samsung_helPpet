package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.myapplication.Fragment_bottom_nav.SearchFragment;
import com.example.myapplication.Model.model;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.huxq17.swipecardsview.BaseCardAdapter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CardAdapter extends BaseCardAdapter {
    private List<animal_lost> model_list ;
    private SearchFragment context;

    public CardAdapter(List<animal_lost> model_list, SearchFragment context) {
        this.model_list = model_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return model_list.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.carditem;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if (model_list == null || model_list.size()==0){
            return;
        }
        ImageView image_card_item = (ImageView)cardview.findViewById(R.id.im_card);
        TextView text_card_item = (TextView)cardview.findViewById(R.id.text_card_item);
        TextView street = (TextView)cardview.findViewById(R.id.street);

        animal_lost model = model_list.get(position);
        text_card_item.setText(model.getName_anim());
        street.setText(model.getStreet_home());
//        Picasso.get().load(model.getImage()).into(image_card_item);

    }
}
