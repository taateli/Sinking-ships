/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import sinkingships.logiikka.Logiikka;

/**
 *
 * @author tatuhelander
 */
public class NimenKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;
    private JTextField nimiKentta;
    private JTextField nimiKentta2;
    private JButton painike;
    private Logiikka peli;

    NimenKuuntelija(Logiikka l, Kayttoliittyma liittyma, JTextField nimiKentta, JTextField nimiKentta2) {
        this.kayttoliittyma = liittyma;
        this.nimiKentta = nimiKentta;
        this.nimiKentta2 = nimiKentta2;
        this.peli = l;
    }

    public void tuoKoponentit(JButton painike, JTextField nimiKentta) {
        this.painike = painike;
        this.nimiKentta = nimiKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nimi = nimiKentta.getText();
        String nimi2 = nimiKentta2.getText();
        this.peli.lisaaPelaajat(nimi, nimi2);

        this.kayttoliittyma.AloitaPeli();

    }

}
