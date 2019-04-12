package com.example.tickettrader;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tickettrader.Adapters.ChatAdapter;

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
    private String user;
    private DatabaseHelper dbHelper;
    private WebSocketClient cc;
    private ChatAdapter cAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        this.message = (EditText) findViewById(R.id.mtext);
        this.send = (Button) findViewById(R.id.send_btn);
        this.otherUser = getIntent().getStringExtra("other_user");
        this.dbHelper = new DatabaseHelper(this);
        Cursor data = dbHelper.getData();
        data.moveToNext();
        data.moveToNext();
        data.moveToNext();
        this.user = data.getString(1);
        this.url = "cs309-pp-1.misc.iastate.edu:8080/message/" + this.user + "/" + this.otherUser;
        Draft[] drafts = {new Draft_6455()};
        this.cAdapter = new ChatAdapter(this);

        try {
            cc = new WebSocketClient(new URI(url),(Draft) drafts[0]) {
                @Override
                public void onMessage(String message) {
                    Message m = new Message(message, 0);
                    cAdapter.add(m);
                }

                @Override
                public void onOpen(ServerHandshake handshake) {
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                }

                @Override
                public void onError(Exception e) {
                }
            };
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        cc.connect();

        this.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cc.send(message.getText().toString());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
