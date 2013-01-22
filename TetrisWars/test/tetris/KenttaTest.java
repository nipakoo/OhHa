/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author albis
 */
public class KenttaTest {
    Kentta kentta;
    
    public KenttaTest() {
    }

    @Before
    public void setUp() {
        kentta = new Kentta();
    }
    
    @Test
    public void oikeaMaaraRiveja() {
        assertEquals(kentta.getRivit().size(), 20);
    }
    
    @Test
    public void ruutujenTayttoOnnistuu() {
        kentta.taytaRuudut(kentta.getRivit().get(0).getRuudut());
        
        assertFalse(kentta.getRivit().get(0).getRuudut().get(0).onkoTyhja());
    }
}
