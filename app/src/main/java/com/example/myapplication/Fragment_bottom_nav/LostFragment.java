package com.example.myapplication.Fragment_bottom_nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Adapter.Animal_adapter;
import com.example.myapplication.Add;
import com.example.myapplication.R;
import com.example.myapplication.add.add_lost;
import com.example.myapplication.model_animal.animal_lost;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.huxq17.swipecardsview.SwipeCardsView;
//import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;

import java.util.List;


public class LostFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ImageButton add;

    Animal_adapter animal_adapter;

    public LostFragment() {
    }

    public static LostFragment newInstance(String param1, String param2) {
        LostFragment fragment = new LostFragment();
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
        View v = inflater.inflate(R.layout.fragment_lost, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        add = v.findViewById(R.id.add_lost);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<animal_lost> options =
                new FirebaseRecyclerOptions.Builder<animal_lost>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Lost_animal"), animal_lost.class)
                        .build();
//        SwipeCardsView swipe_card = (SwipeCardsView)v.findViewById(R.id.swipe_card);
//        swipe_card.retainLastCard(false);
//        swipe_card.enableSwipe(true);
        animal_adapter = new Animal_adapter(options);
        System.out.println("adapter"+animal_adapter);
        recyclerView.setAdapter(animal_adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LostFragment.this.getActivity(), Add.class));

            }
        });
        return v;

    }
    @Override
    public void onStart() {
        super.onStart();
        animal_adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        animal_adapter.stopListening();
    }
}
