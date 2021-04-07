package com.bruno.app.models;

import com.bruno.app.enums.FonteFosforo;
import junit.framework.TestCase;

public class CorrecaoFosforoTest extends TestCase {
    CorrecaoFosforo correcaoFosforoMock = new CorrecaoFosforo(12.0, 8.59, 70.0, FonteFosforo.SUPERFOSFATO_SIMPLES, 1000.0);

    public void testCalculaQuantidadeAAplicar() {
        assertEquals(123.95079365079366, correcaoFosforoMock.calculaQuantidadeAAplicar());
    }

    public void testCalculaPrimeiroResidual() {
        assertEquals(12.395079365079365, correcaoFosforoMock.calculaKgHaPrimeiroResiduo());
        assertEquals("Enxofre", correcaoFosforoMock.calculaNomePrimeiroResiduo());
    }

    public void testCalculaSegundoResidual() {
        assertEquals(34.70622222222223, correcaoFosforoMock.calculaKgHaSegundoResiduo());
        assertEquals("Cálcio", correcaoFosforoMock.calculaNomeSegundoResiduo());
    }

    public void testCalculaPrecoPorToneladaFosforo() {
        assertEquals(123.95079365079366, correcaoFosforoMock.calculaCustoPorHa());
    }
}