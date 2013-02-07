package tetris;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Pisteiden laskemisteta ja tallentamisesta huolehtiva luokka
 * 
 * @author albis
 */
public class Pistelaskenta {
    private int pisteet;
    
    public Pistelaskenta() throws IOException {
        pisteet = 0;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    public void kasvataPisteita() {
        pisteet += 15;
    }
    
    public void kirjaaPisteetYlos(String nimi) throws IOException {
        List<String> uusiPistetilasto = luePistetilasto();
        
        FileWriter tallentaja = new FileWriter("pistetilasto.txt");

        uusiPistetilasto.add(pisteet + " " + nimi);
        
        Collections.sort(uusiPistetilasto);
        
        for (int i = 0; i < uusiPistetilasto.size(); i++) {
            tallentaja.append("\n" + uusiPistetilasto.get(i));
        }
        
        tallentaja.close();
    }
    
    public List<String> luePistetilasto() throws FileNotFoundException {
        List<String> pistelista = new ArrayList<String>();
        
        File pistetilasto = new File("pistetilasto.txt");
        Scanner lukija = new Scanner(pistetilasto);
        
        while (lukija.hasNextLine()) {
            pistelista.add(lukija.nextLine());
        }
        
        lukija.close();
        
        return pistelista;
    }
    
    public String getTahanAstiParas() throws FileNotFoundException {
        List<String> pistetilasto = luePistetilasto();
        
        if (pistetilasto.isEmpty()) {
            return "Ei vielä tuloksia";
        }
        
        return pistetilasto.get(pistetilasto.size() - 1);
    }
}