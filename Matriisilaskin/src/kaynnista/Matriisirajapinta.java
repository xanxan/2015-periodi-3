package kaynnista;

/**
 *
 * @author anna
 * Matriisirajapinta määrittää ne ominaisuudet jotka ovat yhteisiä kaikille matriiseille.
 * getLeveys() palauttaa matriisin leveyden ja getPituus() pituuden.
 */
public interface Matriisirajapinta {
    
    int getLeveys();
    int getPituus();
    /**
     *
     * @param kerroin on vakio jolla matriisin alkiot kerrotaan.
     * @return kertoimen ja matriisin skalaaritulo.
     */
    int [][] skalaaritulo(int kerroin);
}
