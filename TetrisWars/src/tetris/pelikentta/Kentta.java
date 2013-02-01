package tetris.pelikentta;

import java.util.ArrayList;
import java.util.List;
import tetris.palikat.Palikka;

public class Kentta {
    private List<Rivi> rivit;
    private Palikka palikka;
    public int tuhottavaRivi;
    
    public Kentta() {
        rivit = new ArrayList<Rivi>();
        
        for (int i = 0; i < 20; i++) {
            rivit.add(new Rivi(i));
        }
        
        palikka = new Palikka(this);
        tuhottavaRivi = -1;
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
    
    public void taytaRuudut(List<Ruutu> ruudut) {
        for (Ruutu ruutu : ruudut) {
            ruutu.taytaRuutu();
        }
    }
    
    public void tyhjennaRuudut(List<Ruutu> ruudut) {
        for (Ruutu ruutu : ruudut) {
            ruutu.tyhjennaRuutu();
        }
    }
    
    public void kaannaPalikkaa() {
        palikka.kaanna();
    }
    
    public void liikutaPalikkaaAlas() {
        palikka.getPalikanLiikuttaja().liikuAlas();
    }
    
    public void liikutaPalikkaaVasemmalle() {
        palikka.getPalikanLiikuttaja().liikuVasemmalle();
    }
    
    public void liikutaPalikkaaOikealle() {
        palikka.getPalikanLiikuttaja().liikuOikealle();
    }
    
    public void pudotaPalikka() {
        for (int i = 0; i < rivit.size(); i++) {
            liikutaPalikkaaAlas();
        }
    }
    
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
