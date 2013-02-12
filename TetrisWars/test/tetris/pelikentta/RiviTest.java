package tetris.pelikentta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RiviTest {
    Rivi rivi;
    
    public RiviTest() {
    }
    
    @Before
    public void setUp() {
        rivi = new Rivi(5);
    }
    
    @Test
    public void oikeaMaaraRuutuja() {
        assertEquals(rivi.getRuudut().size(), 10);
    }
    
    @Test
    public void ruutujenKorkeusOikein() {
        assertEquals(rivi.getRuudut().get(5).getY(), 5);
    }
    
    @Test
    public void tuhoutuukoPalauttaaTrueOikein() {
        for (int i = 0; i < 10; i++) {
            rivi.getRuudut().get(i).taytaRuutu();
        }
        
        assertTrue(rivi.tarkistaTuhoutuukoRivi());
    }
    
    @Test
    public void tuhoutuukoPalauttaaFalseOikein() {
        for (int i = 1; i < 10; i++) {
            rivi.getRuudut().get(i).taytaRuutu();
        }
        
        assertFalse(rivi.tarkistaTuhoutuukoRivi());
    }
    
    @Test
    public void laskeeRivinKorkeuden() {
        rivi.laskeRiviaYksiAlas();
        rivi.laskeRiviaYksiAlas();
        
        assertEquals(rivi.getRuudut().get(5).getY(), 7);
    }
}
