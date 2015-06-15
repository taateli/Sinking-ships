/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import sinkingships.logiikka.Logiikka;

/**
 * Pelin pääikkuna, johon piirtyy ja päivittyy kuva pelilaudoista. Pelaajat
 * ampuvat vuorollan
 */
public class Kayttoliittyma extends javax.swing.JFrame implements Runnable {

    private JFrame frame;
    private Logiikka laivanupotus;
    private Nappi[][] taulukko = new Nappi[8][8];
    private JLabel vuoro;
    private Aloitus aloitus;

    public Kayttoliittyma() {
        laivanupotus = new Logiikka();
    }

    @Override
    public void run() {
        this.frame = new JFrame("Sinkingships");
        frame.setPreferredSize(new Dimension(300, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoAloitusNakyma();

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container c) {
        JLabel pelaaja1Lauta = new JLabel(laivanupotus.getPelaaja1().getNimi() + "n lauta");
        JPanel omaLauta = luoNapit(1);
        JLabel pelaaja2Lauta = new JLabel(laivanupotus.getPelaaja2().getNimi() + "n lauta");
        JPanel vastustajanLauta = luoNapit(2);
        vuoro = new JLabel("Peliä pelataan vuorotellen ampumalla vastustajan ruudukkoon. " + laivanupotus.getPelaaja1().getNimi() + " aloittaa pelin");
        c.add(vuoro);
        c.add(pelaaja1Lauta);
        c.add(omaLauta);
        c.add(pelaaja2Lauta);
        c.add(vastustajanLauta);
    }

    public void paivitaVuoro() {
        vuoro.setText("Pelaaja " + laivanupotus.getVuoro() + " vuoro");
        this.revalidate();
        this.repaint();
    }

    public JPanel luoNapit(int pelaaja) {
        JPanel paneeli = new JPanel();
        if (pelaaja == 1) {
            paneeli.setLayout(new GridLayout(8, 8));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    taulukko[i][j] = new Nappi(i, j, this, this.laivanupotus, 1);
                    paneeli.add(taulukko[i][j]);
                }
            }
        } else {
            paneeli.setLayout(new GridLayout(8, 8));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    taulukko[i][j] = new Nappi(i, j, this, this.laivanupotus, 2);
                    paneeli.add(taulukko[i][j]);
                }
            }
        }

        return paneeli;
    }

    void AloitaPeli() {
        frame = new JFrame("Sinkingships");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLayout(new GridLayout(5, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoAloitusNakyma() {
        this.aloitus = new Aloitus(this, laivanupotus);
        aloitus.luo();
        frame.getContentPane().add(aloitus, BorderLayout.NORTH);
    }

}
