package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    Button next2;
    EditText name;
    EditText email;
    EditText pass_reg;
    Button but_reg;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        next2 = (Button) findViewById(R.id.but_reg);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        pass_reg = (EditText) findViewById(R.id.pass_reg);
        login = (Button) findViewById(R.id.login);


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(Registration.this, Main_menu.class);
                Registration.this.startActivity(registration);
            }
        });

    }
}