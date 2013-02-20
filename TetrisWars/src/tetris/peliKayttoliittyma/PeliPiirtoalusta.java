package tetris.peliKayttoliittyma;
    
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Rivi;
import tetris.pelikentta.Ruutu;

/**
 * Ruutujen piirtämisestä huolehtiva luokka.
 * 
 * @author albis
 */
public class PeliPiirtoalusta extends JPanel {
    private Kentta kentta;
    private int sivunPituus;
    
    public PeliPiirtoalusta(Kentta kentta, int sivunPituus) {
        super.setBackground(Color.black);
        this.kentta = kentta;
        this.sivunPituus = sivunPituus;
    }
    
    @Override
    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);

        for (Rivi rivi : kentta.getRivit()) {
            for (Ruutu ruutu : rivi.getRuudut()) {
                
                piirraRuutuJosTaysi(ruutu, grafiikka);
                piirraPalikka(ruutu, grafiikka);
                piirraTuhoamisAnimaatiot(grafiikka);
            }
        }
        
        grafiikka.setColor(Color.gray);
        grafiikka.draw3DRect(0, 0, sivunPituus * 10, sivunPituus * 20, true);
    }
    
    /**
     * Värittää ruudun, jos se on täysi.
     * 
     * @param ruutu käsiteltävänä oleva ruutu
     * @param grafiikka 
     */
    private void piirraRuutuJosTaysi(Ruutu ruutu, Graphics grafiikka) {
        if (!ruutu.onkoTyhja()) {
            grafiikka.setColor(Color.green);
            grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                sivunPituus, sivunPituus, true);
        }
    }
    
    /**
     * Värittää ruudun, jos sen kohdalla on palikka.
     * 
     * @param ruutu käsiteltävänä oleva ruutu
     * @param grafiikka 
     */
    private void piirraPalikka(Ruutu ruutu, Graphics grafiikka) {
        if (kentta.getPalikka().getRuudut().contains(ruutu) && kentta.getTuhottavaRivi() < 0) {
            grafiikka.setColor(Color.blue);
            grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                sivunPituus, sivunPituus, true);
        }
    }
    
    /**
     * Värittää rivin, jos se tuhoutuu eli sen kaikki ruudut ovat täysiä.
     * 
     * @param grafiikka 
     */
    private void piirraTuhoamisAnimaatiot(Graphics grafiikka) {
        if (kentta.getTuhottavaRivi() > -1) {
            grafiikka.setColor(Color.yellow);
            grafiikka.fill3DRect(0, kentta.getTuhottavaRivi() * sivunPituus,
                sivunPituus * 10, sivunPituus, true);
        }
    }
}
