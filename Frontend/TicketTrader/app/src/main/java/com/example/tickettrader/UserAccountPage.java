package com.example.tickettrader;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAccountPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ImageView user_pic;
    private TextView name;
    private TextView netID;
    private TextView userID;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_page);

        user_pic = (ImageView)findViewById(R.id.user_pic);
        name = (TextView)findViewById(R.id.name);
        netID = (TextView)findViewById(R.id.net_id);
        userID = (TextView)findViewById(R.id.user_id);
        dbHelper = new DatabaseHelper(this);

        Cursor data = dbHelper.getData();

        if(data.getCount() < 0){
            name.setText("Name");
            netID.setText("Net ID");
            userID.setText("User ID");
        } else{
            data.moveToNext();
            String first = data.getString(1);
            data.moveToNext();
            String last = data.getString(1);
            data.moveToNext();
            name.setText("Name: " + first + " " + last);

            String net = data.getString(1);
            data.moveToNext();
            netID.setText("Net ID: " + net);

            String user = data.getString(1);
            userID.setText("User ID: " + user);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Your Account");
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.feed) {
            Intent feed = new Intent(UserAccountPage.this, feedPage.class);
            startActivity(feed);
        } else if (id == R.id.sell) {
            Intent sell = new Intent(UserAccountPage.this, sellPage.class);
            startActivity(sell);
        } else if (id == R.id.userAccount) {

        } else if (id == R.id.logout) {
            Intent login = new Intent(UserAccountPage.this, Login.class);
            startActivity(login);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}