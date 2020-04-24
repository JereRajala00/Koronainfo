package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Tartuntatiedot extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);

        //from https://developer.android.com/guide/topics/ui/controls/spinner
        spinner = (Spinner) findViewById(R.id.maakunnat_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.maakunnat_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //setMaakunnat();

        /*lv = (ListView)findViewById(R.id.tartuntatiedotListView);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("testi");

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                R.layout.listview_layout,
                arrayList
        );

        lv.setAdapter(arrayAdapter);*/


    }
    /*public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            String selectedMaakunta = spinner.getSelectedItem().toString();
            for (int i; i < MaakuntaModel.; i++)
                if (selectedMaakunta.equals(MaakuntaModel.getInstance().getMaakunta(i).getMaakuntaName() {
                    return MaakuntaModel.getInstance().get
                }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
    private void setMaakunnat() {
        MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues("Ahvenanmaa",11, ))
    }*/
}
