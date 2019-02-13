package com.example.tickettrader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class Login extends AppCompatActivity {

    final private String server_URL = "https://cs309-pp-1.misc.iastate.edu:8080";
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Counter = 3;
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        Info.setText("# of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });



    }

    private void validate(String userName, String userPassword){

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, server_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Info.setText(response.toString());
                        requestQueue.stop();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Info.setText("Something went wrong........");
                        error.printStackTrace();
                    }
                }
        );

        requestQueue.add(stringRequest);

        if(userName.equals("Admin") && (userPassword.equals("password")))
        {
            Intent intent = new Intent(com.example.tickettrader.Login.this, SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            Counter--;

            Info.setText("# of attempts remaining: " + String.valueOf(Counter));

            if(Counter == 0)
            {
                Login.setEnabled(false);
            }
        }
    }
}