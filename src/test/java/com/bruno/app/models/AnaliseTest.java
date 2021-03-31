package com.bruno.app.models;

import junit.framework.TestCase;

public class AnaliseTest extends TestCase {

    public void testCalculaFosforoIdeal() {
        assertEquals(9.0, new Analise().calculaFosforoIdeal(1));
        assertEquals(12.0, new Analise().calculaFosforoIdeal(2));
        assertEquals(0.0, new Analise().calculaFosforoIdeal(3));
    }

    public void testCalculaPotassioIdeal() {
        assertEquals(0.35, new Analise().calculaPotassioIdeal(1));
        assertEquals(0.25, new Analise().calculaPotassioIdeal(2));
        assertEquals(0.0, new Analise().calculaPotassioIdeal(3));
    }

    public void testCalculaCalcioIdeal() {
        assertEquals(6.0, new Analise().calculaCalcioIdeal(1));
        assertEquals(4.0, new Analise().calculaCalcioIdeal(2));
        assertEquals(0.0, new Analise().calculaCalcioIdeal(3));
    }

    public void testCalculaMagnesioIdeal() {
        assertEquals(1.5, new Analise().calculaMagnesioIdeal(1));
        assertEquals(1.0, new Analise().calculaMagnesioIdeal(2));
        assertEquals(0.0, new Analise().calculaMagnesioIdeal(3));
    }

    public void testCalculaEnxofreIdeal() {
        assertEquals(9.0, new Analise().calculaEnxofreIdeal(1));
        assertEquals(6.0, new Analise().calculaEnxofreIdeal(2));
        assertEquals(0.0, new Analise().calculaEnxofreIdeal(3));
    }

    public void testCalculaAluminioIdeal() {
        assertEquals(0.0, new Analise().calculaAluminioIdeal());
    }
}