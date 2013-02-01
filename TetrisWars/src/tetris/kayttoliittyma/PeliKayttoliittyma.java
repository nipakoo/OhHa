package tetris.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.Peli;

public class PeliKayttoliittyma implements Runnable {
    private JFrame frame;
    private Peli peli;
    PeliPiirtoalusta piirtoalusta;
    private int leveys;
    
    public PeliKayttoliittyma(Peli peli) {
        this.peli = peli;
        leveys = 300;
    }
    
    @Override
    public void run() {
        frame = new JFrame("TetrisWars");
        
        frame.setPreferredSize(new Dimension(leveys, leveys * 2));
        //frame.setUndecorated(true);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        piirtoalusta = new PeliPiirtoalusta(peli.getKentta(), leveys / 10);
        
        frame.add(piirtoalusta);
        frame.addKeyListener(new PeliNappaimistonKuuntelija(peli.getKentta(), piirtoalusta));
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public PeliPiirtoalusta getPiirtoalusta() {
        return piirtoalusta;
    }
}
