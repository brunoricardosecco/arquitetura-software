package com.bruno.app.models;

import junit.framework.TestCase;

public class CorrecaoPotassioTest extends TestCase {
    Double ctcCmol = new CorrecaoCTC().calculaCTCcmol(new CorrecaoCTC().calculaScmol(0.15, 5.56, 1.63), 5.35);
    CorrecaoPotassio correcaoPotassioMock = new CorrecaoPotassio(ctcCmol, 7.0, 1, 0.15, 3, 14.0);

    public void testCalculaParticipacaoAtualDoPotassioNaCTC() {
        assertEquals(1.1820330969267139, correcaoPotassioMock.calculaParticipacaoAtualDoPotassioNaCTC());
    }

    public void testCalculaParticipacaoDoPotassioNaCTCAposCorrecao() {
        assertEquals(7.0, correcaoPotassioMock.calculaParticipacaoDoPotassioNaCTCAposCorrecao());
    }

    public void testCalculaParticipacaoDoPotassioIdealNaCTC() {
        assertEquals(3.0, correcaoPotassioMock.calculaParticipacaoPotassioIdealNaCTC());
    }

    public void testCalculaQuantidadeAAplicar() {
        assertEquals(3704.923636363637, correcaoPotassioMock.calculaQuantidadeAAplicar());
    }

    public void testCalculaCustoPorHa() {
        assertEquals(51.86893090909091, correcaoPotassioMock.calculaCustoPorHa());
    }
}