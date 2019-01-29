package com.example.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("# of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });



    }

    private void validate(String userName, String userPassword){
        if(userName.equals("Admin") && (userPassword.equals("password")))
        {
            Intent intent = new Intent(com.example.sandbox.Login.this, SecondActivity.class);
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
