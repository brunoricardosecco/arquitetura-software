package com.bruno.app.models;


import com.bruno.app.models.interfaces.TexturaSolo;

public class Analise {

    public Double calculaFosforoIdeal(TexturaSolo texturaSolo) {
        return texturaSolo.getValorIdealFosforo();
    }

    public Double calculaPotassioIdeal(TexturaSolo texturaSolo) {
        return texturaSolo.getValorIdealPotassio();
    }

    public Double calculaCalcioIdeal(TexturaSolo texturaSolo) {
        return texturaSolo.getValorIdealCalcio();
    }

    public Double calculaMagnesioIdeal(TexturaSolo texturaSolo) {
        return texturaSolo.getValorIdealMagnesio();
    }

    public Double calculaEnxofreIdeal(TexturaSolo texturaSolo) {
        return texturaSolo.getValorIdealEnxofre();
    }

    public Double calculaAluminioIdeal() {
        return 0.0;
    }

    public Double calculaAluminioHidrogenioIdeal() {
        return 0.0;
    }
}
