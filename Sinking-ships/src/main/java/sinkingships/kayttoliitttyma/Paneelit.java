/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tatuhelander
 */
public class Paneelit extends JPanel {

    JButton[][] taulukko = new JButton[6][6];

    public Paneelit() {
        setLayout(new GridLayout(6, 6));

        setBackground(Color.yellow);
    }

}
