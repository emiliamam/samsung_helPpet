package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class add_lost extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    LinearLayout set_image;
    LinearLayout set_name;
    LinearLayout set_street;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lost);


        set_image = (LinearLayout) findViewById(R.id.set_image);
        set_name = (LinearLayout) findViewById(R.id.set_name);
        set_street = (LinearLayout) findViewById(R.id.set_street);

        but_im = (Button) findViewById(R.id.but_im);
        next_add_2 = (Button) findViewById(R.id.next_add_2);
        next_add_3 = (Button) findViewById(R.id.next_add_3);

        set_name.setVisibility(View.INVISIBLE);
        set_street.setVisibility(View.INVISIBLE);

        but_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.VISIBLE);
                set_street.setVisibility(View.INVISIBLE);

            }
        });
        next_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.INVISIBLE);
                set_street.setVisibility(View.VISIBLE);
            }
        });
    }
}