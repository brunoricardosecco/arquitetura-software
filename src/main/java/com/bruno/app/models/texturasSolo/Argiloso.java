package com.bruno.app.models.texturasSolo;

import com.bruno.app.models.interfaces.TexturaSolo;

public class Argiloso implements TexturaSolo {

    @Override
    public Double getValorIdealFosforo() {
        return 9.0;
    }

    @Override
    public Double getValorIdealPotassio() {
        return 0.35;
    }

    @Override
    public Double getValorIdealCalcio() {
        return 6.0;
    }

    @Override
    public Double getValorIdealMagnesio() {
        return 1.5;
    }

    @Override
    public Double getValorIdealEnxofre() {
        return 9.0;
    }
}
