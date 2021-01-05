package com.example.koronainfo;

import androidx.annotation.NonNull;

/**
 * Luokka kuvaa Tartuntatiedot-luokassa tarvittavia eri maakuntien virustartuntaan liittyviä arvoja
 * @author Tiitus Telke
 * @version 22.12.2020
 * @see MaakuntaModel
 */
public class MaakuntaValues{
    private String maakunta;
    private int infected;
    private float incidence;

    /**
     * @param newMaakunta Lisää uuden maakunnan nimen
     * @param newInfected Lisää uuden tartuntojen määrän
     * @param newIncidence Lisää uuden esintyneisyysmäärän
     */
    public MaakuntaValues(String newMaakunta, int newInfected, float newIncidence) {
        this.maakunta = newMaakunta;
        this.infected = newInfected;
        this.incidence = newIncidence;
    }

    /**
     * Käytetään kun halutaan palauttaa maakunnan nimi
     * @return Palauttaa maakunnan nimen
     */
    public String getMaakuntaName() {
        return this.maakunta;
    }

    /**
     * Käytetään kun halutaan palauttaa tartuntamäärä
     * @return Palauttaa maakunnan tartuntamäärän
     */
    public int getMaakuntaInf() {
        return this.infected;
    }

    /**
     * Käytetään kun halutaan vaihtaa tartuntamäärä
     * @param newInfCount Vaihtaa tartuntamäärän (jos esim. haetaan verkosta uusi määrä)
     */
    public void changeInfCount(Integer newInfCount) {
        this.infected = newInfCount;
    }

    /**
     * Käytetään kun halutaan palauttaa esiintyneisyys
     * @return Palauttaa esiintyneisyyden
     */
    public float getMaakuntaInc() {
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
