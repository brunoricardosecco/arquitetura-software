package com.bruno.app.models;

public class CorrecaoCTC {
    public Double calculaScmol(Double potassio, Double calcio, Double magnesio) {
        return potassio + calcio + magnesio;
    }

    public Double calculaCTCcmol(Double Scmol, Double hidrogenioAluminio) {
        return Scmol + hidrogenioAluminio;
    }

    public Double calculaPercentualVAtual(Double Scmol, Double CTCcmol) {
        return (Scmol * 100) / CTCcmol;
    }

    public Double calculaMOPercentual(Double mo) {
        if (mo > 0.01) {
            return mo / 10;
        }
        return 0.0;
    }

    public Double calculaCarbono(Double mo) {
        if (mo < 0.01) {
            return 0.0;
        }
        return calculaMOPercentual(mo) / 1.72 * 10;
    }
}