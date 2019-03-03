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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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
        myHolder.gameDate.setText(current.gameDate);
        myHolder.sport.setText(current.sport);
//        myHolder.gameTime.setText("Start time: " + current.gameTime);
        Glide.with(context).load(current.logo).into(myHolder.logo);
        Glide.with(context).load("https://i.imgur.com/Mhi5WN9.png").into(myHolder.ISU);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView name, username, email, price, gameDate, gameTime, opponent, sport;
        ImageView logo, ISU;
        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.price);
            gameDate = (TextView) itemView.findViewById(R.id.Game_Date);
            logo = (ImageView) itemView.findViewById(R.id.logoIV);
            sport = (TextView) itemView.findViewById(R.id.sport);
            ISU = (ImageView) itemView.findViewById(R.id.isuLogo);

            //logo= (TextView) itemView.findViewById(R.id.logo);
            //gameLocation =(TextView) itemView.findViewById(R.id.gameLocation);
            //ticketID = (TextView) itemView.findViewById(R.id.ticketID);
//            gameTime = (TextView) itemView.findViewById(R.id.Game_Time);
//            opponent = (TextView) itemView.findViewById(R.id.opponentTV);

        }

    }



}
