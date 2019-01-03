package com.example.georgesamuel.egyptianstartups;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        HomeNewsFragment homeNewsFragment = new HomeNewsFragment();
        StartupsNewsFragment startupsNewsFragment = new StartupsNewsFragment();

        if(position == 0)
        {
            return homeNewsFragment;
        }
        else
        {
            return startupsNewsFragment;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }


}
