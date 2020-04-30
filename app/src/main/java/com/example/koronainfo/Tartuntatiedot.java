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
 * Luokka sisältää tartuntatiedot-aktiviteetin käyttöön liittyviä toimintoja.
 * @author Tiitus Telke
 * @version 30.4.2020
 */

public class Tartuntatiedot extends AppCompatActivity {
    private Spinner spinner;
    private Resources res;
    private Integer selectedInf;
    private Double selectedInc;
    private Integer totalInf;
    private Integer totalDth;
    private Double totalInc;
    private TextView maakuntaTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);
        TextView infView = (TextView) findViewById(R.id.InfectedCountView);

        /** Haetaan resurssit res-muuttujaan.
         * Haetaan maakunnat ja niiden sisältö sekä kaikki tartunnat setMaakunnat() -metodista.
         * Lisätään total_info -resurssiin arvot totalInf(kaikki tartunnat), totalDth(kuolemat) ja totalInc(esiintyvyys) ja asetetaan resurssi infView TextViewiin.
         */
        res = getResources();
        setMaakunnat();
        infView.setText(res.getString(R.string.total_info, totalInf, totalDth, totalInc));

        /**
         * Alustetaan spinner(alasvetovalikko) ja ArrayAdapter maakunnat_array -resurssin avulla. Käytetty esimerkkiä https://developer.android.com/guide/topics/ui/controls/spinner -sivulta.
         */
        spinner = (Spinner) findViewById(R.id.maakunnat_spinner);
        // Luodaan spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.maakunnat_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        maakuntaTextView = (TextView) findViewById(R.id.InfectedMaakuntaView);
        /**
         * Asetetaan kuuntelija spinnerille. TextView muuttuu valitun maakunnan mukaan käytten position-muuttujaa käyttäen maakunta_info-resurssia. Arvot haetaan position-muuttujan mukaan MaakuntaModelin instanssista.
         */
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
        /**
         * Asetetaan kuuntelija thl-logolle. Klikatessa aloitetaan luodaan uusi Intent jonka avulla avataan linkki. Tässä on käytetty esimerkkiä. Thank you Cristian from Stackoverflow https://stackoverflow.com/a/3536535.
         */
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
     * @setMaakunnat void Luo Maakuntamodel-singletonin avulla uudet ArrayListit luokasta MaakuntaValues.
     * @see MaakuntaModel
     * @see MaakuntaValues
     */
    private void setMaakunnat() {
        totalInf = 4576;
        totalDth = 190;
        totalInc = 83.0;
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
