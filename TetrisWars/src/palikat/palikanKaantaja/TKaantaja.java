/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat.palikanKaantaja;

/**
 *
 * @author albis
 */
import palikat.Palikka;

public class TKaantaja extends PalikanKaantaja {
    
    public TKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public void kaanna() {
        if (palikka.getAsento() == 0) {
            kaannaAsennon0T();
        } else if (palikka.getAsento() == 1) {
            kaannaAsennon1T();
        } else if (palikka.getAsento() == 2) {
            kaannaAsennon2T();
        } else {
            kaannaAsennon3T();
        }
    }
    
    public void kaannaAsennon0T() {
        siirraRuutua(0, 1, -1);
        siirraRuutua(2, -1, 1);
        siirraRuutua(3, -1, -1);
    }
    
    public void kaannaAsennon1T() {
        siirraRuutua(0, 1, 1);
        siirraRuutua(2, -1, -1);
        siirraRuutua(3, 1, -1);
    }
    
    public void kaannaAsennon2T() {
        siirraRuutua(0, -1, 1);
        siirraRuutua(2, 1, -1);
        siirraRuutua(3, 1, 1);
    }
    
    public void kaannaAsennon3T() {
        siirraRuutua(0, -1, -1);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, -1, 1);
    }
}
