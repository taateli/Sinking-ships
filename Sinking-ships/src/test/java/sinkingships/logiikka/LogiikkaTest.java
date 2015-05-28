package sinkingships.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sinkingships.logiikka.Logiikka;

/**
 *
 * @author tatuhelander
 */
public class LogiikkaTest {
   private Logiikka logic;
   private int[][] lauta1;
   private int[][] lauta2;

    public LogiikkaTest() {
    }
    
   
    @Before
    public void setUp() {
        logic = new Logiikka();
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(logic.getLaivat().size(), 4);
    }
    
    public void konstruktoriToimii2() {
        ArrayList<Laiva> laivat = logic.getLaivat();
        int koko = 0;
        for (Laiva l : laivat) {
            koko = koko + l.getKoko();
        }
        assertEquals(koko, 11);
    }
    
    @Test
    public void lisaaLaivaPelaaja1Toimii() {
        assertEquals(logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 1), true);
    }
    
    @Test
    public void lisaaLaivaPelaaja1Toimii2() {
        logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 1);
        assertEquals(logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 1), false);
    }
    
    @Test
    public void lisaaLaivaPelaaja2Toimii() {
        assertEquals(logic.lisaaLaivaLaudallePelaaja2(true, 2, 1, 1), true);
    }
    
    @Test
    public void lisaaLaivaPelaaja2Toimii2() {
        logic.lisaaLaivaLaudallePelaaja2(true, 2, 1, 1);
        assertEquals(logic.lisaaLaivaLaudallePelaaja2(true, 2, 1, 1), false);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
