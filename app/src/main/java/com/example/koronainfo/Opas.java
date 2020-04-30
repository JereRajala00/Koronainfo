package com.example.koronainfo;


        import android.os.Bundle;

        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.app.AppCompatCallback;
        import androidx.appcompat.app.AppCompatDelegate;
        import androidx.fragment.app.FragmentManager;

        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayerFragment;
        import com.google.android.youtube.player.YouTubePlayerSupportFragment;
        import com.google.android.youtube.player.YouTubePlayerView;



public class Opas extends YouTubeBaseActivity {


    YouTubePlayerView youtube;
    Button nappula;
    Button next;

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

    public void plus(View view) {
        final TextView teksti = findViewById(R.id.opas);
        next = (Button) findViewById(R.id.next);

        final String[] ohjet = {"Pese kädet!", "Vältä kättelyä.", "Tee etätöitä mahdollisuuksien mukaan.",
                "Älä koskettele silmiä, nenää tai suuta", "Älä osallistu ryhmäharrastuksiin, tapahtumiin tai yli 10 hengen tilaisuuksiin.",
                "Jos sinulla on lieviäkin hengitystieinfektion oireita, pysy kotona. "};
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sekota = (int) (Math.random() * 6);
                teksti.setText(ohjet[sekota]);
            }
        });

    }


}






