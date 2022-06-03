package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.Animal_adapter;
import com.example.myapplication.Adapter.CardAdapter;
import com.example.myapplication.Adapter.Chat_adapter;
import com.example.myapplication.Fragment_bottom_nav.SearchFragment;
import com.example.myapplication.Model.Chat;
import com.example.myapplication.model_animal.animal_find;
import com.example.myapplication.model_animal.animal_lost;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class Activity_send_messages extends AppCompatActivity {
    Button next;
    View bottom_layout;
    Button btn_record;
    private String sender_email, text_message;
    private DatabaseReference ref;
    Chat_adapter chat;
    TextView textView;

    private String name_anim, name_user, view, upload_uri, metro, email_user, street_home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        btn_record = findViewById(R.id.btn_record);
        textView  = findViewById(R.id.email_user_order_layout);

//        ref = FirebaseDatabase.getInstance().getReference("Chat");
//        System.out.println(extras.getString("adapterMessage") + " тест");
//
//        textView.setText(extras.getString("adapterMessage"));
        Bundle extras = getIntent().getExtras();
        name_anim = extras.getString("name_anim");
        upload_uri = extras.getString("upload_uri");
        metro = extras.getString("metro");
        email_user = extras.getString("email_user");
        street_home = extras.getString("street_home");
        name_user = extras.getString("name_user");
        System.out.println(name_user + " name_user");
        ref = FirebaseDatabase.getInstance().getReference().child(("Chat"+name_anim+metro+street_home));

        long time = System.currentTimeMillis();
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText text_field = findViewById(R.id.text_field);
                ref.push().setValue(
                        new Chat(name_user,
                                text_field.getText().toString())
                );
                text_field.setText("");
            }
        });
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    System.out.println(map.values());


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview_chat);
        recyclerView.setLayoutManager(new LinearLayoutManager(Activity_send_messages.this));

        FirebaseRecyclerOptions<Chat> options =
                new FirebaseRecyclerOptions.Builder<Chat>()
                        .setQuery(ref, Chat.class)
                        .build();

        chat = new Chat_adapter(options);
        recyclerView.setAdapter(chat);

    }
    @Override
    public void onStart() {
        super.onStart();
        chat.startListening();


        System.out.println(name_anim + upload_uri + metro + email_user + street_home);
//        }
    }

    @Override
    public void onStop() {
        super.onStop();
        chat.stopListening();
    }


}