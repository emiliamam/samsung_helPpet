package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class profile_elit extends AppCompatActivity {
    Button next;
    View bottom_layout;
    FirebaseAuth mfirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        Button logout = findViewById(R.id.logout);
        mfirebaseauth = FirebaseAuth.getInstance();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfirebaseauth.signOut();
                startActivity(new Intent(profile_elit.this, Registration.class));
            }
        });


    }
}