package tetris.kayttoliittyma;
    
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Kentta;
import tetris.Rivi;
import tetris.Ruutu;

public class Piirtoalusta extends JPanel {
    private Kentta kentta;
    private int sivunPituus;
    
    public Piirtoalusta(Kentta kentta, int sivunPituus) {
        super.setBackground(Color.black);
        this.kentta = kentta;
        this.sivunPituus = sivunPituus;
    }
    
    @Override
    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        
        for (Rivi rivi : kentta.getRivit()) {
            for (Ruutu ruutu : rivi.getRuudut()) {
                if (!ruutu.onkoTyhja()) {
                    grafiikka.setColor(Color.yellow);
                    grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                            sivunPituus, sivunPituus, true);
                } else if (kentta.getPalikka().getRuudut().contains(ruutu)) {
                    grafiikka.setColor(Color.blue);
                    grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                            sivunPituus, sivunPituus, true);
                }
            }
        }
    }
    
    public void piirraUudestaan() {
        repaint();
    }
}
