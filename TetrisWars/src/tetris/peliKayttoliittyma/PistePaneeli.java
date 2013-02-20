package tetris.peliKayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tetris.Peli;

/**
 * Pistetilaston sekä tämän hetkisten pisteiden esittämisestä huolehtiva
 * komponentti.
 * @author albis
 */
public class PistePaneeli extends JPanel  {
    
    /**
     * Kayttoliittyman korkeus, jonka mukaan komponentin koko määritetään.
     */
    private int korkeus;
    
    /**
     * Käsiteltävänä oleva peli-olio, jonka kautta haetaan ilmoitettavat pisteet.
     */
    private Peli peli;
    private JLabel pisteet;
    
    public PistePaneeli(int korkeus, Peli peli, int vasenVaiOikeaPaneeli) {
        super.setBackground(Color.black);
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.korkeus = korkeus;
        this.peli = peli;
        
        if (vasenVaiOikeaPaneeli == 0) {
            pisteet = new JLabel("Pisteet: " + peli.getPistelaskenta().getPisteet());
        } else {
            pisteet = new JLabel("Ennatys: " + peli.getPistelaskenta().getTahanAstiParas());
        }
        setPreferredSize(new Dimension(korkeus / 2, korkeus));
        
        pisteet.setForeground(Color.red);
        pisteet.setFont(new Font("Sherif", Font.BOLD, korkeus / 2 / 15));
        
        add(pisteet);
    }
    
    /**
     * Pistemäärän päivittämisestä huolehtiva metodi, jota kutsutaan aina kun
     * pisteet kasvavat.
     */
    public void paivita() {
        pisteet.setText("Pisteet: " + peli.getPistelaskenta().getPisteet());
    }
}

