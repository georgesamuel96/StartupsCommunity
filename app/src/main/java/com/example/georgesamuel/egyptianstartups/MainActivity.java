package com.example.georgesamuel.egyptianstartups;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private BottomBar bottomBar;
    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase, "en"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for set selected from navigation drawer
        Paper.init(this);
        String language = Paper.book().read("language");
        Paper.book().write("language", "en");
        setTitle(R.string.app_name);
        updateView("en");


        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if(tabId == R.id.tab_home)
                {
                    //reSetMarginFragment();
                    HomeFragment newFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
                else if(tabId == R.id.tab_startups)
                {
                    //reSetMarginFragment();
                    StartupsFragment newFragment = new StartupsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
                else if(tabId == R.id.tab_search)
                {
                    //reSetMarginFragment();
                    SearchFragment newFragment = new SearchFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
                else if(tabId == R.id.tab_account)
                {
                    //reSetMarginFragment();
                    ProfileFragment newFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
            }
        });

    }

    private void updateView(String language) {
        Context context = LocalHelper.setLocale(this, language);
        Resources resources = context.getResources();

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



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.nav_what_is_startup)
        {
            startActivity(new Intent(MainActivity.this, WhatStartupActivity.class));
        }
        else if(id == R.id.nav_how_to_register)
        {
            startActivity(new Intent(MainActivity.this, HowToRegisterActivity.class));
        }
        else if(id == R.id.nav_entrepreneur_motivation)
        {
            startActivity(new Intent(MainActivity.this, EntrepreneurMotivationActivity.class));
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /*public void reSetMarginFragment()
    {
        FrameLayout frameLayout;
        frameLayout = (FrameLayout) findViewById(R.id.main_fragment);

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0,110, 0, 0);
        frameLayout.requestLayout();
    }

    public void setMarginFragment()
    {
        FrameLayout frameLayout;
        frameLayout = (FrameLayout) findViewById(R.id.main_fragment);

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0,65, 0, 0);
        frameLayout.requestLayout();
    }*/
}
