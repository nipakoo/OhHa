package tetris.palikat.palikanKaantaja;

//aliluokissa copypastea, ongelma havaittu ja pyritään parantamaan
//tähän mennessä ei vain saatu vielä muuten toimimaan tulostuksena testattaessa

import tetris.palikat.Palikka;

public class PalikanKaantaja {
    protected Palikka palikka;
    
    public PalikanKaantaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public void siirraRuutua(int monesko, int x, int y) {
        palikka.getPalikanLiikuttaja().siirraRuutua(monesko, x, y);
    }
    
    //kaanna() palauttaa false aina kun tiellä ei ole mitään, eli kun
    //kääntäminen onnistuu
    
    public boolean kaanna() {
        return false;
    }
}
