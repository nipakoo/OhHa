package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

public class SuorakulmionKaantaja extends PalikanKaantaja {
    
    public SuorakulmionKaantaja(Palikka palikka) {
        super(palikka);
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
        return kaannaSuorakulmio();
    }
    
    /**
     * Jos palikka on pystyasennossa käytetään ruutujen siirtämiseen vastalukuja,
     * jotta päästään takaisin vaaka-asentoon, tarkistetaan mahtuuko palikka kääntymään
     * ja siirretään ruutuja jos mahdutaan.
     * 
     * @return Palauttaa true, jos palikka osuisi seinään tai toiseen palikkaan ja false
     * jos kääntäminen onnistuu
     */
    public boolean kaannaSuorakulmio() {
        int mistaAsennosta = 1;
        
        if (palikka.getAsento() == 1 || palikka.getAsento() == 3) {
            mistaAsennosta = -1;
        }
        
        palikka.getKentta().tyhjennaRuudut(palikka.getRuudut());
        
        if (tarkistaOsuisikoSeinaanTaiPalikkaan(mistaAsennosta)) {
            return true;
        }
        
        siirraRuutua(0, mistaAsennosta * 1, mistaAsennosta * -1);
        siirraRuutua(2, mistaAsennosta * -1, mistaAsennosta * 1);
        siirraRuutua(3, mistaAsennosta * -2, mistaAsennosta * 2);
        
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
    public boolean tarkistaOsuisikoSeinaanTaiPalikkaan(int mistaAsennosta) {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, mistaAsennosta * 1, mistaAsennosta * -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, mistaAsennosta * -1, mistaAsennosta * 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, mistaAsennosta * -2, mistaAsennosta * 2)) {
            return true;
        }
        
        return false;
    }
}
