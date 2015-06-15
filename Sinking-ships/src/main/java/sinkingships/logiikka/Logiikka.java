package sinkingships.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Koordinoi peliä ja toteuttaa käyttöliittymälle näkyvän rajapinnan ja tarjoaa
 * sille kaiken tarvitseman.
 */
public class Logiikka {

    private final Lauta pelaaja1Lauta;
    private final Lauta pelaaja2Lauta;
    private int pelaaja1Pisteet = 0;
    private int pelaaja2Pisteet = 0;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private final ArrayList<Laiva> laivat = new ArrayList<>();
    private int vuoro;
    private Random rand = new Random();

    public Logiikka() {
        pelaaja1Lauta = new Lauta();
        pelaaja2Lauta = new Lauta();
        asetaLaivat();
        arvoLaivatLaudallePelaaja1();
        arvoLaivatLaudallePelaaja2();
        vuoro = 2;
    }

    /*
     *Asettaa peliin oikean kokoiset laivat
     */
    public void asetaLaivat() {
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(4));
    }

    /**
     * Vaihtaa pelaajan vuoroa
     */
    public void vaihdaVuoroa() {
        if (vuoro == 1) {
            vuoro = 2;
        } else {
            vuoro = 1;
        }

    }

    public int getVuoro() {
        return vuoro;
    }

    public int[][] getLauta1() {
        return pelaaja1Lauta.getLauta();
    }

    public int[][] getLauta2() {
        return pelaaja2Lauta.getLauta();
    }

    public ArrayList<Laiva> getLaivat() {
        return laivat;
    }

    public int getPelaaja1Pisteet() {
        return pelaaja1Pisteet;
    }

    public int getPelaaja2Pisteet() {
        return pelaaja2Pisteet;
    }

    /**
     * Lisää laivan pelaajan 1 laudalle
     *
     * @param suunta - asetettavan laivan suunta. true jos vaaka, false jos
     * pysty
     * @param koko - laivan koko ruutujen lukumääränä
     * @param rivi - pysty suunnassa olevan akselin rivi numero jolta laivaa
     * aletaan sijoittamaan ruudukkoon
     * @param sarake - vaaka suunnassa olevan akselin numero jolta laivaa
     * aletaan sijoittamaan ruudukkoon
     *
     * @return voitiinko laiva asettaa true -> jos onnistui false -> jos ei
     */
    public boolean lisaaLaivaLaudallePelaaja1(boolean suunta, int koko, int rivi, int sarake) {

        if (suunta == true) {
            return pelaaja1Lauta.asetaLaivaVaaka(koko, rivi, sarake);

        } else {
            return pelaaja1Lauta.asetaLaivaPysty(koko, rivi, sarake);

        }
    }

    /**
     * Lisää laivan pelaajan 2 laudalle
     *
     * @param suunta - asetettavan laivan suunta. true jos vaaka, false jos
     * pysty
     * @param koko - laivan koko ruutujen lukumääränä
     * @param rivi - pysty suunnassa olevan akselin rivi numero jolta laivaa
     * aletaan sijoittamaan ruudukkoon
     * @param sarake - vaaka suunnassa olevan akselin numero jolta laivaa
     * aletaan sijoittamaan ruudukkoon
     *
     * @return voitiinko laiva asettaa true -> jos onnistui false -> jos ei
     */
    public boolean lisaaLaivaLaudallePelaaja2(boolean suunta, int koko, int rivi, int sarake) {

        if (suunta == true) {
            return pelaaja2Lauta.asetaLaivaVaaka(koko, rivi, sarake);

        } else {
            return pelaaja2Lauta.asetaLaivaPysty(koko, rivi, sarake);

        }
    }

    /**
     * Luo pelaajat ja lisää ne peliin.
     *
     * @param nimi1 - asetettavan laivan suunta. true jos vaaka, false jos pysty
     */
    public void lisaaPelaajat(String nimi1, String nimi2) {
        pelaaja1 = new Pelaaja(nimi1, pelaaja1Lauta);
        pelaaja2 = new Pelaaja(nimi2, pelaaja2Lauta);
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    /**
     * Pelaaja 1 ampuu pelaajan 2 laudalle.
     *
     * @param rivi - pystyakselin piste jolle pelaaja 1 haluaa ampua
     * @param sarake - vaaka-akselin piste jolle pelaaja 1 haluaa ampua
     *
     * @return palauttaa 3, jos pelaaja 1 osuu pelaaja2 laivaan ja kaikki laivat
     * on upotettu, 1 jos pelaaja osuu vastustajan laivaan ja 2 jos pelaaja ei
     * osu laivaan.
     */
    public int ammuPelaaja1(int rivi, int sarake) {
        if (pelaaja2Lauta.osuukoLaivaan((rivi), (sarake)) == true) {
            pelaaja1Pisteet++;
            if (pelaaja1Pisteet == 12) {
                return 3; // jos osuma laivan ja pelaajalla 12 pistettä palautta 3, eli pelaaja voitaa pelin
            }
            return 1; // jos osuma laivaan palauttaa 1
        } else {
            return 2; // jos ammuttu tyhjään ruutuun palauttaa 2
        }

    }

    /**
     * Pelaaja 2 ampuu pelaajan 1 laudalle.
     *
     * @param rivi - pystyakselin piste jolle pelaaja 1 haluaa ampua
     * @param sarake - vaaka-akselin piste jolle pelaaja 1 haluaa ampua
     *
     * @return palauttaa 3, jos pelaaja2 osuu pelaaja1 laivaan ja kaikki laivat
     * on upotettu, 1 jos pelaaja osuu vastustajan laivaan ja 2 jos pelaaja ei
     * osu laivaan.
     */
    public int ammuPelaaja2(int rivi, int sarake) {
        if (pelaaja1Lauta.osuukoLaivaan((rivi), (sarake)) == true) {
            pelaaja2Pisteet++;
            if (pelaaja2Pisteet == 12) {
                return 3; // jos osuma laivan ja pelaajalla 12 pistettä palautta 3, eli pelaaja voitaa pelin
            }
            return 1; // jos osuma laivaan palauttaa 1
        } else {
            return 2; // jos ammuttu tyhjään ruutuun palauttaa 2
        }

    }

    /**
     * Arpoo pelaajan1 laudalle laivat.
     */
    public void arvoLaivatLaudallePelaaja1() {
        for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(6) + 1;
            int sarake = rand.nextInt(6) + 1;
            if (lisaaLaivaLaudallePelaaja1(arvoLaivalleSuunta(), laivat.get(i).getKoko(), rivi, sarake) == true) {
                i++;
            }
        }
    }

    /**
     * Arpoo pelaajan2 laudalle laivat.
     */
    public void arvoLaivatLaudallePelaaja2() {
        for (int i = 0; i < laivat.size();) {
            int rivi = rand.nextInt(6) + 1;
            int sarake = rand.nextInt(6) + 1;
            if (lisaaLaivaLaudallePelaaja2(arvoLaivalleSuunta(), laivat.get(i).getKoko(), rivi, sarake) == true) {
                i++;
            }
        }
    }

    /**
     * Arvottavien laivojen suunnan arpoja, eli tulee laiva pysty vai
     * vaakasuuntaan
     *
     * @return palauttaa true -> jos vaaka ja false -> jos pysty
     */
    public boolean arvoLaivalleSuunta() {
        int suunta = rand.nextInt(2) + 1;
        if (suunta == 1) {
            return true;
        } else {
            return false;
        }
    }

}
