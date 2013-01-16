/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat;

/**
 *
 * @author albis
 */
import java.util.ArrayList;
import java.util.List;
import tetris.Ruutu;

public class MuodonLuoja {
    private List<Ruutu> ruudut;
    private Palikka palikka;
    
    private int alkuY;
    
    public MuodonLuoja(Palikka palikka) {
        ruudut = new ArrayList<Ruutu>();
        this.palikka = palikka;
        
        alkuY = 0;
    }
    
    public List<Ruutu> luoNelio(int alkuX) {
        ruudut.add(palikka.getKentta().getRuutu(alkuX, alkuY));
        ruudut.add(palikka.getKentta().getRuutu(alkuX, alkuY + 1));
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 1, alkuY + 1));
        
        return ruudut;
    }
    
    public List<Ruutu> luoSuorakulmio(int alkuX) {
        for (int i = 0; i < 4; i++) {
            ruudut.add(palikka.getKentta().getRuutu(alkuX + i, alkuY));
        }
        
        return ruudut;
    }
    
    public List<Ruutu> luoMutka(int alkuX) {
        ruudut.add(palikka.getKentta().getRuutu(alkuY, alkuY));
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 1, alkuY + 1));
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
    
    public List<Ruutu> luoL(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getKentta().getRuutu(alkuX + i, alkuY));
        }
        
        ruudut.add(palikka.getKentta().getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
}
