package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button next;
    View bottom_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (Button)findViewById(R.id.next_main);
        bottom_layout = (View) findViewById(R.id.bottom_layout);
        bottom_layout.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "cool", Toast.LENGTH_LONG).show();
            }
        });

    }
}