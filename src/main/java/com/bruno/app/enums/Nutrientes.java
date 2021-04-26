package com.bruno.app.enums;

public enum Nutrientes {
    ENXOFRE("Enxofre"),
    CALCIO("Cálcio"),
    NITROGENIO("Nitrogênio"),
    MAGNESIO("Magnésio");

    private final String nome;

    Nutrientes(String nome) {
        this.nome = nome;
    }
}
