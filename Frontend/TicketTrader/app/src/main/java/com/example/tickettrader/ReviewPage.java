package com.example.tickettrader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ReviewPage extends AppCompatActivity {
    Button submitRating;
    String currentUser, sellerID;
    RequestQueue requestQueue;
    RatingBar ratingBar;
    TextView rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_page);
        submitRating = findViewById(R.id.btnRate);
        ratingBar = findViewById(R.id.rating_bar);
        rating = findViewById(R.id.tvRating);

        //Used for Volley
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        sellerID = getIntent().getStringExtra("sellerID");

        submitRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postReview();
            }
        });
    }

    void postReview(){
            JSONObject jsonOBJ = new JSONObject();
            rating.setText("Your Rating is: " + ratingBar.getRating());
        try {
            jsonOBJ.put("net_id",sellerID);
            jsonOBJ.put("rating", ratingBar.getRating());
            jsonOBJ.put("rating_id",0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//            jsonOBJ.put("sold",true);


        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,"http://cs309-pp-1.misc.iastate.edu:8080/rating", jsonOBJ, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        requestQueue.add(request);

    }
}
