package tetris.palikat;

import tetris.palikat.Palikka;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.Kentta;
import tetris.Ruutu;

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
}
