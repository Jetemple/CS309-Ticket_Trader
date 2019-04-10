package com.example.tickettrader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class TicketEachActivity extends AppCompatActivity {

    private static final String TAG = "TicketEachActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_each);

        getIncomingIntent();

    }

    private void getIncomingIntent(){


            String sport = getIntent().getStringExtra("sport");
            String awayLogo = getIntent().getStringExtra("logoURL");
            int price = getIntent().getIntExtra("price",-1);


            loadPage(awayLogo, price, sport);

    }

    private void loadPage(String awayLogo, int price, String sport)
    {
        ImageView away_logo = findViewById(R.id.awayLogo);
        ImageView isu_logo = findViewById(R.id.isuLogo);
        TextView tv_price = findViewById(R.id.priceTv);
        TextView tv_sport = findViewById(R.id.sportTV);
//        TextView tv_gameDate = findViewById(R.id.)



//        tv_price.setText(price);
        tv_sport.setText(sport);
        Glide.with(this).load(awayLogo).into(away_logo);
        Glide.with(this).load("https://i.imgur.com/Mhi5WN9.png").into(isu_logo);
    }

//    private void setPrice(String price){
//
//        TextView tv_price = findViewById(R.id.tv_sport);
//        tv_price.setText(price);
//    }

//    private void setSport(String sport){
//
//        TextView tv_price = findViewById(R.id.tv_sport);
//        tv_price.setText(sport);
//    }
}
