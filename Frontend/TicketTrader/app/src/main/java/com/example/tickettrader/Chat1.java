package com.example.tickettrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Chat1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat1);
        WebView wb = (WebView) findViewById(R.id.web_view);
        wb.loadUrl("file:///android_asset/index.html");
    }
}
