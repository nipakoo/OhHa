/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat.palikanKaantaja;

import org.junit.Before;
import org.junit.Test;
import palikat.Palikka;
import static org.junit.Assert.*;
import tetris.Kentta;
import tetris.Ruutu;

/**
 *
 * @author albis
 */
public class PalikanKaantajaTest {
    Palikka palikka;
    PalikanKaantaja palikanKaantaja;
    
    public PalikanKaantajaTest() {
    }

    @Before
    public void setUp() {
        palikka = new Palikka(new Kentta());
        palikanKaantaja = new SuorakulmionKaantaja(palikka);
    }
    
    @Test
    public void ruutuSiirtyyOikeinAlas() {
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(2).getX(), palikka.getRuudut().get(2).getY() + 3);
        
        palikanKaantaja.siirraRuutua(2, 0, 3);
        
        assertTrue(haluttuRuutu.equals(palikka.getRuudut().get(2)));
    }
    
    @Test
    public void ruutuSiirtyyOikeinYlos() {
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(3).getX(), palikka.getRuudut().get(3).getY() + 5);
        
        palikanKaantaja.siirraRuutua(3, 0, 8);
        palikanKaantaja.siirraRuutua(3, 0, -3);
        
        assertTrue(haluttuRuutu.equals(palikka.getRuudut().get(3)));
    }
    
    @Test
    public void ruutuSiirtyyOikeinVasemmalle() {
        int haluttuX = palikka.getRuudut().get(2).getX() - 5;
        
        palikanKaantaja.siirraRuutua(2, -5, 0);
        
        assertEquals(haluttuX, palikka.getRuudut().get(2).getX());
    }
    
    @Test
    public void ruutuSiirtyyOikeinOikealle() {
        int haluttuX = palikka.getRuudut().get(1).getX() + 4;
        
        palikanKaantaja.siirraRuutua(1, 4, 0);
        
        assertEquals(haluttuX, palikka.getRuudut().get(1).getX());
    }
    
    @Test
    public void ruutuSiirtyyOikeinPystyynJaVaakaan() {
        int haluttuX = palikka.getRuudut().get(3).getX() + 3;
        int haluttuY = palikka.getRuudut().get(3).getY() - 2;
        
        Ruutu haluttuRuutu = new Ruutu(haluttuX, haluttuY);
        
        palikanKaantaja.siirraRuutua(3, 3, -2);
        
        assertTrue(haluttuRuutu.equals(palikka.getRuudut().get(3)));
    }
}
