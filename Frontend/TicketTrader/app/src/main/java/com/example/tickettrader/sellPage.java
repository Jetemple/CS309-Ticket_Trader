package com.example.tickettrader;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
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
import java.util.Scanner;

public class sellPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private String url;
    private EditText opponent;
    private Spinner sport;
    private EditText date;
    private EditText time;
    private EditText price;
    private EditText location;
    private int userId;
    private Button sell;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        opponent = (EditText)findViewById(R.id.opponent_team);
        sport = (Spinner)findViewById(R.id.game_sport);
        date = (EditText)findViewById(R.id.game_date);
        time = (EditText)findViewById(R.id.game_time);
        location = (EditText)findViewById(R.id.game_location);
        price = (EditText)findViewById(R.id.game_price);
        sell = (Button)findViewById(R.id.sell_btn);
        userId = 0;

        ArrayAdapter sportAdapter = ArrayAdapter.createFromResource(this, R.array.sport_array, R.layout.sport_item);
        sport.setAdapter(sportAdapter);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sell A Ticket");
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
                Scanner sc = new Scanner(price.getText().toString());
                int priceNum = sc.nextInt();

                sellTicket(opponent.getText().toString(),
                        sport.getSelectedItem().toString(),
                        date.getText().toString(),
                        time.getText().toString(), priceNum, location.getText().toString());

                opponent.setText("");
                date.setText("");
                time.setText("");
                price.setText("");
                location.setText("");
            }
        });
    }

    private void sellTicket(String opponent, String sport, String date, String time, int price, String location)
    {
        JSONObject jsonObject = new JSONObject();

        try{
            jsonObject.put("opponent",opponent);
            jsonObject.put("sport",sport);
            jsonObject.put("game_date",date);
            jsonObject.put("game_time",time);
            jsonObject.put("price",price);
            jsonObject.put("game_location", location);
            jsonObject.put("seller_id", userId);
            jsonObject.put("ticket_id", 0);
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