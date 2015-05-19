 
package taateli.sinking.ships.logiikka;

import java.util.Scanner;

/**
 *
 * @author tatuhelander
 */


public class Logiikka {
    
    private final Lauta pelaaja1Lauta;
    private final Lauta pelaaja2Lauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Scanner lukija = new Scanner(System.in);
    
    public Logiikka(){
       pelaaja1Lauta = new Lauta();
       pelaaja2Lauta = new Lauta();
}
    
    public void Peli(){
        lisaaPelaajat();
        lisaaLaivaLaudalle(pelaaja1Lauta);
    }
    

    public void naytaPelilaudat() {
        System.out.println("Pelaaja 1 lauta: ");
        pelaaja1Lauta.tulostaPeliAlue();
        System.out.println("Pelaaja 2 lauta: ");
        pelaaja2Lauta.tulostaPeliAlue();
    }
    
    public void lisaaLaivaLaudalle(Lauta lauta) {
        System.out.print("Laivan koko (2-4): ");
        int koko = lukija.nextInt();
        
        System.out.print("Vertikaalisesti(1) vai horisontaalisesti(2)? ");
        boolean horisontaalinen;
        if (lukija.nextInt() == 2) {
            horisontaalinen = true;
        } else {
            horisontaalinen = false;
        }
        System.out.print("Rivi: ");
        int rivi = lukija.nextInt();
        
        System.out.print("Sarake");
        int sarake = lukija.nextInt();
        
        lauta.asetaLaiva(koko, horisontaalinen, rivi, sarake);
    }
    
    public void lisaaPelaajat() {
        System.out.print("Pelaaja 1 anna nimi: ");
        String nimi = lukija.nextLine();
        pelaaja1 = new Pelaaja(nimi, pelaaja1Lauta);
        
        System.out.print("Pelaaja 2 anna nimi: ");
        String nimi2 = lukija.nextLine();
        pelaaja2 = new Pelaaja(nimi2, pelaaja2Lauta);
        
    }
    
    
    
    
    
    
    
    
    
    
}
