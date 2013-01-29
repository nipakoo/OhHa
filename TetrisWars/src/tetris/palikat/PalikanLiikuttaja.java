package tetris.palikat;

import tetris.Ruutu;

public class PalikanLiikuttaja {

    private Palikka palikka;
    
    public PalikanLiikuttaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public void siirraRuutua(int monesko, int x, int y) {
        Ruutu uusiRuutu = palikka.getKentta().getRuutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y));
        
        palikka.getRuudut().set(monesko, uusiRuutu);
    }
    
    public boolean osuisikoSeinaanTaiPalikkaan(int monesko, int x, int y) {
        if (laskeUusiX(monesko, x) < 0 || laskeUusiX(monesko, x) > 9) {
            return true;
        }
        
        if (laskeUusiY(monesko, y) < 0 || laskeUusiY(monesko, y) > 19) {
            return true;
        }
        
        if (!palikka.getRuutu(laskeUusiX(monesko, x), laskeUusiY(monesko, y)).onkoTyhja()) {
            return true;
        }
        
        return false;
    }
    
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
    
    public int laskeUusiX(int monesko, int x) {
        return palikka.getRuudut().get(monesko).getX() + x;
    }
    
    public int laskeUusiY(int monesko, int y) {
        return palikka.getRuudut().get(monesko).getY() + y;
    }
    
    public void liikuAlas() {
        liikutaPalikkaa(0, 1);
    }
    
    public void liikuVasemmalle() {
        liikutaPalikkaa(-1, 0);
    }
    
    public void liikuOikealle() {
        liikutaPalikkaa(1, 0);
    }
}
