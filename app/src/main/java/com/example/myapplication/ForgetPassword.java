package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.ForgetPassw;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    Button next;
    View bottom_layout;
    ImageButton back;
    Button button_reset_password;
    EditText email;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        back = (ImageButton) findViewById(R.id.arrow_back);
        button_reset_password = (Button) findViewById(R.id.but_reset_pass);
        email = (EditText) findViewById(R.id.email_pass) ;

        auth = FirebaseAuth.getInstance();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgetPassword.this, Login.class));

            }
        });
        button_reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.sendPasswordResetEmail(email.getText().toString())

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(ForgetPassword.this, ForgetPassword2.class));
                                } else {
                                    Toast.makeText(ForgetPassword.this, "Ошибка", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }
}
