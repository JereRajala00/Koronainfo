package com.example.koronainfo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


public class FetchData extends AsyncTask<Void, Void, JSONObject> {
    private JSONObject allData;
    public AsyncResponse delegate = null;

    protected JSONObject doInBackground(Void... voids) {
        try {
            URL url = new URL("https://sampo.thl.fi/pivot/prod/fi/epirapo/covid19case/fact_epirapo_covid19case.json?column=hcdmunicipality2020-445222");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            //Log.d("test", response.toString());

            allData = new JSONObject(response.toString());

            Log.d("test","mitasd");
            /*JSONObject infCounts = allData.getJSONObject("dataset").getJSONObject("value");
            JSONObject county = allData.getJSONObject("dataset").getJSONObject("label");
            JSONArray infArray = infCounts.toJSONArray(infCounts.names());
            JSONArray countyArray = county.toJSONArray(county.names());
            Log.d("tag","aasd");
            Log.d("test", infCounts.toString());
            //Log.d("test", String.valueOf(infArray[i].length));

            for (int i = 0; i < infArray.length() - 1; i++) {
                Log.d("test",countyArray.getString(i));
                MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues(countyArray.getString(i),infArray.getInt(i), 36.8));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }

    @Override
    protected void onPostExecute(JSONObject result) {

        delegate.setMaakunnat(result);
    }
    /*public JSONObject getInfCounts() {
        return infCounts;
    }*/
}
