/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.logiikka;

import java.util.ArrayList;

/**
 * Koordinoi pelaajan nimeä ja lautaa.
 */
public class Pelaaja {
    private final String nimi;
    private final Lauta lauta;

    
    public Pelaaja(String nimi, Lauta lauta) {
        this.nimi = nimi;
        this.lauta = lauta;
    }
    
   
    public int[][] getLauta() {
        return lauta.getLauta();
    }
    
  
    
    public String getNimi() {
        return nimi;
    }
    
}
