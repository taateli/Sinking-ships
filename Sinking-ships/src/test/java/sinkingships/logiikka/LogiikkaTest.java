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

    @Test
    public void konstruktoriToimii2() {
        ArrayList<Laiva> laivat = logic.getLaivat();
        int koko = 0;
        for (Laiva l : laivat) {
            koko = koko + l.getKoko();
        }
        assertEquals(koko, 12);
    }

    @Test
    public void lisaaPelaajatToimii() {
        logic.lisaaPelaajat("Matti", "Teppo");
        assertEquals(logic.getPelaaja1().getNimi(), "Matti");
    }

    @Test
    public void lisaaPelaajatToimii2() {
        logic.lisaaPelaajat("Matti", "Teppo");
        assertEquals(logic.getPelaaja2().getNimi(), "Teppo");
    }
    //@Test
    // public void miinanLisaysPelaaja1Toimii1() {
    //     assertEquals(logic.pelaaja1LisaaMiina(1, 1), true);
    // }

    //@Test
    // public void miinanLisaysPelaaja1Toimii2() {
    //     assertEquals(logic.pelaaja1LisaaMiina(7, 2), false);
    // }
    //@Test
    //public void miinanLisaysPelaaja2Toimii1() {
    //    assertEquals(logic.pelaaja2LisaaMiina(1, 1), true);
    //}
    //@Test
    //public void miinanLisaysPelaaja2Toimii2() {
    //    assertEquals(logic.pelaaja2LisaaMiina(7, 2), false);
    //}
    @Test
    public void lisaaLaivaPelaaja1Toimii2() {
        logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 1);
        assertEquals(logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 1), false);
    }

    @Test
    public void lisaaLaivaPelaaja2Toimii2() {
        logic.lisaaLaivaLaudallePelaaja2(true, 2, 1, 1);
        assertEquals(logic.lisaaLaivaLaudallePelaaja2(true, 2, 1, 1), false);
    }

    @Test
    public void vuoroAluksi2() {
        assertEquals(logic.getVuoro(), 2);
    }

    @Test
    public void vaihdaVuoroaToimii() {
        logic.vaihdaVuoroa();
        logic.vaihdaVuoroa();
        assertEquals(logic.getVuoro(), 2);
    }

    @Test
    public void vaihdaVuoroaToimii2() {
        logic.vaihdaVuoroa();
        assertEquals(logic.getVuoro(), 1);
    }

    @Test
    public void ammuPelaaja1Toimii1() {
        logic.lisaaLaivaLaudallePelaaja2(true, 3, 2, 1);
        assertEquals(logic.ammuPelaaja1(1, 0), 2);
    }

    @Test
    public void ammuPelaaja2Toimii1() {
        logic.lisaaLaivaLaudallePelaaja1(true, 2, 1, 0);
        assertEquals(logic.ammuPelaaja1(2, 0), 2);
    }

    @Test
    public void ammuPelaaja2Toimii() {
        assertEquals(logic.ammuPelaaja2(7, 7), 2);
    }

    @Test
    public void pelaaja1PisteetToimii() {
        assertEquals(logic.getPelaaja1Pisteet(), 0);
    }

    @Test
    public void pelaaja2PisteetToimii() {
        assertEquals(logic.getPelaaja2Pisteet(), 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
