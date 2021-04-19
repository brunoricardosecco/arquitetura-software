package com.bruno.app.models;

import com.bruno.app.enums.TexturaSolo;
import junit.framework.TestCase;

public class AnaliseTest extends TestCase {

    public void testSoloArgilosoValoresIdeais() {
        Analise analise = new Analise(TexturaSolo.ARGILOSO);
        assertEquals(9.0, analise.calculaFosforoIdeal());
        assertEquals(0.35, analise.calculaPotassioIdeal());
        assertEquals(6.0, analise.calculaCalcioIdeal());
        assertEquals(1.5, analise.calculaMagnesioIdeal());
        assertEquals(9.0, analise.calculaEnxofreIdeal());
        assertEquals(0.0, analise.calculaAluminioIdeal());
        assertEquals(0.0, analise.calculaAluminioHidrogenioIdeal());
    }

    public void testSoloTexturaMediaIdeais() {
        Analise analise = new Analise(TexturaSolo.TEXTURA_MEDIA);
        assertEquals(12.0, analise.calculaFosforoIdeal());
        assertEquals(0.25, analise.calculaPotassioIdeal());
        assertEquals(4.0, analise.calculaCalcioIdeal());
        assertEquals(1.0, analise.calculaMagnesioIdeal());
        assertEquals(6.0, analise.calculaEnxofreIdeal());
        assertEquals(0.0, analise.calculaAluminioIdeal());
        assertEquals(0.0, analise.calculaAluminioHidrogenioIdeal());
    }
}