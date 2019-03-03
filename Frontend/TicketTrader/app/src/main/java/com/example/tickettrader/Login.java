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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    final private String server_URL = "https://cs309-pp-1.misc.iastate.edu:8080/users";
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Register;
    private int Counter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        //Initializes all of the Variables
        Counter = 3;
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.info);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        Info.setText("# of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginVerify(Name.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(com.example.tickettrader.Login.this, Registration.class);
                startActivity(intent);

            }
        });
    }


    private void loginVerify(final String userName, final String userPassword) {

//        String url = "http://cs309-pp-1.misc.iastate.edu:8080/users";
        String url = "https://api.myjson.com/bins/19kf52"; //NO VPN Required

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("users");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject color = jsonArray.getJSONObject(i);

                        String first_name = color.getString("first_name");
                        String last_name = color.getString("last_name");

                        //If Username and Password both exist in the DataTable, Then Return True.
                        if (userName.equals(first_name) && userPassword.equals(last_name)) {
                            Intent intent = new Intent(com.example.tickettrader.Login.this, feedPage.class);
                            startActivity(intent);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

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