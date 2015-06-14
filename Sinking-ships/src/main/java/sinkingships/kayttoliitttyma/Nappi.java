/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import sinkingships.logiikka.Logiikka;

/**
 * Laudan rakentavat napit. Jotka toteuttavat ampumisen.
 */
public class Nappi extends JButton implements ActionListener {

    private int rivi;
    private int sarake;
    private Kayttoliittyma k;
    private Logiikka logic;
    int pelaaja;
    private JFrame lopetus;

    public Nappi(int rivi, int sarake, Kayttoliittyma k, Logiikka l, int pelaaja) {
        this.rivi = rivi;
        this.sarake = sarake;
        this.k = k;
        this.logic = l;
        this.pelaaja = pelaaja;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (logic.getVuoro() == pelaaja) {

            int tulos = ammu(pelaaja);

            if (tulos == 1 || tulos == 2) {

                if (tulos == 2) {
                    setText("~~~");
                    setBackground(Color.blue);
                    setEnabled(false);
                    logic.vaihdaVuoroa();
                }
                if (tulos == 1) {
                    setText("x");
                    setBackground(Color.red);
                    setEnabled(false);
                    logic.vaihdaVuoroa();
                }
            }

            if (tulos == 3) {
                setText("x");
                setBackground(Color.red);
                setEnabled(false);

                lopetus = new JFrame("Peli päättyi");
                lopetus.setPreferredSize(new Dimension(300, 200));

                lopetus.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                lopetus.setLayout(new GridLayout(2, 1));
                String voittaja;
                if (pelaaja == 1) {
                    voittaja = logic.getPelaaja2().getNimi();
                } else {
                    voittaja = logic.getPelaaja1().getNimi();
                }

                JLabel onnittelu = new JLabel(voittaja + " Voitit pelin!");

                lopetus.add(onnittelu);

                lopetus.pack();
                lopetus.setVisible(true);

            }
        }
    }

    public int ammu(int pelaaja) {
        if (pelaaja == 1) {
            return logic.ammuPelaaja1(rivi, sarake);
        } else {
            return logic.ammuPelaaja2(rivi, sarake);
        }
    }

}
