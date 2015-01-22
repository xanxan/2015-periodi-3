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
        if (this.koontarkistus(m2)) {
             for (int i = 0; i < this.pituus; i++) {
                for (int j = 0; j < this.leveys; j++) {
                    this.matriisi[i][j] = this.matriisi[i][j] + m2.matriisi[i][j];
                }
              }
        
             return this.matriisi;
        } else {
            throw new IllegalArgumentException("Et voi summata erikokoisia matriiseja!");
        }
    }
    /**
     * matriisienerotus laskee kahden matriisin erotuksen.
     * @param m2 vähennettävä matriisi
     * @return erotusmatriisi
     */
    public int[][] matriisienerotus(Normimatriisi m2) {
        if (this.koontarkistus(m2)) {
            for (int i = 0; i < this.pituus; i++) {
                for (int j = 0; j < this.leveys; j++) {
                    this.matriisi[i][j] = this.matriisi[i][j] - m2.matriisi[i][j];
                }
            }
            return this.matriisi;
        } else {
            throw new IllegalArgumentException("Et voi erottaa erikokoisia matriiseja!");
        }
    }

    public int[][] matriisitulo(Normimatriisi m2) {
        int apu = 0;
        if (this.leveys == m2.pituus) {
           
            int[][] tulo = new int[this.pituus][m2.leveys];
           
            for (int i = 0; i < this.pituus; i++) {
                for (int j = 0; j < m2.leveys; j++) {
                    for (int k = 1; k <= this.leveys; k++) {
                        apu += this.matriisi[i][k]*m2.matriisi[k][j];
                    }
                    tulo[i][j] = apu;
                    apu = 0;
                  
                }
            } 
            return tulo;
        } else {
            throw new IllegalArgumentException("Et voi kertoa vääränkokoisia matriiseja!");
        }
        
            
    }
    
    
    public boolean koontarkistus(Normimatriisi m2) {
        
        if (this.leveys == m2.leveys && this.pituus == m2.pituus) {
            return true;
        }
        return false;
    }
}
