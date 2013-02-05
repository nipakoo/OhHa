package tetris.palikat.palikanKaantaja;

import sun.swing.plaf.synth.Paint9Painter;
import tetris.palikat.Palikka;

public class LKaantaja extends PalikanKaantaja{
    
    public LKaantaja(Palikka palikka) {
        super(palikka);
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
        
        siirraRuutua(0, 2, -1);
        siirraRuutua(1, 1, 0);
        siirraRuutua(2, 0, 1);
        siirraRuutua(3, -1, 0);
        
        return false;
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
        
        siirraRuutua(0, 0, 2);
        siirraRuutua(1, -1, 1);
        siirraRuutua(2, -2, 0);
        siirraRuutua(3, -1, -1);
        
        return false;
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
        
        siirraRuutua(0, -1, 0);
        siirraRuutua(1, 0, -1);
        siirraRuutua(2, 1, -2);
        siirraRuutua(3, 2, -1);
    
        return false;
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
        
        siirraRuutua(0, -1, -1);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, 0, 2);
    
        return false;
    }
    
    /**
     * Tarkistaa voidaanko asennossa 0 oleva L-palikka kääntää.
     * 
     * @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
     * jos käännös onnistuu
     */
    public boolean tarkistaOsuisikoAsennon0LSeinaanTaiPalikkaan() {
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
     * Tarkistaa voidaanko asennossa 1 oleva L-palikka kääntää.
     * 
     * @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
     * jos käännös onnistuu
     */
    public boolean tarkistaOsuisikoAsennon1LSeinaanTaiPalikkaan() {
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
     * Tarkistaa voidaanko asennossa 2 oleva L-palikka kääntää.
     * 
     * @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
     * jos käännös onnistuu
     */
    public boolean tarkistaOsuisikoAsennon2LSeinaanTaiPalikkaan() {
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
     * Tarkistaa voidaanko asennossa 3 oleva L-palikka kääntää.
     * 
     * @return Palauttaa true, jos palikka osuisi muihin ruutuihin tai seinään, false
     * jos käännös onnistuu
     */
    public boolean tarkistaOsuisikoAsennon3LSeinaanTaiPalikkaan() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 0, 2)) {
            return true;
        }
        
        return false;
    }
}
