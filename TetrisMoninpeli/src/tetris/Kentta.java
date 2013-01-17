/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author albis
 */
import java.util.ArrayList;
import java.util.List;

public class Kentta {
    private List<Rivi> rivit;
    
    public Kentta() {
        rivit = new ArrayList<Rivi>();
        
        for (int i = 0; i < 20; i++) {
            rivit.add(new Rivi(i));
        }
    }
    
    public Ruutu getRuutu(int x, int y) {
        return rivit.get(y).getRuudut().get(x);
    }
    
    public List<Rivi> getRivit() {
        return rivit;
    }
    
    public void taytaRuudut(List<Ruutu> ruudut) {
        for (Ruutu ruutu : ruudut) {
            ruutu.taytaRuutu();
        }
    }
}
