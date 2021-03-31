package com.bruno.app.models;

import com.bruno.app.enums.TexturaSolo;

public class Analise {

    private TexturaSolo texturaSolo;

    public Analise(TexturaSolo texturaSolo) {
        this.texturaSolo = texturaSolo;
    }

    public Double calculaFosforoIdeal() {
        switch (texturaSolo) {
            case ARGILOSO:
                return 9.0;
            case TEXTURA_MEDIA:
                return 12.0;
            default:
                return 0.0;
        }
    }

    public Double calculaPotassioIdeal() {
        switch (texturaSolo) {
            case ARGILOSO:
                return 0.35;
            case TEXTURA_MEDIA:
                return 0.25;
            default:
                return 0.0;
        }
    }

    public Double calculaCalcioIdeal() {
        switch (texturaSolo) {
            case ARGILOSO:
                return 6.0;
            case TEXTURA_MEDIA:
                return 4.0;
            default:
                return 0.0;
        }
    }

    public Double calculaMagnesioIdeal() {
        switch (texturaSolo) {
            case ARGILOSO:
                return 1.5;
            case TEXTURA_MEDIA:
                return 1.0;
            default:
                return 0.0;
        }
    }

    public Double calculaEnxofreIdeal() {
        switch (texturaSolo) {
            case ARGILOSO:
                return 9.0;
            case TEXTURA_MEDIA:
                return 6.0;
            default:
                return 0.0;
        }
    }

    public Double calculaAluminioIdeal() {
        return 0.0;
    }

    public Double calculaAluminioHidrogenioIdeal() {
        return 0.0;
    }
}
