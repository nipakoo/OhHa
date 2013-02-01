package tetris.palikat.palikanKaantaja;

import tetris.palikat.Palikka;

public class SuorakulmionKaantaja extends PalikanKaantaja {
    
    public SuorakulmionKaantaja(Palikka palikka) {
        super(palikka);
    }
    
    @Override
    public boolean kaanna() {
        return kaannaSuorakulmio();
    }
    
    //jos palikka on pystyssä, käytetään siirtojen vastalukuja, jotta käännytään
    //toiseen suuntaan
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
