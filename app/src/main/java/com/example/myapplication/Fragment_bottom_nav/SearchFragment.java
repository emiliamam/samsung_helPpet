package com.example.myapplication.Fragment_bottom_nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

//import com.example.myapplication.Adapter.CardAdapter;
import com.example.myapplication.Adapter.CardAdapter;
import com.example.myapplication.Add;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_find;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huxq17.swipecardsview.SwipeCardsView;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchFragment extends Fragment {


    ArrayList<String> s;
    ArrayList<String> s2;
    ArrayList<String> list;
    Map<String, String> map = new HashMap<String, String>();

    ArrayAdapter arrayAdapter;
    int n=0;

    private ImageButton add_search;

    private DatabaseReference ref;
    private SwipeCardsView swipe_card;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

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
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        SwipeCardsView swipe_card = (SwipeCardsView)v.findViewById(R.id.swipe_card);
        swipe_card.retainLastCard(false);
        swipe_card.enableSwipe(true);



        FirebaseAuth mauth = FirebaseAuth.getInstance();
        TextView text_card_item = v.findViewById(R.id.text_card_item);
        s = new ArrayList<String >();


        s.add("one");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        List<animal_find> modellist = new ArrayList<animal_find>();
        animal_find animal_find = new animal_find();
        List<animal_find> displaylist = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Find_animal");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    System.out.println(map.values());
//                    System.out.println(map.get("street_home"));
                    String view = map.get("view").toString();
                    String metro = map.get("metro").toString();
                    String street_home = map.get("street_home").toString();
                    String email_user = map.get("email_user").toString();
                    String upload_uri = map.get("upload_uri").toString();

                    displaylist.add(new animal_find(email_user, upload_uri, view, metro, street_home));
                    CardAdapter cardAdapter = new CardAdapter(displaylist,SearchFragment.this.getActivity());
                    swipe_card.setAdapter(cardAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        CardAdapter cardAdapter = new CardAdapter(displaylist,SearchFragment.this.getActivity());
//        swipe_card.setAdapter(cardAdapter);


//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
////                System.out.println(snapshot.child("email_user").getValue().toString());
////                animal_find.setEmail_user(snapshot.child("email_user").getValue().toString());
////                animal_find.setMetro(snapshot.child("metro").getValue().toString());
////                animal_find.setStreet_home(snapshot.child("street").getValue().toString());
////                animal_find.setView(snapshot.child("category").getValue().toString());
////                System.out.println(animal_find.getMetro());
////                GenericTypeIndicator<List<animal_find>> t = new GenericTypeIndicator<List<animal_find>>() {};
////                List<animal_find> messages = snapshot.getValue(t);
////                System.out.println(messages.size());
//                String email = snapshot.child("street_home").getValue(String.class);
//                System.out.println(email);
//                s.add(email);
//            }

//            @Override
//            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
//
//            }
//        });
        add_search = (ImageButton) v.findViewById(R.id.add_search);

        add_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchFragment.this.getActivity(), Add.class));

            }
        });

//        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) v.findViewById(R.id.card);
//        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.carditem, R.id.text_card_item, s);

//        swipeFlingAdapterView.setAdapter(arrayAdapter);
//        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
//            @Override
//            public void removeFirstObjectInAdapter() {
//                s.remove(0);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onLeftCardExit(Object o) {
//
//            }
//
//            @Override
//            public void onRightCardExit(Object o) {
//
//            }
//
//            @Override
//            public void onAdapterAboutToEmpty(int i) {
//
//            }
//
//            @Override
//            public void onScroll(float v) {
//
//            }
//        });
        return v;
    }
}