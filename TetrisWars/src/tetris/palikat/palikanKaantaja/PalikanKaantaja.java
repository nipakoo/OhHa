package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

/**
 * Eri tyyppisten kääntäjien yliluokka, ei ilmennetä muulloin kuin neliön
 * muotoisten palikoiden yhteydessä, sillä se ei käänny.
 * 
 * @author albis
 */
public class PalikanKaantaja {
    /**
     * Palikka-olio, jota kyseinen PalikanKaantaja kääntelee.
     */
    protected Palikka palikka;
    
    public PalikanKaantaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    /**
     * Siirtaa palikan annetussa parametrinä annetussa indeksissä olevaa ruutun
     * korkeus- ja leveyssijainteja annetut määrät.
     * 
     * @param monesko Mitä Palikka-olion ruudut-listan Ruutu-olioista siirretään
     * @param x Paljonko ruutua siirretään leveyssuunnassa
     * @param y Paljonko ruutua siirretään korkeussuunnassa
     */
    public void siirraRuutua(int monesko, int x, int y) {
        palikka.getPalikanLiikuttaja().siirraRuutua(monesko, x, y);
    }
    
    /**
     * Jos metodia ei ole ylikirjoitettu ei tee muuta kuin palauttaa totuusarvon.
     * 
     * @return Palauttaa false
     */
    public boolean kaanna() {
        return false;
    }
}
