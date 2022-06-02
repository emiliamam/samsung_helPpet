package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment_bottom_nav.HandsFragment;
import com.example.myapplication.Fragment_bottom_nav.LostFragment;
import com.example.myapplication.Fragment_bottom_nav.ProfileFragment;
import com.example.myapplication.Fragment_bottom_nav.SearchFragment;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model_animal.animal_lost;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class TestTest extends AppCompatActivity {
    Button next;
    View bottom_layout;
    FirebaseListAdapter<animal_lost> adapter;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testtest);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        displayallanimal();


        binding.bottomNavig.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.search:
                    startActivity(new Intent(TestTest.this, Main_menu.class));
//                    ReplaceFragment(new SearchFragment());
                    break;
                case R.id.hands:

                    ReplaceFragment(new HandsFragment());
                    break;

                case R.id.lost:
//                    ReplaceFragment(new LostFragment());
                    startActivity(new Intent(TestTest.this, TestTest.class));
                    break;

                case R.id.profile:
                    ReplaceFragment(new ProfileFragment());
                    break;

            }

            return true;
        });
    }
    private void ReplaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

    private void displayallanimal() {
        ListView list_lost = findViewById(R.id.list_test);

        adapter = new FirebaseListAdapter<animal_lost>(TestTest.this, animal_lost.class, R.layout.advertcarditem, FirebaseDatabase.getInstance().getReference().child("Lost_animal")) {
            @Override
            protected void populateView(View view, animal_lost model, int position) {
                TextView name_anim, street;
                name_anim = view.findViewById(R.id.title_anim);
                street = view.findViewById(R.id.street_anim);
                name_anim.setText(model.getName_anim());
                street.setText(model.getStreet_home());
            }
        };list_lost.setAdapter(adapter);
    }
}