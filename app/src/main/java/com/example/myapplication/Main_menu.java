package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment_bottom_nav.HandsFragment;
import com.example.myapplication.Fragment_bottom_nav.LostFragment;
import com.example.myapplication.Fragment_bottom_nav.ProfileFragment;
import com.example.myapplication.Fragment_bottom_nav.SearchFragment;
import com.example.myapplication.databinding.ActivityMainBinding;

public class Main_menu extends AppCompatActivity {
    Button next;
    ActivityMainBinding binding;
    View main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        main = (View) findViewById(R.id.main);
        main.setVisibility(View.INVISIBLE);
        binding.bottomNavig.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.search:
                    ReplaceFragment(new SearchFragment());
                case R.id.hands:
                    ReplaceFragment(new HandsFragment());
                case R.id.lost:
                    ReplaceFragment(new LostFragment());
                case R.id.profile:
                    ReplaceFragment(new ProfileFragment());
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