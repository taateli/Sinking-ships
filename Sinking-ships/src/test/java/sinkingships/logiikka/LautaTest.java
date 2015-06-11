package sinkingships.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sinkingships.logiikka.Lauta;

/**
 *
 * @author tatuhelander
 */
public class LautaTest {

    Lauta lauta;

    @Before
    public void setUp() {
        lauta = new Lauta();
    }

    @Test
    public void lautaAlustetaanOikein() {
        for (int rivi = 0; rivi < 6; rivi++) {
            for (int sarake = 0; sarake < 6; sarake++) {
                assertEquals(lauta.getArvo(rivi, sarake), -1);
            }
        }
    }
    
//    @Test
//    public void lisaaPommiToimii1() {
//        lauta.lisaaSyvyysPommi(1, 1);
//        assertEquals(lauta.getArvo(1, 1), 3);
//    }
//    
//    @Test
//    public void lisaaPommiToimii2() {
//        assertEquals(lauta.lisaaSyvyysPommi(6, 8), false);
//    }
    
    
    @Test
    public void lautaAlustetaanOikein2() {
        assertEquals(lauta.getArvo(0, 0), -1);
    }

    @Test
    public void lautaAlustetaanOikein3() {
        assertEquals(lauta.getArvo(5, 5), -1);
    }

    @Test
    public void laivaAlkaaOikeastaPaikasta() {
        lauta.asetaLaivaVaaka(2, 1, 1);
        assertEquals(lauta.getArvo(1, 1), 1);
    }
    
    @Test
    public void asetaLaivaPystyToimii1() {
        assertEquals(lauta.asetaLaivaPysty(3, 1, 2), true);
    }
    
    @Test
    public void asetaLaivaVaakaToimii2() {
        assertEquals(lauta.asetaLaivaVaaka(2, 3, 2), true);
    }
    
    
    @Test
    public void asetaLaivaVaakaToimii() {
        lauta.asetaLaivaPysty(3, 1, 2);
        assertEquals(lauta.asetaLaivaPysty(3, 1, 2), false);
    }
    

    @Test
    public void laivaLoppuuOikeaanPaikkaan() {
        lauta.asetaLaivaPysty(3, 1, 4);
        assertEquals(lauta.getArvo(4, 4), -1);
    }
    
    @Test
    public void laivaLoppuuOikeaanPaikkaan2() {
        lauta.asetaLaivaPysty(3, 1, 4);
        assertEquals(lauta.getArvo(5, 4), -1);
    }
    
    @Test
    public void laivaEiLaudalla() {
        assertEquals(lauta.asetaLaivaPysty(4, 4, 1), false);
    }
    
    @Test
    public void laivaEiLaudalla2() {
        assertEquals(lauta.asetaLaivaVaaka(4, 1, 5), false);
    }
    
    @Test
    public void osuukoLaivaanToimiiKunOsuu() {
        lauta.asetaLaivaVaaka(3, 2, 1);
        assertEquals(lauta.osuukoLaivaan(2, 1), true);
    }
    
    @Test
    public void osuukoLaivaanToimiiKunEiOsu() {
        lauta.asetaLaivaVaaka(2, 2, 1);
        assertEquals(lauta.osuukoLaivaan(5, 1), false);
    }
    
    @Test
    public void toimiikoOnkoPisteLaudalla1() {
        assertEquals(lauta.onkoPisteLaudalla(1, 1), true);
    }
    
    @Test
    public void toimiikoOnkoPisteLaudalla2() {
        assertEquals(lauta.onkoPisteLaudalla(0, 0), true);
    }
    
    @Test
    public void toimiikoOnkoPisteLaudalla3() {
        assertEquals(lauta.onkoPisteLaudalla(7, 10), false);
    }
    
    @Test
    public void toimiikoOnkoPisteLaudalla4() {
        assertEquals(lauta.onkoPisteLaudalla(5, 5), true);
    }
    
    @Test
    public void onkoTilaVapaaPystyToimii() {
        lauta.asetaLaivaVaaka(3, 4, 1);
        assertEquals(lauta.onkoTilaVapaaPysty(3, 4, 2), false);
    }
    
    @Test
    public void onkoTilaVapaaVaakaToimii2() {
        lauta.asetaLaivaVaaka(3, 2, 4);
        assertEquals(lauta.onkoTilaVapaaVaaka(2, 3, 1), true);
    }
    
    @Test
    public void onkoTilaVapaaVaakaToimii3() {
        lauta.asetaLaivaVaaka(3, 2, 1);
        assertEquals(lauta.onkoTilaVapaaVaaka(2, 2, 1), false);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
