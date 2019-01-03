package com.example.georgesamuel.egyptianstartups;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.google.android.youtube.player.YouTubeBaseActivity;

import io.paperdb.Paper;

public class EntrepreneurMotivationActivity extends YouTubeBaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_motivation);

        recyclerView = (RecyclerView)findViewById(R.id.youtube_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        videoAdapter= new VideoAdapter();
        recyclerView.setAdapter(videoAdapter);

    }


    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_what_is_startup)
        {
            startActivity(new Intent(EntrepreneurMotivationActivity.this, WhatStartupActivity.class));
        }
        else if(id == R.id.nav_how_to_register)
        {
            startActivity(new Intent(EntrepreneurMotivationActivity.this, HowToRegisterActivity.class));
        }
        else if(id == R.id.nav_home)
        {
            startActivity(new Intent(EntrepreneurMotivationActivity.this, MainActivity.class));
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
