package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * This class is for tartuntatiedot (infection data) activity.
 *
 * Class sets values for infection data and sets it using MaakuntaModel singleton which can be used to create a new ArrayList of MaakuntaValues.
 * Initializes a spinner using values from setMaakunnat() method. Sets listener for the spinner.
 * The correct data for the provinces are set in the OnItemSelectedListener() -method using getInstance().getMaakunta(position) -method.
 * @author Tiitus Telke
 * @version 22.12.2020
 * @see MaakuntaModel
 * @see MaakuntaValues
 */

public class Tartuntatiedot extends AppCompatActivity implements AsyncResponse{
    private Spinner spinner;
    private Resources res;
    private Integer selectedInf;            //amount of infections in selected province (maakunta)
    private Double selectedInc;             //incidence in selected province
    private Integer totalInf;               //amount of infections in whole country
    private Integer totalDth;               //deaths in whole country
    private Double totalInc;                //incidence in whole country
    private TextView infView;                //this TextView shows the infection and death data in whole country
    private TextView maakuntaTextView;      //this TextView shows the
    FetchData fd = new FetchData();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);

        infView = (TextView) findViewById(R.id.InfectedCountView);


        /* Gets resources to res variable
         * Sets all the data for the provinces with setMaakunnat() -method
         * Adds to total_info resource variables totalInf(all infections), totalDth(deaths) ja totalInc(incidence) ja sets the resource for the infView TextView.
         */
        totalInf = 5254;
        totalDth = 230;
        totalInc = 95.0;
        res = getResources();
        //setMaakunnat();
        infView.setText(res.getString(R.string.total_info, totalInf, totalDth, totalInc));


        maakuntaTextView = (TextView) findViewById(R.id.InfectedMaakuntaView);

        // Sets listener for the spinner. TextView is used according to selected province using maakunta_info resource. Values are retrieved using MaakuntaModel and the position variable.



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

        fd.delegate = this;
        fd.execute();

        //setMaakunnat();
    }

    /**
     * Creates a new ArrayList of MaakuntaValues using MaakuntaModel and sets total infected and deaths also.
     * @setMaakunnat Creates a new ArrayList of MaakuntaValues using MaakuntaModel and sets total infected and deaths also.
     * @see MaakuntaModel
     * @see MaakuntaValues
     */
    @Override
    public void setMaakunnat(JSONObject result) {
        try {
            JSONObject infCounts = result.getJSONObject("dataset").getJSONObject("value");
            JSONObject county = result.getJSONObject("dataset").getJSONObject("dimension").getJSONObject("hcdmunicipality2020").getJSONObject("category").getJSONObject("label");
            JSONArray infArray = infCounts.toJSONArray(infCounts.names());
            JSONArray countyArray = county.toJSONArray(county.names());
            Log.wtf("test", String.valueOf(infArray.length()));
            for (int i = 0; i < infArray.length() - 1; i++) {
                Log.wtf("test",countyArray.getString(i));
                MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues(countyArray.getString(i),infArray.getInt(i), 36.8));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

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
    }
}
