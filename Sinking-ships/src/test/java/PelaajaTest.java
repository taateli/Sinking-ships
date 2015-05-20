/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import taateli.sinking.ships.logiikka.Lauta;
import taateli.sinking.ships.logiikka.Pelaaja;

/**
 *
 * @author tatuhelander
 */
public class PelaajaTest {
    private Pelaaja pelaaja;

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Pertti", new Lauta());
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
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
