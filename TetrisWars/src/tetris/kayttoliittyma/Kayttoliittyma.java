/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.Kentta;

/**
 *
 * @author albis
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Kentta kentta;
    
    public Kayttoliittyma() {   
    }
    
    @Override
    public void run() {
        frame = new JFrame("TetrisWars");
        kentta = new Kentta();
        
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        int leveys = 200;
        JPanel rata = new JPanel();
        rata.setSize(leveys, leveys * 2);
        
        rata.add(new Piirtoalusta(kentta, leveys / 10));
        
        container.add(rata, BorderLayout.CENTER);
    }
    
    public void piirraUudelleen() {
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
