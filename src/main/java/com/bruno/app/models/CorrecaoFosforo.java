package com.bruno.app.models;

public class CorrecaoFosforo {

    private Integer fonteDeFosforo;
    private Double teorFosforoAtingirMgDm3;
    private Double teorFosforoAtualMgDm3;
    private Double percentualEficienciaFosforo;

    public CorrecaoFosforo(Double teorFosforoAtingirMgDm3, Double teorFosforoAtualMgDm3, Double percentualEficienciaFosforo, Integer fonteDeFosforo) {
        this.teorFosforoAtingirMgDm3 = teorFosforoAtingirMgDm3;
        this.teorFosforoAtualMgDm3 = teorFosforoAtualMgDm3;
        this.percentualEficienciaFosforo = percentualEficienciaFosforo;
        this.fonteDeFosforo = fonteDeFosforo;
    }

    public Double transformaMgDm3EmKgHaFosforo() {
        if ((teorFosforoAtingirMgDm3 - teorFosforoAtualMgDm3) > 0.01) {
            return ((teorFosforoAtingirMgDm3 - teorFosforoAtualMgDm3) * 2);
        }
        return 0.0;
    }

    public Double transformaKgHaFosforoEmKgHaP2O5() {
        return transformaMgDm3EmKgHaFosforo() * 2.29;
    }

    public Double transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() {
        return transformaKgHaFosforoEmKgHaP2O5() / (percentualEficienciaFosforo / 100);
    }

    public Double calculaPercentualTeorFonteP2O5() {
        switch (fonteDeFosforo) {
            case 1:
                return 18.0;
            case 2:
                return 41.0;
            case 3:
                return 48.0;
            case 4:
                return 45.0;
            case 5:
                return 18.0;
            case 6:
                return 33.0;
            case 7:
                return 29.0;
            case 8:
                return 32.0;
            case 9:
                return 24.0;
            case 10:
                return 18.5;
            case 11:
                return 52.0;
            case 12:
                return 18.0;
            default:
                return 0.0;
        }
    }

    public Double calculaQuantidadeAAplicar() {
        return transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() * (100 / calculaPercentualTeorFonteP2O5());
    }
}
