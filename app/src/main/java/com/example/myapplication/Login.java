package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.ForgetPassw;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button next;
    EditText email;
    EditText password;
    Button forget_pass;
    Button registr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        next = (Button) findViewById(R.id.but_log);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        forget_pass = (Button) findViewById(R.id.forget_pass);
        registr = (Button) findViewById(R.id.registr);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forget_pass:
                startActivity(new Intent(this, ForgetPassw.class));
                break;
        }
    }
}
