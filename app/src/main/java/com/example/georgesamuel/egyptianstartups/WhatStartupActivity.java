package com.example.georgesamuel.egyptianstartups;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import io.paperdb.Paper;

public class WhatStartupActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_startup);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if(id == R.id.nav_home)
        {
            startActivity(new Intent(WhatStartupActivity.this, MainActivity.class));
        }
        else if(id == R.id.nav_how_to_register)
        {
            startActivity(new Intent(WhatStartupActivity.this, HowToRegisterActivity.class));
        }
        else if(id == R.id.nav_entrepreneur_motivation)
        {
            startActivity(new Intent(WhatStartupActivity.this, EntrepreneurMotivationActivity.class));
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout daDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(daDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            daDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
