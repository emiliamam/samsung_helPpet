package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    Button next;
    View bottom_layout;
    String UserEmail;
    String UserPassword;

    private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (Button) findViewById(R.id.next_main);
        bottom_layout = (View) findViewById(R.id.bottom_layout);
        mauth = FirebaseAuth.getInstance();


        bottom_layout.setVisibility(View.INVISIBLE);
        Paper.init(this);
        String email_b = Paper.book().read(Prevalent.UserEmail);
        System.out.println(email_b);
        String password_b = Paper.book().read(Prevalent.UserPassword);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email_b != null && password_b != null) {
                    if (!email_b.isEmpty() && !password_b.isEmpty()) {
                        mauth.signInWithEmailAndPassword(email_b, password_b)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(MainActivity.this, Main_menu.class);
                                            startActivity(intent);

                                        }
                                    }
                                });
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}

//    private void login_user(String email, String password) {
//        mauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Intent intent = new Intent(MainActivity.this, Main_menu.class);
//                    startActivity(intent);
//                }
//            }
//        });
