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
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
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


    private void loginVerify(final String userName, final String userPassword)
    {

        String url = "http://cs309-pp-1.misc.iastate.edu:8080/users";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("users");
                    for (int i = 0; i<jsonArray.length(); i++)
                    {
                        JSONObject color = jsonArray.getJSONObject(i);

                        String first_name = color.getString("first_name");
                        String last_name = color.getString("last_name");

                        //If Username and Password both exist in the DataTable, Then Return True.
                        if(userName.equals(first_name) && userPassword.equals(last_name))
                        {
                            Intent intent = new Intent(com.example.tickettrader.Login.this, SecondActivity.class);
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


    //Second Validate USERName and Password Method. Will delete late @TODO
//    private void validate(String userName, String userPassword){
//
//        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, server_URL, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Info.setText(response.toString());
//                        requestQueue.stop();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Info.setText("Something went wrong........");
//                        error.printStackTrace();
//                    }
//                }
//        );
//
//        requestQueue.add(stringRequest);
//
//        if(userName.equals("Admin") && (userPassword.equals("password")))
//        {
//            Intent intent = new Intent(com.example.tickettrader.Login.this, SecondActivity.class);
//            startActivity(intent);
//        }
//        else
//        {
//            Counter--;
//
//            Info.setText("# of attempts remaining: " + String.valueOf(Counter));
//
//            if(Counter == 0)
//            {
//                Login.setEnabled(false);
//            }
//        }
//    }
}


//DELETE BELOW THIS @TODO
//package com.neel;
//
//        import android.app.Activity;
//
///**
// * @author Neelmani.Karn
// *
// */
//public class MainActivity extends Activity {
//
//    private ProgressDialog mProgressDialog;
//    private Button btn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btn_ = (Button) findViewById(R.id.btn);
//
//        btn.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                login("Username", "Password");
//            }
//        });
//    }
//
//
//
//    private void login(String username, String password){
//        String url= YOUR URL;
//        JSONObject jsonObject = new JSONObject();
//
//        try {
//            jsonObject .put("username", username);
//            jsonObject .put("password", password);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        if (android.os.Build.VERSION.SDK_INT >= 11) {
//            mProgressDialog = new ProgressDialog(LoginActivity.this, ProgressDialog.THEME_HOLO_LIGHT);
//        } else {
//            mProgressDialog = new ProgressDialog(LoginActivity.this);
//        }
//        mProgressDialog.setMessage(Html.fromHtml("<b>" + getString(R.string.loading)+ "</b>"));
//        mProgressDialog.setIndeterminate(true);
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.show();
//
//        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                com.android.volley.Request.Method.POST, url,
//                loginObject,
//                new com.android.volley.Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        mProgressDialog.dismiss();
//                        Log.v("reponse", "" + response);
//
//
//
//                        startActivity(new Intent(SoruceActivity.this, TargetActivity.class));
//                        finish();
//                    }
//
//
//                }, new com.android.volley.Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                if (error!=null) {
//
//                    Toast.makeText(LoginActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
//                    VolleyLog.d("Neelmani Karn", "Error: " + error.getMessage());
//
//                    System.out.println(error.networkResponse.statusCode+"))))))))))))))))");
//                    System.out.println(error);
//                    if (mProgressDialog != null) {
//                        mProgressDialog.dismiss();
//                        mProgressDialog = null;
//                    }
//                }else{
//                    Toast.makeText(LoginActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
//                    System.out.println(error);
//                    if (mProgressDialog != null) {
//                        mProgressDialog.dismiss();
//                        mProgressDialog = null;
//                    }
//                }
//            }
//        });
//
//        queue.add(jsonObjectRequest);
//
//    }
//}