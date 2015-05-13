
package taateli.sinking.ships.logiikka;


public class Laiva {
    Alus alus;
    
    public Laiva(Alus alus){
        this.alus = alus;
    }
    
    public int getKoko(){
        return alus.getKoko();
    }
}
