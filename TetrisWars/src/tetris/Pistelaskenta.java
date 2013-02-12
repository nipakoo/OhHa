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
    
    public Pistelaskenta() {
        pisteet = 0;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    public void kasvataPisteita() {
        pisteet += 15;
    }
    
    public void kirjaaPisteetYlos(String nimi) {
        List<String> uusiPistetilasto = luePistetilasto();
        
        FileWriter tallentaja = null;
        try {
            tallentaja = new FileWriter("pistetilasto.txt");
        } catch (IOException e) {
            System.out.println("Virhe FileWriteria luotaessa!");
        }
        
        if (tallentaja == null) {
            return;
        }

        uusiPistetilasto.add(pisteet + " " + nimi);
        
        Collections.sort(uusiPistetilasto);
        
        for (int i = 0; i < uusiPistetilasto.size(); i++) {
            try {
                tallentaja.append("\n" + uusiPistetilasto.get(i));
            } catch (IOException e) {
                System.out.println("Virhe pistetilastoa kirjoitettaessa!");
            }
        }
        
        try {
            tallentaja.close();
        } catch (IOException e) {
            System.out.println("Virhe FileWriteria sulkiessa!");
        }
    }
    
    public List<String> luePistetilasto() {
        List<String> pistelista = new ArrayList<String>();
        
        Scanner lukija = null;
        File pistetilasto = new File("pistetilasto.txt");
        
        try {
            lukija = new Scanner(pistetilasto);
        } catch (FileNotFoundException e) {
            System.out.println("Virhe tiedostoa luettaessa! Tiedostoa ei löytynyt.");
        }
        
        if (lukija == null) {
            return pistelista;
        }
            
        while (lukija.hasNextLine()) {
            pistelista.add(lukija.nextLine());
        }
        
        lukija.close();
        
        return pistelista;
    }
    
    public String getTahanAstiParas() {
        List<String> pistetilasto = luePistetilasto();
        
        if (pistetilasto.isEmpty()) {
            return "Ei vielä tuloksia";
        }
        
        return pistetilasto.get(pistetilasto.size() - 1);
    }
}