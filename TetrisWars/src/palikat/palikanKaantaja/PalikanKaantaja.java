/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat.palikanKaantaja;

import palikat.Palikka;
import tetris.Ruutu;
/**
 *
 * @author albis
 */
public class PalikanKaantaja {
    protected Palikka palikka;
    
    public PalikanKaantaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public void siirraRuutua(int monesko, int x, int y) {
        Ruutu uusiRuutu;
        
        try {
            uusiRuutu = palikka.getKentta().getRuutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y));
        } catch (Exception e) {
            uusiRuutu = new Ruutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y));
        }
            
        palikka.getRuudut().set(monesko, uusiRuutu);
    }
    
    public int laskeUusiX(int monesko, int x) {
        return palikka.getRuudut().get(monesko).getX() + x;
    }
    
    public int laskeUusiY(int monesko, int y) {
        return palikka.getRuudut().get(monesko).getY() + y;
    }
    
    public void kaanna() {
    }
}
