/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taateli.sinking.ships.logiikka;

import java.util.ArrayList;

/**
 *
 * @author tatuhelander
 */
public class Pelaaja {
    private final String nimi;
    private final Lauta lauta;
    private int pisteet = 0;
    private ArrayList<Laiva> laivat = new ArrayList<Laiva>();
    
    public Pelaaja(String nimi, Lauta lauta) {
        this.nimi = nimi;
        this.lauta = lauta;
    }
    
    public void lisaaPiste(){
        this.pisteet++;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    public void lisaaLaiva(Laiva laiva) {
        laivat.add(laiva);
    }
    
    public ArrayList<Laiva> annaLaivat() {
        return laivat;
    }
    
    public String getNimi() {
        return nimi;
    }
    
}
