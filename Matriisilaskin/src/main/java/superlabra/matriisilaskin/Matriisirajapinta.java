package superlabra.matriisilaskin;

/**
 * Matriisirajapinta määrittää ne ominaisuudet jotka ovat yhteisiä kaikille matriiseille.
 * Nämä ominaisuudet pitää löytyä kaikilta matriisiluokilta.
 * @author anna
 */
public interface Matriisirajapinta {
    int getLeveys();
    int getPituus();
    double[][] getMatriisi();
 
}
