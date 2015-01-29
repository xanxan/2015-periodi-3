package superlabra.matriisilaskin;

/**
 * LUmatriisiluokan tehtävänä on laskea annetun matriisin determinantti ja käänteismatriisi LU-hajotelman avulla.
 * @author anna
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class LUmatriisi implements Matriisirajapinta {

    private double [][] matriisi;
    
    public LUmatriisi(double[][] matriisi) {
       
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
    public double[][] skalaaritulo(int kerroin) {
        double[][] tulo = new double[this.getPituus()][this.getLeveys()];
        for (int i = 0; i < this.getPituus(); i++) {
            for (int j = 0; j < this.getLeveys(); j++) {
                tulo[i][j] = this.matriisi[i][j] * kerroin;
            }
        }
        
        return tulo;
       
    }

     /**
     * koontarkistus varmistaa, että kaksi matriisia ovat samankokoiset (molemmat nxm).
     * @param m2 verrattava matriisi
     * @return true jos koot täsmäävät, muuten false.
     */
    public boolean koontarkistus() {
        
        if (this.getLeveys() == this.getPituus()) {
            return true;
        }
        return false;
    }
    /**
     * metodi toteuttaa doolittle algoritmin, siis hajauttaa matriisin.
     * @return hajotelma matriisi
     */
    public double[][] doolittle() { // tämä ei anna muutamille alkioille oikeita arvoja, missä vika?
     
        if (this.koontarkistus()) {
           double[][] hajotelma = new double[this.getPituus()][this.getLeveys()];
           for (int i = 0; i < this.getLeveys(); i++) {
                for (int j = 0; j < i; j++) {
                    double a = this.getMatriisi()[i][j];
                    for (int p = 0; p < j; p++) {
                        a = a - this.getMatriisi()[i][p] * this.getMatriisi()[p][j];
                        
                    }
                    hajotelma[i][j] = a / this.getMatriisi()[j][j];
                }
                for (int j = i; j< this.getPituus(); j++) {
                    double a = this.getMatriisi()[i][j];
                    for (int p = 0; p < i; p++) {
                        a = a - this.getMatriisi()[i][p] * this.getMatriisi()[p][j];
                    }
                    hajotelma[i][j] = a;
                }
        }
           return hajotelma;
        } else {
            throw new IllegalArgumentException("Matriisi ei ole neliömatriisi!");
        }
       
    }
    
    @Override
    public double[][] getMatriisi() {
        return this.matriisi;
    }
}
