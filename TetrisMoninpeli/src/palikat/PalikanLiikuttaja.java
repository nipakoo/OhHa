/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat;

/**
 *
 * @author albis
 */
public class PalikanLiikuttaja {
    private Palikka palikka;
    
    public PalikanLiikuttaja(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public void liikutaPalikkaa(int x, int y) {
        for (int i = 0; i < palikka.getRuudut().size(); i++) {
            palikka.getRuudut().get(i).tyhjennaRuutu();
            palikka.getRuudut().set(i, palikka.getKentta().getRuutu
                    (palikka.getRuudut().get(i).getX() + x, palikka.getRuudut().get(i).getY() + y));
        }
        
        palikka.getKentta().taytaRuudut(palikka.getRuudut());
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
