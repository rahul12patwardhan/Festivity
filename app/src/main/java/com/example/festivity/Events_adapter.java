package com.example.festivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Events_adapter extends RecyclerView.Adapter<Events_adapter.myViewHolder> {

    Context mContext;
    List<item> mData;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    public Events_adapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.activity_events_page,parent,false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.register.setText(mData.get(position).getReg());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference userdb = database.getReference().child("Events");

                if(position==0){
                    userdb.child("Slurp").child("UID").setValue(user.getUid());
                }
                if(position==1){
                    userdb.child("Pong").child("UID").setValue(user.getUid());
                }
                if(position==2){
                    userdb.child("Pop").child("UID").setValue(user.getUid());
                }

                Intent intent = new Intent(mContext, VisitorDashboard.class);
                mContext.startActivity(intent);
            }
        });

        holder.background_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){
                    Intent intent = new Intent(mContext, EventBanner.class);
                    mContext.startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(mContext, EventBanner3.class);
                    mContext.startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(mContext, EventBanner2.class);
                    mContext.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView background_img;
        TextView register;
        Button button;


        public myViewHolder(View itemView){
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            register = itemView.findViewById(R.id.textView8);
            button = itemView.findViewById(R.id.button_events);
        }
    }

}
