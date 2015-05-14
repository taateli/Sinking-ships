
package taateli.sinking.ships.logiikka;

/**
 *
 * @author tatuhelander
 */
public enum Alus {

    /**
     *
     */
    TIEDUSTELUALUS(2),
    SUKELLUSVENE(3),
    MIINALAIVA(4);
    
    
    private final int koko;
    
    private Alus(int koko){
        this.koko = koko;
    }
    
    public int getKoko(){
        return koko;
    }
}
