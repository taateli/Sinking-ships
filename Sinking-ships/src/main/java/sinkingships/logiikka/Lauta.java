/*
 * 
 * 
 * 
 */
package sinkingships.logiikka;

/**
 * Pelissä käytettävä pelialusta
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

 /**
  * Asettaa laivan laudalle vaakatasoon
  * 
  * @param koko - laivan koko pisteinä
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos laivan asetus onnistui tai false jos se ei onnistunut
 */
    
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

 /**
  * Asettaa laivan laudalle pystysuunnassa
  * 
  * @param koko - laivan koko pisteinä
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos laivan asetus onnistui tai false jos se ei onnistunut    
  */
    
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

 /**
  * Tarkistaa mahtuuko laiva pystysuunnassa ajateltuun kohtaan
  * 
  * @param koko - laivan koko pisteinä
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos laivan kokoinen tila pystysuunnassa aloitus pisteestä on vapaa
  * tai false jos se ei ole    
  */
    
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
    
 /**
  * Tarkistaa mahtuuko laiva pystysuunnassa ajateltuun kohtaan
  * 
  * @param koko - laivan koko pisteinä
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos laivan kokoinen tila pystysuunnassa aloitus pisteestä on vapaa
  * tai false jos se ei ole    
  */

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

/**
  * Tarkistaa onko pisteessä laivaa
  * 
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos pisteessä on laiva tai false jos ei ole    
  */
    
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

/**
  * Tarkistaa onko piste laudalla
  * 
  * @param rivi - pystysuunnan rivinumero jolta laiva alkaa
  * @param sarake - vaakasuunnan rivinumero jolta laiva alkaa
  * 
  * @return palauttaa joko true, jos pisteessä on laudalla tai false jos ei ole    
  */    
    
    public boolean onkoPisteLaudalla(int rivi, int sarake) {
       if (rivi < 8 && sarake < 8) {
           return true;
       } else {
           return false;
       }
    }


}
