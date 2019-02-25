package com.example.tickettrader.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tickettrader.R;
import com.example.tickettrader.feed;

import java.util.Collections;
import java.util.List;

public class feedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<feed> data= Collections.emptyList();

    // create constructor to innitilize context and data sent from MainActivity
    public feedAdapter(Context context, List<feed> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.feed_card, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        feed current=data.get(position);
        myHolder.price.setText("$" + current.price);
        myHolder.gameDate.setText("Date: " + current.gameDate);
        myHolder.gameTime.setText("Start time: " + current.gameTime);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView name, username, email, price, gameDate, gameTime;
        ImageView image;
        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.sport);
//            image = (ImageView) itemView.findViewById(R.id.image);
            //photo= (TextView) itemView.findViewById(R.id.photo);
            //gameLocation =(TextView) itemView.findViewById(R.id.gameLocation);
            //ticketID = (TextView) itemView.findViewById(R.id.ticketID);
            price = (TextView) itemView.findViewById(R.id.price);
            gameDate = (TextView) itemView.findViewById(R.id.Game_Date);
            gameTime = (TextView) itemView.findViewById(R.id.Game_Time);
            //website = (TextView) itemView.findViewById(R.id.website);
            //street = (TextView) itemView.findViewById(R.id.street);
            //suite = (TextView) itemView.findViewById(R.id.sport);
            //sellerID = (TextView) itemView.findViewById(R.id.sellerID);
            //zip = (TextView) itemView.findViewById(R.id.zip);
            //cname = (TextView) itemView.findViewById(R.id.cname);
            //cp = (TextView) itemView.findViewById(R.id.cp);
            //bs = (TextView) itemView.findViewById(R.id.bs);
        }

    }



}
