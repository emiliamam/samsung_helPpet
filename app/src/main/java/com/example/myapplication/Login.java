package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.ForgetPassw;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button next;
    EditText email;
    EditText password;
    TextView forget_pass;
    TextView registr;
    TextView wrong_email;
    TextView wrong_password;
    TextView wrong_password2;
    TextView something_wrong;

    private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        next = (Button) findViewById(R.id.but_log);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        forget_pass = (TextView) findViewById(R.id.forget_pass);
        registr = (TextView) findViewById(R.id.registr);
        wrong_email = (TextView) findViewById(R.id.wrong_email);
        wrong_password = (TextView) findViewById(R.id.wrong_password);
        wrong_password2 = (TextView) findViewById(R.id.wrong_password2);
        something_wrong = (TextView) findViewById(R.id.something_wrong);

        wrong_email.setVisibility(View.INVISIBLE);
        wrong_password.setVisibility(View.INVISIBLE);
        wrong_password2.setVisibility(View.INVISIBLE);
        something_wrong.setVisibility(View.INVISIBLE);

        mauth = FirebaseAuth.getInstance();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    wrong_email.setVisibility(View.VISIBLE);
                } else if (password.getText().toString().isEmpty()) {
                    wrong_password.setVisibility(View.VISIBLE);
                } else if(password.length()<8){
                    wrong_password2.setVisibility(View.VISIBLE);
                }else {
                    mauth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(Login.this, Main_menu.class);
                                        startActivity(intent);
                                    }else{
                                        something_wrong.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        registr.setOnClickListener(new View.OnClickListener() {
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
            case R.id.registr:
                startActivity(new Intent(this, Registration.class));
                break;
        }
    }
}
