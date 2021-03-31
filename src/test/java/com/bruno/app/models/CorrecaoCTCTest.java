package com.bruno.app.models;

import junit.framework.TestCase;

public class CorrecaoCTCTest extends TestCase {

    public void testCalculaScmol() {
        assertEquals(7.54, new CorrecaoCTC().calculaScmol(0.15, 5.76, 1.63));
    }

    public void testCalculaCTCcmol() {
        CorrecaoCTC calculaCTC = new CorrecaoCTC();
        Double Scmol = calculaCTC.calculaScmol(0.15, 5.76, 1.63);
        assertEquals(12.89, calculaCTC.calculaCTCcmol(Scmol, 5.35));
    }

    public void testCalculaPercentualVAtual() {
        CorrecaoCTC calculaCTC = new CorrecaoCTC();
        Double Scmol = calculaCTC.calculaScmol(0.15, 5.76, 1.63);
        Double CTCcmol = calculaCTC.calculaCTCcmol(Scmol, 5.35);
        assertEquals(58.494957331264544, calculaCTC.calculaPercentualVAtual(Scmol, CTCcmol));
    }

    public void testCalculaMOPercentual() {
        assertEquals(3.07, new CorrecaoCTC().calculaMOPercentual(30.7));
        assertEquals(0.0, new CorrecaoCTC().calculaMOPercentual(0.0));
    }

    public void testCalculaCarbono() {
        assertEquals(17.848837209302324, new CorrecaoCTC().calculaCarbono(30.7));
        assertEquals(0.0, new CorrecaoCTC().calculaCarbono(0.0));
    }
}