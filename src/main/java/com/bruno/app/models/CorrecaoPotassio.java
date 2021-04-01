package com.bruno.app.models;

public class CorrecaoPotassio {
    private Double teorPotassioAtualNaCTC;
    private Double ctcCmol;
    private Double teorPotassioDesejadoNaCTC;

    public CorrecaoPotassio(Double teorPotassioAtualNaCTC, Double ctcCmol, Double teorPotassioDesejadoNaCTC) {
        this.teorPotassioAtualNaCTC = teorPotassioAtualNaCTC;
        this.ctcCmol = ctcCmol;
        this.teorPotassioDesejadoNaCTC = teorPotassioDesejadoNaCTC;
    }

    public Double calculaParticipacaoAtualDoPotassioNaCTC() {
        return teorPotassioAtualNaCTC / ctcCmol * 100;
    }

    public Double calculaParticipacaoDoPotassioNaCTCAposCorrecao() {
        return teorPotassioDesejadoNaCTC;
    }
}
