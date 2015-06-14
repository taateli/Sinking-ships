/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sinkingships.logiikka.Logiikka;

/**
 * Pelin aloitus ruutu
 */
public class Aloitus extends JPanel {

    private Logiikka l;
    private Kayttoliittyma liittyma;
    private NimenKuuntelija kuuntelija;
    private JTextField nimiKentta;
    private JTextField nimiKentta2;
    private JButton painike;

    public Aloitus(Kayttoliittyma kayttoliittyma, Logiikka l) {
        this.setLayout(new GridLayout(6, 1));
        this.liittyma = kayttoliittyma;
        this.l = l;
    }

    public JPanel getPanel() {
        return this;
    }

    public void luo() {
        this.add(new JLabel("Tervetuloa pelaamaan laivanupotusta!"));
        this.add(new JLabel("Anna pelaajan 1 nimi: "));

        nimiKentta = new JTextField();
        this.add(nimiKentta);

        this.add(new JLabel("Anna pelaajan 2 nimi: "));
        nimiKentta2 = new JTextField();
        this.add(nimiKentta2);

        kuuntelija = new NimenKuuntelija(l, liittyma, nimiKentta, nimiKentta2);
        painike = new JButton("Aloita");
        painike.addActionListener(kuuntelija);
        this.add(painike);

    }
}
