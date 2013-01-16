/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat.palikanKaantaja;

import palikat.Palikka;
/**
 *
 * @author albis
 */
public abstract class PalikanKaantaja {
    protected Palikka palikka;
    
    public PalikanKaantaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public void siirraRuutua(int monesko, int x, int y) {
        palikka.getRuudut().set(monesko, palikka.getKentta().getRuutu
                (palikka.getRuudut().get(monesko).getX() + x, palikka.getRuudut().get(monesko).getY() + y));
    }
    
    public abstract void kaanna();
}
