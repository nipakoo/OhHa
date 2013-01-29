package tetris;

import java.util.ArrayList;
import java.util.List;
import tetris.palikat.Palikka;

public class Kentta {
    private List<Rivi> rivit;
    private Palikka palikka;
    
    public Kentta() {
        rivit = new ArrayList<Rivi>();
        
        for (int i = 0; i < 20; i++) {
            rivit.add(new Rivi(i));
        }
        
        palikka = new Palikka(this);
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
    
    public void liikuAlas() {
        palikka.getPalikanLiikuttaja().liikuAlas();
    }
    
    public void liikuVasemmalle() {
        palikka.getPalikanLiikuttaja().liikuVasemmalle();
    }
    
    public void liikuOikealle() {
        palikka.getPalikanLiikuttaja().liikuOikealle();
    }
    
    public void pudotaPalikka() {
        for (int i = 0; i < rivit.size(); i++) {
            liikuAlas();
        }
    }
}
