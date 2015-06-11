/*
 * 
 * 
 * 
 */
package sinkingships.logiikka;

/**
 *
 * @author tatuhelander
 */
public class Lauta {

    private final int[][] lauta;
    int laivoja;

    public Lauta() {
        this.lauta = new int[8][8];

        for (int rivi = 0; rivi < 8; rivi++) {
            for (int sarake = 0; sarake < 8; sarake++) {
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
        int onkoLaudallaVaaka = koko + sarake;
        if (onkoPisteLaudalla(rivi, onkoLaudallaVaaka) == false || onkoPisteLaudalla(rivi, sarake) == false) {
            return false;
        }

        if (onkoTilaVapaaPysty(koko, rivi, sarake) == true) {
            for (int i = 0; i < koko; i++) {
                lauta[rivi][sarake] = 1;
                sarake++;
            }
            return true;

        } else {
            return false;
        }

    }

    public boolean asetaLaivaPysty(int koko, int rivi, int sarake) {
        int onkoLaudallaPysty = koko + rivi;
        if (onkoPisteLaudalla(onkoLaudallaPysty, sarake) == false || onkoPisteLaudalla(rivi, sarake) == false) {
            return false;
        }
        if (onkoTilaVapaaPysty(koko, rivi, sarake) == true) {
            for (int i = 0; i < koko; i++) {
                if (lauta[rivi][sarake] == 3) {
                    lauta[rivi][sarake] = 2;
                    rivi++;
                } else {
                    lauta[rivi][sarake] = 1;
                    rivi++;
                }
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean onkoTilaVapaaPysty(int koko, int rivi, int sarake) {
        int onkoLaudallaPysty = koko + rivi;
        if (onkoPisteLaudalla(onkoLaudallaPysty, sarake) == false || onkoPisteLaudalla(rivi, sarake) == false) {
            return false;
        }
            for (int i = 0; i < koko; i++) {
                if (lauta[rivi][sarake] == 1) {
                    return false;
                } else {
                    rivi++;
                }
            }
            return true;
        } 
    


    public boolean onkoTilaVapaaVaaka(int koko, int rivi, int sarake) {
        int onkoLaudallaVaaka = koko + sarake;
        if (onkoPisteLaudalla(rivi, onkoLaudallaVaaka) == true || onkoPisteLaudalla(rivi, sarake) == true) {

            for (int i = 0; i < koko; i++) {
                if (lauta[rivi][sarake] == 1) {
                    return false;
                } else {
                    sarake++;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean osuukoLaivaan(int rivi, int sarake) {

        if (onkoPisteLaudalla(rivi, sarake) == true) {
            if (lauta[rivi][sarake] == 1) {
                lauta[rivi][sarake] = 2;
                return true;
            } else {
                lauta[rivi][sarake] = 0;
                return false;
            }
        }
        return false;
    }

    public boolean onkoPisteLaudalla(int rivi, int sarake) {
       if (rivi < 8 && sarake < 8) {
           return true;
       } else {
           return false;
       }
    }


}
