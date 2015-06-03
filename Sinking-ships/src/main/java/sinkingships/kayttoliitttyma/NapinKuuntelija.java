/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkingships.kayttoliitttyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tatuhelander
 */
public class NapinKuuntelija implements ActionListener  {

    private static Object getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = NapinKuuntelija.getSource();
        System.out.println(source);
    }
    
}
