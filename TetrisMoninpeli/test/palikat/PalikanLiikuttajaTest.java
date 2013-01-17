/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.Kentta;
import tetris.Ruutu;

/**
 *
 * @author albis
 */
public class PalikanLiikuttajaTest {
    Palikka palikka;
    PalikanLiikuttaja palikanLiikuttaja;
    List<Ruutu> ruudut;
    
    public PalikanLiikuttajaTest() {
    }
    
    @Before
    public void setUp() {
        palikka = new Palikka(new Kentta());
        palikanLiikuttaja = new PalikanLiikuttaja(palikka);
        ruudut = new ArrayList<Ruutu>();
    }
    
    @Test
    public void liikkuuAlas() {
        ruudut.add(new Ruutu(palikka.getRuudut().get(0).getX(), palikka.getRuudut().get(0).getY() + 3));
        ruudut.add(new Ruutu(palikka.getRuudut().get(1).getX(), palikka.getRuudut().get(1).getY() + 3));
        ruudut.add(new Ruutu(palikka.getRuudut().get(2).getX(), palikka.getRuudut().get(2).getY() + 3));
        ruudut.add(new Ruutu(palikka.getRuudut().get(3).getX(), palikka.getRuudut().get(3).getY() + 3));
        
        palikanLiikuttaja.liikuAlas();
        palikanLiikuttaja.liikuAlas();
        palikanLiikuttaja.liikuAlas();
        
        assertEquals(palikka.getRuudut().equals(ruudut), true);
    }
    
    @Test
    public void liikkuuVasemmalle() {
        int haluttuX = 0;
        if (palikka.getRuudut().get(0).getX() - 1 > 0) {
            haluttuX = palikka.getRuudut().get(0).getX() - 1;
        }
        
        palikanLiikuttaja.liikuVasemmalle();
        
        assertEquals(palikka.getRuudut().get(0).getX(), haluttuX);
    }
    
    @Test
    public void liikkuuOikealle() {
        int haluttuX = 9;
        if (palikka.getRuudut().get(3).getX() + 1 < 9) {
            haluttuX = palikka.getRuudut().get(3).getX() + 1;
        }
        
        palikanLiikuttaja.liikuOikealle();
        
        assertEquals(palikka.getRuudut().get(3).getX(), haluttuX);
    }
    
    @Test
    public void eiLiikuUlosKentalta() {
        for (int i = 0; i < 199; i++) {
            palikanLiikuttaja.liikuVasemmalle();
        }
        
        assertEquals(palikka.getRuudut().get(0).getX(), 0);
    }
}
