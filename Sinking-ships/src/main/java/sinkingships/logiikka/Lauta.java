/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.logiikka;

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

    public int[][] getLauta() {
        return lauta;
    }

    public int getArvo(int rivi, int sarake) {
        return lauta[rivi][sarake];
    }


    public boolean asetaLaivaVaaka(int koko, int rivi, int sarake) {
        int onkoLaudallaHorisontaalisesti = koko + sarake;
        if (onkoLaudallaHorisontaalisesti > 6) {
            return false;
        }
        boolean paikkaOK = true;
        int testausSarake = sarake;
        for (int i = 0; i < koko; i++) {
            if (lauta[rivi][testausSarake] == 1) {
                return false;
            } else {
                testausSarake++;
            }
        }

        if (paikkaOK = true) {

            for (int i = 0; i < koko; i++) {
                lauta[rivi][sarake] = 1;
                sarake++;
            }

            return true;
        }
        return false;
    }

    public boolean asetaLaivaPysty(int koko, int rivi, int sarake) {

        int onkoLaudallaVertikaalisesti = koko + rivi;
        if (onkoLaudallaVertikaalisesti > 6) {
            return false;
        }

        boolean paikkaOK = true;

        int testausRivi = rivi;
        for (int i = 0; i < koko; i++) {
            if (lauta[testausRivi][sarake] == 1) {
                return false;
            } else {
                testausRivi++;
            }
        }

        if (paikkaOK == true) {

            for (int i = 0; i < koko; i++) {
                lauta[rivi][sarake] = 1;
                rivi++;
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
