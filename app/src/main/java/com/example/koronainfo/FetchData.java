package com.example.koronainfo;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class fetches data from thl's covid infection data API. Data is fetch using 3 different queries and put into three different arrayList where index 0 = total infections, 1 = total population, 2 = deaths
 * @author Tiitus Telke
 * @Version 22.12.2020
 */

public class FetchData extends AsyncTask<String, Void, Boolean> {
    private JSONObject allData;
    public AsyncResponse delegate = null;
    private ArrayList<Float> totalInfo;            //totalInfo = has total values index 0 = total infections, 1 = total population, 2 = total deaths
    JSONArray infArray, countyArray, populationArray;       //infArray = all covid infections for each county, countyArray = names of counties in same order as infections, populationArray = population of each county

    protected void onPreExecute() {
        totalInfo = new ArrayList<>();
    }
    protected Boolean doInBackground(String... urls) {

        for (int i = 0; i < urls.length; i++) {
            try {
                URL url = new URL(urls[i]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }
                bufferedReader.close();

                allData = new JSONObject(response.toString());

                JSONObject county;
                JSONObject values = allData.getJSONObject("dataset").getJSONObject("value");
                JSONArray valuesArray = values.toJSONArray(values.names());
                if (i == 0) {
                    county = allData.getJSONObject("dataset").getJSONObject("dimension").getJSONObject("hcdmunicipality2020").getJSONObject("category").getJSONObject("label");
                    infArray = valuesArray;
                    countyArray = county.toJSONArray(county.names());
                    totalInfo.add((float) valuesArray.getInt(21));          //total amount of infections is at index 21
                } else if (i == 1) {
                    populationArray = valuesArray;
                    float totalInc = totalInfo.get(0) / valuesArray.getInt(21) * 100000;
                    totalInfo.add(totalInc);
                } else if (i == 2) {
                    totalInfo.add((float)valuesArray.getInt(0));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    protected void onPostExecute(Boolean bool) {
        for (int i = 0; i < infArray.length() - 1; i++) {
            try {
                float incidence = ((float)infArray.getInt(i) / populationArray.getInt(i)) * 100000;
                MaakuntaModel.getInstance().getMaakunta().add(new MaakuntaValues(countyArray.getString(i),infArray.getInt(i), incidence));              //adds data for each county to a singleton
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        delegate.setMaakunnat(totalInfo);
    }
}
