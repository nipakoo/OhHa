/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat;

/**
 *
 * @author albis
 */
import java.util.List;
import java.util.Random;
import palikat.palikanKaantaja.LKaantaja;
import palikat.palikanKaantaja.MutkanKaantaja;
import palikat.palikanKaantaja.PalikanKaantaja;
import palikat.palikanKaantaja.SuorakulmionKaantaja;
import palikat.palikanKaantaja.TKaantaja;
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
    
    public void liikuAlas() {
        palikanLiikuttaja.liikuAlas();
    }
    
    public void liikuVasemmalle() {
        palikanLiikuttaja.liikuVasemmalle();
    }
    
    public void liikuOikealle() {
        palikanLiikuttaja.liikuOikealle();
    }
    
    public int getAsento() {
        return palikanAsento;
    }
    
    public int getTyyppi() {
        return palikanTyyppi;
    }
    
    public void kaanna() {
        kentta.tyhjennaRuudut(ruudut);
        
        palikanKaantaja.kaanna();
        
        for (Ruutu ruutu : ruudut) {
            if (!ruutu.onkoTyhja()) {
                takaisinEdelliseenAsentoon();              
                return;
            }
        }
        
        for (int i = 0; i < ruudut.size(); i++) {
            if (ruudut.get(i).getX() < 0 || ruudut.get(i).getX() > 9 ||
                    ruudut.get(i).getY() < 0 || ruudut.get(i).getY() > 19) {
                
                takaisinEdelliseenAsentoon();    
                return;
            }
        }
        
        kentta.taytaRuudut(ruudut);  
        palikanAsento++;
        
        if (palikanAsento > 3) {
            palikanAsento = 0;
        }
    }
    
    public void takaisinEdelliseenAsentoon() {
        for (int j = 0; j < 3; j++) {
                    palikanKaantaja.kaanna();
        }
        
        kentta.taytaRuudut(ruudut);
    }
}
