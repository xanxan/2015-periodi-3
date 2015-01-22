package kaynnista;

/**
 *
 * @author anna
 * Matriisirajapinta määrittää ne ominaisuudet jotka ovat yhteisiä kaikille matriiseille.
 * Nämä ominaisuudet pitää löytyä kaikilta matriisiluokilta.
 */
public interface Matriisirajapinta {
    
    int getLeveys();
    int getPituus();
    int[][] getMatriisi();
    /**
     *
     * @param kerroin on vakio jolla matriisin alkiot kerrotaan.
     * @return kertoimen ja matriisin skalaaritulo.
     */
    int [][] skalaaritulo(int kerroin);
}
