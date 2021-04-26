package com.bruno.app.models;

import com.bruno.app.enums.FontePotassio;
import com.bruno.app.enums.TexturaSolo;

public class CorrecaoPotassio {
    private Double ctcCmol;
    private Double teorPotassioDesejadoNaCTC;
    private TexturaSolo texturaSolo;
    private Double teorAtualPotassioNoSolo;
    private FontePotassio fontePotassio;
    private Double valorFontePorTonelada;
    private  final Double eficienciaPotassio = 0.85;

    public CorrecaoPotassio(Double ctcCmol, Double teorPotassioDesejadoNaCTC, TexturaSolo texturaSolo, Double teorAtualPotassioNoSolo, FontePotassio fontePotassio, Double valorFontePorTonelada) {
        this.ctcCmol = ctcCmol;
        this.teorPotassioDesejadoNaCTC = teorPotassioDesejadoNaCTC;
        this.texturaSolo = texturaSolo;
        this.teorAtualPotassioNoSolo = teorAtualPotassioNoSolo;
        this.fontePotassio = fontePotassio;
        this.valorFontePorTonelada = valorFontePorTonelada;
    }

    public Double calculaParticipacaoAtualDoPotassioNaCTC() {
        return teorAtualPotassioNoSolo / ctcCmol * 100;
    }

    public Double calculaParticipacaoDoPotassioNaCTCAposCorrecao() {
        return teorPotassioDesejadoNaCTC;
    }

    public Double calculaParticipacaoPotassioIdealNaCTC() {
        return 3.0;
    }

    private Double calculaNecessidadeDeK() {
        return (teorAtualPotassioNoSolo * teorPotassioDesejadoNaCTC / calculaParticipacaoAtualDoPotassioNaCTC()) - teorAtualPotassioNoSolo;
    }

    private Double calculaCmolDm3DeKEmMgDm3DeK() {
        return calculaNecessidadeDeK() * 39.1 * 10;
    }

    private Double calculaMgDm3DeKEmKgHaDeK() {
        return calculaCmolDm3DeKEmMgDm3DeK() * 2;
    }

    private Double calculaKgHaDeKEmK2O() {
        return calculaMgDm3DeKEmKgHaDeK() * 1.2;
    }

    private Double calculaValorDeK2OConsiderandoEficienciaPotassio() {
        return calculaKgHaDeKEmK2O() / eficienciaPotassio;
    }


    private Double calculaTeorDeK2ODaFonteDePotassio() {
        return fontePotassio.getValorFonte();
    }

    public Double calculaQuantidadeAAplicar() {
        return calculaValorDeK2OConsiderandoEficienciaPotassio() * 100 / calculaTeorDeK2ODaFonteDePotassio();
    }

    public Double calculaCustoPorHa() {
        Double kgAlPotassio = (calculaValorDeK2OConsiderandoEficienciaPotassio() * 100 / calculaTeorDeK2ODaFonteDePotassio()) * 2.42;
        return (valorFontePorTonelada * kgAlPotassio / 1000) / 2.42;
    }
}
