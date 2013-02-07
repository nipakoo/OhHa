package tetris.palikat;

import tetris.pelikentta.Ruutu;

/**
 * Liikuttelee palikkaa, sekä tarjoaa metodit ruutujen siirtämiseen ja
 * tarkistamiseen onko siirto mahdollinen.
 * 
 * @author albis
 */
public class PalikanLiikuttaja {

    /**
     * Liikuteltavana oleva palikka.
     */
    private Palikka palikka;
    
    public PalikanLiikuttaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    /**
     * Hakee uuden ruudun sijainnin ja asettaa sen halutulle paikalle palikkaa.
     * 
     * @param monesko Monenteenko palikan ruudut listan paikkaan uusi ruutu asetetaan
     * @param x Kuinka paljon ruutua siirretään leveyssuunnassa
     * @param y Kuinka paljon ruutua siirretään korkeussuunnassa
     */
    public void siirraRuutua(int monesko, int x, int y) {
        Ruutu uusiRuutu = palikka.getKentta().getRuutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y));
        
        palikka.getRuudut().set(monesko, uusiRuutu);
    }
    
    /**
     * Tarkastaa onko uusi ruutu kentän sisällä ja onko se täynnä.
     * 
     * @param monesko Monettako ruutua halutaan siirtää
     * @param x Kuinka paljon ruutua siirretään leveyssuunnassa
     * @param y Kuinka paljon ruutua siirretään korkeussuunnassa
     * 
     * @return Palauttaa true jos ruutu osuisi seinään tai täyteen ruutuun, false jos
     * siirtäminen on mahdollista
     */
    public boolean osuisikoSeinaanTaiPalikkaan(int monesko, int x, int y) {
        if (laskeUusiX(monesko, x) < 0 || laskeUusiX(monesko, x) > 9) {
            return true;
        } else if (laskeUusiY(monesko, y) < 0 || laskeUusiY(monesko, y) > 19) {
            return true;
        } else if (!palikka.getRuutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y)).onkoTyhja()) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Liikuttaa attribuuttina olevan palikan kaikkia ruutuja halutun määrän
     * 
     * @param x Kuinka paljon palikkaa halutaan siirtää leveyssuunnassa
     * @param y Kuinka paljon palikkaa halutaan siirtää korkeussuunnassa
     */
    public void liikutaPalikkaa(int x, int y) {
        palikka.getKentta().tyhjennaRuudut(palikka.getRuudut());
        
        for (int j = 0; j < palikka.getRuudut().size(); j++) {
            if (osuisikoSeinaanTaiPalikkaan(j, x, y)) {
                palikka.getKentta().taytaRuudut(palikka.getRuudut());
                return;
            }
        }
        
        for (int i = 0; i < palikka.getRuudut().size(); i++) {
            siirraRuutua(i, x, y);
        }
        
        palikka.getKentta().taytaRuudut(palikka.getRuudut());
    }
    
    /**
     * Laskee ruudun uuden leveyssijainnin halutun sivuttaissuunnassa tapahtuvan
     * siirron tapauksessa.
     * 
     * @param monesko Monettako palikan ruutua halutaan siirtää
     * @param x Paljonko ruutua halutaan siirtää leveyssuunnassa
     * 
     * @return Palauttaa uuden leveyssijainnin
     */
    public int laskeUusiX(int monesko, int x) {
        return palikka.getRuudut().get(monesko).getX() + x;
    }
    
    /**
     * Laskee ruudun uuden korkeussijainnin halutun korkeussuunnassa tapahtuvan
     * siirron tapauksessa.
     * 
     * @param monesko Monettako palikan ruutua halutaan siirtää
     * @param x Paljonko ruutua halutaan siirtää korkeussuunnassa
     * 
     * @return Palauttaa uuden korkeussijainnin
     */
    public int laskeUusiY(int monesko, int y) {
        return palikka.getRuudut().get(monesko).getY() + y;
    }
    
    /**
     * Liikuttaa kaikkia attribuuttina olevan Palikka-olion ruutuja yhden alaspäin,
     * eli kasvattaa korkeussijaintia.
     */
    public void liikuAlas() {
        liikutaPalikkaa(0, 1);
    }
    
    /**
     * Liikuttaa kaikkia attribuuttina olevan Palikka-olion ruutuja yhden vasemmalle,
     * eli pienentää niiden leveyssijaintia.
     */
    public void liikuVasemmalle() {
        liikutaPalikkaa(-1, 0);
    }
    
    /**
     * Liikuttaa kaikkia attribuuttina olevan Palikka-olion ruutuja yhden oikealle,
     * eli kasvattaa niiden leveyssijaintia.
     */
    public void liikuOikealle() {
        liikutaPalikkaa(1, 0);
    }
}
