package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Diagnose extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private double points = 0;
    private double maximumpoints = 11;
    private TextView kuume;
    private SeekBar kuumemittari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
        kuume = findViewById(R.id.kuume);
        kuumemittari = findViewById(R.id.kuumemittari);
        kuumemittari.setMax(43);
        kuumemittari.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kuume.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void tulos(View view) {
        RadioButton yes1 = findViewById(R.id.yes); // tarkista tässä metodissa kaikki vastaukset
        RadioButton yes2 = findViewById(R.id.yes2);
        RadioButton yes3 = findViewById(R.id.yes3);
        RadioButton yes5 = findViewById(R.id.yes5);
        RadioButton yes6 = findViewById(R.id.yes6);
        RadioButton short1 = findViewById(R.id.short1);
        RadioButton middle1 = findViewById(R.id.middle1);
        RadioButton yes8 = findViewById(R.id.yes8);
        RadioButton yes9 = findViewById(R.id.yes9);
        if (yes1.isChecked()) {
            points++;
        }
        if (yes2.isChecked()) {
            points++;
        }
        if (yes3.isChecked()) {
            points++;
        }
        if (kuumemittari.getProgress() > 36 && kuumemittari.getProgress() < 39) {
            points++;
        } else if (kuumemittari.getProgress() > 39) { // jos lämpötila on yli 39 astetta, lisätään 2 pistettä
            points = points + 2;
        }
        if (yes5.isChecked()) {
            points++;
        }
        if (yes6.isChecked()) {
            points++;
        }
        if (short1.isChecked() || middle1.isChecked()) {
            points++;
        }
        if (yes8.isChecked()) {  // lisätään 2 pistettä, jos lähikontaktia koronapositiiviseen on ollut
            points = points + 2;
        }
        if (yes9.isChecked()) {
            points++;
        }
        Intent intent = new Intent(this, DiagnoseFinal.class);
        intent.putExtra(EXTRA_MESSAGE, (Double.toString((points / maximumpoints) * 100))); // laske tartunnan todennäköisyys prosentteina ja lähetä se
        startActivity(intent);
    }
}
