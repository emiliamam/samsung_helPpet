package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        btn_record = findViewById(R.id.btn_record);

        ref = FirebaseDatabase.getInstance().getReference("Chat");

        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText text_field = findViewById(R.id.text_field);
                FirebaseDatabase.getInstance().getReference().child("Chat").push().setValue(
                        new Chat(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                                text_field.getText().toString())
                );
                text_field.setText("");
            }
        });
        ref = FirebaseDatabase.getInstance().getReference("Chat");
        Intent i = new Intent(Activity_send_messages.this, Activity_send_messages.class);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    System.out.println(map.values());
//                    System.out.println(map.get("street_home"));


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
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Chat"), Chat.class)
                        .build();

        chat = new Chat_adapter(options);
        recyclerView.setAdapter(chat);


    }
    @Override
    public void onStart() {
        super.onStart();
        chat.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        chat.stopListening();
    }

}