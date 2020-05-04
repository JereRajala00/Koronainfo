// author Jere Rajala
package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DiagnoseFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_final);
        Intent intent = getIntent();
        String probability = intent.getStringExtra(Diagnose.EXTRA_MESSAGE);  // get the intent extra messages
        String message = intent.getStringExtra(Diagnose.EXTRA_MESSAGE2);
        TextView tulosteksti = findViewById(R.id.tulosteksti);
        TextView kommentti = findViewById(R.id.kommentti);
        tulosteksti.setText(probability + " %");  // display infection probability in percents and message to user
        kommentti.setText(message);
    }
    public void returnToMain(View view) {  // return to MainActivity (first screen)
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
