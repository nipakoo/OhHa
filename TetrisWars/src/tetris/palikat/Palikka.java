package tetris.palikat;

import java.util.List;
import java.util.Random;
import tetris.palikat.palikanKaantaja.LKaantaja;
import tetris.palikat.palikanKaantaja.MutkanKaantaja;
import tetris.palikat.palikanKaantaja.PalikanKaantaja;
import tetris.palikat.palikanKaantaja.SuorakulmionKaantaja;
import tetris.palikat.palikanKaantaja.TKaantaja;
import tetris.Kentta;
import tetris.Ruutu;

public  class Palikka {
    private Kentta kentta;
    private MuodonLuoja muodonLuoja;
    
    private Random arpoja = new Random();
    private List<Ruutu> ruudut;
    
    private int palikanTyyppi;
    private int palikanAsento;
    
    private PalikanLiikuttaja palikanLiikuttaja;
    private PalikanKaantaja palikanKaantaja;
    
    public Palikka(Kentta kentta) {
        this.kentta = kentta;
        muodonLuoja = new MuodonLuoja(this);
        
        palikanTyyppi = arpoja.nextInt(5);
        palikanAsento = 0;
        
        if (palikanTyyppi == 0) {
            ruudut = muodonLuoja.luoNelio(arpoja.nextInt(9));
            palikanKaantaja = new PalikanKaantaja(this);
        } else if (palikanTyyppi == 1) {
            ruudut = muodonLuoja.luoSuorakulmio(arpoja.nextInt(7));
            palikanKaantaja = new SuorakulmionKaantaja(this);
        } else if (palikanTyyppi == 2) {
            ruudut = muodonLuoja.luoMutka(arpoja.nextInt(8));
            palikanKaantaja = new MutkanKaantaja(this);
        } else if (palikanTyyppi == 3) {
            ruudut = muodonLuoja.luoL(arpoja.nextInt(8));
            palikanKaantaja = new LKaantaja(this);
        } else {
            ruudut = muodonLuoja.luoT(arpoja.nextInt(8));
            palikanKaantaja = new TKaantaja(this);
        }
        
        this.kentta.taytaRuudut(ruudut);
        
        palikanLiikuttaja = new PalikanLiikuttaja(this);
    }
    
    public Kentta getKentta() {
        return kentta;
    }
    
    public Ruutu getRuutu(int x, int y) {
        return kentta.getRuutu(x, y);
    }
    
    public List<Ruutu> getRuudut() {
        return ruudut;
    }
    
    public PalikanLiikuttaja getPalikanLiikuttaja() {
        return palikanLiikuttaja;
    }
    
    public int getAsento() {
        return palikanAsento;
    }
    
    public int getTyyppi() {
        return palikanTyyppi;
    }
    
    public void kaanna() {
        if (palikanKaantaja.kaanna()) {
            kentta.taytaRuudut(ruudut);
            return;
        }
        
        palikanAsento++;
        if (palikanAsento > 3) {
            palikanAsento = 0;
        }
        
        kentta.taytaRuudut(ruudut);  
    }
}
