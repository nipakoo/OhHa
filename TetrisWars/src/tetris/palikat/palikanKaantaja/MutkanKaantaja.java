package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

/**
 * Mutka-muotoisten palikoiden kääntämisestä huolehtiva luokka.
 * 
 * @author albis
 */
public class MutkanKaantaja extends PalikanKaantaja {
    /**
     * Arvona joko -1 tai 1 riippuen kummin päin palikka on, käytetään muuttamaan siirtojen
     * arvoja vastaluvuiksi, jos tarpeen.
     */
    private int kumminPain;
    
    public MutkanKaantaja(Palikka palikka, int kumminPain) {
        super(palikka);
        this.kumminPain = kumminPain;
    }
    
    /**
     * Ylikirjoittaa yliluokan kaanna-metodin kääntämällä palikkaa sen asennon edellyttämällä
     * tavalla.
     * 
     * @see PalikanKaantaja#kaanna() 
     * 
     * @return Palauttaa totuusarvon false jos kääntäminen mahdutaan suorittamaan
     */
    @Override
    public boolean kaanna() {
        return kaannaMutka();
    }
    
    /**
     * Jos palikka on pystyasennossa käytetään ruutujen siirtämiseen vastalukuja,
     * jotta päästään takaisin vaaka-asentoon, tarkistetaan mahtuuko palikka kääntymään
     * ja siirretään ruutuja jos mahdutaan.
     * 
     * @return Palauttaa true, jos palikka osuisi seinään tai toiseen palikkaan ja false
     * jos kääntäminen onnistuu
     */
    private boolean kaannaMutka() {
        int mistaAsennosta = 1;
        
        if (palikka.getAsento() == 1 || palikka.getAsento() == 3) {
            mistaAsennosta = -1;
        }
        
        palikka.getKentta().tyhjennaRuudut(palikka.getRuudut());
        
        if (tarkistaOsuisikoSeinaanTaiPalikkaan(mistaAsennosta)) {
            return true;
        }
        
        siirraRuutua(0, mistaAsennosta * 2, mistaAsennosta * -1 * kumminPain);
        siirraRuutua(1, mistaAsennosta * 1, mistaAsennosta * 0);
        siirraRuutua(2, mistaAsennosta * 0, mistaAsennosta * -1 * kumminPain);
        siirraRuutua(3, mistaAsennosta * -1, mistaAsennosta * 0);
        
        return false;
    }
    
    /**
     * Tarkistetaan voidaanko palikkaa kääntää.
     * 
     * @param mistaAsennosta Jos palikka on pystyssä käytetään vaaka-asennosta kääntämisen
     * vastalukuja
     * 
     * @return Jos palikan tiellä on täysiä ruutuja tai seinä palautetaan true, muuten false
     */
    private boolean tarkistaOsuisikoSeinaanTaiPalikkaan(int mistaAsennosta) {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, mistaAsennosta * 2, mistaAsennosta * -1 * kumminPain)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, mistaAsennosta * 1, mistaAsennosta * 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, mistaAsennosta * 0, mistaAsennosta * -1 * kumminPain)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, mistaAsennosta * -1, mistaAsennosta * 0)) {
            return true;
        }
        
        return false;
    }
}
