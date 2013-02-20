package tetris.pelikentta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    
    @Test
    public void ruutujenTyhjennysOnnistuu() {
        kentta.taytaRuudut(kentta.getRivit().get(19).getRuudut());
        kentta.tyhjennaRuudut(kentta.getRivit().get(19).getRuudut());
        
        assertTrue(kentta.getRivit().get(19).getRuudut().get(9).onkoTyhja());
    }
    
    @Test
    public void liikkuukoOikealle() {
        int haluttuX = 9;
        if (kentta.getPalikka().getTyyppi() == 6) {
            haluttuX = 8;
        }
        
        if (kentta.getPalikka().getRuudut().get(3).getX() + 3 < 9) {
            haluttuX = kentta.getPalikka().getRuudut().get(3).getX() + 3;
        }
        
        for (int i = 0; i < 3; i++) {
            kentta.liikutaPalikkaaOikealle();
        }
        
        assertEquals(haluttuX, kentta.getPalikka().getRuudut().get(3).getX());
    }
    
    @Test
    public void liikkuukoVasemmalle() {
        int haluttuX = 0;
        if (kentta.getPalikka().getRuudut().get(0).getX() - 3 > 0) {
            haluttuX = kentta.getPalikka().getRuudut().get(0).getX() - 3;
        }
        
        for (int i = 0; i < 3; i++) {
            kentta.liikutaPalikkaaVasemmalle();
        }
        
        assertEquals(haluttuX, kentta.getPalikka().getRuudut().get(0).getX());
    }
    
    @Test
    public void liikkuukoAlas() {
        int haluttuY = 0;
        if (kentta.getPalikka().getRuudut().get(0).getY() + 3 > 0) {
            haluttuY = kentta.getPalikka().getRuudut().get(0).getY() + 3;
        }
        
        for (int i = 0; i < 3; i++) {
            kentta.liikutaPalikkaaAlas();
        }
        
        assertEquals(haluttuY, kentta.getPalikka().getRuudut().get(0).getY());
    }
    
    @Test
    public void asentoMuuttuuKaantyessa() {
        if (kentta.getPalikka().getRuudut().get(0).getX() < 2) {
            kentta.liikutaPalikkaaOikealle();
        } else if (kentta.getPalikka().getRuudut().get(3).getX() > 7) {
            kentta.liikutaPalikkaaVasemmalle();
        }
        
        kentta.liikutaPalikkaaAlas();
        kentta.liikutaPalikkaaAlas();
        kentta.liikutaPalikkaaAlas();
        kentta.liikutaPalikkaaAlas();
        
        kentta.getPalikka().kaanna();
        kentta.getPalikka().kaanna();
        
        assertEquals(kentta.getPalikka().getAsento(), 2);
    }
    
    @Test
    public void pysahtyminenTodetaanOikein() {
        kentta.pudotaPalikka();
        
        assertTrue(kentta.pysahtyykoPalikka());
    }
}
