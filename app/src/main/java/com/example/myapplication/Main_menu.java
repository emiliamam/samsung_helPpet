package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import com.google.firebase.auth.FirebaseAuth;

public class Main_menu extends AppCompatActivity {
    Button next;
    ActivityMainBinding binding;
    ImageView verh1;
    ImageView im_main;
    TextView main_str;
    TextView main_str2;
    ImageView dog_hum_main;
    Button next_main;
    private FirebaseAuth mauth;
    Button logout;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        verh1 = (ImageView) findViewById(R.id.verh1);
        im_main = (ImageView) findViewById(R.id.im_main);
        dog_hum_main = (ImageView) findViewById(R.id.dog_hum_main);
        main_str = (TextView) findViewById(R.id.main_str);
        main_str2 = (TextView) findViewById(R.id.main_str2);
        next_main = (Button) findViewById(R.id.next_main);

        verh1.setVisibility(View.INVISIBLE);
        im_main.setVisibility(View.INVISIBLE);
        dog_hum_main.setVisibility(View.INVISIBLE);
        main_str.setVisibility(View.INVISIBLE);
        main_str2.setVisibility(View.INVISIBLE);
        next_main.setVisibility(View.INVISIBLE);

        mauth = FirebaseAuth.getInstance();



        binding.bottomNavig.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.search:
                    ReplaceFragment(new SearchFragment());
                    break;
                case R.id.hands:
                    ReplaceFragment(new HandsFragment());
                    break;

                case R.id.lost:
                    ReplaceFragment(new LostFragment());
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
}