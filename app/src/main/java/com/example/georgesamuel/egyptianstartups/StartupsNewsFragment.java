package com.example.georgesamuel.egyptianstartups;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartupsNewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<News> list = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private NewsAdapter adapter;

    public StartupsNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_startups_news, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.startup_news_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);


        return view;
    }

}
