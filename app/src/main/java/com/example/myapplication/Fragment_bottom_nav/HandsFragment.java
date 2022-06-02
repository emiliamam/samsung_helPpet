package com.example.myapplication.Fragment_bottom_nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.myapplication.Adapter.Animal_adapter;
import com.example.myapplication.Adapter.Animal_adapter_hands;
import com.example.myapplication.Add;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_give;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HandsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    ImageButton add;
    Animal_adapter_hands animal_adapter;

    public HandsFragment() {
    }

    public static HandsFragment newInstance(String param1, String param2) {
        HandsFragment fragment = new HandsFragment();
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
        View v = inflater.inflate(R.layout.fragment_hands, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerview_hands);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        add = v.findViewById(R.id.add_hands);

        FirebaseRecyclerOptions<animal_give> options =
                new FirebaseRecyclerOptions.Builder<animal_give>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Give_animal"), animal_give.class)
                        .build();
        animal_adapter = new Animal_adapter_hands(options);

        System.out.println("adapter "+animal_adapter);
        recyclerView.setAdapter(animal_adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HandsFragment.this.getActivity(), Add.class));

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