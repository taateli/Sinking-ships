/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.util.ArrayList;
import java.util.Scanner;
import sinkingships.logiikka.Laiva;
import sinkingships.logiikka.Lauta;
import sinkingships.logiikka.Logiikka;
import sinkingships.logiikka.Pelaaja;

/**
 *
 * @author tatuhelander
 */
public class Tekstikayttoliittyma {

    private final Logiikka logic;
    private final Scanner lukija = new Scanner(System.in);
    private String pelaaja1;
    private String pelaaja2;

    public Tekstikayttoliittyma() {
        logic = new Logiikka();
    }

    public void peli() {
        lisaaPelaajat();
        //lisaaPommitPelaaja1();
        //lisaaPommitPelaaja2();
        System.out.println(pelaaja1 + " aseta laivat!");        
        
        naytaPeliAluePelaaja1();
        
        System.out.println(pelaaja2 + " aseta laivat!");
        
        naytaPeliAluePelaaja2();
        
        while (true) {
            naytaPeliAluePelaaja1();
            if (pelaaPelaaja1Vuoro() == false) {
                break;
            }
            naytaPeliAluePelaaja2();
            if (pelaaPelaaja2Vuoro() == false) {
                break;
            }            
        }
    }

    public void lisaaPelaajat() {
        System.out.print("Anna ensimmäisen pelaajan nimi: ");
        this.pelaaja1 = lukija.nextLine();
        System.out.print("Anna toisen pelaajan nimi: ");
        this.pelaaja2 = lukija.nextLine();
        logic.lisaaPelaajat(pelaaja1, pelaaja2);
    }
    
    //public void lisaaPommitPelaaja1() {
    //    System.out.println(logic.getPelaaja1().getNimi() + " lisää syvyyspommit(2) vastustajan laudalle!");
    //    for (int i = 0; i < 2;) {
    //        System.out.print("Rivi: ");
    //        int rivi = lukija.nextInt();
    //        System.out.print("Sarake: ");
    //        int sarake = lukija.nextInt();
    //        
    //        if (logic.pelaaja1LisaaMiina(rivi, sarake) == true) {
    //            i++;
    //        }
    //    }
//}
    
  //      public void lisaaPommitPelaaja2() {
  //      System.out.println(logic.getPelaaja2().getNimi() + " lisää syvyyspommit(2) vastustajan laudalle!");
  //      for (int i = 0; i < 2;) {
  //          System.out.print("Rivi: ");
  //          int rivi = lukija.nextInt();
  //          System.out.print("Sarake: ");
  //          int sarake = lukija.nextInt();
  //          
  //          if (logic.pelaaja2LisaaMiina(rivi, sarake) == true) {
  ////              i++;
  //          }
  //      }
//}
    

    public void lisaaLaivatPelaaja1() {
        ArrayList<Laiva> laivat = logic.getLaivat();
        for (int i = 0; i < laivat.size();) {
            Laiva laiva = (Laiva) logic.getLaivat().get(i);
            System.out.println("Aseta laiva nr." + (i+1) +" koko " + laiva.getKoko());
            System.out.print("Vaaka(1) vai pysty(2): ");
            boolean suunta = true;
            if (lukija.nextInt() == 2) {
                suunta = false;
            }
            System.out.print("Aloitus rivi: ");
            int rivi = lukija.nextInt();
            System.out.print("Aloitus sarake: ");
            int sarake = lukija.nextInt();

            if (logic.lisaaLaivaLaudallePelaaja1(suunta, laiva.getKoko(), rivi, sarake) == true) {
                i++;
            } else {
                System.out.println("Laiva ulkona pelialueelta tai jo asetetun laivan päällä!");
            }
        }
        System.out.println("Laivat lisätty!");
    }

    public void lisaaLaivatPelaaja2() {
        ArrayList<Laiva> laivat = logic.getLaivat();
        for (int i = 0; i < laivat.size();) {
            Laiva laiva = (Laiva) logic.getLaivat().get(i);
            System.out.println("Aseta laiva nr." + (i+1) +" koko " + laiva.getKoko());
            System.out.print("Vaaka(1) vai pysty(2): ");
            boolean suunta = true;
            if (lukija.nextInt() == 2) {
                suunta = false;
            }
            System.out.print("Aloitus rivi: ");
            int rivi = lukija.nextInt();
            System.out.print("Aloitus sarake: ");
            int sarake = lukija.nextInt();

            if (logic.lisaaLaivaLaudallePelaaja2(suunta, laiva.getKoko(), rivi, sarake) == true) {
                i++;
            } else {
                System.out.println("Laiva ulkona pelialueelta tai jo asetetun laivan päällä!");
            }
        }
        System.out.println("Laivat lisätty!");
    }

    public void naytaPeliAluePelaaja1() {
        int[][] lauta1 = logic.getLauta1();
        int[][] lauta2 = logic.getLauta2();
        System.out.println("Oma pelialue: ");
        tulostaOmaLauta(lauta1);
        System.out.println("Vastustajan pelialue: ");
        tulostaVastustajanLauta(lauta2);
    }

    public void naytaPeliAluePelaaja2() {
        int[][] lauta1 = logic.getLauta2();
        int[][] lauta2 = logic.getLauta1();
        System.out.println("Oma pelialue: ");
        tulostaOmaLauta(lauta1);
        System.out.println("Vastustajan pelialue: ");
        tulostaVastustajanLauta(lauta2);
    }

    public void tulostaOmaLauta(int[][] lauta) {
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6");
        System.out.println();
        int[][] pelialue = lauta;
        for (int rivi = 0; rivi < 6; rivi++) {
            System.out.print((rivi + 1) + "");
            for (int sarake = 0; sarake < 6; sarake++) {
                if (lauta[rivi][sarake] == -1) {
                    System.out.print("\t" + "~");
                } else if (lauta[rivi][sarake] == 0) {
                    System.out.print("\t" + "*");
                } else if (lauta[rivi][sarake] == 1) {
                    System.out.print("\t" + "=");
                } else if (lauta[rivi][sarake] == 2) {
                    System.out.print("\t" + "X");
                }

            }
            System.out.println();
        }

    }

    public void tulostaVastustajanLauta(int[][] lauta) {
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6");
        System.out.println();
        int[][] pelialue = lauta;
        for (int rivi = 0; rivi < 6; rivi++) {
            System.out.print((rivi + 1) + "");
            for (int sarake = 0; sarake < 6; sarake++) {
                if (lauta[rivi][sarake] == -1) {
                    System.out.print("\t" + "~");
                } else if (lauta[rivi][sarake] == 0) {
                    System.out.print("\t" + "*");
                } else if (lauta[rivi][sarake] == 1) {
                    System.out.print("\t" + "~");
                } else if (lauta[rivi][sarake] == 2) {
                    System.out.print("\t" + "X");
                }

            }
            System.out.println();
        }

    }
    
    public boolean pelaaPelaaja1Vuoro() {
        Pelaaja pelaaja = logic.getPelaaja1();
        System.out.println(pelaaja.getNimi() + " ammu vastustajan laudalle!");
        System.out.print("Rivi: ");
        int rivi = lukija.nextInt();
        System.out.print("Sarake: ");
        int sarake = lukija.nextInt();
        if (logic.ammuPelaaja1(rivi, sarake) == true){
            return true;
        } else {
            System.out.println("Onnea " + pelaaja.getNimi() + " voitit pelin!");
            return false;
        }
        
    }
    
        public boolean pelaaPelaaja2Vuoro() {
        Pelaaja pelaaja = logic.getPelaaja2();
        System.out.println(pelaaja.getNimi() + " ammu vastustajan laudalle!");
        System.out.print("Rivi: ");
        int rivi = lukija.nextInt();
        System.out.print("Sarake: ");
        int sarake = lukija.nextInt();
        if (logic.ammuPelaaja2(rivi, sarake) == true){
            return true;
        } else {
            System.out.println("Onnea " + pelaaja.getNimi() + " voitit pelin!");
            return false;
        }
        
        
    }

}


