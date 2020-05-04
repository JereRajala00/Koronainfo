package com.example.koronainfo;


        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayerFragment;
        import com.google.android.youtube.player.YouTubePlayerSupportFragment;
        import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Luokka sisältää oppaan jossa mm käsienpesuvideo ja THL:n ohjeita viruksen välttämiseksi
 * @author Jarno Kaikkonen
 * @version 30.4.2020
 */

public class Opas extends YouTubeBaseActivity {


    YouTubePlayerView youtube;
    Button nappula;
    Button next;

    YouTubePlayer.OnInitializedListener kuuntelija;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/**
 * Youtubevideo toistaminen painamalla Toista-painiketta video lähtee pyörimään
 */
        setContentView(R.layout.activity_opas);
        nappula = (Button) findViewById(R.id.nappula);
        youtube = (YouTubePlayerView) findViewById(R.id.video);

        kuuntelija = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("isLPN0UdeDM");
                /**
                 * jos success niin pyöritä video
                 */
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                /**
                 * jos fail niin älä tee mitään (voi laittaa koodia)
                 */

            }
        };
        nappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youtube.initialize(YoutubeConfig.getApiKey(), kuuntelija);
                /**
                 * haetaan API key YoutubeConfig luokasta
                 */

            }
        });
    }

    public void plus(View view) {
        final TextView teksti = findViewById(R.id.opas);
        next = (Button) findViewById(R.id.next);
/**
 * luodaan taulukko johon laitetaan ohjeita ja otetaan niitä randomilla sieltä
 */
        final String[] ohjet = {"Pese kädet!", "Vältä kättelyä.", "Tee etätöitä mahdollisuuksien mukaan.",
                "Älä koskettele silmiä, nenää tai suuta", "Älä osallistu ryhmäharrastuksiin, tapahtumiin tai yli 10 hengen tilaisuuksiin.",
                "Jos sinulla on lieviäkin hengitystieinfektion oireita, pysy kotona. "};
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sekota = (int) (Math.random()*6);
                teksti.setText(ohjet[sekota]);
            }
        });

    }
}







