package tetris.palikat;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Ruutu;

public class MuodonLuojaTest {
    MuodonLuoja muodonLuoja;
    List<Ruutu> ruudut;
    
    public MuodonLuojaTest() {
    }
    
    @Before
    public void setUp() {
        muodonLuoja = new MuodonLuoja(new Palikka(new Kentta()));
        ruudut = new ArrayList<Ruutu>();
    }
    
    @Test
    public void korkeusAsettuuOikein() {
        assertEquals(muodonLuoja.luoNelio(5).get(0).getY(), 0);
    }
    
    @Test
    public void leveysAsettuuOikein() {
        assertEquals(muodonLuoja.luoNelio(5).get(0).getX(), 5);
    }
    
    @Test
    public void nelioMuodostuuOikein() {
        ruudut.add(new Ruutu(0, 0));
        ruudut.add(new Ruutu(0, 1));
        ruudut.add(new Ruutu(1, 0));
        ruudut.add(new Ruutu(1, 1));
        
        assertTrue(ruudut.equals(muodonLuoja.luoNelio(0)));
    }
    
    @Test
    public void suorakulmioMuodostuuOikein() {
        ruudut.add(new Ruutu(6, 0));
        ruudut.add(new Ruutu(7, 0));
        ruudut.add(new Ruutu(8, 0));
        ruudut.add(new Ruutu(9, 0));
        
        assertTrue(ruudut.equals(muodonLuoja.luoSuorakulmio(6)));
    }
    
    @Test
    public void mutkaMuodostuuOikein() {
        ruudut.add(new Ruutu(4, 0));
        ruudut.add(new Ruutu(5, 0));
        ruudut.add(new Ruutu(5, 1));
        ruudut.add(new Ruutu(6, 1));
        
        assertTrue(ruudut.equals(muodonLuoja.luoMutka(4)));
    }
    
    @Test
    public void LMuodostuuOikein() {
        ruudut.add(new Ruutu(7, 0));
        ruudut.add(new Ruutu(8, 0));
        ruudut.add(new Ruutu(9, 0));
        ruudut.add(new Ruutu(9, 1));
        
        assertTrue(ruudut.equals(muodonLuoja.luoL(7)));
    }
    
    @Test
    public void TMuodotuuOikein() {
        ruudut.add(new Ruutu(0, 0));
        ruudut.add(new Ruutu(1, 0));
        ruudut.add(new Ruutu(2, 0));
        ruudut.add(new Ruutu(1, 1));
        
        assertTrue(ruudut.equals(muodonLuoja.luoT(0)));
    }
}
