/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taateli.sinking.ships.logiikka;

/**
 *
 * @author tatuhelander
 */
public class Lauta {

    private final int[][] lauta;

    public Lauta() {
        this.lauta = new int[6][6];

        for (int rivi = 0; rivi < 6; rivi++) {
            for (int sarake = 0; sarake < 6; sarake++) {
                lauta[rivi][sarake] = -1;
            }
        }
    }

    public int getArvo(int rivi, int sarake) {
        return lauta[rivi][sarake];
    }

    public void tulostaPeliAlue() {
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6");
        System.out.println();

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

    public boolean asetaLaivaHorisontaalisesti(int koko, int rivi, int sarake) {
        boolean paikkaOK = true;
        int testausSarake = sarake;
        for (int i = 0; i < koko; i++) {
            if (lauta[rivi][testausSarake] == 1) {
                paikkaOK = false;
                testausSarake++;
            } else {
                testausSarake++;
            }
        }

        if (paikkaOK = true) {

            int onkoLaudallaHorisontaalisesti = koko + sarake;
            if (onkoLaudallaHorisontaalisesti < 6) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    sarake++;
                }

            }
            return true;
        }
        return false;
    }

    public boolean asetaLaivaVertikaalisesti(int koko, int rivi, int sarake) {

        boolean paikkaOK = true;
        int testausRivi = rivi;
        for (int i = 0; i < koko; i++) {
            if (lauta[testausRivi][sarake] == 1) {
                paikkaOK = false;
                testausRivi++;
            } else {
                testausRivi++;
            }
        }

        if (paikkaOK == true) {

            int onkoLaudallaVertikaalisesti = koko + rivi;
            if (onkoLaudallaVertikaalisesti < 6) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    rivi++;
                }

            }
            return true;

        } else {
            return false;
        }
    }

    public boolean osuukoLaivaan(int rivi, int sarake) {
        if (lauta[rivi][sarake] == 1) {
            lauta[rivi][sarake] = 2;
            return true;
        } else {
            lauta[rivi][sarake] = 0;
            return false;
        }
    }



}
