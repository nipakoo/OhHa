package tetris;

/**
 * Yksittäisen pistetiedon sisältävä luokka.
 * 
 * @author albis
 */
public class PisteTieto implements Comparable<PisteTieto> {
    
    /**
     * Saavutettujen pisteiden määrä.
     */
    private int pisteet;
    
    /**
     * Pelaajan nimi, jolla pisteet tallennetaan.
     */
    private String nimi;
    
    public PisteTieto(int pisteet, String nimi) {
        this.pisteet = pisteet;
        if (nimi.length() > 10) {
            this.nimi = nimi.substring(0, 11);
        } else {
            this.nimi = nimi;
        }
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
