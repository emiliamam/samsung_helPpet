package com.example.myapplication.Adapter;
//
////import static android.os.Build.VERSION_CODES.R;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.R;
//import com.example.myapplication.model_animal.animal_find;
//import com.example.myapplication.model_animal.animal_lost;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//
//public class Animal_adapter_find extends FirebaseRecyclerAdapter<animal_find, Animal_adapter_find.myviewholder> {
//
//    public Animal_adapter_find(@NonNull FirebaseRecyclerOptions<animal_find> options) {
//        super(options);
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull animal_lost model) {
//        holder.name.setText(model.getName_anim());
//        holder.street.setText((model.getMetro()+", "+model.getStreet_home()));
//    }
//
//    @NonNull
//    @Override
//    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertcarditem, parent, false);
//        return new myviewholder(view);
//    }
//
//    public class myviewholder extends RecyclerView.ViewHolder{
//
//        TextView name, street;
//
//        public myviewholder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.title_anim);
//            street = itemView.findViewById(R.id.street_anim);
//        }
//    }
//
//}
