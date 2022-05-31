package com.example.myapplication.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Add;
import com.example.myapplication.R;

public class add_lost extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    ImageButton arrow_back;
    LinearLayout set_image;
    LinearLayout set_name;
    LinearLayout set_street;

    ProgressBar progressBar;
    int i=0;

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

        arrow_back = (ImageButton) findViewById(R.id.arrow_back_lost);

        progressBar = (ProgressBar) findViewById(R.id.pb_lost);

        set_name.setVisibility(View.INVISIBLE);
        set_street.setVisibility(View.INVISIBLE);

        progressBar.setMax(3);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==1){
                    back(set_image, set_name,set_street);
                    i--;
                    progressBar.setProgress(i);
                    System.out.println("все норм...");
                } else if(i==2){
                    i--;
                    progressBar.setProgress(i);
                    back(set_name, set_image,set_street);
                } else if(i==0){
                    progressBar.setProgress(i);
                    startActivity(new Intent(add_lost.this, Add.class));
                }
            }
        });
        but_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=1;
                progressBar.setProgress(i);
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.VISIBLE);
                set_street.setVisibility(View.INVISIBLE);

            }
        });
        next_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=2;
                progressBar.setProgress(i);
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.INVISIBLE);
                set_street.setVisibility(View.VISIBLE);
            }
        });

    }

    private void back(LinearLayout lin_hidden, LinearLayout lin_not_hidden, LinearLayout lin_not_hidden2) {
        lin_hidden.setVisibility(View.VISIBLE);
        lin_not_hidden.setVisibility(View.INVISIBLE);
        lin_not_hidden2.setVisibility(View.INVISIBLE);

    }
}