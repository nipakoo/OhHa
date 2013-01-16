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
        
        palikanTyyppi = arpoja.nextInt(4);
        palikanAsento = 0;
        
        if (palikanTyyppi == 0) {
            ruudut = muodonLuoja.luoNelio(arpoja.nextInt(9));
            palikanKaantaja = null;
        } else if (palikanTyyppi == 1) {
            ruudut = muodonLuoja.luoSuorakulmio(arpoja.nextInt(7));
            palikanKaantaja = new SuorakulmionKaantaja(this);
        } else if (palikanTyyppi == 2) {
            ruudut = muodonLuoja.luoMutka(arpoja.nextInt(8));
            palikanKaantaja = new MutkanKaantaja(this);
        } else {
            ruudut = muodonLuoja.luoL(arpoja.nextInt(8));
            palikanKaantaja = new LKaantaja(this);
        }
        
        this.kentta.taytaRuudut(ruudut);
        
        palikanLiikuttaja = new PalikanLiikuttaja(this);
    }
    
    public Kentta getKentta() {
        return this.kentta;
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
    
    public void kaanna() {
        palikanKaantaja.kaanna();
        
        palikanAsento++;
        
        if (palikanAsento > 3) {
            palikanAsento = 0;
        }
    }
}
