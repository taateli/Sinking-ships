/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.util.Scanner;
import sinkingships.logiikka.Logiikka;
import sinkingships.logiikka.Pelaaja;

/**
 *
 * @author tatuhelander
 */
public class Tekstikayttoliittyma {
    
    private final Logiikka logic;
    private final Scanner lukija = new Scanner(System.in);
    
    public Tekstikayttoliittyma() {
        logic = new Logiikka();
    }
    
    public void peli(){
        lisaaPelaajat();
    }
    
    public void lisaaPelaajat() {
        System.out.print("Anna ensimmäisen pelaajan nimi: ");
        String nimi1 = lukija.nextLine();
        System.out.print("Anna toisen pelaajan nimi: ");
        String nimi2 = lukija.nextLine();
        logic.lisaaPelaajat(nimi1, nimi2);
    }
    
    public void lisaaLaivat() {
       
    }
    
   
}
