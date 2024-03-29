package com.example.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ProgressDialog dialog = new ProgressDialog(home.this);
        dialog.setTitle("Loading...");
        dialog.setMessage("please wait");
        dialog.setMax(100);
        dialog.show();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent me_intent = new Intent(getApplicationContext(), me.class);
                startActivity(me_intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());

        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl("file:///android_asset/index.html");

        dialog.dismiss();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_music) {
            // Handle the camera action
            Intent music_intent = new Intent(getApplicationContext(), more.class);
            startActivity(music_intent);
        } else if (id == R.id.nav_video) {

            Intent vida_intent = new Intent(getApplicationContext(), display.class);
            startActivity(vida_intent);
        } else if (id == R.id.nav_picture) {
            Intent pic_intent = new Intent(getApplicationContext(), grid.class);
            startActivity(pic_intent);
        } else if (id == R.id.nav_record) {
            Intent rec_intent = new Intent(getApplicationContext(), rec.class);
            startActivity(rec_intent);
        } else if (id == R.id.nav_share) {
            Intent share_intent = new Intent(getApplicationContext(), share.class);
            startActivity(share_intent);
        } else if (id == R.id.register) {
            Intent save_intent = new Intent(getApplicationContext(), save.class);
            startActivity(save_intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

