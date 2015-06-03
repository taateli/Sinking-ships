/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author tatuhelander
 */
public class Nappi extends JButton implements ActionListener {
    private int rivi;
    private int sarake;
    private Kayttoliittyma k;
    
    public Nappi (int rivi, int sarake, Kayttoliittyma k) {
        this.rivi = rivi;
        this.sarake = sarake;
        this.k = k;
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(rivi + " " + sarake);
    }
    
}
