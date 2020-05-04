package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Purpose of this class is to calculate user's probability of being infected based on the questions asked from user.
 * Information will be sent with intent extra to DiagnoseFinal class for displaying.
 * @author Jere Rajala
 * @version 4.5.2020
 */

/** declare all the widgets and variables **/
public class Diagnose extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";
    private double points = 0;
    private double maximumpoints = 12;  /** at the end, amount of gathered points is divided by maximum possible number of points **/
    private TextView kuume;
    private SeekBar kuumemittari;
    public static final String PREFERENCE = "database";
    private RadioButton yes1;
    private RadioButton yes2;
    private RadioButton yes3;
    private RadioButton yes5;
    private RadioButton yes6;
    private RadioButton short1;
    private RadioButton middle1;
    private RadioButton long1;
    private RadioButton yes8;
    private RadioButton yes9;
    private RadioButton no1;
    private RadioButton no2;
    private RadioButton no3;
    private RadioButton no5;
    private RadioButton no6;
    private RadioButton much;
    private RadioButton little;
    private RadioButton no7;
    private RadioButton no8;
    private RadioButton no9;
    @Override
    /** intialize all the widgets and variables, give them values **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
        yes1 = findViewById(R.id.yes1);
        yes2 = findViewById(R.id.yes2);
        yes3 = findViewById(R.id.yes3);
        yes5 = findViewById(R.id.yes5);
        yes6 = findViewById(R.id.yes6);
        short1 = findViewById(R.id.short1);
        middle1 = findViewById(R.id.middle1);
        long1 = findViewById(R.id.long1);
        yes8 = findViewById(R.id.yes8);
        yes9 = findViewById(R.id.yes9);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no5 = findViewById(R.id.no5);
        no6 = findViewById(R.id.no6);
        much = findViewById(R.id.much);
        little = findViewById(R.id.little);
        no7 = findViewById(R.id.no7);
        no8 = findViewById(R.id.no8);
        no9 = findViewById(R.id.no9);
        kuume = findViewById(R.id.kuume);
        kuumemittari = findViewById(R.id.kuumemittari);
        kuumemittari.setMax(43);
        /**  setting up listener for seekbar **/
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
    /** save user data when user exits application **/
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCE, MODE_PRIVATE).edit();
        if (yes1.isChecked()) {
            editor.putString("yes1_data", "True");
        } else {
            editor.putString("yes1_data", "False");
        }
        if (yes2.isChecked()) {
            editor.putString("yes2_data", "True");
        } else {
            editor.putString("yes2_data", "False");
        }
        if (yes3.isChecked()) {
            editor.putString("yes3_data", "True");
        } else {
            editor.putString("yes3_data", "False");
        }
        editor.putString("kuumemittari_data", Integer.toString(kuumemittari.getProgress()));
        if (yes5.isChecked()) {
            editor.putString("yes5_data", "True");
        } else {
            editor.putString("yes5_data", "False");
        }
        if (yes6.isChecked()) {
            editor.putString("yes6_data", "True");
        } else {
            editor.putString("yes6_data", "False");
        }
        if (much.isChecked()) {
            editor.putString("much_data", "True");
        } else {
            editor.putString("much_data", "False");
        }
        if (little.isChecked()) {
            editor.putString("little_data", "True");
        } else {
            editor.putString("little_data", "False");
        }
        if (no7.isChecked()) {
            editor.putString("no7_data", "True");
        } else {
            editor.putString("no7_data", "False");
        }
        if (short1.isChecked()) {
            editor.putString("short1_data", "True");
        }
        if (middle1.isChecked()) {
            editor.putString("middle1_data", "True");
        }
        if (long1.isChecked()) {
            editor.putString("long1_data", "True");
        }
        if (yes8.isChecked()) {
            editor.putString("yes8_data", "True");
        } else {
            editor.putString("yes8_data", "False");
        }
        if (yes9.isChecked()) {
            editor.putString("yes9_data", "True");
        } else {
            editor.putString("yes9_data", "False");
        }
        editor.apply();
        editor.commit();
    }
    /** restore user data from SharedPreferences **/
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        String yes1_data = prefs.getString("yes1_data", "null");
        String yes2_data = prefs.getString("yes2_data", "null");
        String yes3_data = prefs.getString("yes3_data", "null");
        String kuumemittari_data = prefs.getString("kuumemittari_data", "0");
        String yes5_data = prefs.getString("yes5_data", "null");
        String yes6_data = prefs.getString("yes6_data", "null");
        String much_data = prefs.getString("much_data", "null");
        String little_data = prefs.getString("little_data", "null");
        String no7_data = prefs.getString("no7_data", "null");
        String short1_data = prefs.getString("short1_data", "null");
        String middle1_data = prefs.getString("miidle1_data", "null");
        String long1_data = prefs.getString("long1_data", "null");
        String yes8_data = prefs.getString("yes8_data", "null");
        String yes9_data = prefs.getString("yes9_data", "null");
        if (yes1_data.equals("True")) {
            yes1.setChecked(true);
        } else {
            no1.setChecked(true);
        }
        if (yes2_data.equals("True")) {
            yes2.setChecked(true);
        } else {
            no2.setChecked(true);
        }
        if (yes3_data.equals("True")) {
            yes3.setChecked(true);
        } else {
            no3.setChecked(true);
        }
        kuumemittari.setProgress(Integer.parseInt(kuumemittari_data));
        if (yes5_data.equals("True")) {
            yes5.setChecked(true);
        } else {
            no5.setChecked(true);
        }
        if (yes6_data.equals("True")) {
            yes6.setChecked(true);
        } else {
            no6.setChecked(true);
        }
        if (much_data.equals("True")) {
            much.setChecked(true);
        }
        if (little_data.equals("True")) {
            little.setChecked(true);
        }
        if (no7_data.equals("True")) {
            no7.setChecked(true);
        }
        if (short1_data.equals("True")) {
            short1.setChecked(true);
        }
        if (middle1_data.equals("True")) {
            middle1.setChecked(true);
        }
        if (long1_data.equals("True")) {
            long1.setChecked(true);
        }
        if (yes8_data.equals("True")) {
            yes8.setChecked(true);
        } else {
            no8.setChecked(true);
        }
        if (yes9_data.equals("True")) {
            yes9.setChecked(true);
        } else {
            no9.setChecked(true);
        }
    }
    /** check all the user answers here and call this method from final button **/
    public void tulos(View view) {
        points = 0;  // always start point counting from zero
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
        } else if (kuumemittari.getProgress() > 39) {   // if temperature is over 39 degrees, add two points
            points = points + 2;
        }
        if (yes5.isChecked()) {
            points++;
        }
        if (yes6.isChecked()) {
            points++;
        }
        if (much.isChecked()) {
            points++;
        }
        if (yes8.isChecked()) {  // add two points here if true
            points = points + 2;
        }
        if (yes9.isChecked()) {
            points++;
        }
        if (short1.isChecked() || middle1.isChecked()) {
            points++;
        }
        /** calculate infection probability and send it to DiagnoseFinal **/
        Intent intent = new Intent(this, DiagnoseFinal.class);
        intent.putExtra(EXTRA_MESSAGE, Long.toString((Math.round((points / maximumpoints) * 100))));
        if ((points / maximumpoints) * 100 < 40) {   // send also a message to user
            intent.putExtra(EXTRA_MESSAGE2, "Alhainen tartunnan todennäköisyys");
        }
        if ((points / maximumpoints) * 100 > 40 && (points / maximumpoints) * 100 < 70) {
            intent.putExtra(EXTRA_MESSAGE2, "Kohtalainen tartunnan todennäköisyys");
        }
        if ((points / maximumpoints) * 100 > 70) {
            intent.putExtra(EXTRA_MESSAGE2, "Korkea tartunnan todennäköisyys");
        }
        startActivity(intent);
    }
}
