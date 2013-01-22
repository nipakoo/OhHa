/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palikat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Kentta;
import tetris.Ruutu;

/**
 *
 * @author albis
 */
public class PalikkaTest {
    private Palikka palikka;
    
    public PalikkaTest() {
    }    

    @Before
    public void setUp() {
        palikka = new Palikka(new Kentta());
    }

    @Test
    public void palikanAsentoAlussaNolla() {
        assertEquals(palikka.getAsento(), 0);
    }
    
    @Test
    public void palikanRuudutTaynna() {
        int apumuuttuja = 0;
        
        for (Ruutu ruutu : palikka.getRuudut()) {
            if (ruutu.onkoTyhja()) {
                apumuuttuja++;
            }
        }
        
        assertEquals(apumuuttuja, 0);
    }
    
    @Test
    public void palikkaEiKaannyJosEiMahdu() {
        palikka.kaanna();
        palikka.kaanna();
        
        int oikeaAsento;
        if (palikka.getTyyppi() == 0) {
            oikeaAsento = 2;
        } else {
            oikeaAsento = 0;
        }
        
        assertEquals(palikka.getAsento(), oikeaAsento);
    }
    
    @Test
    public void asentoMuuttuuKaantyessa() {
        palikka.liikuAlas();
        palikka.liikuAlas();
        palikka.liikuAlas();
        
        palikka.kaanna();
        palikka.kaanna();
        
        assertEquals(palikka.getAsento(), 2);
    }
}
