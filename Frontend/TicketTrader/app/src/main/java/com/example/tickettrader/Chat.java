package com.example.tickettrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


public class Chat extends AppCompatActivity {
    private EditText message;
    private Button send;
    private String url;
    private String otherUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        this.message = (EditText) findViewById(R.id.mtext);
        this.send = (Button) findViewById(R.id.send_btn);
        this.otherUser = getIntent().getExtras("EXTRA_other_user");

    }
}
