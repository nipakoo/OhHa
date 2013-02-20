package tetris.peliKayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.Peli;
import tetris.PisteTieto;

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
    
    /**
     * Käynnissä olevan pelin pistetilasto, tarvitaan jotta voidaan esittää piisteet sillä aikaa
     * kun peli odottaa.
     */
    private List<PisteTieto> pistetilasto;
    
    public PeliKayttoliittyma(Peli peli) {
        this.peli = peli;
        korkeus = Toolkit.getDefaultToolkit().getScreenSize().height - 100;
        pistetilasto = peli.getPistelaskenta().luePistetilasto();
    }
    
    @Override
    public void run() {
        frame = new JFrame("TetrisWars");
        
        Dimension koko = new Dimension(korkeus / 2 * 3, korkeus);
        
        frame.setPreferredSize(koko);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.setUndecorated(true);
        
        luoKomponentit();

        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Liittää pelin eri graafiset komponentit yhdeksi käyttöliittymäksi.
     * 
     * @throws FileNotFoundException 
     */
    private void luoKomponentit() {
        frame.setLayout(new GridLayout(1, 3));
        piirtoalusta = new PeliPiirtoalusta(peli.getKentta(), korkeus / 20);
        
        JPanel rata = piirtoalusta;
        rata.setPreferredSize(new Dimension(korkeus / 2, korkeus));
        
        frame.addKeyListener(new PeliNappaimistonKuuntelija(peli, this));
        
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
        //frame.removeKeyListener(frame.getKeyListeners()[0]);
        frame.setEnabled(false);
        String nimi = (String)JOptionPane.showInputDialog(frame, "Tuloksesi" +
                " " + peli.getPistelaskenta().getPisteet(),
                "Anna nimesi!", JOptionPane.PLAIN_MESSAGE);
        
        if (nimi != null) {
            peli.setNimi(nimi);
        }
    }
    
    /**
     * Pelin pausettava, sekä mahdollisuudet pelin lopettamiseen, sekä huipputulosten katselemiseen
     * tarjoava metodi.
     */
    public void kysyLopetetaanko() {
        peli.pause();
        
        Object[] vaihtoehdot = {"Lopeta peli", "Jatka peliä", "Tarkastele pistetilastoa"};
        
        int n = JOptionPane.showOptionDialog(frame, "Mitä tehdään?", "PAUSE",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                vaihtoehdot, null);
        
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (n == JOptionPane.CANCEL_OPTION) {
            naytaPistetilasto();
        } else {
            peli.jatka();
            synchronized(peli) {
                peli.notify();
            }
        }
    }
    
    /**
     * Käynnissä olevan pelin pistetilaston 10 parhaan tuloksen esitys.
     */
    public void naytaPistetilasto() {
        String pistetilastoMerkkijono = "";
        
        for (int i = pistetilasto.size() - 1; i >= 0; i--) {
            if (!pistetilasto.get(i).toString().isEmpty() && i > pistetilasto.size() - 11) {
                pistetilastoMerkkijono += pistetilasto.size() - i
                        + ". " + pistetilasto.get(i).toString() + "\n";
            }
        }
        
        JOptionPane.showMessageDialog(frame, pistetilastoMerkkijono);
        kysyLopetetaanko();
    }
    
    public void setPistetilasto(List<PisteTieto> uusiLista) {
        pistetilasto = uusiLista;
    }
}
