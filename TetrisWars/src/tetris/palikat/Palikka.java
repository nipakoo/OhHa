package tetris.palikat;

import java.util.List;
import java.util.Random;
import tetris.palikat.palikanKaantaja.LKaantaja;
import tetris.palikat.palikanKaantaja.MutkanKaantaja;
import tetris.palikat.palikanKaantaja.PalikanKaantaja;
import tetris.palikat.palikanKaantaja.SuorakulmionKaantaja;
import tetris.palikat.palikanKaantaja.TKaantaja;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Ruutu;

/**
 * Kuvaa käyttäjän liikuteltavana ja käänneltävänä olevaa palikkaa.
 * @author albis
 */
public  class Palikka {
    
    /**
     * Kentta-olio johon tämä palikka kuuluu.
     */
    private Kentta kentta;
    
    /**
     * Palikan käyttämä MuodonLuoja-olio, joka asettaa palikan ruudut
     * haluttuun muotoon.
     */
    private MuodonLuoja muodonLuoja;
    
    private Random arpoja = new Random();
    
    /**
     * Palikan sisältämät ruudut.
     */
    private List<Ruutu> ruudut;
    
    /**
     * Palikan tyypin lukuarvo: 0 = neliö, 1 = suorakulmio, 2 = mutka,
     * 3 = L, 4 = T.
     */
    private int palikanTyyppi;
    
    /**
     * Palikan asennon lukuarvo: 0 = vaakaan, ruudut vasemmalta oikealle,
     * 1 = pystyyn, ruudut ylhäältä alas, 2 = vaakaan, ruudut oikealta vasemmalle,
     * 3 = pystyyn, ruudut alhaalta ylös.
     */
    private int palikanAsento;
    
    /**
     * Palikan liikkumisesta huolehtiva olio.
     */
    private PalikanLiikuttaja palikanLiikuttaja;
    
    /**
     * Palikan kääntymisestä huolehtiva olio.
     */
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
    
    /**
     * Kääntää palikkaa, jos ei mahtunut kääntymään täytetään ruudut ja palataan,
     * jos mahtui kasvatetaan palikanAsento-attribuuttia yhdellä ja täytetään ruudut.
     */
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
