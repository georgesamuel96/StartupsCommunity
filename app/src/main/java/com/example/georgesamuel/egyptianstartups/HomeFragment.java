package com.example.georgesamuel.egyptianstartups;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    private TextView textView;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        /**/

        /**/

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        setupTabLayout();
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 2; i++) {
                    if (i == position) {
                        tabLayout.getTabAt(i).getCustomView().setBackgroundResource(R.drawable.tab_background_selected);
                    } else {
                        tabLayout.getTabAt(i).getCustomView().setBackgroundColor(Color.parseColor("#00000000"));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        return view;

    }

    private void setupTabLayout() {

        TextView customTab1 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab_layout, null);
        TextView customTab2 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab_layout, null);
        customTab1.setText(R.string.home);
        customTab1.setBackgroundResource(R.drawable.tab_background_selected);
        tabLayout.getTabAt(0).setCustomView(customTab1);
        customTab2.setText(getString(R.string.startUps));
        customTab2.setBackgroundResource(R.color.transparent);
        tabLayout.getTabAt(1).setCustomView(customTab2);

    }



    /*private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            Log.v("show fragment", "asddddd");

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_fragment, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            return true;
        }
        return false;
    }*/

}
