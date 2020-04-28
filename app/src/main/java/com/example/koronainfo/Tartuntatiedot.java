package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class Tartuntatiedot extends AppCompatActivity {
    private Spinner spinner;
    private Resources res;
    private String selectedInf;
    private String selectedInc;
    private String totalInf;
    private String totalDth;
    private String totalInc;
    private TextView maakuntaTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);
        TextView infView = (TextView) findViewById(R.id.InfectedCountView);

        res = getResources();
        //totalInf = res.getString(R.string.total_inf);
        //totalDth = res.getString(R.string.total_dth);
        //totalInc = res.getString(R.string.total_incidence);
        setMaakunnat();
        infView.setText(res.getString(R.string.total_info, totalInf, totalDth, totalInc));

        //from https://developer.android.com/guide/topics/ui/controls/spinner
        spinner = (Spinner) findViewById(R.id.maakunnat_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<MaakuntaValues> adapter = new ArrayAdapter<MaakuntaValues>(
                this, android.R.layout.simple_spinner_item, MaakuntaModel.getInstance().getMaakunta());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        maakuntaTextView = (TextView) findViewById(R.id.InfectedMaakuntaView);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView maakuntaTextView = (TextView) findViewById(R.id.InfectedMaakuntaView);
                selectedInf = Integer.toString(MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaInf());
                selectedInc = Double.toString(MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaInc());
                maakuntaTextView.setText(res.getString(R.string.maakunta_info, MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaName(), selectedInf, selectedInc));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                maakuntaTextView.setText("Valitse maakunta");
            }
        });
        ImageView img = (ImageView)findViewById(R.id.ThlLogoView);
        //Thank you Cristian from Stackoverflow https://stackoverflow.com/a/3536535
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://thl.fi/fi/web/infektiotaudit-ja-rokotukset/ajankohtaista/ajankohtaista-koronaviruksesta-covid-19/tilannekatsaus-koronaviruksesta"));
                startActivity(intent);
            }
        });
    }

    private void setMaakunnat() {
        totalInf = "4 576";
        totalDth = "190";
        totalInc = "83";
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Ahvenanmaa",11, 36.8));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Karjala",14, 11.0));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Pohjanmaa",36,18.6));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Savo", 46,46.5));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kainuu",55,76.1));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kanta-Häme", 75,43.9));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Keski-Pohjanmaa", 13, 16.8));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Keski-Suomi", 123, 48.7));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kymenlaakso", 35,21.3));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Lappi", 68, 58.2));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pirkanmaa", 213, 41.4));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjanmaa", 47, 27.7));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Karjala", 24, 14.6));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Pohjanmaa", 122, 29.7));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Savo", 120, 49.1));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Päijät-Häme", 72, 34.3));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Satakunta", 51, 23.5));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Uusimaa", 3204, 190.0));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Varsinais-Suomi", 250, 51.8));
    }
}
