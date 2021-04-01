package com.bruno.app.models;

import junit.framework.TestCase;

public class CorrecaoFosforoTest extends TestCase {

    public void testCalculaQuantidadeAAplicar() {
        assertEquals(123.95079365079366, new CorrecaoFosforo(12.0, 8.59, 70.0, 1).calculaQuantidadeAAplicar());
    }
}