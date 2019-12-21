package com.example.festivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Events_adapter_main extends RecyclerView.Adapter<Events_adapter_main.myViewHolder> {

    Context mContext;
    List<item> mData;


    public Events_adapter_main(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.activity_events_page_main,parent,false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Events_adapter_main.myViewHolder holder, int position) {
            holder.background_img.setImageResource(mData.get(position).getBackground());
    }

//    @Override
//    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
//
//        holder.background_img.setImageResource(mData.get(position).getBackground());
//        holder.register.setText(mData.get(position).getReg());
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, VisitorDashboard.class);
//                mContext.startActivity(intent);
//            }
//        });

//    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView background_img;
        TextView register;



        public myViewHolder(View itemView){
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            register = itemView.findViewById(R.id.textView8);
        }
    }

}

