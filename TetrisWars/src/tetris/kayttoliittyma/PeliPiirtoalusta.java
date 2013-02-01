package tetris.kayttoliittyma;
    
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Rivi;
import tetris.pelikentta.Ruutu;

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
                if (!ruutu.onkoTyhja()) {
                    grafiikka.setColor(Color.green);
                    grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                            sivunPituus, sivunPituus, true);
                }
                if (kentta.getPalikka().getRuudut().contains(ruutu)) {
                    grafiikka.setColor(Color.blue);
                    grafiikka.fill3DRect(sivunPituus * ruutu.getX(), sivunPituus * ruutu.getY(),
                            sivunPituus, sivunPituus, true);
                }
                if (kentta.tuhottavaRivi > -1) {
                    grafiikka.setColor(Color.yellow);
                    grafiikka.fill3DRect(0, kentta.tuhottavaRivi * sivunPituus,
                            sivunPituus * 10, sivunPituus, true);
                }
            }
        }
    }
}
