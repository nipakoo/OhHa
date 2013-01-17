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

public class SuorakulmionKaantaja extends PalikanKaantaja {
    
    public SuorakulmionKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public void kaanna() {
        kaannaSuorakulmio();
    }
    
    //jos palikka on pystyssä, käytetään siirtojen vastalukuja, jotta käännytään
    //toiseen suuntaan
    public void kaannaSuorakulmio() {
        int mistaAsennosta = 1;
        
        if (palikka.getAsento() == 1 || palikka.getAsento() == 3) {
            mistaAsennosta = -1;
        }
        
        siirraRuutua(0, 1, -1);
        siirraRuutua(1, 0, 0);
        siirraRuutua(2, -1, 1);
        siirraRuutua(3, -2, 2);
    }
}
