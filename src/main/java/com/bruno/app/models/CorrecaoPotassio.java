package com.bruno.app.models;

public class CorrecaoPotassio {
    private Double teorPotassioAtual;
    private Double ctcCmol;

    public CorrecaoPotassio(Double teorPotassioAtual, Double ctcCmol) {
        this.teorPotassioAtual = teorPotassioAtual;
        this.ctcCmol = ctcCmol;
    }

    public Double calculaParticipacaoAtualDoPotassioNaCTC() {
        return teorPotassioAtual / ctcCmol * 100;
    }
}
