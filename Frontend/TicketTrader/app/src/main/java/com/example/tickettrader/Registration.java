package com.example.tickettrader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registration extends AppCompatActivity {

    private Button Back;
    private Button Register;
    private EditText FirstName;
    private EditText LastName;
    private EditText netID;
    private EditText password;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        //Initializes all of the buttons
        Back = (Button) findViewById(R.id.btnBack);
        Register = (Button) findViewById(R.id.btnRegister);
        FirstName = (EditText) findViewById(R.id.first_name); //Change to Email
        LastName = (EditText) findViewById(R.id.last_name); //Change to Password
        netID = (EditText) findViewById(R.id.net_id); //Change to Confirm Password4
        password = (EditText)findViewById(R.id.password);


        //Setups the Requests for Volley
        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();


        //Executes actions after Login is clicked
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Registration.this, Login.class);
                startActivity(Login);

            }
        });

        //Executes Actions after Register is clicked
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(FirstName.getText().toString(), LastName.getText().toString(), netID.getText().toString(), password.getText().toString());

                Intent SecondActivity = new Intent(Registration.this, Login.class);
                startActivity(SecondActivity);

            }
        });
    }


    private void register(final String FirstName, final String LastName, final String netID, final String password)
    {

        String url = "http://cs309-pp-1.misc.iastate.edu:8080/users";
        JSONObject jsonObject = new JSONObject();


        //Creates a JSON to get ready to POST
        try{
            jsonObject.put("first_name",FirstName);
            jsonObject.put("last_name",LastName);
            jsonObject.put("net_Id",netID);
            jsonObject.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //POSTS the JSON, the add it to the Request Queue
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, null, null);
        requestQueue.add(jsonObjectRequest);
//
    }
}