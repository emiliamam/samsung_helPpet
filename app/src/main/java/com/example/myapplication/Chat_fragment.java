package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Adapter.Chat_adapter;
import com.example.myapplication.Model.Chat;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;



public class Chat_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn_record;
    private String sender_email, text_message;
    private DatabaseReference ref;
    Chat_adapter chat;
    String user_order_email;
    String name_anim,  metro, street_home, upload_uri,email;


    public Chat_fragment(String sender_email) {
        this.user_order_email = sender_email;
    }
    public Chat_fragment() {
    }

    public Chat_fragment(String name_anim, String metro, String street_home, String upload_uri, String email) {
        this.name_anim = name_anim;
        this.metro = metro;
        this.street_home = street_home;
        this.upload_uri = upload_uri;
        this.email = email;
    }

    public static Chat_fragment newInstance(String param1, String param2) {
        Chat_fragment fragment = new Chat_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat_fragment, container, false);
        btn_record = v.findViewById(R.id.btn_record);
        TextView email_user_order = v.findViewById(R.id.email_user_order);

        email_user_order.setText(email);

        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText text_field = v.findViewById(R.id.text_field);
                FirebaseDatabase.getInstance().getReference().child("Chat").child(name_anim+street_home+metro).push().setValue(
                        new Chat(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                                text_field.getText().toString())
                );
                text_field.setText("");
            }
        });
        ref = FirebaseDatabase.getInstance().getReference("Chat").child(name_anim+street_home+metro);
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

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview_chat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Chat> options =
                new FirebaseRecyclerOptions.Builder<Chat>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Chat"), Chat.class)
                        .build();

        chat = new Chat_adapter(options);
        recyclerView.setAdapter(chat);
        return v;

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