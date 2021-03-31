package com.bruno.app.models;

import com.bruno.app.enums.TexturaSolo;
import junit.framework.TestCase;

public class AnaliseTest extends TestCase {

    public void testSoloArgilosoValoresIdeais() {
        assertEquals(9.0, new Analise(TexturaSolo.ARGILOSO).calculaFosforoIdeal());
        assertEquals(0.35, new Analise(TexturaSolo.ARGILOSO).calculaPotassioIdeal());
        assertEquals(6.0, new Analise(TexturaSolo.ARGILOSO).calculaCalcioIdeal());
        assertEquals(1.5, new Analise(TexturaSolo.ARGILOSO).calculaMagnesioIdeal());
        assertEquals(9.0, new Analise(TexturaSolo.ARGILOSO).calculaEnxofreIdeal());
        assertEquals(0.0, new Analise(TexturaSolo.ARGILOSO).calculaAluminioIdeal());
        assertEquals(0.0, new Analise(TexturaSolo.ARGILOSO).calculaAluminioHidrogenioIdeal());
    }

    public void testSoloTexturaMediaIdeais() {
        assertEquals(12.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaFosforoIdeal());
        assertEquals(0.25, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaPotassioIdeal());
        assertEquals(4.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaCalcioIdeal());
        assertEquals(1.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaMagnesioIdeal());
        assertEquals(6.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaEnxofreIdeal());
        assertEquals(0.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaAluminioIdeal());
        assertEquals(0.0, new Analise(TexturaSolo.TEXTURA_MEDIA).calculaAluminioHidrogenioIdeal());
    }
}