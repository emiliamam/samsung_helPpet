package com.example.myapplication.Adapter;

//import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Chat;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_lost;
import com.example.myapplication.more_card_item;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Chat_adapter extends FirebaseRecyclerAdapter<Chat, Chat_adapter.myviewholder> {

    String email_user;
    String email_sender;
    String fuser;

    public static final int MSG_TYPE_RIGHT=0;
    public static final int MSG_TYPE_LEFT=1;
    Chat model;



    public Chat_adapter(@NonNull FirebaseRecyclerOptions<Chat> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Chat model) {
        holder.text_messages.setText(model.getText_message());
        holder.name_user.setText(model.getSender_email());
        System.out.println(model.getText_message());
        System.out.println(model.getSender_email());

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        email_user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        System.out.println(email_sender + " email_sender");

        if(viewType==MSG_TYPE_RIGHT){
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_sent_message, parent, false);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_received_message, parent, false);
        }
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView text_messages, name_user;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

                    text_messages = itemView.findViewById(R.id.text_message2);
                    name_user = itemView.findViewById(R.id.email_sent_message);
//                }

        }
    }


}