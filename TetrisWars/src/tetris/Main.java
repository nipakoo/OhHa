package tetris;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kentta kentta = new Kentta();
        
        while (true) {
            for (Rivi rivi : kentta.getRivit()) {
                System.out.println("");
                for (Ruutu ruutu : rivi.getRuudut()) {
                    if (!ruutu.onkoTyhja()) {
                        System.out.print("x");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            
            String komento = lukija.nextLine();
            
            if (komento.equals("d")) {
                kentta.liikuOikealle();
            } else if (komento.equals("a")) {
                kentta.liikuVasemmalle();
            } else if (komento.equals("s")) {
                kentta.liikuAlas();
            } else if (komento.equals("w")) {
                kentta.kaannaPalikkaa();
            } else if (komento.equals("x")) {
                kentta.pudotaPalikka();
            } else {
                break;
            }
        }
    }
}
