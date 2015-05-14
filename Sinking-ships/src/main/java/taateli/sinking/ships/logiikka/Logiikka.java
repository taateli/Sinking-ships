 
package taateli.sinking.ships.logiikka;

/**
 *
 * @author tatuhelander
 */


public class Logiikka {

    private final int[][] lauta;

    public Logiikka() {
        this.lauta = new int[6][6];
    }

    public void alustaLauta() {
        for (int rivi = 0; rivi < 6; rivi++) {
            for (int sarake = 0; sarake < 6; sarake++) {
                lauta[rivi][sarake] = -1;
            }
        }
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

    public void asetaLaiva(int koko, boolean horisontaalinen, int rivi, int sarake) {

        if (horisontaalinen == true) {   // suunta horisontaalinen
            int onkoLaudallaHorisontaalisesti = koko + sarake;
            if (onkoLaudallaHorisontaalisesti < 6) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    sarake++;
                }

            }
        } else {   // suunta vertikaalinen
            int onkoLaudallaVertikaalisesti = koko + rivi;
            if (onkoLaudallaVertikaalisesti < 6) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    rivi++;
                }

            }

        }
    }

    public void osuukoLaivaan(int rivi, int sarake) {
        if (lauta[rivi][sarake] == 1) {
            lauta[rivi][sarake] = 2;
        } else {
            lauta[rivi][sarake] = 0;
        }
    }

}
