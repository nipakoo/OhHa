/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author albis
 */
public class Ruutu {
    private boolean onkoTyhja;
    private int x;
    private int y;
    
    public Ruutu(int x, int y) {
        onkoTyhja = true;
        this.x = x;
        this.y = y;
    }
    
    public void taytaRuutu() {
        onkoTyhja = false;
    }
    
    public void tyhjennaRuutu() {
        onkoTyhja = true;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
