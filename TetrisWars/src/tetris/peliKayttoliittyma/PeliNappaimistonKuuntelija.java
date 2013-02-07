package tetris.peliKayttoliittyma;

import java.awt.Component;
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
    private Peli peli;
    private Component component;
    
    public PeliNappaimistonKuuntelija(Peli peli, Component component) {
        this.peli = peli;
        this.component = component;
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
        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}