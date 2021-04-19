package com.bruno.app.models;

import junit.framework.TestCase;

public class CorrecaoCTCTest extends TestCase {
    CorrecaoCTC correcao = new CorrecaoCTC();

    public void testCalculaScmol() {
        assertEquals(7.54, correcao.calculaScmol(0.15, 5.76, 1.63));
    }

    public void testCalculaCTCcmol() {
        Double Scmol = correcao.calculaScmol(0.15, 5.76, 1.63);
        assertEquals(12.89, correcao.calculaCTCcmol(Scmol, 5.35));
    }

    public void testCalculaPercentualVAtual() {
        Double Scmol = correcao.calculaScmol(0.15, 5.76, 1.63);
        Double CTCcmol = correcao.calculaCTCcmol(Scmol, 5.35);
        assertEquals(58.494957331264544, correcao.calculaPercentualVAtual(Scmol, CTCcmol));
    }

    public void testCalculaMOPercentual() {
        assertEquals(3.07, correcao.calculaMOPercentual(30.7));
        assertEquals(0.0, correcao.calculaMOPercentual(0.0));
    }

    public void testCalculaCarbono() {
        assertEquals(17.848837209302324, correcao.calculaCarbono(30.7));
        assertEquals(0.0, correcao.calculaCarbono(0.0));
    }
}