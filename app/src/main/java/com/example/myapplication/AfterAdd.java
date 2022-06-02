package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Fragment_bottom_nav.SearchFragment;

public class AfterAdd extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_after_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_add);

        but_after_add = (Button) findViewById(R.id.but_after_add);

        but_after_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterAdd.this, SearchFragment.class));
            }
        });

    }
}