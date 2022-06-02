package com.example.myapplication.Fragment_bottom_nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//import com.example.myapplication.Adapter.CardAdapter;
import com.example.myapplication.Add;
import com.example.myapplication.ForgetPassword;
import com.example.myapplication.Login;
import com.example.myapplication.Main_menu;
import com.example.myapplication.Model.model;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huxq17.swipecardsview.SwipeCardsView;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {


    ArrayList<String> s;
    ArrayList<String> s2;

    ArrayAdapter arrayAdapter;
    int n=0;

    private ImageButton add_search;

    private DatabaseReference ref;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        FirebaseAuth mauth = FirebaseAuth.getInstance();
        TextView text_card_item = v.findViewById(R.id.text_card_item);
        s = new ArrayList<String >();
        s2 = new ArrayList<String >();

        s.add("one");
//        s.add("two");
//        s.add("three");

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        List<animal_lost> modellist = new ArrayList<animal_lost>();
        animal_lost animal_lost = new animal_lost();

        ref = FirebaseDatabase.getInstance().getReference("Find_animal").child(mAuth.getCurrentUser().getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                System.out.println(snapshot.child("email_user").getValue().toString());
                animal_lost.setEmail_user(snapshot.child("email_user").getValue().toString());
                animal_lost.setMetro(snapshot.child("metro").getValue().toString());
//                animal_lost.setName_anim(snapshot.child("name").getValue().toString());
                animal_lost.setStreet_home(snapshot.child("street").getValue().toString());
                animal_lost.setView(snapshot.child("category").getValue().toString());
                System.out.println(animal_lost.getMetro());
                s.add(animal_lost.getName_anim());
                s2.add(animal_lost.getStreet_home());
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
        add_search = (ImageButton) v.findViewById(R.id.add_search);

        System.out.println(animal_lost.getMetro() + " " + animal_lost.getView());
        add_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchFragment.this.getActivity(), Add.class));

            }
        });

        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) v.findViewById(R.id.card);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.carditem, R.id.text_card_item, s);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.carditem, R.id.street, s2);

        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
        return v;
    }
}