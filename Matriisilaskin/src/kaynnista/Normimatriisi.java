package kaynnista;

/**
 *
 * @author anna
 * Normimatriisin tehtävänä on suorittaa matriisin plus- ja miinuslaskut, matriisikertolasku ja transpoosit.
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class Normimatriisi implements Matriisirajapinta {
    private int leveys;
    private int pituus;
    private int [][] matriisi;

    public Normimatriisi(int leveys, int pituus, int[][] matriisi) {
        this.leveys = leveys;
        this.pituus = pituus;
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
    
    public int[][] getMatriisi() {
        return this.matriisi;
        
    }
    /**
     * Metodi laskee matriisin ja vakioluvun skalaaritulon.
     * @param kerroin kerroin
     * @return tulomatriisi
     */

    @Override
    public int[][] skalaaritulo(int kerroin) {
        
        for (int i = 0; i < this.pituus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                this.matriisi[i][j] = this.matriisi[i][j] * kerroin;
            }
        }
        
        return this.matriisi;
        
    }
    
    /**
     * matriisiensumma laskee kahden matriisin summan.
     * @param m2 summattava matriisi
     * @return summamatriisi
     */
    public int[][] matriisiensumma(Normimatriisi m2) {
        
        for (int i = 0; i < this.pituus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                this.matriisi[i][j] = this.matriisi[i][j] + m2.matriisi[i][j];
            }
        }
        
        return this.matriisi;
    
}
    /**
     * matriisienerotus laskee kahden matriisin erotuksen.
     * @param m2 vähennettävä matriisi
     * @return erotusmatriisi
     */
        public int[][] matriisienerotus(Normimatriisi m2) {
        
        for (int i = 0; i < this.pituus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                this.matriisi[i][j] = this.matriisi[i][j] - m2.matriisi[i][j];
            }
        }
        
        return this.matriisi;
    
}
    
}
