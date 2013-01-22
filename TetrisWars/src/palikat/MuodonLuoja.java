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
        ruudut.add(0, palikka.getRuutu(alkuX, alkuY));
        ruudut.add(1, palikka.getRuutu(alkuX, alkuY + 1));
        ruudut.add(2, palikka.getRuutu(alkuX + 1, alkuY));
        ruudut.add(3, palikka.getRuutu(alkuX + 1, alkuY + 1));
        
        return ruudut;
    }
    
    public List<Ruutu> luoSuorakulmio(int alkuX) {
        for (int i = 0; i < 4; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        return ruudut;
    }
    
    public List<Ruutu> luoMutka(int alkuX) {
        ruudut.add(palikka.getRuutu(alkuX, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
    
    public List<Ruutu> luoL(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
    
    public List<Ruutu> luoT(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        
        return ruudut;
    }
}
