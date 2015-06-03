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
 *
 * @author tatuhelander
 */
public class Kayttoliittyma extends javax.swing.JFrame implements Runnable {
    
    private JFrame frame;
    private Logiikka laivanupotus;
    Nappi[][] taulukko = new Nappi[6][6];
    
    public Kayttoliittyma() {
        laivanupotus = new Logiikka();
    }
    

    @Override
    public void run() {
     frame = new JFrame("Sinkingships");
     frame.setPreferredSize(new Dimension(800, 600));
     frame.setLayout(new GridLayout(4, 1));
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
     luoKomponentit(frame.getContentPane());

     frame.pack();
     frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        JLabel pelaaja1Lauta = new JLabel("Pelaaja1 lauta");
        JPanel omaLauta = luoNapit();
        JLabel pelaaja2Lauta = new JLabel("Pelaaja2 lauta");
        JPanel vastustajanLauta = luoNapit();
        c.add(pelaaja1Lauta);
        c.add(omaLauta);
        c.add(pelaaja2Lauta);
        c.add(vastustajanLauta);
    }
    
     public JPanel luoNapit() {
         
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new GridLayout(6, 6));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                taulukko[i][j] = new Nappi(i, j, this);
                paneeli.add(taulukko[i][j]);            
        }
    }
        
        return paneeli;
}
    
    
}
