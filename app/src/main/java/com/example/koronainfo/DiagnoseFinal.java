// author Jere Rajala
package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Purpose of this class is to display information received from Diagnose class and also offer return to main function
 * @author Jere Rajala
 * @version 4.5.2020
 */

public class DiagnoseFinal extends AppCompatActivity {

    @Override
    /** display infection probability in percents and message to user **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_final);
        Intent intent = getIntent();
        String probability = intent.getStringExtra(Diagnose.EXTRA_MESSAGE);
        String message = intent.getStringExtra(Diagnose.EXTRA_MESSAGE2);
        TextView tulosteksti = findViewById(R.id.tulosteksti);
        TextView kommentti = findViewById(R.id.kommentti);
        tulosteksti.setText(probability + " %");
        kommentti.setText(message);
    }
    /** return to MainActivity (first screen) **/
    public void returnToMain(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
