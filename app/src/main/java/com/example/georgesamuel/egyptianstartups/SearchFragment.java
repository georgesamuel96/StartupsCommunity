package com.example.georgesamuel.egyptianstartups;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private BottomBar bottomBar;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        View view1 = inflater.inflate(R.layout.activity_main, container, false);

        Log.v("From Search", "Say Hello !");

        /*bottomBar = (BottomBar) view1.findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if(tabId == R.id.tab_home)
                {
                    HomeFragment newFragment = new HomeFragment();
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();

                }
                else if(tabId == R.id.tab_startups)
                {
                    StartupsFragment newFragment = new StartupsFragment();
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
                else if(tabId == R.id.tab_search)
                {
                    SearchFragment newFragment = new SearchFragment();
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
                else if(tabId == R.id.tab_account)
                {
                    ProfileFragment newFragment = new ProfileFragment();
                    getFragmentManager().beginTransaction().replace(R.id.main_fragment, newFragment).commit();
                }
            }
        });*/

        return view;
    }

}
