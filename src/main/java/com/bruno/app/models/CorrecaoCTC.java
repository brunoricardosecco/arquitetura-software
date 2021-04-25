// Código utilizado como referência desenvolvido pelo professor Gabriel Costa Silva
// O código original pode ser encontrado no link abaixo
// https://github.com/gabrielcostasilva/sa-soilcorrection/blob/main/src/main/java/edu/utfpr/cp/dacom/sa/soilcorrection/EquilibrioCorrecaoCTC.java

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
            return mo / 10;
    }

    public Double calculaCarbono(Double mo) {
        return calculaMOPercentual(mo) / 1.72 * 10;
    }
}
