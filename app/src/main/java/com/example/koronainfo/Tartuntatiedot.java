package com.example.koronainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tartuntatiedot extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tartuntatiedot);

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
}
