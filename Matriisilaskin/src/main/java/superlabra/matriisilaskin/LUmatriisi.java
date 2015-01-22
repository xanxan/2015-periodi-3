package superlabra.matriisilaskin1;

/**
 * LUmatriisiluokan tehtävänä on laskea annetun matriisin determinantti ja käänteismatriisi LU-hajotelman avulla.
 * @author anna
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class LUmatriisi implements Matriisirajapinta {
    private int leveys;
    private int pituus;
    private int [][] matriisi;
    
    public LUmatriisi(int[][] matriisi) {
        this.leveys = matriisi[0].length;
        this.pituus = matriisi.length;
        this.matriisi = matriisi;
    }
    
    
     @Override
    public int getLeveys() {
        return this.leveys;
    }

    @Override
    public int getPituus() {
        return this.pituus;
    }
    
    /**
     * Metodi laskee matriisin ja vakioluvun skalaaritulon.
     * @param kerroin kerroin
     * @return tulomatriisi
     */

    @Override
    public int[][] skalaaritulo(int kerroin) {
        int[][] tulo = new int[this.pituus][this.leveys];
        for (int i = 0; i < this.pituus; i++) {
            for (int j = 0; j < this.leveys; j++) {
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
