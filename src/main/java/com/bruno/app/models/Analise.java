package com.bruno.app.models;

public class Analise {


    public Analise() {
    }

    public Double calculaFosforoIdeal(Integer texturaSolo) {
        switch (texturaSolo) {
            case 1:
                return 9.0;
            case 2:
                return 12.0;
            default:
                return 0.0;
        }
    }

    public Double calculaPotassioIdeal(Integer texturaSolo) {
        switch (texturaSolo) {
            case 1:
                return 0.35;
            case 2:
                return 0.25;
            default:
                return 0.0;
        }
    }

    public Double calculaCalcioIdeal(Integer texturaSolo) {
        switch (texturaSolo) {
            case 1:
                return 6.0;
            case 2:
                return 4.0;
            default:
                return 0.0;
        }
    }

    public Double calculaMagnesioIdeal(Integer texturaSolo) {
        switch (texturaSolo) {
            case 1:
                return 1.5;
            case 2:
                return 1.0;
            default:
                return 0.0;
        }
    }

    public Double calculaEnxofreIdeal(Integer texturaSolo) {
        switch (texturaSolo) {
            case 1:
                return 9.0;
            case 2:
                return 6.0;
            default:
                return 0.0;
        }
    }

    public Double calculaAluminioIdeal() {
        return 0.0;
    }

    public Double calculaAluminioHidrogenioIdeal() {
        return 0.0;
    }
}
