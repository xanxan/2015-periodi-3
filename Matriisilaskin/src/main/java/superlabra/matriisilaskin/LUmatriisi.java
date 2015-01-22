package superlabra.matriisilaskin;

/**
 * LUmatriisiluokan tehtävänä on laskea annetun matriisin determinantti ja käänteismatriisi LU-hajotelman avulla.
 * @author anna
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class LUmatriisi implements Matriisirajapinta {

    private int [][] matriisi;
    
    public LUmatriisi(int[][] matriisi) {
       
        this.matriisi = matriisi;
    }
    
    
     @Override
    public int getLeveys() {
        return this.matriisi[0].length;
    }

    @Override
    public int getPituus() {
        return this.matriisi.length;
    }
    
    /**
     * Metodi laskee matriisin ja vakioluvun skalaaritulon.
     * @param kerroin kerroin
     * @return tulomatriisi
     */

    @Override
    public int[][] skalaaritulo(int kerroin) {
        int[][] tulo = new int[this.getPituus()][this.getLeveys()];
        for (int i = 0; i < this.getPituus(); i++) {
            for (int j = 0; j < this.getLeveys(); j++) {
                tulo[i][j] = this.matriisi[i][j] * kerroin;
            }
        }
        
        return tulo;
        
        
        
    }

    @Override
    public int[][] getMatriisi() {
        return this.matriisi;
    }
}
