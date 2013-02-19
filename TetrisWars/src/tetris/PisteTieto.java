package tetris;

/**
 * Yksittäisen pistetiedon sisältävä luokka.
 * 
 * @author albis
 */
public class PisteTieto implements Comparable<PisteTieto> {
    private int pisteet;
    private String nimi;
    
    public PisteTieto(int pisteet, String nimi) {
        this.pisteet = pisteet;
        this.nimi = nimi;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    @Override
    public String toString() {
        return pisteet + " " + nimi;
    }

    @Override
    public int compareTo(PisteTieto verrattava) {
        return this.pisteet - verrattava.getPisteet();
    }
}
