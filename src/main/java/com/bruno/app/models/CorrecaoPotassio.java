package com.bruno.app.models;

public class CorrecaoPotassio {
    private Double teorPotassioAtualNaCTC;
    private Double ctcCmol;
    private Double teorPotassioDesejadoNaCTC;
    private Integer texturaSolo;

    public CorrecaoPotassio(Double teorPotassioAtualNaCTC, Double ctcCmol, Double teorPotassioDesejadoNaCTC, Integer texturaSolo) {
        this.teorPotassioAtualNaCTC = teorPotassioAtualNaCTC;
        this.ctcCmol = ctcCmol;
        this.teorPotassioDesejadoNaCTC = teorPotassioDesejadoNaCTC;
        this.texturaSolo = texturaSolo;
    }

    public Double calculaParticipacaoAtualDoPotassioNaCTC() {
        return teorPotassioAtualNaCTC / ctcCmol * 100;
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
}
