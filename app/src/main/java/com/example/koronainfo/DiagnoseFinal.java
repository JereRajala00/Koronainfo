package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DiagnoseFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_final);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Diagnose.EXTRA_MESSAGE);
        TextView tulosteksti = findViewById(R.id.tulosteksti);
        tulosteksti.setText(message);
    }

}
