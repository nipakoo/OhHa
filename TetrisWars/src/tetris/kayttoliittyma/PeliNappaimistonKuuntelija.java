package tetris.kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.pelikentta.Kentta;

public class PeliNappaimistonKuuntelija implements KeyListener {
    private Kentta kentta;
    private Component component;
    
    public PeliNappaimistonKuuntelija(Kentta kentta, Component component) {
        this.kentta = kentta;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            kentta.kaannaPalikkaa();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            kentta.liikutaPalikkaaOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            kentta.liikutaPalikkaaVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            kentta.pudotaPalikka();
        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}