package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

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

/**
 * This class is for tartuntatiedot (infection data) activity.
 *
 * Class sets values for infection data and sets it using MaakuntaModel singleton which can be used to create a new ArrayList of MaakuntaValues.
 * Initializes a spinner using values from setMaakunnat() method. Sets listener for the spinner.
 * The correct data for the provinces are set in the OnItemSelectedListener() -method using getInstance().getMaakunta(position) -method.
 * @author Tiitus Telke
 * @version 30.4.2020
 * @see MaakuntaModel
 * @see MaakuntaValues
 */

public class Tartuntatiedot extends AppCompatActivity {
    private Spinner spinner;
    private Resources res;
    private Integer selectedInf;            //amount of infections in selected province (maakunta)
    private Double selectedInc;             //incidence in selected province
    private Integer totalInf;               //amount of infections in whole country
    private Integer totalDth;               //deaths in whole country
    private Double totalInc;                //incidence in whole country
    private TextView infView;                //this TextView shows the infection and death data in whole country
    private TextView maakuntaTextView;      //this TextView shows the

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);
        infView = (TextView) findViewById(R.id.InfectedCountView);

        /* Gets resources to res variable
         * Sets all the data for the provinces with setMaakunnat() -method
         * Adds to total_info resource variables totalInf(all infections), totalDth(deaths) ja totalInc(incidence) ja sets the resource for the infView TextView.
         */
        res = getResources();
        setMaakunnat();
        infView.setText(res.getString(R.string.total_info, totalInf, totalDth, totalInc));

        /*
         * initializes the spinner and ArrayAdapter using maakunnat_array -resource. I used the example from https://developer.android.com/guide/topics/ui/controls/spinner
         */
        spinner = (Spinner) findViewById(R.id.maakunnat_spinner);
        // Creates the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.maakunnat_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        maakuntaTextView = (TextView) findViewById(R.id.InfectedMaakuntaView);

        // Sets listener for the spinner. TextView is used according to selected province using maakunta_info resource. Values are retrieved using MaakuntaModel and the position variable.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedInf = MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaInf();
                selectedInc = MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaInc();
                maakuntaTextView.setText(res.getString(R.string.maakunta_info, MaakuntaModel.getInstance().getMaakunta(position).getMaakuntaName(), selectedInf, selectedInc));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                maakuntaTextView.setText("Valitse maakunta");
            }
        });

         //Sets listener for logo of the Finnish institute of health and welfare. I used an example code. Thank you Cristian from Stackoverflow https://stackoverflow.com/a/3536535.

        ImageView img = (ImageView)findViewById(R.id.ThlLogoView);
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

    /**
     * Creates a new ArrayList of MaakuntaValues using MaakuntaModel and sets total infected and deaths also.
     * @setMaakunnat Creates a new ArrayList of MaakuntaValues using MaakuntaModel and sets total infected and deaths also.
     * @see MaakuntaModel
     * @see MaakuntaValues
     */
    private void setMaakunnat() {
        totalInf = 5254;
        totalDth = 230;
        totalInc = 95.0;
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Ahvenanmaa",11, 36.8));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Karjala",14, 11.0));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Pohjanmaa",36,18.6));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Etelä-Savo", 46,46.5));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kainuu",63,87.1));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kanta-Häme", 86,50.3));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Keski-Pohjanmaa", 13, 16.8));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Keski-Suomi", 127, 50.3));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Kymenlaakso", 37,22.5));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Lappi", 70, 59.9));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pirkanmaa", 231, 44.9));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjanmaa", 51, 30.1));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Karjala", 24, 14.6));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Pohjanmaa", 128, 31.2));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Pohjois-Savo", 124, 50.8));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Päijät-Häme", 75, 35.7));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Satakunta", 51, 23.5));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Uusimaa", 3662, 217.2));
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Varsinais-Suomi", 278, 57.7));
    }
}
