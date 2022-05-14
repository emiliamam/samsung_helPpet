package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        next2 = (Button) findViewById(R.id.but_reg);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(Registration.this, Main_menu.class);
                Registration.this.startActivity(registration);
            }
        });

    }
}