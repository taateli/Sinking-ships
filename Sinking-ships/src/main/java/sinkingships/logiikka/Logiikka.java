package sinkingships.logiikka;



/**
 *
 * @author tatuhelander
 */
public class Logiikka {

    private final Lauta pelaaja1Lauta;
    private final Lauta pelaaja2Lauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    public Logiikka() {
        pelaaja1Lauta = new Lauta();
        pelaaja2Lauta = new Lauta();
    }

    public Lauta getLauta(Pelaaja pelaaja) {
        return pelaaja.getLauta();
    }

    public boolean lisaaLaivaLaudalle(Lauta lauta, boolean suunta, int koko, int rivi, int sarake) {

        int laivanKoko = koko;

        boolean horisontaalinen = suunta;

        int aloitusRivi = rivi--;

        int aloitusSarake = sarake--;

        if (horisontaalinen == true) {
            return lauta.asetaLaivaHorisontaalisesti(laivanKoko, aloitusRivi, aloitusSarake);
        } else {
            return lauta.asetaLaivaVertikaalisesti(laivanKoko, aloitusRivi, aloitusSarake);
        }

    }

    public void lisaaPelaajat(String nimi1, String nimi2) {
        pelaaja1 = new Pelaaja(nimi1, pelaaja1Lauta);
        pelaaja2 = new Pelaaja(nimi2, pelaaja2Lauta);
    }
}
