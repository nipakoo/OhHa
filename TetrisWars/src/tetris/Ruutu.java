package tetris;

public class Ruutu {
    private boolean onkoTyhja;
    private int x;
    private int y;
    
    public Ruutu(int x, int y) {
        onkoTyhja = true;
        
        this.x = x;
        this.y = y;
    }
    
    public void taytaRuutu() {
        onkoTyhja = false;
    }
    
    public void tyhjennaRuutu() {
        onkoTyhja = true;
    }
    
    public boolean onkoTyhja() {
        return onkoTyhja;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    @Override
    public boolean equals(Object verrattava) {
        Ruutu verrattavaRuutu = (Ruutu) verrattava;
        
        if (!verrattavaRuutu.getClass().equals(this.getClass())) {
            return false;
        }
        
        if (verrattavaRuutu.getX() != x) {
            return false;
        }
        
        if (verrattavaRuutu.getY() != y) {
            return false;
        }
        
        return true;
    }
}
