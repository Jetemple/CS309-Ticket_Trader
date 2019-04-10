package com.example.tickettrader;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class popup_filter extends Activity{
    private EditText date;
    private Spinner sportSpinner,  opponentSpinner;
    int year, month, day;
    Button btnFilter;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_filter);

        btnFilter = findViewById(R.id.btnFilter);
        //Change how much of the screen the popup window fills (in percent)
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.97),(int) (height*.97));


//        Intent intent = getIntent();
//        Bundle args = intent.getBundleExtra("Bundle");
//        List<feed> feedData = new ArrayList<>();
//        feedData = feedPage.retFeedData();
        String[] sportArray = getResources().getStringArray(R.array.sport_array);
        String[] opponentArray = getResources().getStringArray(R.array.opponent_array);

//        ArrayAdapter<String> sportAdaper = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sportArray);
//        ArrayAdapter<String> opponentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opponentArray);
//        sOpponents.findViewById(R.id.spinner);
//        sOpponents.setAdapter(opponentAdapter);






        sportSpinner = (Spinner) findViewById(R.id.spinner);
        opponentSpinner = (Spinner) findViewById(R.id.spinner2);


        ArrayAdapter<String> sportAdapter = new ArrayAdapter<String>(popup_filter.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sport_array));

        sportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportSpinner.setAdapter(sportAdapter);


        ArrayAdapter<String> opponentAdapter = new ArrayAdapter<String>(popup_filter.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.opponent_array));

        opponentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opponentSpinner.setAdapter(opponentAdapter);



        date = findViewById(R.id.Date_popup);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(popup_filter.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText((month+1)+"/"+day+"/"+year);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject ret = new JSONObject();

                try {
                    ret = filter();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(popup_filter.this, feedPage.class);
                i.putExtra("json", ret.toString());
                setResult(RESULT_OK,i);
                finish();

            }
        });
    }


    public JSONObject filter() throws JSONException {
        String game_date = (month+1)+"/"+day+"/"+year;
        String sport = sportSpinner.getSelectedItem().toString();
        String opponent = opponentSpinner.getSelectedItem().toString();

        JSONObject ret = new JSONObject();
        ret.put("date", game_date);
        ret.put("sport", sport);
        ret.put("opponent", opponent);

        return ret;
    }
}

