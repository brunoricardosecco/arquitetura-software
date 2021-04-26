package com.bruno.app.enums;

public enum FontePotassio {
    CLORETO_DE_POTASSIO(1, 58.0, new Double[] {0.0, 0.0}, new Nutrientes[] {null, null}),
    SULFATO_DE_POTASSIO(2, 52.0, new Double[] {0.17, 0.0}, new Nutrientes[] {Nutrientes.ENXOFRE, null}),
    SULFATO_DE_POTASSIO_MAGNESIO(3, 22.0, new Double[] {0.22, 0.18}, new Nutrientes[] {Nutrientes.ENXOFRE, Nutrientes.MAGNESIO});

    private final Integer codigo;
    private final Double valorFonte;
    private final Double valoresResiduos[];
    private final Nutrientes nomesResiduos[];

    FontePotassio(Integer codigo, Double valorFonte, Double[] valoresResiduos, Nutrientes[] nomesResiduos) {
        this.codigo = codigo;
        this.valorFonte = valorFonte;
        this.valoresResiduos = valoresResiduos;
        this.nomesResiduos = nomesResiduos;
    }

    public Double getValorFonte() {
        return valorFonte;
    }

    public Double[] getValoresResiduos() {
        return valoresResiduos;
    }

    public Nutrientes[] getNomesResiduos() {
        return nomesResiduos;
    }
}
