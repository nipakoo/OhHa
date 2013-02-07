package tetris.peliKayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.Peli;

/**
 * Pelin graafisen kokonaisuuden komponentit kokoava luokka.
 * 
 * @author albis
 */
public class PeliKayttoliittyma implements Runnable {
    private JFrame frame;
    
    /**
     * Peli-olio, jonka perusteella piirrettävät muodot määritetään.
     */
    private Peli peli;
    
    /**
     * Ruutujen graafisesta piirtämisestä huolehtiva luokka.
     */
    private PeliPiirtoalusta piirtoalusta;
    
    /**
     * Tämänhetkiset pisteet sekä ennätyspisteet ilmaiseva komponentti.
     */
    private PistePaneeli pisteet;
    
    /**
     * Kayttoliittyman korkeuden kertova attribuutti, jonka mukaan komponenttien
     * koot määritettään.
     */
    private int korkeus;
    
    public PeliKayttoliittyma(Peli peli) {
        this.peli = peli;
        korkeus = Toolkit.getDefaultToolkit().getScreenSize().height - 100;
    }
    
    @Override
    public void run() {
        frame = new JFrame("TetrisWars");
        
        Dimension koko = new Dimension(korkeus / 2 * 3, korkeus);
        
        frame.setPreferredSize(koko);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.setUndecorated(true);
        
        try {
            luoKomponentit();
        } catch (FileNotFoundException ex) {
        }
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Liittää pelin eri graafiset komponentit yhdeksi käyttöliittymäksi.
     * 
     * @throws FileNotFoundException 
     */
    private void luoKomponentit() throws FileNotFoundException {
        frame.setLayout(new GridLayout(1, 3));
        piirtoalusta = new PeliPiirtoalusta(peli.getKentta(), korkeus / 20);
        
        JPanel rata = piirtoalusta;
        rata.setPreferredSize(new Dimension(korkeus / 2, korkeus));
        
        frame.addKeyListener(new PeliNappaimistonKuuntelija(peli, piirtoalusta));
        
        pisteet = new PistePaneeli(korkeus, peli, 0);
        JPanel pistePaneeli = pisteet;
        
        JPanel ennatysPisteet = new PistePaneeli(korkeus, peli, 1);
        
        frame.add(pistePaneeli);
        frame.add(rata);
        frame.add(ennatysPisteet);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public PistePaneeli getPistePaneeli() {
        return pisteet;
    }
    
    public PeliPiirtoalusta getPiirtoalusta() {
        return piirtoalusta;
    }
    
    /**
     * Pelin loputtua suoritettava metodi, joka kysyy käyttäjän nimen
     * pisteiden tallentamista varten.
     */
    public void kysyNimi() {
        frame.removeKeyListener(frame.getKeyListeners()[0]);
        
        peli.setNimi((String)JOptionPane.showInputDialog(frame, "Tuloksesi" +
                " " + peli.getPistelaskenta().getPisteet(),
                "Anna nimesi!", JOptionPane.PLAIN_MESSAGE));
    }
}
