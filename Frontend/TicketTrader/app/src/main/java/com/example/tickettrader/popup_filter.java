package com.example.tickettrader;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

public class popup_filter extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_filter);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.9));
    }
}

