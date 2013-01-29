package tetris;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
