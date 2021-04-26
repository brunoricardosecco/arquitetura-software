package com.bruno.app.models.texturasSolo;

import com.bruno.app.models.interfaces.TexturaSolo;

public class TexturaMedia implements TexturaSolo {
    @Override
    public Double getValorIdealFosforo() {
        return 12.0;
    }

    @Override
    public Double getValorIdealPotassio() {
        return 0.25;
    }

    @Override
    public Double getValorIdealCalcio() {
        return 4.0;
    }

    @Override
    public Double getValorIdealMagnesio() {
        return 1.0;
    }

    @Override
    public Double getValorIdealEnxofre() {
        return 6.0;
    }
}
