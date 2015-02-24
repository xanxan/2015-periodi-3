package superlabra.matriisilaskin;

import superlabra.matriisilaskin.Matriisirajapinta;

/**
 *
 * @author anna
 * Normimatriisin tehtävänä on suorittaa matriisin plus- ja miinuslaskut, matriisikertolasku ja transpoosit.
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class Matriisi implements Matriisirajapinta {
    
    private final double [][] matriisi;
    private String nimi;

    public Matriisi(double[][] matriisi) {
        this.nimi = "M";
        this.matriisi = matriisi;
    } 
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    @Override
    public int getLeveys() {
        return matriisi[0].length;
    }

    @Override
    public int getPituus() {
        return matriisi.length;
    }
    
    @Override
    public double[][] getMatriisi() {
        return this.matriisi;
        
    }
    
    public String getNimi() {
        return this.nimi;
    }
    /**
     * Metodi laskee matriisin ja vakioluvun skalaaritulon.
     * @param kerroin kerroin
     * @return tulomatriisi
     */

   
    public Matriisi skalaaritulo(double kerroin) {
        double[][] tulo = new double[this.getPituus()][this.getLeveys()];
        for (int i = 0; i < this.getPituus(); i++) {
            for (int j = 0; j < this.getLeveys(); j++) {
                tulo[i][j] = this.matriisi[i][j] * kerroin;
            }
        }
        
        return new Matriisi(tulo);
        
    }
    
    /**
     * matriisiensumma laskee kahden matriisin summan.
     * @param m2 summattava matriisi
     * @return summamatriisi
     */
    public Matriisi matriisiensumma(Matriisi m2) {
        double[][] summa = new double[this.getPituus()][this.getLeveys()];
        if (this.koontarkistus(m2)) {
             for (int i = 0; i < this.getPituus(); i++) {
                for (int j = 0; j < this.getLeveys(); j++) {
                    summa[i][j] = this.matriisi[i][j] + m2.matriisi[i][j];
                }
              }
        
             return new Matriisi(summa);
        } else {
            throw new IllegalArgumentException("Et voi summata erikokoisia matriiseja!");
        }
    }
    /**
     * matriisienerotus laskee kahden matriisin erotuksen.
     * @param m2 vähennettävä matriisi
     * @return erotusmatriisi
     */
    public Matriisi matriisienerotus(Matriisi m2) {
        double[][] erotus = new double[this.getPituus()][this.getLeveys()];
        if (this.koontarkistus(m2)) {
            for (int i = 0; i < this.getPituus(); i++) {
                for (int j = 0; j < this.getLeveys(); j++) {
                    erotus[i][j] = this.matriisi[i][j] - m2.matriisi[i][j];
                }
            }
            return new Matriisi(erotus);
        } else {
            throw new IllegalArgumentException("Et voi erottaa erikokoisia matriiseja!");
        }
    }
    /**
     * matriisitulo laskee kahden matriisin tulon.
     * apumuuttuja apu laskee kerrottujen solujen tulot yhteen.
     * @param m2 kerrottava matriisi
     * @return tulomatriisi
     */
    public Matriisi matriisitulo(Matriisi m2) {
        
        if (this.onkoKerrottavissa(m2)) {
           
            double[][] tulo = new double[this.getPituus()][m2.getLeveys()];
           
            for (int i = 0; i < this.getPituus(); i++) {
                for (int j = 0; j < m2.getLeveys(); j++) {
                    double apu = 0;
                    for (int k = 0; k < this.getLeveys(); k++) {
                        apu += this.matriisi[i][k]*m2.matriisi[k][j];
                    }
                    tulo[i][j] = apu;
                    
                  
                }
            } 
            return new Matriisi(tulo);
        } else {
            throw new IllegalArgumentException("Et voi kertoa vääränkokoisia matriiseja!");
        }
        
            
    }
    /**
     * onkokerrottavissa tarkistaa, että matriisien koot mahdollistavat matriisikertolaskun.
     * @param m2
     * @return boolean
     */
    public boolean onkoKerrottavissa(Matriisi m2) {
        
        return this.getLeveys() == m2.getPituus();
    }
    
    /**
     * koontarkistus varmistaa, että kaksi matriisia ovat samankokoiset (molemmat nxm).
     * @param m2 verrattava matriisi
     * @return true jos koot täsmäävät, muuten false.
     */
    public boolean koontarkistus(Matriisi m2) {
        
        return this.getLeveys() == m2.getLeveys() && this.getPituus() == m2.getPituus();
    }
    /**
     * onNelio() varmistaa, että matriisi on neliömatriisi (nxn).
     * @return true jos koot täsmäävät, muuten false.
     */
     public boolean onNelio() {
        return this.getPituus() == this.getLeveys();
    }
     
    /**
     * Transpoosi() laskee matriisin transpoosin.
     * @return matriisin transpoosi
     */
    
    public Matriisi transpoosi() {
        
        double[][] transpoosi = new double[this.getLeveys()][this.getPituus()];
        
        for (int i = 0; i < this.getLeveys(); i++) {
                for (int j = 0; j < this.getPituus(); j++) {
                    transpoosi[i][j] = this.getMatriisi()[j][i];
                }
        }
        
        return new Matriisi(transpoosi);
    }
    /**
    * toString() tulostaa matriisin. 
    */
    public String toString() {
        String matriisi = "";
        for (int i = 0; i < this.matriisi.length; i++) {
             matriisi += "[ ";
            for (int j = 0; j < this.matriisi[0].length; j++) {
                matriisi += this.matriisi[i][j] + " ";
            }
             matriisi += " ] \n";
        }
        
        return matriisi;
    }
}

