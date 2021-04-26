package com.bruno.app.models;

import com.bruno.app.enums.FonteFosforo;
import com.bruno.app.enums.Nutrientes;

public class CorrecaoFosforo {

    private FonteFosforo fonteDeFosforo;
    private Double teorFosforoAtingirMgDm3;
    private Double teorFosforoAtualMgDm3;
    private Double percentualEficienciaFosforo;
    private Double valorFontePorTonelada;

    public CorrecaoFosforo(Double teorFosforoAtingirMgDm3, Double teorFosforoAtualMgDm3, Double percentualEficienciaFosforo, FonteFosforo fonteDeFosforo, Double valorFontePorTonelada) {
        this.teorFosforoAtingirMgDm3 = teorFosforoAtingirMgDm3;
        this.teorFosforoAtualMgDm3 = teorFosforoAtualMgDm3;
        this.percentualEficienciaFosforo = percentualEficienciaFosforo;
        this.fonteDeFosforo = fonteDeFosforo;
        this.valorFontePorTonelada = valorFontePorTonelada;
    }

    public Double transformaMgDm3EmKgHaFosforo() {
        return ((teorFosforoAtingirMgDm3 - teorFosforoAtualMgDm3) * 2);
    }

    public Double transformaKgHaFosforoEmKgHaP2O5() {
        return transformaMgDm3EmKgHaFosforo() * 2.29;
    }

    public Double transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() {
        return transformaKgHaFosforoEmKgHaP2O5() / (percentualEficienciaFosforo / 100);
    }

    public Double calculaQuantidadeAAplicar() {
        return transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo() * (100 / fonteDeFosforo.getValorFonte());
    }

    public Double calculaKgHaPrimeiroResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaPrimeiroResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, fonteDeFosforo.getValorFonte(), calculaQuantidadeAAplicar()).calculaKgHaPrimeiroResidual();
    }

    public String calculaNomePrimeiroResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaPrimeiroResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, fonteDeFosforo.getValorFonte(), calculaQuantidadeAAplicar()).getNomeResidual();
    }

    public Double calculaKgHaSegundoResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaSegundoResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, fonteDeFosforo.getValorFonte()).calculaKgHaPrimeiroResidual();
    }

    public String calculaNomeSegundoResiduo() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        return new CalculaSegundoResidual(kgHaConsiderandoEficienciaFosforo, fonteDeFosforo, fonteDeFosforo.getValorFonte()).getNomeResidual();
    }

    public double calculaCustoPorHa() {
        Double kgHaConsiderandoEficienciaFosforo = transformaKgHaFosforoEmKgHaP2O5ConsiderandoEficienciaFosforo();
        Double kgAlFosforo = (kgHaConsiderandoEficienciaFosforo * 100 / fonteDeFosforo.getValorFonte()) * 2.42;

        return (valorFontePorTonelada * kgAlFosforo / 1000) / 2.42;
    }

    private class CalculaPrimeiroResidual {
        private Double kgHaConsiderandoEficienciaFosforo;
        private Double teorDeP2O5EmFonteFosforo;
        private Double quantidadeDeFosforoAAplicar;
        private String nomeResidual;
        private FonteFosforo fonteDeFosforo;

        public CalculaPrimeiroResidual(Double kgHaConsiderandoEficienciaFosforo, FonteFosforo fonteDeFosforo, Double teorDeP2O5EmFonteFosforo, Double quantidadeDeFosforoAAplicar) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            this.quantidadeDeFosforoAAplicar = quantidadeDeFosforoAAplicar;
            this.nomeResidual = fonteDeFosforo.getNomesResiduos()[0].getNome();
        }

        public String getNomeResidual() {
            return nomeResidual;
        }

        public Double calculaKgHaPrimeiroResidual() {
            return (calculaKgAlResiduo() * fonteDeFosforo.getValoresResiduos()[0]) / 2.42;
        }

        private Double calculaKgHeResiduo() {
            return kgHaConsiderandoEficienciaFosforo * 100 / teorDeP2O5EmFonteFosforo;
        }

        private Double calculaKgAlResiduo() {
            return calculaKgHeResiduo() * 2.42;
        }


    }

    private class CalculaSegundoResidual {
        private Double kgHaConsiderandoEficienciaFosforo;
        private Double teorDeP2O5EmFonteFosforo;
        private String nomeResidual;
        private FonteFosforo fonteDeFosforo;

        public CalculaSegundoResidual(Double kgHaConsiderandoEficienciaFosforo, FonteFosforo fonteDeFosforo, Double teorDeP2O5EmFonteFosforo) {
            this.kgHaConsiderandoEficienciaFosforo = kgHaConsiderandoEficienciaFosforo;
            this.fonteDeFosforo = fonteDeFosforo;
            this.teorDeP2O5EmFonteFosforo = teorDeP2O5EmFonteFosforo;
            this.nomeResidual = fonteDeFosforo.getNomesResiduos()[1].getNome();
        }

        public String getNomeResidual() {
            return nomeResidual;
        }

        public Double calculaKgHaPrimeiroResidual() {
            return (calculaKgAlResiduo() * fonteDeFosforo.getValoresResiduos()[1]) / 2.42;
        }

        private Double calculaKgHeResiduo() {
            return kgHaConsiderandoEficienciaFosforo * 100 / teorDeP2O5EmFonteFosforo;
        }

        private Double calculaKgAlResiduo() {
            return calculaKgHeResiduo() * 2.42;
        }


    }
}
