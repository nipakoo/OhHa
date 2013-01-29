package tetris.palikat;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.Kentta;
import tetris.Ruutu;

public class PalikanLiikuttajaTest {
    Kentta kentta;
    List<Ruutu> ruudut;
    
    public PalikanLiikuttajaTest() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta();
        ruudut = new ArrayList<Ruutu>();
    }
    
    @Test
    public void liikkuuAlas() {
        ruudut.add(new Ruutu(kentta.getPalikka().getRuudut().get(0).getX(), kentta.getPalikka().getRuudut().get(0).getY() + 1));
        ruudut.add(new Ruutu(kentta.getPalikka().getRuudut().get(1).getX(), kentta.getPalikka().getRuudut().get(1).getY() + 1));
        ruudut.add(new Ruutu(kentta.getPalikka().getRuudut().get(2).getX(), kentta.getPalikka().getRuudut().get(2).getY() + 1));
        ruudut.add(new Ruutu(kentta.getPalikka().getRuudut().get(3).getX(), kentta.getPalikka().getRuudut().get(3).getY() + 1));
        
        kentta.liikuAlas();
        
        assertTrue(kentta.getPalikka().getRuudut().equals(ruudut));
    }
    
    @Test
    public void liikkuuVasemmalle() {
        int haluttuX = kentta.getPalikka().getRuudut().get(0).getX() - 1;
        if (haluttuX < 0) {
            haluttuX = 0;
        }
        
        kentta.liikuVasemmalle();
        
        assertEquals(kentta.getPalikka().getRuudut().get(0).getX(), haluttuX);
    }
    
    @Test
    public void liikkuuOikealle() {
        int haluttuX = kentta.getPalikka().getRuudut().get(3).getX() + 1;
        int maksimi = 9;
        
        if (kentta.getPalikka().getTyyppi() == 4) {
            maksimi = 8;
        }
        
        if (haluttuX > maksimi) {
            haluttuX = maksimi;
        }
        
        kentta.liikuOikealle();
        
        assertEquals(kentta.getPalikka().getRuudut().get(3).getX(), haluttuX);
    }
}
