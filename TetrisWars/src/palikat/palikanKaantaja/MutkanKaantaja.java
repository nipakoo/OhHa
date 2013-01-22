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
public class MutkanKaantaja extends PalikanKaantaja {
    
    public MutkanKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public void kaanna() {
        kaannaMutka();
    }
    
    //jos palikka on pystyssä, käytetään siirtojen vastalukuja, jotta käännytään
    //toiseen suuntaan
    public void kaannaMutka() {
        int mistaAsennosta = 1;
        
        if (palikka.getAsento() == 1 || palikka.getAsento() == 3) {
            mistaAsennosta = -1;
        }
        
        siirraRuutua(0, mistaAsennosta * 2, mistaAsennosta * -1);
        siirraRuutua(1, mistaAsennosta * 1, mistaAsennosta * 0);
        siirraRuutua(2, mistaAsennosta * 0, mistaAsennosta * -1);
        siirraRuutua(3, mistaAsennosta * -1, mistaAsennosta * 0);
    }
}
