package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Fragment_bottom_nav.LostFragment;
import com.example.myapplication.Fragment_bottom_nav.ProfileFragment;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class more_card_item extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String name_anim, view, upload_uri, metro, email_user, street_home;

    public more_card_item() {
    }

    public more_card_item(String name_anim, String view, String upload_uri, String metro, String email_user, String street_home) {
        this.name_anim = name_anim;
        this.view = view;
        this.upload_uri = upload_uri;
        this.metro = metro;
        this.email_user = email_user;
        this.street_home = street_home;


    }


    public static more_card_item newInstance(String param1, String param2) {
        more_card_item fragment = new more_card_item();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_card_item, container, false);
        ImageView imageView = view.findViewById(R.id.more_image);
        TextView name = view.findViewById(R.id.text_name);
        TextView street = view.findViewById(R.id.text_street);
        Button but_for_chat = view.findViewById(R.id.but_for_chat);

        but_for_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new more_card_item(model.getName_anim(), model.getView(), model.getUpload_uri(),model.getMetro(), model.getEmail_user(), model.getStreet_home())).addToBackStack(null).commit();
            }
        });

        System.out.println(upload_uri+ metro + street_home);
        name.setText(name_anim);
        Picasso.get().load(upload_uri).into(imageView);
        street.setText((metro+", " + street_home));
        return view;
    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new LostFragment()).addToBackStack(null).commit();
    }
}