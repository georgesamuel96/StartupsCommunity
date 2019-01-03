package com.example.georgesamuel.egyptianstartups;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class StartupAdapter extends RecyclerView.Adapter<StartupAdapter.MyViewHolder> {

    private Context context;

    public StartupAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_startup, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        /*if(i == 3)
        {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) myViewHolder.cardView.getLayoutParams();
            layoutParams.setMargins(16, 4, 16, 140);
            myViewHolder.cardView.requestLayout();
        }*/

        myViewHolder.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment, new StartUpDetailFragment()).addToBackStack(null).commit();*/

                /*((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment, new StartUpDetailFragment()).addToBackStack(null).commit();*/

                Intent i = new Intent(context, StartupDetailActivity.class);
                context.startActivity(i);

               // ((Activity) context).overridePendingTransition(0,0);

            }
        });

    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        private Button goButton;

        public MyViewHolder(View view)
        {
            super(view);
            cardView = (CardView) view.findViewById(R.id.startup_cardview);
            goButton = (Button) view.findViewById(R.id.go_btn);
        }
    }
}
