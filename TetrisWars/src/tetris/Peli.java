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

    /**
     * Pisteiden ylös ottamisesta ja laskemisesta huolehtiva olio.
     */
    private Pistelaskenta pistelaskenta;
    
    private boolean pause;
    
    private String kayttajanNimi;
    
    public Peli() {
        kentta = new Kentta();
        aikaLiikkeidenValissa = 1000;
        pistelaskenta = new Pistelaskenta();
        pause = false;
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
    
    public void setKayttoliittyma(PeliKayttoliittyma kayttoLiittyma) {
        this.kayttoLiittyma = kayttoLiittyma;
    }
    
    public void pause() {
        pause = true;
    }
    
    public void jatka() {
        pause = false;
    }
    
    /**
     * Metodi, joka aloittaa tetrispelin ja käyttää sitä, kunnes palikka pysähtyy ylimmälle riville.
     */
    public void pelaaPeli() {
        while (true) {
            synchronized (this) {
                while (pause) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Virhe pausessa" + e.getMessage());
                    }
                }
                
            }
            try {
                Thread.sleep(aikaLiikkeidenValissa);
            } catch (InterruptedException e) {
                System.out.println("Virhe palikan liikkuessa alas!" + e.getMessage());
            }

            if (kentta.pysahtyykoPalikka()) {
                tuhoaTaydetRivit();
                
                if (kentta.getPalikka().getRuudut().get(0).getY() == 0 ||
                        kentta.getPalikka().getRuudut().get(3).getY() == 0) {
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
        kayttoLiittyma.setPistetilasto(pistelaskenta.luePistetilasto());
        
        kayttoLiittyma.kysyLopetetaanko();
    }
    
    private void nopeuta() {
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
    private void tuhoaTaydetRivit() {
        for (int i = 0; i < kentta.getRivit().size(); i++) {
            if (kentta.getRivit().get(i).tarkistaTuhoutuukoRivi()) {
                
                pistelaskenta.kasvataPisteita();
                suoritaTuhoamisAnimaatio(i);
                
                laskeYlemmatRivit(i);
            }
        }
        
        kentta.setTuhottavaRivi(-1); 
    }
    
    /**
     * Suorittaa rivin tuhoamisanimaation.
     * 
     * @param rivinSijainti kertoo mihin kohtaan kenttää tuhoamisanimaatio suoritetaan.
     */
    private void suoritaTuhoamisAnimaatio(int rivinSijainti) {
        kentta.setTuhottavaRivi(rivinSijainti);
        kayttoLiittyma.getPistePaneeli().paivita();
        kayttoLiittyma.getPiirtoalusta().repaint();
                
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Virhe rivin tuhoutumisanimaatiota esittäessä!" + e.getMessage());
        }
    }
    
    /**
     * Laskee tuhoutuneen rivin ylempiä rivejä yhden alas.
     * 
     * @param rivinSijainti kertoo mistä korkeudesta ylemmät rivit on laskettava.
     */
    private void laskeYlemmatRivit(int rivinSijainti) {
        kentta.tyhjennaRuudut(kentta.getRivit().get(rivinSijainti).getRuudut());
                
        for (int j = rivinSijainti; j >= 0; j--) {
            if (j == 0) {
                kentta.setRivi(new Rivi(j), 0);
            } else {
                kentta.setRivi(kentta.getRivit().get(j - 1), j);
                kentta.getRivit().get(j).laskeRiviaYksiAlas();
            }
        }
    }
}
