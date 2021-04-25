package com.bruno.app.models;

import com.bruno.app.enums.TexturaSolo;
import junit.framework.TestCase;

public class AnaliseTest extends TestCase {

    public void testSoloArgilosoValoresIdeais() {
        Analise analise = new Analise();
        Argiloso argiloso = new Argiloso();
        assertEquals(9.0, analise.calculaFosforoIdeal(argiloso));
        assertEquals(0.35, analise.calculaPotassioIdeal(argiloso));
        assertEquals(6.0, analise.calculaCalcioIdeal(argiloso));
        assertEquals(1.5, analise.calculaMagnesioIdeal(argiloso));
        assertEquals(9.0, analise.calculaEnxofreIdeal(argiloso));
        assertEquals(0.0, analise.calculaAluminioIdeal());
        assertEquals(0.0, analise.calculaAluminioHidrogenioIdeal());
    }

    public void testSoloTexturaMediaIdeais() {
        Analise analise = new Analise();
        TexturaMedia texturaMedia = new TexturaMedia();
        assertEquals(12.0, analise.calculaFosforoIdeal(texturaMedia));
        assertEquals(0.25, analise.calculaPotassioIdeal(texturaMedia));
        assertEquals(4.0, analise.calculaCalcioIdeal(texturaMedia));
        assertEquals(1.0, analise.calculaMagnesioIdeal(texturaMedia));
        assertEquals(6.0, analise.calculaEnxofreIdeal(texturaMedia));
        assertEquals(0.0, analise.calculaAluminioIdeal());
        assertEquals(0.0, analise.calculaAluminioHidrogenioIdeal());
    }
}