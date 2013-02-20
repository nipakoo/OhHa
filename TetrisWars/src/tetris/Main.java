package tetris;

import javax.swing.SwingUtilities;
import tetris.peliKayttoliittyma.PeliKayttoliittyma;

public class Main {
    
    public static void main(String[] args) throws Exception {
        while (true) {
            Peli peli = new Peli();
            PeliKayttoliittyma kayttoliittyma = new PeliKayttoliittyma(peli);
            SwingUtilities.invokeLater(kayttoliittyma);

            while (kayttoliittyma.getPiirtoalusta() == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Piirtoalustaa ei ole vielä luotu.");
                }
            }

            peli.setKayttoliittyma(kayttoliittyma);
            peli.pelaaPeli();
            kayttoliittyma.getFrame().dispose();
        }
    }    
}
