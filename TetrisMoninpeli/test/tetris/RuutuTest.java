/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author albis
 */
public class RuutuTest {
    Ruutu ruutu;
    
    public RuutuTest() {
    }

    
    @Before
    public void setUp() {
        ruutu = new Ruutu(5, 10);
    }
    
    @Test
    public void konstruktoriAsettaaXOikein() {
        assertEquals(ruutu.getX(), 5);
    }
    
    @Test
    public void konstruktoriAsettaaYOikein() {
        assertEquals(ruutu.getY(), 10);  
    }
    
    @Test
    public void luotuRuutuOnTyhja() {
        assertEquals(ruutu.onkoTyhja(), true);
    }
    
    @Test
    public void tayttaminenOnnistuu() {
        ruutu.taytaRuutu();
        
        assertEquals(ruutu.onkoTyhja(), false);
    }
    
    @Test
    public void tyhjentaminenOnnistuu() {
        ruutu.taytaRuutu();
        ruutu.tyhjennaRuutu();
        
        assertEquals(ruutu.onkoTyhja(), true);
    }
    
    @Test
    public void equalsMetodiAntaaFalseOikein() {
        Ruutu verrattava = new Ruutu(5, 5);
        
        assertEquals(ruutu.equals(verrattava), false);
    }
}
