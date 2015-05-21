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
import sinkingships.logiikka.Logiikka;

/**
 *
 * @author tatuhelander
 */
public class LogiikkaTest {
   private Logiikka logic;
   
    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
        logic = new Logiikka();
    }
    
    @Test
    public void lisaaPelaajatToimii() {
        logic.lisaaPelaajat("Matti", "Esko");
        
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
