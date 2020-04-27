package com.example.koronainfo;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class Opas extends YouTubeBaseActivity {

    YouTubePlayerView youtube;
    Button nappula;
    YouTubePlayer.OnInitializedListener kuuntelija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opas);
        nappula = (Button) findViewById(R.id.nappula);
        youtube = (YouTubePlayerView) findViewById(R.id.video);

        kuuntelija = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo("ZKt0CJe85gY");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        nappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youtube.initialize(YoutubeConfig.getApiKey(), kuuntelija);

            }
        });

    }

}
