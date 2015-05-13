/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taateli.sinking.ships.logiikka;

/**
 *
 * @author tatuhelander
 */
public class Paaluokka {
    public static void main(String[] args) {
        Logiikka logic = new Logiikka();
        logic.alustaLauta();
        logic.asetaLaiva(2, 0, 2, 1);
        logic.tulostaPeliAlue();
    }
}
