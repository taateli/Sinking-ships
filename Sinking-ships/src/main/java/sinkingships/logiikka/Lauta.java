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
    
    public boolean lisaaSyvyysPommi(int rivi, int sarake) {
        if (onkoPisteLaudalla(rivi, sarake) == true){
        lauta[rivi][sarake] = 3;
        return true;
        } else {
            return false;
        }
    }

    public int asetaLaivaVaaka(int koko, int rivi, int sarake) {
        int osuukoMiinat = 0;
        int onkoLaudallaVaaka = koko + sarake;
        if (onkoPisteLaudalla(rivi, onkoLaudallaVaaka) == false || onkoPisteLaudalla(rivi, sarake)== false) {
            osuukoMiinat = -1;
            return osuukoMiinat;
        }
        int testausSarake = sarake;
        for (int i = 0; i < koko; i++) {
            if (lauta[rivi][testausSarake] == 1) {
                osuukoMiinat = -1;
                return osuukoMiinat;
            } else {
                testausSarake++;
            }
        }
         for (int i = 0; i < koko; i++) {
             if (lauta[rivi][sarake] ==3) {
                 lauta[rivi][sarake] = 2;
                 osuukoMiinat++;
                 sarake++;
             } else {
                lauta[rivi][sarake] = 1;
                sarake++;
            }
    }
            return osuukoMiinat;
        
    }

    public int asetaLaivaPysty(int koko, int rivi, int sarake) {
        int osuukoMiinat = 0;
        int onkoLaudallaPysty = koko + rivi;
        if (onkoPisteLaudalla(onkoLaudallaPysty, sarake) == false || onkoPisteLaudalla(rivi, sarake)== false) {
            osuukoMiinat = -1;
            return osuukoMiinat;
        }
        
        int testausRivi = rivi;
        for (int i = 0; i < koko; i++) {
            if (lauta[testausRivi][sarake]== 1) {
                osuukoMiinat = -1;
                return osuukoMiinat;
            } else {
                testausRivi++;
            }
        }

            for (int i = 0; i < koko; i++) {
                if (lauta[rivi][sarake] == 3) {
                    lauta[rivi][sarake] = 2;
                    osuukoMiinat++;
                    rivi++;
                } else {
                lauta[rivi][sarake] = 1;
                rivi++;
            }
            }
            return osuukoMiinat;

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
        return rivi < 6 && sarake < 6;
    }
    
    public boolean onkoPisteessaLaivaa(int rivi, int sarake) {
        return lauta[rivi][sarake] == 1;
    }

}
