/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tatuhelander
 */
public class LaivaTest {
    
    private Laiva laiva;
    
    public LaivaTest() {
    }
    
 
  
    @Before
    public void setUp() {
    laiva = new Laiva(4);    
    }
    
    @Test
    public void getKokoToimii() {
        assertEquals(laiva.getKoko(), 4);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
