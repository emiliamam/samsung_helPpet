package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    Button next2;
    EditText name;
    EditText email;
    EditText pass_reg;
    Button but_reg;
    TextView login;
    TextView wrong_name;
    TextView wrong_email;
    TextView wrong_password;
    TextView wrong_password2;
    TextView something_wrong;
    TextView login_registr;
    EditText name_reg;

    private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        next2 = (Button) findViewById(R.id.but_reg);
        login_registr = (TextView) findViewById(R.id.login_registr);

        name = (EditText) findViewById(R.id.name_reg);
        email = (EditText) findViewById(R.id.email_reg);
        pass_reg = (EditText) findViewById(R.id.pass_reg);
        name_reg = (EditText) findViewById(R.id.name_reg);

        login = (TextView) findViewById(R.id.login);
        wrong_name = (TextView) findViewById(R.id.wrong_name);
        wrong_email = (TextView) findViewById(R.id.wrong_email);
        wrong_password = (TextView) findViewById(R.id.wrong_password);
        wrong_password2 = (TextView) findViewById(R.id.wrong_password2);

        something_wrong = (TextView) findViewById(R.id.something_wrong);

        wrong_email.setVisibility(View.INVISIBLE);
        wrong_name.setVisibility(View.INVISIBLE);
        wrong_password.setVisibility(View.INVISIBLE);
        wrong_password2.setVisibility(View.INVISIBLE);

        something_wrong.setVisibility(View.INVISIBLE);

        mauth = FirebaseAuth.getInstance();

        login_registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()){
                    wrong_email.setVisibility(View.VISIBLE);
                }else if (name.getText().toString().isEmpty()){
                    wrong_name.setVisibility(View.VISIBLE);
                }else if (pass_reg.getText().toString().isEmpty()){
                    wrong_password.setVisibility(View.VISIBLE);
                } else if(pass_reg.length()<8){
                    wrong_password2.setVisibility(View.VISIBLE);

                }
                else{

                    mauth.createUserWithEmailAndPassword(email.getText().toString(), pass_reg.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(Registration.this, Main_menu.class);
                                        intent.putExtra("name_user", name_reg.getText().toString());
                                        startActivity(intent);
                                    }else{
                                        something_wrong.setVisibility(View.VISIBLE);
                                    }
                                }
                            });

                }
            }
        });

    }
}