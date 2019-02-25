package com.example.tickettrader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
//    private Button Back;
    RequestQueue requestQueue;
    String url;

    List<feed> feedData =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Back = (Button) findViewById(R.id.btnBack);
//
//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(feedPage.this, Login.class);
//                startActivity(intent);
//            }
//        });
        //Make call to AsyncTask
        //new jasonparse().execute();

        requestQueue = Volley.newRequestQueue(this);
//        url = "https://api.androidhive.info/json/contacts.json";
        url = "https://api.myjson.com/bins/77i0u";

        refresh(url);

    }


    private void refresh(String url)

//    url = "https://api.myjson.com/bins/77i0u";
    { final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                JSONArray jsonArray = response.getJSONArray("ticket");

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject json_data = jsonArray.getJSONObject(i);

                    feed Feed = new feed();
                    Feed.setSport(json_data.getString("sport"));
                    //User.setGameLocation(json_data.getString("gameLocation"));
                    //User.setTicketiD(json_data.getString("ticketID"));
//                        User.setPhoto(json_data.getString("image"));
                    Feed.setGame_Date(json_data.getString("game_date"));
                    Feed.setPrice(json_data.getInt("price"));

                    feedData.add(Feed);

                }

                mFeed = findViewById(R.id.ticketList);
                mAdapter = new feedAdapter(feedPage.this, feedData);
                mFeed.setAdapter(mAdapter);
                mFeed.setLayoutManager(new LinearLayoutManager(feedPage.this));
            }catch(JSONException e){
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
