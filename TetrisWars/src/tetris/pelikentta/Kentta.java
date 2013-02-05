package tetris.pelikentta;

import java.util.ArrayList;
import java.util.List;
import tetris.palikat.PalikanLiikuttaja;
import tetris.palikat.Palikka;

public class Kentta {
    
    /**
     * Lista, joka sisältää kenttään kuuluvat rivit, näitä on aina 20 kappaletta.
     */
    private List<Rivi> rivit;
    
    /**
     * Liikuteltavaa palikkaa kuvaava Palikka-olio.
     */
    private Palikka palikka;
    
    /**
     * Rivit-listasta tuhottavan Rivi-olion indeksi, oletuksena arvona on -1, Peli-olio
     * muuttaa arvon, jos rivi on täynnä ja se on tuhottava.
     */
    private int tuhottavaRivi;
    
    public Kentta() {
        rivit = new ArrayList<Rivi>();
        
        for (int i = 0; i < 20; i++) {
            rivit.add(new Rivi(i));
        }
        
        palikka = new Palikka(this);
        tuhottavaRivi = -1;
    }
    
    public int getTuhottavaRivi() {
        return tuhottavaRivi;
    }
    
    public void setTuhottavaRivi(int uusiIndeksi) {
        tuhottavaRivi = uusiIndeksi;
    }
    
    public void uusiPalikka() {
        palikka = new Palikka(this);
    }
    
    public Palikka getPalikka() {
        return palikka;
    }
    
    public Ruutu getRuutu(int x, int y) {
        return rivit.get(y).getRuudut().get(x);
    }
    
    public void setRivi(Rivi rivi, int monesko) {
        rivit.set(monesko, rivi);
    }
    
    public List<Rivi> getRivit() {
        return rivit;
    }
    
    /**
     * Muuttaa syötteenä annettun listan Ruutu-olioiden attribuutin onkoTyhja
     * arvoksi totuusarvon false.
     * 
     * @param ruudut Syötteenä annettu lista
     * 
     * @see Ruutu#taytaRuutu()
     */
    public void taytaRuudut(List<Ruutu> ruudut) {
        for (Ruutu ruutu : ruudut) {
            ruutu.taytaRuutu();
        }
    }
    
    /**
     * Muuttaa syötteenä annetun listan Ruutu-olioiden attribuutin onkoTyhja arvoksi
     * totuusarvon true.
     * 
     * @param ruudut Syötteenä annettu lista
     * 
     * @see Ruutu#tyhjennaRuutu() 
     */
    public void tyhjennaRuudut(List<Ruutu> ruudut) {
        for (Ruutu ruutu : ruudut) {
            ruutu.tyhjennaRuutu();
        }
    }
    
    /**
     * Kaantaa Palikkaa myötäpäivään.
     * 
     * @see Palikka#kaanna() 
     */
    public void kaannaPalikkaa() {
        palikka.kaanna();
    }
    
    /**
     * Liikuttaa Palikka-oliota yhden ruudun alas päin.
     * 
     * @see PalikanLiikuttaja#liikuAlas() 
     */
    public void liikutaPalikkaaAlas() {
        palikka.getPalikanLiikuttaja().liikuAlas();
    }
    
    /**
     * Liikuttaa Palikka-oliota yhden ruudun vasemmalle päin.
     * 
     * @see PalikanLiikuttaja#liikuVasemmalle() 
     */
    public void liikutaPalikkaaVasemmalle() {
        palikka.getPalikanLiikuttaja().liikuVasemmalle();
    }
    
    /**
     * Liikuttaa Palikka-oliota yhden ruudun oikealle päin.
     * 
     * @see PalikanLiikuttaja#liikuOikealle() 
     */
    public void liikutaPalikkaaOikealle() {
        palikka.getPalikanLiikuttaja().liikuOikealle();
    }
    
    /**
     * Pudottaa palikan niin alas kuin mahdollista, eli joko alimmalle riville asti tai
     * niin kauan kuin tielle tulee täynnä oleva ruutu.
     */
    public void pudotaPalikka() {
        for (int i = 0; i < rivit.size(); i++) {
            liikutaPalikkaaAlas();
        }
    }
    
    /**
     * Kertoo osuisiko palikka seinään tai täyteen ruutun liikkuessaan yhden alas.
     * 
     * @see PalikanLiikuttaja#osuisikoSeinaanTaiPalikkaan(int, int, int) 
     * 
     * @return Palauttaa false, jos palikka ei osuisi seinään liikkuessaan alas, true
     * taas jos osuisi
     */
    public boolean pysahtyykoPalikka() {
        tyhjennaRuudut(palikka.getRuudut());
        
        for (int i = 0; i < palikka.getRuudut().size(); i++) {
            if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(i, 0, 1)) {
                taytaRuudut(palikka.getRuudut());
                return true;
            }
        }
        
        taytaRuudut(palikka.getRuudut());
        return false;
    }
}
