package com.bruno.app.enums;

public enum FontePotassio {
    CLORETO_DE_POTASSIO(1),
    SULFATO_DE_POTASSIO(2),
    SULFATO_DE_POTASSIO_MAGNESIO(3),
    OUTRO(4);

    private final Integer codigo;

    FontePotassio(Integer codigo) {
        this.codigo = codigo;
    }
}
