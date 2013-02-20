package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

/**
* L-muotoisten palikoiden kääntymistä huolehtiva luokka.
*
* @author albis
*/
public class LKaantaja extends PalikanKaantaja{
    
    /**
     * Kertoo kummin päin palikka on, jos true on alussa sakara alas päin.
     */
    private boolean mahallaan;
    
    public LKaantaja(Palikka palikka, boolean mahallaan) {
        super(palikka);
        this.mahallaan = mahallaan;
    }
    
    /**
* Ylikirjoittaa yliluokan kaanna-metodin kääntämällä palikkaa sen asennon
* edellyttämällä tavalla.
*
* @see PalikanKaantaja#kaanna()
*
* @return Palauttaa totuusarvon false jos kääntäminen mahdutaan suorittamaan
*/
    @Override
    public boolean kaanna() {
        palikka.getKentta().tyhjennaRuudut(palikka.getRuudut());
        
        if (palikka.getAsento() == 0) {
            return kaannaAsennon0L();
        } else if (palikka.getAsento() == 1) {
            return kaannaAsennon1L();
        } else if (palikka.getAsento() == 2) {
            return kaannaAsennon2L();
        } else {
            return kaannaAsennon3L();
        }
    }
    
    /**
* Tarkistaa mahtuuko asennossa 0 oleva L-palikka kääntymään ja siirtää palikan
* ruutuja jos mahtuu.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean kaannaAsennon0L() {
        if (tarkistaOsuisikoAsennon0LSeinaanTaiPalikkaan()) {
            return true;
        }
        if (mahallaan) {
            kaannaMahallaanOleva0AsennonL();
        } else {
            kaannaSelallaanOleva0AsennonL();
        }
        
        return false;
    }
    
    /**
     * Siirtaa ruutuja 0 asennon mahallaan olevan L-palikan edellyttämällä tavalla.
     */
    private void kaannaMahallaanOleva0AsennonL() {
        siirraRuutua(0, 2, -1);
        siirraRuutua(1, 1, 0);
        siirraRuutua(2, 0, 1);
        siirraRuutua(3, -1, 0);
    }
    
    /**
     * SIirtää ruutuja 0 asennon selallaan olevan L-palikan edellyttämällä tavalla.
     */
    private void kaannaSelallaanOleva0AsennonL() {
        siirraRuutua(0, 1, -2);
        siirraRuutua(1, 0, -1);
        siirraRuutua(2, -1, 0);
        siirraRuutua(3, 0, 1);
    }
    
    /**
* Tarkistaa mahtuuko asennossa 1 oleva L-palikka kääntymään ja siirtää palikan
* ruutuja jos mahtuu.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean kaannaAsennon1L() {
        if (tarkistaOsuisikoAsennon1LSeinaanTaiPalikkaan()) {
            return true;
        }
        
        if (mahallaan) {
            kaannaMahallaanOlevaAsennon1L();
        } else {
            kaannaSelallaanOlevaAsennon1L();
        }
        
        return false;
    }
    
    /**
     * Siirtää ruutuja 1-asennossa mahallaan olevan L-palikan käännöksen edellyttämällä tavalla.
     */
    private void kaannaMahallaanOlevaAsennon1L() {
        siirraRuutua(0, 0, 2);
        siirraRuutua(1, -1, 1);
        siirraRuutua(2, -2, 0);
        siirraRuutua(3, -1, -1);
    }
    
    /**
     * Siirtää ruutuja selällään olevan 1-asennossa olevan L-palikan käännöksen edellyttämällä tavalla.
     */
    private void kaannaSelallaanOlevaAsennon1L() {
        siirraRuutua(0, 1, 1);
        siirraRuutua(2, -1, -1);
        siirraRuutua(3, -2, 0);
    }
    
    /**
* Tarkistaa mahtuuko asennossa 2 oleva L-palikka kääntymään ja siirtää palikan
* ruutuja jos mahtuu.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean kaannaAsennon2L() {
        if (tarkistaOsuisikoAsennon2LSeinaanTaiPalikkaan()) {
            return true;
        }
        
        if (mahallaan) {
            kaannaMahallaanOleva2AsennonL();
        } else {
            kaannaSelallaanOleva2AsennonL();
        }
    
        return false;
    }
    
    /**
     * Siirtaa ruutuja mahallaan olevan 2-asennon palikan käännöksen edellyttämällä tavalla.
     */
    private void kaannaMahallaanOleva2AsennonL() {
        siirraRuutua(0, -1, 0);
        siirraRuutua(1, 0, -1);
        siirraRuutua(2, 1, -2);
        siirraRuutua(3, 2, -1);
    }
    
    /**
     * Siirtää ruutuja selallaan olevan 2-asennon palikan käännöksen edellyttällä tavalla.
     */
    private void kaannaSelallaanOleva2AsennonL() {
        siirraRuutua(0, -1, 1);
        siirraRuutua(2, 1, -1);
        siirraRuutua(3, 0, -2);
    }
    
    /**
* Tarkistaa mahtuuko asennossa 3 oleva L-palikka kääntymään ja siirtää palikan
* ruutuja jos mahtuu.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean kaannaAsennon3L() {
        if (tarkistaOsuisikoAsennon3LSeinaanTaiPalikkaan()) {
            return true;
        }
        
        if (mahallaan) {
            kaannaMahallaanOlevaAsennon3L();
        } else {
            kaannaSelallaanOlevaAsennon3L();
        }
    
        return false;
    }
    
    /**
     * Siirtää ruutuja mahallaan olevan 3-asennon palikan käännöksen edellyttämällä tavalla.
     */
    private void kaannaMahallaanOlevaAsennon3L() {
        siirraRuutua(0, -1, -1);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, 0, 2);
    }
    
    /**
     * Siirtää ruutuja selällään olevan 3-asennon palikan käännöksen edellyttämällä tavalla.
     */
    private void kaannaSelallaanOlevaAsennon3L() {
        siirraRuutua(0, -1, 0);
        siirraRuutua(1, 0, 1);
        siirraRuutua(2, 1, 2);
        siirraRuutua(3, 2, 1);
    }
    /**
* Tarkistaa voidaanko asennossa 0 oleva L-palikka kääntää.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean tarkistaOsuisikoAsennon0LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOleva0AsennonL();
        }
            
        return tarkistaSelallaanOleva0AsennonL();
    }
    
    /**
     * Tarkistaa mahallaan olevan 0-asennon palikan siirtojen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikoita tai seinä, false jos siirto on mahdollinen.
     */
    private boolean tarkistaMahallaanOleva0AsennonL() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 2, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, 1, 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 0, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, -1, 0)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa selällään olevan 0-asennon palikan siirtojen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiettä on palikoita tai seinä, false jos siirto on mahdollinen.
     */
    private boolean tarkistaSelallaanOleva0AsennonL() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 1, -2)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, 0, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, -1, 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 0, 1)) {
            return true;
        }

        return false;
    }
    /**
* Tarkistaa voidaanko asennossa 1 oleva L-palikka kääntää.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean tarkistaOsuisikoAsennon1LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOlevaAsennon1L();
        }
        
        return tarkistaSelallaanOlevaAsennon1L();
    }
    
    /**
     * Tarkistaa mahallaan olevan 1-asennon palikan käännön mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikoita tai seinä, false jos käännös on mahdollista tehdä
     */
    private boolean tarkistaMahallaanOlevaAsennon1L() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 0, 2)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, -1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, -2, 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, -1, -1)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa selällään olevan 1-asennon palikan käännöksen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikoita tai seinä, false, jos käännös on mahdollinen
     */
    private boolean tarkistaSelallaanOlevaAsennon1L() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, -1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, -2, 0)) {
            return true;
        }
        
        return false;
    }
    
    /**
* Tarkistaa voidaanko asennossa 2 oleva L-palikka kääntää.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean tarkistaOsuisikoAsennon2LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOleva2AsennonL();
        }
        
        return tarkistaSelallaanOleva2AsennonL();
    }
    
    /**
     * Tarkistaa mahallaan olevan 2-asennon palikan käännöksen mahdollisuuuden.
     * 
     * @return Palauttaa truem jos tiellä on palikoita tai seinä, false jos käännös voidaan tehdä. 
     */
    private boolean tarkistaMahallaanOleva2AsennonL() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, 0, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, -2)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 2, -1)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa selallaan olevan 2-asennon palikan käännöksen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikoita tai seinä, false jos siirto voidaan tehdä.
     */
    private boolean tarkistaSelallaanOleva2AsennonL() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 0, -2)) {
            return true;
        }
        
        return false;
    }
    
    /**
* Tarkistaa voidaanko asennossa 3 oleva L-palikka kääntää.
*
* @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
* jos käännös onnistuu
*/
    private boolean tarkistaOsuisikoAsennon3LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOlevaAsennon3L();
        }
        
        return tarkistaSelallaanOlevaAsennon3L();
    }
    
    /**
     * Tarkistaa mahallaan olevan 3-asennon palikan käännöksen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikoita tai seinä, false, jos käännös on mahdollinen
     */
    private boolean tarkistaMahallaanOlevaAsennon3L() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 0, 2)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa selällään olevan 3-asennon palikan käännöksen mahdollisuuden.
     * 
     * @return Palauttaa true, jos tiellä on palikka tai seinä, false jos käännös onnistuu
     */
    private boolean tarkistaSelallaanOlevaAsennon3L() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, 0)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(1, 0, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, 2)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 2, 1)) {
            return true;
        }
        
        return false;
    }
}