package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OpenScreenOne(View view) {
        Intent intent = new Intent(this, Diagnose.class);
        startActivity(intent);
    }
    public void OpenScreenTwo(View view) {
        Intent intent = new Intent(this, Tartuntatiedot.class);
        startActivity(intent);
    }
    public void OpenScreenThree(View view) {
        Intent intent = new Intent(this, Opas.class);
        startActivity(intent);
    }
    public void exit(View view) {
        finishAffinity();  // close the entire application
    }
}
