package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.add.add_find;
import com.example.myapplication.add.add_give;
import com.example.myapplication.add.add_lost;

public class Add extends AppCompatActivity {
    Button next;
    View bottom_layout;
    Button i_lost;
    Button i_find;
    Button i_give;
    Button next3;
    Button but_next_add;

    Boolean press = false;
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        i_lost = (Button) findViewById(R.id.i_lost);
        i_find = (Button) findViewById(R.id.i_find);
        i_give = (Button) findViewById(R.id.i_give);
        but_next_add = (Button) findViewById(R.id.but_next_add);

        i_lost.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    i_lost.setBackgroundResource(R.drawable.button_add_press);
                    i_find.setBackgroundResource(R.drawable.button_add);
                    i_give.setBackgroundResource(R.drawable.button_add);
                    press = true;
                    number = 1;
                }if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    i_lost.setBackgroundResource(R.drawable.button_add);
                }
            return false;
            }
        });
        i_find.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    i_lost.setBackgroundResource(R.drawable.button_add);
                    i_find.setBackgroundResource(R.drawable.button_add_press);
                    i_give.setBackgroundResource(R.drawable.button_add);
                    number = 2;
                }if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    i_find.setBackgroundResource(R.drawable.button_add);
                }
                return false;
            }
        });
        i_give.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    i_lost.setBackgroundResource(R.drawable.button_add);
                    i_find.setBackgroundResource(R.drawable.button_add);
                    i_give.setBackgroundResource(R.drawable.button_add_press);
                    number = 3;
                }if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    i_give.setBackgroundResource(R.drawable.button_add);
                }
                return false;
            }
        });

        but_next_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number==1){
                    startActivity(new Intent(Add.this, add_lost.class));
                }else if(number==2){
                    startActivity(new Intent(Add.this, add_give.class));
                }else if(number==3){
                    startActivity(new Intent(Add.this, add_find.class));
                }
            }
        });
    }


}