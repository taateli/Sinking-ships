package sinkingships.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author tatuhelander
 */
public class Logiikka {

    private final Lauta pelaaja1Lauta;
    private final Lauta pelaaja2Lauta;
    private int pelaaja1Pisteet = 0;
    private int pelaaja2Pisteet = 0;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private final ArrayList<Laiva> laivat = new ArrayList<>();
    private int vuoro;
    private Random rand = new Random();
    
    public Logiikka() {
        pelaaja1Lauta = new Lauta();
        pelaaja2Lauta = new Lauta();
        asetaLaivat();
        arvoLaivatLaudallePelaaja1();
        arvoLaivatLaudallePelaaja2();
        vuoro = 2;
    }
    
    //public Logiika() {
    //    pelaaja1Lauta = new Lauta();
    //    pelaaja2Lauta = new Lauta();
    //    asetaLaivat();
    //    arvoLaivatLaudalle();
    //}

    
    /*
    *Asettaa peliin oikean kokoiset laivat
    */
    public void asetaLaivat() {
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(4));
    }
    
    public void vaihdaVuoroa() {
        if (vuoro == 1) {
            vuoro = 2;
        } else {
            vuoro = 1;
        }
        
    }
    
    public int getVuoro() {
        return vuoro;
    }

    /*
    *Palauttaa pelaaja1 laudan
    */
    public int[][] getLauta1() {
        return pelaaja1Lauta.getLauta();
    }

    public int[][] getLauta2() {
        return pelaaja2Lauta.getLauta();
    }

    public ArrayList<Laiva> getLaivat() {
        return laivat;
    }

    public int getPelaaja1Pisteet() {
        return pelaaja1Pisteet;
    }

    public int getPelaaja2Pisteet() {
        return pelaaja2Pisteet;
    }

    //public boolean pelaaja1LisaaMiina(int rivi, int sarake) {
    //    rivi = (rivi - 1);
    //    sarake = (sarake - 1);
    //    return pelaaja2Lauta.lisaaSyvyysPommi(rivi, sarake);
    //}

   // public boolean pelaaja2LisaaMiina(int rivi, int sarake) {
   //     rivi = (rivi - 1);
   //     sarake = (sarake - 1);
   //     return pelaaja1Lauta.lisaaSyvyysPommi(rivi, sarake);
   // }

    /*
    *Lisää laivan pelaaja1 laudalle
    *
    *@param   syote   
    */
    public boolean lisaaLaivaLaudallePelaaja1(boolean suunta, int koko, int rivi, int sarake) {

           if (suunta == true) {
            return pelaaja1Lauta.asetaLaivaVaaka(koko, rivi, sarake);
            
        } else {
            return pelaaja1Lauta.asetaLaivaPysty(koko, rivi, sarake);
     
    }
    }

    public boolean lisaaLaivaLaudallePelaaja2(boolean suunta, int koko, int rivi, int sarake) {

        if (suunta == true) {
            return pelaaja2Lauta.asetaLaivaVaaka(koko, rivi, sarake);
            
        } else {
            return pelaaja2Lauta.asetaLaivaPysty(koko, rivi, sarake);
            
    }
    }

    public void lisaaPelaajat(String nimi1, String nimi2) {
        pelaaja1 = new Pelaaja(nimi1, pelaaja1Lauta);
        pelaaja2 = new Pelaaja(nimi2, pelaaja2Lauta);
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public int ammuPelaaja1(int rivi, int sarake) {
        if (pelaaja2Lauta.osuukoLaivaan((rivi), (sarake)) == true) {
            pelaaja1Pisteet++;
            if (pelaaja1Pisteet == 12) {
            return 3; // jos osuma laivan ja pelaajalla 12 pistettä palautta 3, eli pelaaja voitaa pelin
            }
            return 1; // jos osuma laivaan palauttaa 1
        } else {
            return 2; // jos ammuttu tyhjään ruutuun palauttaa 2
        }

    }

    public int ammuPelaaja2(int rivi, int sarake) {
        if (pelaaja1Lauta.osuukoLaivaan((rivi), (sarake)) == true) {
            pelaaja2Pisteet++;
            if (pelaaja2Pisteet == 12) {
            return 3; // jos osuma laivan ja pelaajalla 12 pistettä palautta 3, eli pelaaja voitaa pelin
            }
            return 1; // jos osuma laivaan palauttaa 1
        } else {
            return 2; // jos ammuttu tyhjään ruutuun palauttaa 2
        }

    }
    
    public void arvoLaivatLaudallePelaaja1() {
        for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(6) +1;
            int sarake = rand.nextInt(6) +1;
            if (lisaaLaivaLaudallePelaaja1(arvoLaivalleSuunta(), laivat.get(i).getKoko(), rivi, sarake) == true){
                i++;
            }
        }
    }
    public void arvoLaivatLaudallePelaaja2() {
    for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(6) + 1;
            int sarake = rand.nextInt(6) + 1;
            if (lisaaLaivaLaudallePelaaja2(arvoLaivalleSuunta(), laivat.get(i).getKoko(), rivi, sarake) == true){
                i++;
            } 
        }    
    }
        
    
    
    public boolean arvoLaivalleSuunta() {
        int suunta = rand.nextInt(2) +1;
        if (suunta == 1) {
            return true;
        } else {
            return false;
        }
    }

}
