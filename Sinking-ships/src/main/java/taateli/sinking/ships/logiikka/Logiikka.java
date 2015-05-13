 /
package taateli.sinking.ships.logiikka;

/**
 *
 * @author tatuhelander
 */


public class Logiikka {

    private final int[][] lauta;

    public Logiikka() {
        this.lauta = new int[5][5];
    }

    public void alustaLauta() {
        for (int rivi = 0; rivi < 5; rivi++) {
            for (int sarake = 0; sarake < 5; sarake++) {
                lauta[rivi][sarake] = -1;
            }
        }
    }

    public void tulostaPeliAlue() {
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();

        for (int rivi = 0; rivi < 5; rivi++) {
            System.out.print((rivi + 1) + "");
            for (int sarake = 0; sarake < 5; sarake++) {
                if (lauta[rivi][sarake] == -1) {
                    System.out.print("\t" + "~");
                } else if (lauta[rivi][sarake] == 0) {
                    System.out.print("\t" + "*");
                } else if (lauta[rivi][sarake] == 1) {
                    System.out.print("\t" + "X");
                }

            }
            System.out.println();
        }

    }

    public void asetaLaiva(int koko, int suunta, int rivi, int sarake) {
        if (suunta == 1) {   // suunta horisontaalinen eli vaaka
            int onkoLaudallaHorisontaalisesti = koko + sarake;
            if (onkoLaudallaHorisontaalisesti < 5) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    sarake++;
                }

            }
            if (suunta == 0) {   // suunta vertikaalinen eli 
            int onkoLaudallaVertikaalisesti = koko + rivi;
            if (onkoLaudallaVertikaalisesti < 5) {
                for (int i = 0; i < koko; i++) {
                    lauta[rivi][sarake] = 1;
                    rivi++;
                }

            }

        }
    }
}
