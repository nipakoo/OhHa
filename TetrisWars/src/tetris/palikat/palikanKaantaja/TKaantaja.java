package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

public class TKaantaja extends PalikanKaantaja {
    
    public TKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public boolean kaanna() {
        palikka.getKentta().tyhjennaRuudut(palikka.getRuudut());
        
        if (palikka.getAsento() == 0) {
            return kaannaAsennon0T();
        } else if (palikka.getAsento() == 1) {
            return kaannaAsennon1T();
        } else if (palikka.getAsento() == 2) {
            return kaannaAsennon2T();
        } else {
            return kaannaAsennon3T();
        }
    }
    
    public boolean kaannaAsennon0T() {
        if (tarkistaOsuisikoAsennon0TSeinaanTaiPalikkaan()) {
            return true;
        }
        
        siirraRuutua(0, 1, -1);
        siirraRuutua(2, -1, 1);
        siirraRuutua(3, -1, -1);
        
        return false;
    }
    
    public boolean kaannaAsennon1T() {
        if (tarkistaOsuisikoAsennon0TSeinaanTaiPalikkaan()) {
            return true;
        }
        
        siirraRuutua(0, 1, 1);
        siirraRuutua(2, -1, -1);
        siirraRuutua(3, 1, -1);
    
        return false;
    }
    
    public boolean kaannaAsennon2T() {
        if (tarkistaOsuisikoAsennon2TSeinaanTaiPalikkaan()) {
            return true;
        }
        
        siirraRuutua(0, -1, 1);
        siirraRuutua(2, 1, -1);
        siirraRuutua(3, 1, 1);
        
        return false;
    }
    
    public boolean kaannaAsennon3T() {
        if (tarkistaOsuisikoAsennon3TSeinaanTaiPalikkaan()) {
            return true;
        }
        
        siirraRuutua(0, -1, -1);
        siirraRuutua(2, 1, 1);
        siirraRuutua(3, -1, 1);
        
        return false;
    }
    
    public boolean tarkistaOsuisikoAsennon0TSeinaanTaiPalikkaan() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, -1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, -1, -1)) {
            return true;
        }
        
        return false;
    }
    
    public boolean tarkistaOsuisikoAsennon1TSeinaanTaiPalikkaan() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, -1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 1, -1)) {
            return true;
        }
        
        return false;
    }
    
    public boolean tarkistaOsuisikoAsennon2TSeinaanTaiPalikkaan() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, 1, 1)) {
            return true;
        }
        
        return false;
    }
    
    public boolean tarkistaOsuisikoAsennon3TSeinaanTaiPalikkaan() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -1, -1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(2, 1, 1)) {
            return true;
        } else if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(3, -1, 1)) {
            return true;
        }
        
        return false;
    }
}