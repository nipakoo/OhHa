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
        if (palikka.getAsento() == 0) {
            kaannaAsennon0Suorakulmio();
        } else if (palikka.getAsento() == 1) {
            kaannaAsennon1Suorakulmio();
        } else if (palikka.getAsento() == 2) {
            kaannaAsennon2Suorakulmio();
        } else {
            kaannaAsennon3Suorakulmio();
        }
    }
    
    public void asetaRuudutEnsimmaisenMukaan() {
        if (palikka.getAsento() == 0) {
            for (int i = 1; i < palikka.getRuudut().size(); i++) {
                palikka.getRuudut().set(i, palikka.getKentta().getRuutu
                        (palikka.getRuudut().get(0).getX(), palikka.getRuudut().get(0).getY() + i));
            }
        } else if (palikka.getAsento() == 1) {
            for (int i = 1; i < palikka.getRuudut().size(); i++) {
                palikka.getRuudut().set(i, palikka.getKentta().getRuutu
                        (palikka.getRuudut().get(0).getX() - i, palikka.getRuudut().get(0).getY()));
            }
        } else if (palikka.getAsento() == 2) {
            for (int i = 1; i < palikka.getRuudut().size(); i++) {
                palikka.getRuudut().set(i, palikka.getKentta().getRuutu
                        (palikka.getRuudut().get(0).getX(), palikka.getRuudut().get(0).getY() - i));
            }
        } else {
            for (int i = 1; i < palikka.getRuudut().size(); i++) {
                palikka.getRuudut().set(i, palikka.getKentta().getRuutu
                        (palikka.getRuudut().get(0).getX() + i, palikka.getRuudut().get(0).getY()));
            }
        }
    }
    
    public void kaannaAsennon0Suorakulmio() {
         siirraRuutua(0, 1, -1);
         asetaRuudutEnsimmaisenMukaan();
    }
    
    public void kaannaAsennon1Suorakulmio() {
        siirraRuutua(0, 1, 1);
        asetaRuudutEnsimmaisenMukaan();
    }
    
    public void kaannaAsennon2Suorakulmio() {
        siirraRuutua(0, -1, 1);
        asetaRuudutEnsimmaisenMukaan();
    }
    
    public void kaannaAsennon3Suorakulmio() {
        siirraRuutua(0, -1, -1);
        asetaRuudutEnsimmaisenMukaan();
    }
}
