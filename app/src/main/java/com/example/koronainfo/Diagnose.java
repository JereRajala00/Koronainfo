package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Diagnose extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private double points = 0;
    private double totalpoints = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
    }
    public void tulos(View view) {
        RadioButton yes1 = findViewById(R.id.yes); // tarkista tässä metodissa kaikki vastaukset
        if (yes1.isChecked()) {
            points++;
        }
        Intent intent = new Intent(this, DiagnoseFinal.class);
        intent.putExtra(EXTRA_MESSAGE, (Double.toString((points / totalpoints) * 100))); // laske tartunnan todennäköisyys prosentteina ja lähetä se
        startActivity(intent);
    }
}
