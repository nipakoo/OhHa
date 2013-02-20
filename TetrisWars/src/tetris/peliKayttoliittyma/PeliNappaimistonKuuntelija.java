package tetris.peliKayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Peli;

/**
 * Palikan liikkumiseen käytettävien näppäinkomentojen vastaanottamisesta huolehtiva
 * luokka.
 * 
 * @author albis
 */
public class PeliNappaimistonKuuntelija implements KeyListener {
    
    /**
     * Peli-olio, joka suorittaa toiminnot kun määritettyjä näppäimiä painetaan.
     */
    private Peli peli;
    private PeliKayttoliittyma kayttoliittyma;
    
    public PeliNappaimistonKuuntelija(Peli peli, PeliKayttoliittyma kayttoliittyma) {
        this.peli = peli;
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            peli.getKentta().kaannaPalikkaa();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            peli.getKentta().liikutaPalikkaaOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            peli.getKentta().liikutaPalikkaaVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            peli.getKentta().pudotaPalikka();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            kayttoliittyma.kysyLopetetaanko();
        }
        
        kayttoliittyma.getPiirtoalusta().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}