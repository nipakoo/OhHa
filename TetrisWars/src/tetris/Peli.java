package tetris;

import tetris.peliKayttoliittyma.PeliKayttoliittyma;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Rivi;

/**
 * Pelin aloittamisesta ja komponenttien hallitsemisesta huolehtiva luokka.
 * 
 * @author albis
 */
public class Peli {
    
    /**
     * 10x20 kokoinen kenttä jossa peliä pelataan.
     */
    private Kentta kentta;
    
    /**
     * Palikoiden graafisesta piirtämisestä huolehtiva olio.
     */
    private PeliKayttoliittyma kayttoLiittyma;
    
    /**
     * Käytetään määrittämään palikan tippumisen nopeus.
     */
    private int aikaLiikkeidenValissa;

    
    private Pistelaskenta pistelaskenta;
    
    private String kayttajanNimi;
    
    public Peli() throws Exception {
        kentta = new Kentta();
        aikaLiikkeidenValissa = 1000;
        pistelaskenta = new Pistelaskenta();
        kayttajanNimi = "";
    }
    
    public Kentta getKentta() {
        return kentta;
    }
    
    public void setNimi(String nimi) {
        kayttajanNimi = nimi;
    }
    
    public Pistelaskenta getPistelaskenta() {
        return pistelaskenta;
    }
    
    public void setPiirtoalusta(PeliKayttoliittyma kayttoLiittyma) {
        this.kayttoLiittyma = kayttoLiittyma;
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
                
                kayttoLiittyma.getPiirtoalusta().repaint();
                continue;
            }
            
            kentta.liikutaPalikkaaAlas();
            
            kayttoLiittyma.getPiirtoalusta().repaint();
        }
        
        kayttoLiittyma.kysyNimi();
        if (!kayttajanNimi.isEmpty()) {
            pistelaskenta.kirjaaPisteetYlos(kayttajanNimi);
        }
    }
    
    public void nopeuta() {
        if (aikaLiikkeidenValissa > 300) {
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
                
                pistelaskenta.kasvataPisteita();
                kentta.setTuhottavaRivi(i);
                kayttoLiittyma.getPistePaneeli().paivita();
                kayttoLiittyma.getPiirtoalusta().repaint();
                
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
