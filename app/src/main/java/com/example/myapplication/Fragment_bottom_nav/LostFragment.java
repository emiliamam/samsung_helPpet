package com.example.myapplication.Fragment_bottom_nav;

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
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FirebaseListAdapter<animal_lost> adapter;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LostFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lost, container, false);

//        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
//
//        String[] name = new String[2];
//        String[] street = new String[2];
//        name[0] = "попуг";
//        name[1] = "не попуг";
//        street[0] = "динамо";
//        street[1] = "аэропорт";
//
//        Animal_adapter animal_adapter = new Animal_adapter(name,street, LostFragment.this.getActivity());
//        recyclerView.setAdapter(animal_adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(LostFragment.this.getActivity()));
//        ImageButton add_lost = (ImageButton) v.findViewById(R.id.add_search);
//
//
        displayallanimal(v);
        System.out.println("workwork");

        return inflater.inflate(R.layout.fragment_lost, container, false);
//    }
    }

    private void displayallanimal(View v) {
        ListView list_lost = v.findViewById(R.id.list_lost);

        adapter = new FirebaseListAdapter<animal_lost>(LostFragment.this.getActivity(),animal_lost.class,R.layout.advertcarditem,FirebaseDatabase.getInstance().getReference().child("Lost_animal")) {
            @Override
            protected void populateView(View view, animal_lost model, int position) {
                TextView name_anim, street;
                name_anim = view.findViewById(R.id.title_anim);
                street = view.findViewById(R.id.street_anim);
                name_anim.setText(model.getName_anim());
                street.setText(model.getStreet_home());
            }
        };
//        adapter = new FirebaseListAdapter<animal_lost>(options) {
//            @Override
//            protected void populateView(@NonNull View view, @NonNull animal_lost model, int position) {
//                TextView name_anim, street;
//                name_anim = view.findViewById(R.id.title_anim);
//                street = view.findViewById(R.id.street_anim);
//                name_anim.setText(model.getName_anim());
//                street.setText(model.getStreet_home());
//                System.out.println(model.getName_anim() + " name");
//
//            }
//        };
        list_lost.setAdapter(adapter);
    }
}
