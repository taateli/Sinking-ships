/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.logiikka;

import java.util.ArrayList;

/**
 *
 * @author tatuhelander
 */
public class Pelaaja {
    private final String nimi;
    private final Lauta lauta;
    private int pisteet = 0;
    private final ArrayList<Laiva> laivat = new ArrayList<>();
    
    public Pelaaja(String nimi, Lauta lauta) {
        this.nimi = nimi;
        this.lauta = lauta;
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(4));
    }
    
    public void lisaaPiste(){
        this.pisteet++;
    }
    
    public int getPisteet() {
        return pisteet;
    }

    public Lauta getLauta() {
        return lauta;
    }
    
    public ArrayList<Laiva> annaLaivat() {
        return laivat;
    }
    
    public String getNimi() {
        return nimi;
    }
    
}
