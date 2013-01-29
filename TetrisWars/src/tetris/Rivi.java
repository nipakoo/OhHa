package tetris;

import java.util.ArrayList;
import java.util.List;

public class Rivi {
    private List<Ruutu> ruudut;
    private int y;
    
    public Rivi(int y) {
        ruudut = new ArrayList<Ruutu>();
        
        for (int i = 0; i < 10; i++) {
            ruudut.add(new Ruutu(i, y));
        }
        
        this.y = y;
    }
    
    public List<Ruutu> getRuudut() {
        return ruudut;
    }
}
