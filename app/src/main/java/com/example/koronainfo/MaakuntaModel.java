package com.example.koronainfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton-luokka, joka luo Listin MaakuntaValues -luokan perusteella ja palauttaa luokan instanssin sekä lisää ArrayListin MaakuntaValuesin Lististä.
 * Pohjana on käytetty Android-luento 6:n GlobalModel-luokkaa.
 * @author Tiitus Telke
 * @version 29.4.2020
 */
public class MaakuntaModel {
    private List<MaakuntaValues> maakunta;
    private static final MaakuntaModel ourInstance = new MaakuntaModel();

    /**
     *
     * @return Palauttaa instanssin tästä luokasta.
     */
    public static MaakuntaModel getInstance() {
        return ourInstance;
    }

    /**
     * Luo ArrayListin MaakuntaValues-luokasta tehdystä Lististä
     */
    private MaakuntaModel() {
        maakunta = new ArrayList<>();
    }

    /**
     * Käytetään kun halutaan käsitellä tähän luokkaan liitettyä MaakuntaValues-tyyppistä Listiä
     * @return Palauttaa instanssimuuttujan tähän luokkaan liitetystä Lististä, joka on MaakuntaValues-luokasta
     */
    public List<MaakuntaValues> getMaakunta() {
        return maakunta;
    }

    /**
     * Käytetään kun halutaan käsitellä tiettyä ArrayListin jäsentä
     * @param i Määrittää ArrayListin indeksin
     * @return Palauttaa ArrayListin jossa parametrin indeksi
     */
    public MaakuntaValues getMaakunta(int i) {
        return maakunta.get(i);
    }
}
