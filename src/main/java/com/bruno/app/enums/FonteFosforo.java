package com.bruno.app.enums;

public enum FonteFosforo {
    SUPERFOSFATO_SIMPLES(1, 18.0, new Double[] {0.1, 0.28}, new Nutrientes[] {Nutrientes.ENXOFRE, Nutrientes.CALCIO}),
    SUPERFOSFATO_TRIPLO(2, 41.0, new Double[] {0.0, 0.2}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    MAP(3, 48.0, new Double[] {0.0, 0.09}, new Nutrientes[] {null, Nutrientes.NITROGENIO}),
    DAP(4, 45.0, new Double[] {0.0, 0.16}, new Nutrientes[] {null, Nutrientes.NITROGENIO}),
    YOORIN(5, 18.0, new Double[] {0.15, 0.28}, new Nutrientes[] {Nutrientes.MAGNESIO, Nutrientes.CALCIO}),
    FOSFATO_ARAD(6, 33.0, new Double[] {0.0, 0.52}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    FOSFATO_GAFSA(7, 29.0, new Double[] {0.0, 0.52}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    FOSFATO_DAOUI(8, 32.0, new Double[] {0.0, 0.45}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    FOSFATO_PATOS_MINAS(9, 24.0, new Double[] {0.0, 0.28}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    ESCORIA_DE_THOMAS(10, 18.5, new Double[] {0.0, 0.44}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    ACIDO_FOSFORICO(11, 52.0, new Double[] {0.0, 0.0}, new Nutrientes[] {null, Nutrientes.CALCIO}),
    MULTIFOSFATO_MAGNESIANO(12, 18.0, new Double[] {0.11, 0.18}, new Nutrientes[] {Nutrientes.ENXOFRE, Nutrientes.CALCIO});

    private final Integer codigo;
    private final Double valorFonte;
    private final Double valoresResiduos[];
    private final Nutrientes nomesResiduos[];

    FonteFosforo(Integer codigo, Double valorFonte, Double[] valoresResiduos, Nutrientes[] nomesResiduos) {
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
