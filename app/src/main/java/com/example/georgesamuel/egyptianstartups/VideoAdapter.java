package com.example.georgesamuel.egyptianstartups;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    Context context;

    public VideoAdapter()
    {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        this.context = viewGroup.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int i) {

        myViewHolder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewHolder.youTubePlayerView.initialize(PlayerConfig.API_KEY, myViewHolder.onInitializedListener);
            }
        });


        myViewHolder.onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("89_KXT5ztTU");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(context, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private Button play;
        YouTubePlayerView youTubePlayerView;
        YouTubePlayer.OnInitializedListener onInitializedListener, onInitializedListener2;

        public MyViewHolder(View view)
        {
            super(view);
            play = (Button) view.findViewById(R.id.play);
            youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player_view);
        }
    }
}
