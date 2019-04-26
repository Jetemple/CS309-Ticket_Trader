package com.example.tickettrader;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

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
    private ImageButton back;
    private String url;
    private ListView mChat;
    private String otherUser;
    private String user;
    private DatabaseHelper dbHelper;
    private WebSocketClient cc;
    private ChatAdapter cAdapter;
    private String ticketId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        this.back = (ImageButton) findViewById(R.id.chat_back);
        this.message = (EditText) findViewById(R.id.mtext);
        this.send = (Button) findViewById(R.id.send_btn);
        this.mChat = (ListView) findViewById(R.id.messages_view);
        this.otherUser = getIntent().getStringExtra("other_user");
        this.ticketId = getIntent().getStringExtra("ticket_id");
        this.dbHelper = new DatabaseHelper(this);
        Cursor data = dbHelper.getData();
        data.moveToNext();
        data.moveToNext();
        data.moveToNext();
        this.user = data.getString(1);
        this.url = "ws://cs309-pp-1.misc.iastate.edu:8080/websocket/" + this.otherUser + "/" + this.user + "/" + ticketId;
//        this.url = "ws://cs309-pp-1.misc.iastate.edu:8080/websocket/jetemple@iastate.edu/admin1@iastate.edu/" + ticketId;

        this.cAdapter = new ChatAdapter(Chat.this);
        this.mChat.setAdapter(cAdapter);

        System.out.println("The ticket id " + ticketId);

        Draft[] drafts = {new Draft_6455()};
        try {
            Log.d("trying", "");
            cc = new WebSocketClient(new URI(url), (Draft) drafts[0]) {
                @Override
                public void onMessage(String message) {
                    final Message m = new Message(message, 0);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cAdapter.add(m);
                        }
                    });
                }

                @Override
                public void onOpen(ServerHandshake handshake) {
                    Log.d("open", "");
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.d("close", "");
                    System.out.println(reason);
                }

                @Override
                public void onError(Exception e) {
                    System.out.println("error");
                    e.printStackTrace();
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        cc.connect();

        this.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cc.send(message.getText().toString());
                    Message m = new Message(message.getText().toString(), 1);
                    cAdapter.add(m);
                    message.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
