package com.bruno.app.enums;

public enum FonteFosforo {
    SUPERFOSFATO_SIMPLES(1),
    SUPERFOSFATO_TRIPLO(2),
    MAP(3),
    DAP(4),
    YOORIN(5),
    FOSFATO_ARAD(6),
    FOSFATO_GAFSA(7),
    FOSFATO_DAOUI(8),
    FOSFATO_PATOS_MINAS(9),
    ESCORIA_DE_THOMAS(10),
    ACIDO_FOSFORICO(11),
    MULTIFOSFATO_MAGNESIANO(12);

    private final Integer codigo;

    FonteFosforo(Integer codigo) {
        this.codigo = codigo;
    }
}
