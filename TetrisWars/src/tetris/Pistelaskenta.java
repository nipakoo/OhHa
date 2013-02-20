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
    
    /**
     * Pelin pisteet reaaliajassa, joita kasvatetaan Peli-luokasta käsin aina, kun
     * rivi tuhoutuu.
     */
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
    
    /**
     * Kirjaa pistelistaan uuden tuloksen.
     * 
     * @param nimi pelaajan syöttämä nimi, jolla pisteet tallennetaan. 
     */
    public void kirjaaPisteetYlos(String nimi) {
        List<PisteTieto> uusiPistetilasto = luePistetilasto();
        
        FileWriter tallentaja = null;
        try {
            tallentaja = new FileWriter("pistetilasto.txt");
        } catch (IOException e) {
            System.out.println("Virhe FileWriteria luotaessa!" + e.getMessage());
        }
        
        if (tallentaja == null) {
            return;
        }

        uusiPistetilasto.add(new PisteTieto(pisteet, nimi));
        
        Collections.sort(uusiPistetilasto);
        
        for (int i = 0; i < uusiPistetilasto.size(); i++) {
            try {
                tallentaja.append("\n" + uusiPistetilasto.get(i));
            } catch (IOException e) {
                System.out.println("Virhe pistetilastoa kirjoitettaessa!" + e.getMessage());
            }
        }
        
        try {
            tallentaja.close();
        } catch (IOException e) {
            System.out.println("Virhe FileWriteria sulkiessa!" + e.getMessage());
        }
    }
    
    /**
     * Lukee olemassaolevat pistetiedot.
     * 
     * @return Palauttaa listan pistetiedoista.
     */
    public List<PisteTieto> luePistetilasto() {
        List<PisteTieto> pistelista = new ArrayList<PisteTieto>();
        
        Scanner lukija = null;
        File pistetilasto = new File("pistetilasto.txt");
        
        try {
            lukija = new Scanner(pistetilasto);
        } catch (FileNotFoundException e) {
            System.out.println("Virhe tiedostoa luettaessa! Tiedostoa ei löytynyt." + e.getMessage());
        }
        
        if (lukija == null) {
            return pistelista;
        }
            
        while (lukija.hasNextLine()) {
            String lisattava = lukija.nextLine();
            String[] lisattavat = lisattava.split(" ");
            if (!lisattava.isEmpty()) {
                pistelista.add(new PisteTieto(Integer.parseInt(lisattavat[0]), lisattavat[1]));
            }
        }
        
        lukija.close();
        
        return pistelista;
    }
    
    /**
     * Haetaan suurimmat pisteet omaava tulos.
     * 
     * @return Palauttaa parhaan pistetiedon merkkijonoesityksen
     */
    public String getTahanAstiParas() {
        List<PisteTieto> pistetilasto = luePistetilasto();
        
        if (pistetilasto.isEmpty()) {
            return "Ei vielä tuloksia";
        }
        
        return pistetilasto.get(pistetilasto.size() - 1).toString();
    }
}