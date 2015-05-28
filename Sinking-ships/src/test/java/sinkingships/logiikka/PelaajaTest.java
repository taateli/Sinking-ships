package sinkingships.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sinkingships.logiikka.Lauta;
import sinkingships.logiikka.Pelaaja;

/**
 *
 * @author tatuhelander
 */
public class PelaajaTest {
    private Pelaaja pelaaja;
    Lauta lauta = new Lauta();
    int[][] testi;

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Pertti", lauta);
        testi = pelaaja.getLauta();
    }
    
    @Test
    public void pelaajaPalauttaaNimen() {
        assertEquals(pelaaja.getNimi(), "Pertti");
    }
    
    @Test
    public void pisteetAluksiNolla() {
        assertEquals(pelaaja.getPisteet(), 0);
    }
    
    @Test
    public void pisteidenLisaysToimii() {
        pelaaja.lisaaPiste();
        pelaaja.lisaaPiste();
        assertEquals(pelaaja.getPisteet(), 2);
    }
    
    @Test
    public void laudanPalautusToiii() {
        assertEquals(pelaaja.getLauta(), testi);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
