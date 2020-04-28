package com.example.koronainfo;

import java.util.ArrayList;
import java.util.List;

public class MaakuntaModel {
    private List<MaakuntaValues> maakunta;
    private static final MaakuntaModel ourInstance = new MaakuntaModel();

    public static MaakuntaModel getInstance() {
        return ourInstance;
    }

    private MaakuntaModel() {
        maakunta = new ArrayList<>();
    }

    public List<MaakuntaValues> getMaakunta() {
        return maakunta;
    }

    public MaakuntaValues getMaakunta(int i) {
        return maakunta.get(i);
    }
}
