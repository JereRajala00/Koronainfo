package com.example.koronainfo;

import java.util.ArrayList;
import java.util.List;

public class MaakuntaValues{
    private String maakunta;
    private int infected;
    private int deaths;


    public MaakuntaValues(String newMaakunta, int newInfected, int newDeaths) {
        this.maakunta = newMaakunta;
        this.infected = newInfected;
        this.deaths = newDeaths;
    }

    public String getMaakuntaName() {
        return this.maakunta;
    }
}
