package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

/**
* L-muotoisten palikoiden kääntymistä huolehtiva luokka.
*
* @author albis
*/
public class LKaantaja extends PalikanKaantaja{
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
    public boolean kaannaAsennon0L() {
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
    
    private void kaannaMahallaanOleva0AsennonL() {
        siirraRuutua(0, 2, -1);
        siirraRuutua(1, 1, 0);
        siirraRuutua(2, 0, 1);
        siirraRuutua(3, -1, 0);
    }
    
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
    public boolean kaannaAsennon1L() {
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
    
    private void kaannaMahallaanOlevaAsennon1L() {
        siirraRuutua(0, 0, 2);
        siirraRuutua(1, -1, 1);
        siirraRuutua(2, -2, 0);
        siirraRuutua(3, -1, -1);
    }
    
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
    public boolean kaannaAsennon2L() {
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
    
    private void kaannaMahallaanOleva2AsennonL() {
        siirraRuutua(0, -1, 0);
        siirraRuutua(1, 0, -1);
        siirraRuutua(2, 1, -2);
        siirraRuutua(3, 2, -1);
    }
    
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
    public boolean kaannaAsennon3L() {
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
    
    private void kaannaMahallaanOlevaAsennon3L() {
        siirraRuutua(0, -1, -1);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, 0, 2);
    }
    
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
    public boolean tarkistaOsuisikoAsennon0LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOleva0AsennonL();
        }
            
        return tarkistaSelallaanOleva0AsennonL();
    }
    
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
    public boolean tarkistaOsuisikoAsennon1LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOlevaAsennon1L();
        }
        
        return tarkistaSelallaanOlevaAsennon1L();
    }
    
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
    public boolean tarkistaOsuisikoAsennon2LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOleva2AsennonL();
        }
        
        return tarkistaSelallaanOleva2AsennonL();
    }
    
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
    public boolean tarkistaOsuisikoAsennon3LSeinaanTaiPalikkaan() {
        if (mahallaan) {
            return tarkistaMahallaanOlevaAsennon3L();
        }
        
        return tarkistaSelallaanOlevaAsennon3L();
    }
    
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