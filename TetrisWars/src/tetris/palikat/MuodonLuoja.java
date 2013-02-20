package tetris.palikat;

import java.util.ArrayList;
import java.util.List;
import tetris.pelikentta.Ruutu;

/**
 * Asettaa palikan ruudut haluttuihin kohtiin palikan tyypin mukaisen 
 * asennon perusteella
 * 
 * @author albis
 */
public class MuodonLuoja {
    /**
     * Lista Ruutu-olioita, johon lisätään halutut Ruutu-oliot.
     */
    private List<Ruutu> ruudut;
    
    /**
     * Palikka-olio, jolle ruudut palautetaan.
     */
    private Palikka palikka;
    
    /**
     * Jokaisen palikan ensimmäisen ruudun korkeussijainti alussa eli 0.
     */
    private int alkuY;
    
    public MuodonLuoja(Palikka palikka) {
        ruudut = new ArrayList<Ruutu>();
        this.palikka = palikka;
        
        alkuY = 0;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu neliö.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut
     * ruudut asetetaan.
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoNelio(int alkuX) {
        ruudut.add(palikka.getRuutu(alkuX, alkuY));
        ruudut.add(palikka.getRuutu(alkuX, alkuY + 1));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu suorakulmio.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut
     * ruudut asetetaan
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoSuorakulmio(int alkuX) {
        for (int i = 0; i < 4; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu mutka.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut
     * ruudut asetetaan
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoMutka(int alkuX) {
        ruudut.add(palikka.getRuutu(alkuX, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu toisinpäin oleva mutka-palikka.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut ruudut asetetaan
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoMutkaEriPain(int alkuX) {
        ruudut.add(palikka.getRuutu(alkuX, alkuY + 1));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY));
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY));
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu L.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut
     * ruudut asetetaan.
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoMahallaanOlevaL(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY + 1));
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu L, jonka sakara osoittaa oikealle ylös.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut ruudut asetetaan
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoSelallaanOlevaL(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY + 1));
        }
        
        ruudut.add(palikka.getRuutu(alkuX + 2, alkuY));
        
        return ruudut;
    }
    
    /**
     * Asettaa palikan ruudut niin, että muodostuu T.
     * 
     * @param alkuX Ensimmäisen ruudun leveyskoordinaatti, jonka mukaan muut
     * ruudut asetetaan.
     * 
     * @return Muodostettu lista ruutuja
     */
    public List<Ruutu> luoT(int alkuX) {
        for (int i = 0; i < 3; i++) {
            ruudut.add(palikka.getRuutu(alkuX + i, alkuY));
        }
        
        ruudut.add(palikka.getRuutu(alkuX + 1, alkuY + 1));
        
        return ruudut;
    }
}
