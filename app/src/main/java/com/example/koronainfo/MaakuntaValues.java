package com.example.koronainfo;

public class MaakuntaValues{
    private String maakunta;
    private int infected;
    private double incidence;


    public MaakuntaValues(String newMaakunta, int newInfected, double newIncidence) {
        this.maakunta = newMaakunta;
        this.infected = newInfected;
        this.incidence = newIncidence;
    }

    public String getMaakuntaName() {
        return this.maakunta;
    }

    public Integer getMaakuntaInf() {
        return this.infected;
    }

    public Double getMaakuntaInc() {
        return this.incidence;
    }
}
