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
import taateli.sinking.ships.logiikka.Lauta;

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
        lauta.asetaLaivaHorisontaalisesti(2, 1, 1);
        assertEquals(lauta.getArvo(1, 1), 1);
    }

    @Test
    public void laivaLoppuuOikeaanPaikkaan() {
        lauta.asetaLaivaVertikaalisesti(3, 1, 4);
        assertEquals(lauta.getArvo(1, 4), 1);
    }

    public void osuukoLaivaanToimiiKunOsuu() {
        lauta.asetaLaivaHorisontaalisesti(3, 2, 1);
        lauta.osuukoLaivaan(2, 3);
        assertEquals(lauta.getArvo(2, 3), 2);
    }

    public void osuukoLaivaanToimiiKunEiOsu() {
        lauta.asetaLaivaHorisontaalisesti(3, 2, 1);
        lauta.osuukoLaivaan(4, 1);
        assertEquals(lauta.getArvo(4, 1), 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
