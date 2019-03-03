package com.example.tickettrader;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tickettrader.Adapters.feedAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class feedPage extends AppCompatActivity {

    private RecyclerView mFeed;
    private feedAdapter mAdapter;
    private ImageButton bRefresh;
    RequestQueue requestQueue;
    String url;

    List<feed> feedData =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        mFeed = findViewById(R.id.ticketList);
        bRefresh = findViewById(R.id.refresh);

        requestQueue = Volley.newRequestQueue(this);
//        url = "https://api.androidhive.info/json/contacts.json";
//        url = "https://api.myjson.com/bins/77i0u";
        url = "https://api.myjson.com/bins/dndee"; //With opponent and logo
        refresh(url);

        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh("https://api.myjson.com/bins/i8mh2" );//Refresh data test
            }
        });



    }


    private void refresh(String url) {

        feedData.clear();

//    url = "https://api.myjson.com/bins/77i0u";
        {
            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("ticket");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject json_data = jsonArray.getJSONObject(i);

                            feed Feed = new feed();
                            Feed.setSport(json_data.getString("sport"));
//                    Feed.setOpponent(json_data.getString("opponent"));
                            Feed.setLogo(json_data.getString("logo"));
                            Feed.setSport(json_data.getString("sport"));

                            //User.setGameLocation(json_data.getString("gameLocation"));
                            //User.setTicketiD(json_data.getString("ticketID"));
//                        User.setLogo(json_data.getString("image"));
                            Feed.setGame_Date(json_data.getString("game_date"));
                            Feed.setPrice(json_data.getInt("price"));

                            feedData.add(Feed);

                        }

                        mAdapter = new feedAdapter(feedPage.this, feedData);
                        mFeed.setAdapter(mAdapter);
                        mFeed.setLayoutManager(new LinearLayoutManager(feedPage.this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(feedPage.this, "Check Internet Connection", Toast.LENGTH_LONG).show();
                }
            });

            requestQueue.add(request);
        }
    }


}
