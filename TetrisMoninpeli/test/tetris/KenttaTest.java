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
        
        assertEquals(kentta.getRivit().get(0).getRuudut().get(0).onkoTyhja(), false);
    }
}
