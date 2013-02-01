package tetris;

import tetris.kayttoliittyma.PeliPiirtoalusta;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Rivi;

public class Peli {
    private Kentta kentta;
    private PeliPiirtoalusta piirtoalusta;
    private int aikaLiikkeidenValissa;
    private int pisteet;
    
    public Peli() {
        kentta = new Kentta();
        aikaLiikkeidenValissa = 1500;
    }
    
    public Kentta getKentta() {
        return kentta;
    }
    
    public void setPiirtoalusta(PeliPiirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }
    
    public void pelaaPeli() throws Exception {
        while (true) {
            Thread.sleep(aikaLiikkeidenValissa);

            if (kentta.pysahtyykoPalikka()) {
                if (kentta.getPalikka().getRuudut().get(0).getY() == 0) {
                    break;
                }
                tuhoaTaydetRivit();
                kentta.uusiPalikka();
                nopeuta();
                
                piirtoalusta.repaint();
                continue;
            }
            
            kentta.liikutaPalikkaaAlas();
            
            piirtoalusta.repaint();
        }
    }
    
    public void nopeuta() {
        if (aikaLiikkeidenValissa > 500) {
            aikaLiikkeidenValissa -= 1;
        }
    }
    
    public void tuhoaTaydetRivit() throws Exception {
        for (int i = 0; i < kentta.getRivit().size(); i++) {
            if (kentta.getRivit().get(i).tarkistaTuhoutuukoRivi()) {
                
                kentta.tuhottavaRivi = i;
                piirtoalusta.repaint();
                Thread.sleep(500);
                
                kentta.tyhjennaRuudut(kentta.getRivit().get(i).getRuudut());
                
                for (int j = i; j >= 0; j--) {
                    if (j == 0) {
                        kentta.setRivi(new Rivi(j), 0);
                    } else {
                        kentta.setRivi(kentta.getRivit().get(j - 1), j);
                        kentta.getRivit().get(j).laskeRiviaYksiAlas();
                    }
                }
            }
        }
        
        kentta.tuhottavaRivi = -1; 
    }
}
