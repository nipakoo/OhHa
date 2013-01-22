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
public class LKaantaja extends PalikanKaantaja{
    
    public LKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public void kaanna() {
        if (palikka.getAsento() == 0) {
            kaannaAsennon0L();
        } else if (palikka.getAsento() == 1) {
            kaannaAsennon1L();
        } else if (palikka.getAsento() == 2) {
            kaannaAsennon2L();
        } else {
            kaannaAsennon3L();
        }
    }
    
    public void kaannaAsennon0L() {
        siirraRuutua(0, 2, -1);
        siirraRuutua(1, 1, 0);
        siirraRuutua(2, 0, 1);
        siirraRuutua(3, -1, 0);
    }
    
    public void kaannaAsennon1L() {
        siirraRuutua(0, 0, 2);
        siirraRuutua(1, -1, 1);
        siirraRuutua(2, -2, 0);
        siirraRuutua(3, -1, -1);
    }
    
    public void kaannaAsennon2L() {
        siirraRuutua(0, -1, 0);
        siirraRuutua(1, 0, -1);
        siirraRuutua(2, 1, -2);
        siirraRuutua(3, 2, -1);
    }
    
    public void kaannaAsennon3L() {
        siirraRuutua(0, -1, -1);
        siirraRuutua(1, 0, 0);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, 0, 2);
    }
}
