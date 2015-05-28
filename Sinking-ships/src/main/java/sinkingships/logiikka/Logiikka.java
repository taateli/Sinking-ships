package sinkingships.logiikka;

import java.util.ArrayList;



/**
 *
 * @author tatuhelander
 */
public class Logiikka {

    private final Lauta pelaaja1Lauta;
    private final Lauta pelaaja2Lauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private final ArrayList<Laiva> laivat = new ArrayList<>();
    
    public Logiikka() {
        pelaaja1Lauta = new Lauta();
        pelaaja2Lauta = new Lauta();
        asetaLaivat();
    }
    
    public void asetaLaivat() {
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(4));
    }

    public int[][] getLauta1() {
        return pelaaja1.getLauta();
    }
    
    
    public int[][] getLauta2() {
        return pelaaja2.getLauta();
    }
    
    public ArrayList<Laiva> getLaivat() {
        return laivat;
    }
    
    

    public boolean lisaaLaivaLaudallePelaaja1(boolean suunta, int koko, int rivi, int sarake) {

        int laivanKoko = koko;

        int aloitusRivi = (rivi-1);

        int aloitusSarake = (sarake-1);

        if (suunta == true) {
            return pelaaja1Lauta.asetaLaivaVaaka(laivanKoko, aloitusRivi, aloitusSarake);
        } else {
            return pelaaja1Lauta.asetaLaivaPysty(laivanKoko, aloitusRivi, aloitusSarake);
        }

    }
    
        public boolean lisaaLaivaLaudallePelaaja2(boolean suunta, int koko, int rivi, int sarake) {

        int laivanKoko = koko;

        int aloitusRivi = rivi--;

        int aloitusSarake = sarake--;

        if (suunta == true) {
            return pelaaja2Lauta.asetaLaivaVaaka(laivanKoko, aloitusRivi, aloitusSarake);
        } else {
            return pelaaja2Lauta.asetaLaivaPysty(laivanKoko, aloitusRivi, aloitusSarake);
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
    
    public boolean ammuPelaaja1(Pelaaja pelaaja, int rivi, int sarake) {
        if (pelaaja2Lauta.osuukoLaivaan(rivi, sarake) == true){
                pelaaja.lisaaPiste();
        }
        
        if (pelaaja.getPisteet() == 11) {
            return false;
        } else {
            return true;
        }
        
    }
    
    public boolean ammuPelaaja2(Pelaaja pelaaja, int rivi, int sarake) {
        if (pelaaja1Lauta.osuukoLaivaan(rivi, sarake) == true){
                pelaaja.lisaaPiste();
        }
        
        if (pelaaja.getPisteet() == 11) {
            return false;
        } else {
            return true;
        }
        
    }
}
