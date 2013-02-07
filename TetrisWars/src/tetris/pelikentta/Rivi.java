package tetris.pelikentta;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka, joka sisältää kentän yksittäisen rivin kaikki ruudut ja hallinnoi
 * niitä.
 * 
 * @author albis
 */
public class Rivi {
    
    /**
     * Lista, joka sisältää riviin kuuluvat ruudut, näitä on aina 10 kappaletta.
     */
    private List<Ruutu> ruudut;
    
    /**
     * Kertoo tämän rivin korkeussijainnin kentällä.
     */
    private int y;
    
    public Rivi(int y) {
        ruudut = new ArrayList<Ruutu>();
        
        for (int i = 0; i < 10; i++) {
            ruudut.add(new Ruutu(i, y));
        }
        
        this.y = y;
    }
    
    public List<Ruutu> getRuudut() {
        return ruudut;
    }
    
    /**
     * Tarkistetaan tuhoutuuko tämä rivi, eli ovatko kaikki tällä korkeudella olevat
     * ruudut täysiä
     * 
     * @return Palautetaan false, jos yksikin ruuduista on tyhjä, muuten true 
     */
    public boolean tarkistaTuhoutuukoRivi() {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.onkoTyhja()) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Laskee tämän rivin ja kaikkien tällä rivillä olevien ruutujen korkeussijaintia
     * yhdellä.
     */
    public void laskeRiviaYksiAlas() {
        y++;
        for (Ruutu ruutu : ruudut) {
            ruutu.setY(y);
        }
    }
}
