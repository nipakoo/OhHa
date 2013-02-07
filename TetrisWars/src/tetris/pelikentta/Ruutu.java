package tetris.pelikentta;

/**
 * Ilmentää pelin yksittäistä ruutua pitäen kirjaa sen sijainnista ja siitä,
 * onko kyseinen sijainti tyhjä vai täysi.
 * 
 * @author albis
 */
public class Ruutu {
    
    /**
     * Kertoo onko tämä ruutu tyhjä vai ei, jos tyhjä arvona true, jos täysi arvona
     * false.
     */
    private boolean onkoTyhja;
    
    /**
     * Kertoo tämän ruudun leveyssijainnin kentällä.
     */
    private int x;
    
    /**
     * Kertoo tämän ruudun korkeussijainnin kentällä.
     */
    private int y;
    
    public Ruutu(int x, int y) {
        onkoTyhja = true;
        
        this.x = x;
        this.y = y;
    }
    
    /**
     * Asettaa onkoTyhja attribuutin arvoksi false, eli täyttää ruudun.
     */
    public void taytaRuutu() {
        onkoTyhja = false;
    }
    
    /**
     * Asettaa onkoTyhja attribuutin arvoksi true, eli tyhjentää ruudun.
     */
    public void tyhjennaRuutu() {
        onkoTyhja = true;
    }
    
    /**
     * Kertoo onko tämä ruutu tyhjä vai täysi.
     * 
     * @return Palauttaa totuusarvoisen attribuutin onkoTyhja arvon
     */
    public boolean onkoTyhja() {
        return onkoTyhja;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
    
    /**
     * Vertaa parametrinä annettua oliota tähän ruutuun. 
     * 
     * @param verrattava Tähän ruutuun verrattava olio
     * 
     * @return Jos saatu parametri on luokkaa
     * Ruutu ja sen sijainti on sama kuin tällä, palautetaan true
     */
    @Override
    public boolean equals(Object verrattava) {
        Ruutu verrattavaRuutu = (Ruutu) verrattava;
        
        if (!verrattavaRuutu.getClass().equals(this.getClass())) {
            return false;
        }
        
        if (verrattavaRuutu.getX() != x) {
            return false;
        }
        
        if (verrattavaRuutu.getY() != y) {
            return false;
        }
        
        return true;
    }
}
