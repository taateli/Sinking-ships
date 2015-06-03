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

    public Logiikka() {
        pelaaja1Lauta = new Lauta();
        pelaaja2Lauta = new Lauta();
        asetaLaivat();
        arvoLaivatLaudalle();
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

    /*
    *Palauttaa pelaaja1 laudan
    */
    public int[][] getLauta1() {
        return pelaaja1.getLauta();
    }

    public int[][] getLauta2() {
        return pelaaja2.getLauta();
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

        int laivanKoko = koko;

        int aloitusRivi = (rivi - 1);

        int aloitusSarake = (sarake - 1);

        if (suunta == true) {
            int pisteita = pelaaja1Lauta.asetaLaivaVaaka(laivanKoko, aloitusRivi, aloitusSarake);
            if (pisteita == (-1)) {
                return false;
            } else {
                for (int i = 0; i < pisteita; i++) {
                    pelaaja2Pisteet++;
                }
                return true;
            }
        } else {
            int pisteita = pelaaja1Lauta.asetaLaivaPysty(laivanKoko, aloitusRivi, aloitusSarake);
            if (pisteita == -1) {
                return false;
            } else {
                for (int i = 0; i < pisteita; i++) {
                    pelaaja2Pisteet++;
                }
                return true;
            }
        }
    }

    public boolean lisaaLaivaLaudallePelaaja2(boolean suunta, int koko, int rivi, int sarake) {

        int laivanKoko = koko;

        int aloitusRivi = (rivi - 1);

        int aloitusSarake = (sarake - 1);

        if (suunta == true) {
            int pisteita = pelaaja2Lauta.asetaLaivaVaaka(laivanKoko, aloitusRivi, aloitusSarake);
            if (pisteita == -1) {
                return false;
            } else {
                for (int i = 0; i < pisteita; i++) {
                    pelaaja1Pisteet++;
                }
                return true;
            }
        } else {
            int pisteita = pelaaja2Lauta.asetaLaivaPysty(laivanKoko, aloitusRivi, aloitusSarake);
            if (pisteita == -1) {
                return false;
            } else {
                for (int i = 0; i < pisteita; i++) {
                    pelaaja1Pisteet++;
                }
                return true;
            }
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

    public boolean ammuPelaaja1(int rivi, int sarake) {
        if (pelaaja2Lauta.osuukoLaivaan((rivi - 1), (sarake - 1)) == true) {
            pelaaja1Pisteet++;
        }

        if (pelaaja1Pisteet == 12) {
            return false;
        } else {
            return true;
        }

    }

    public boolean ammuPelaaja2(int rivi, int sarake) {
        if (pelaaja1Lauta.osuukoLaivaan((rivi - 1), (sarake - 1)) == true) {
            pelaaja2Pisteet++;
        }

        if (pelaaja2Pisteet == 12) {
            return false;
        } else {
            return true;
        }

    }
    
    public void arvoLaivatLaudalle() {
        Random rand = new Random();
        for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(5) +1;
            int sarake = rand.nextInt(5) +1;
            if (lisaaLaivaLaudallePelaaja1(true, laivat.get(i).getKoko(), rivi, sarake) == true){
                i++;
            } 
        }
        for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(5) + 1;
            int sarake = rand.nextInt(5) + 1;
            if (lisaaLaivaLaudallePelaaja2(true, laivat.get(i).getKoko(), rivi, sarake) == true){
                i++;
            } 
        }
    }
}
