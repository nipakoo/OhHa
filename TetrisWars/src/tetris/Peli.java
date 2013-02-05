package tetris;

import tetris.kayttoliittyma.PeliPiirtoalusta;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Rivi;

public class Peli {
    
    /**
     * 10x20 kokoinen kenttä jossa peliä pelataan.
     */
    private Kentta kentta;
    
    /**
     * Palikoiden graafisesta piirtämisestä huolehtiva olio.
     */
    private PeliPiirtoalusta piirtoalusta;
    
    /**
     * Käytetään määrittämään palikan tippumisen nopeus.
     */
    private int aikaLiikkeidenValissa;
    
    /**
     * Kuinka paljon pisteitä on tähän mennessä saatu kerättyä.
     */
    private int pisteet;
    
    public Peli() {
        kentta = new Kentta();
        
        aikaLiikkeidenValissa = 1500;
        pisteet = 0;
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
                tuhoaTaydetRivit();
                
                if (kentta.getPalikka().getRuudut().get(0).getY() == 0) {
                    break;
                }
       
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
            aikaLiikkeidenValissa -= 10;
        }
    }
    
    /**
     * Tarkistaa onko yhdenkään rivin kaikki ruudut täysiä, jos on, kasvatetaan pisteitä,
     * asetetaan tuhottavan rivin indeksi, piirretään tuhoutumisanimaatio ja tuhotaan rivi,
     * sekä lasketaan ylempiä rivejä yksi alaspäin ja asetetaan tuhottavan rivin indeksiksi -1.
     * 
     * @throws Exception 
     */
    public void tuhoaTaydetRivit() throws Exception {
        for (int i = 0; i < kentta.getRivit().size(); i++) {
            if (kentta.getRivit().get(i).tarkistaTuhoutuukoRivi()) {
                
                pisteet += 10;
                kentta.setTuhottavaRivi(i);
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
        
        kentta.setTuhottavaRivi(-1); 
    }
}
