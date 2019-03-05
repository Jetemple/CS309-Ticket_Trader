package com.example.tickettrader;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tickettrader.Adapters.feedAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class sellPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private String url;
    private EditText team1;
    private EditText team2;
    private Spinner sport;
    private EditText month;
    private EditText day;
    private EditText time;
    private EditText price;
    private EditText location;
    private String userId;
    private String record;
    private Integer ticketId;
    private Button sell;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        team1 = (EditText)findViewById(R.id.sellTeam1);
        team2 = (EditText)findViewById(R.id.sellTeam2);
        sport = (Spinner)findViewById(R.id.sellGameSport);
        month = (EditText)findViewById(R.id.sellGameMon);
        day = (EditText)findViewById(R.id.sellGameDay);
        time = (EditText)findViewById(R.id.sellGameTime);
        location = (EditText)findViewById(R.id.gameLocation);
        price = (EditText)findViewById(R.id.sellPrice);
        sell = (Button)findViewById(R.id.sellBtn) ;
        userId = "";
        record ="";
        ticketId = 0;

        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sell");
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        url = "http://cs309-pp-1.misc.iastate.edu:8080/tickets";

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellTicket(team1.getText().toString(), team2.getText().toString(),
                        sport.getSelectedItem().toString(),
                        month.getText().toString() + "/" + day.getText().toString(),
                        time.getText().toString(), price.getText().toString(), location.getText().toString());

                team1.setText("First Team");
                team2.setText("Second Team");
                month.setText("Month");
                day.setText("Day");
                time.setText("Game time");
                price.setText("Price");
                location.setText("Game Location");
            }
        });
    }

    private void sellTicket(String team1, String team2, String sport, String date, String time, String price, String location)
    {
        JSONObject jsonObject = new JSONObject();

        try{
            //jsonObject.put("first_team",team1);
            jsonObject.put("opponent",team2);
            jsonObject.put("sport",sport);
            jsonObject.put("game_date",date);
            jsonObject.put("game_time",time);
            jsonObject.put("price",price);
            jsonObject.put("game_location", location);
            jsonObject.put("seller_id", userId);
            jsonObject.put("record", record);
            jsonObject.put("ticket_id", ticketId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, null, null);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.feed) {
            Intent feed = new Intent(sellPage.this, feedPage.class);
            startActivity(feed);
        } else if (id == R.id.sell) {

        } else if (id == R.id.userAccount) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
