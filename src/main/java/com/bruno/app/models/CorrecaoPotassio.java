package com.bruno.app.models;

public class CorrecaoPotassio {
    private Double ctcCmol;
    private Double teorPotassioDesejadoNaCTC;
    private Integer texturaSolo;
    private Double teorAtualPotassioNoSolo;
    private Integer fontePotassio;
    private  final Double eficienciaPotassio = 0.85;

    public CorrecaoPotassio(Double ctcCmol, Double teorPotassioDesejadoNaCTC, Integer texturaSolo, Double teorAtualPotassioNoSolo, Integer fontePotassio) {
        this.ctcCmol = ctcCmol;
        this.teorPotassioDesejadoNaCTC = teorPotassioDesejadoNaCTC;
        this.texturaSolo = texturaSolo;
        this.teorAtualPotassioNoSolo = teorAtualPotassioNoSolo;
        this.fontePotassio = fontePotassio;
    }

    public Double calculaParticipacaoAtualDoPotassioNaCTC() {
        return teorAtualPotassioNoSolo / ctcCmol * 100;
    }

    public Double calculaParticipacaoDoPotassioNaCTCAposCorrecao() {
        return teorPotassioDesejadoNaCTC;
    }

    public Double calculaParticipacaoPotassioIdealNaCTC() {
        switch (texturaSolo) {
            case 1:
                return 3.0;
            case 2:
                return 3.0;
            default:
                return 0.0;
        }
    }

    private Double calculaNecessidadeDeK() {
        return (teorAtualPotassioNoSolo * teorPotassioDesejadoNaCTC / calculaParticipacaoAtualDoPotassioNaCTC()) - teorAtualPotassioNoSolo;
    }

    private Double calculaCmolDm3DeKEmMgDm3DeK() {
        if (calculaNecessidadeDeK() < 0.01) {
            return 0.0;
        }
        return calculaNecessidadeDeK() * 39.1 * 10;
    }

    private Double calculaMgDm3DeKEmKgHaDeK() {
        return calculaCmolDm3DeKEmMgDm3DeK() * 2;
    }

    private Double calculaKgHaDeKEmK2O() {
        return calculaMgDm3DeKEmKgHaDeK() * 1.2;
    }

    private Double calculaValorDeK2OConsiderandoEficienciaPotassio() {
        return calculaKgHaDeKEmK2O() * 100 / eficienciaPotassio / 100;
    }


    private Double calculaTeorDeK2ODaFonteDePotassio() {
        switch (fontePotassio) {
            case 1:
                return 58.0;
            case 2:
                return 52.0;
            case 3:
                return 22.0;
            case 4:
                return 44.0;
            default:
                return 0.0;
        }
    }

    public Double calculaQuantidadeAAplicar() {
        return calculaValorDeK2OConsiderandoEficienciaPotassio() * 100 / calculaTeorDeK2ODaFonteDePotassio();
    }

}
