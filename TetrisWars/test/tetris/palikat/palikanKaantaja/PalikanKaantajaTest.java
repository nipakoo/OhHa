package tetris.palikat.palikanKaantaja;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.palikat.Palikka;
import tetris.pelikentta.Kentta;
import tetris.pelikentta.Ruutu;

public class PalikanKaantajaTest {
    private PalikanKaantaja kaantaja;
    private Palikka palikka;
    
    public PalikanKaantajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        palikka = new Palikka(new Kentta());
        kaantaja = new PalikanKaantaja(palikka);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ruudunSiirtoToimiiOikealle() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 2, 0)) {
            return;
        }
        
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(0).getX() + 2, 0);
        
        kaantaja.siirraRuutua(0, 2, 0);
        
        assertEquals(palikka.getRuudut().get(0), haluttuRuutu);
    }
    
    @Test
    public void ruudunSiirtoToimiiVasemmalle() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, -5, 0)) {
            return;
        }
        
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(0).getX() -5, 0);
        
        kaantaja.siirraRuutua(0, -5, 0);
        
        assertEquals(palikka.getRuudut().get(0), haluttuRuutu);
    }
    
    @Test
    public void ruudunSiirtoToimiiAlas() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 0, 3)) {
            return;
        }
        
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(0).getX(), 3);
        
        kaantaja.siirraRuutua(0, 0, 3);
        
        assertEquals(palikka.getRuudut().get(0), haluttuRuutu);
    }
    
    public void ruudunSiirtoToimiiSekaVasemmalleEttaOikealle() {
        if (palikka.getPalikanLiikuttaja().osuisikoSeinaanTaiPalikkaan(0, 4, 1)) {
            return;
        }
        
        Ruutu haluttuRuutu = new Ruutu(palikka.getRuudut().get(0).getX() + 4, 1);
        
        kaantaja.siirraRuutua(0, 4, 1);
        
        assertEquals(palikka.getRuudut().get(0), haluttuRuutu);
    }
    
}
