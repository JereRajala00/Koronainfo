package com.example.koronainfo;

import androidx.annotation.NonNull;

/**
 * Luokka kuvaa Tartuntatiedot-luokassa tarvittavia eri maakuntien virustartuntaan liittyviä arvoja
 * @author Tiitus Telke
 * @version 29.4.2020
 */
public class MaakuntaValues{
    private String maakunta;
    private int infected;
    private double incidence;

    /**
     * @param newMaakunta Lisää uuden maakunnan nimen
     * @param newInfected Lisää uuden tartuntojen määrän
     * @param newIncidence Lisää uuden esintyneisyysmäärän
     */
    public MaakuntaValues(String newMaakunta, int newInfected, double newIncidence) {
        this.maakunta = newMaakunta;
        this.infected = newInfected;
        this.incidence = newIncidence;
    }

    /**
     * @return Palauttaa maakunnan nimen
     */
    public String getMaakuntaName() {
        return this.maakunta;
    }

    /**
     * @return Palauttaa maakunnan tartuntamäärän
     */
    public Integer getMaakuntaInf() {
        return this.infected;
    }

    /**
     *
     * @param newInfCount Vaihtaa tartuntamäärän (jos esim. haetaan verkosta uusi määrä)
     */
    public void changeInfCount(Integer newInfCount) {
        this.infected = newInfCount;
    }

    /**
     *
     * @return Palauttaa esiintyneisyyden
     */
    public Double getMaakuntaInc() {
        return this.incidence;
    }

    /**
     *
     * @return palauttaa maakunnan nimen
     */
    @Override
    public String toString() {
        return this.maakunta;
    }
}
