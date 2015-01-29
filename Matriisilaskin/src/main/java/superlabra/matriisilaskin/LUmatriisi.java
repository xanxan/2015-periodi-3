package superlabra.matriisilaskin;

/**
 * LUmatriisiluokan tehtävänä on laskea annetun matriisin determinantti ja käänteismatriisi LU-hajotelman avulla.
 * @author anna
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class LUmatriisi implements Matriisirajapinta {
    private double[][] l;
    private double[][] matriisi;
    private double[][] u;
    
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
    public double[][] doolittle() { // tämä toimii syötteellä 4,3;6,3 mutta muista syötteistä en ole täysin varma
     
        if (this.koontarkistus()) {
//       
         
           double[][] hajotelma = this.matriisi; //palautettava hajotelmamatriisi
           
           for (int j = 0; j < this.matriisi.length; j++) {
                for (int i = 0; i < j; i++) {
                    double a = this.getMatriisi()[j][i];
                    for (int p = 0; p < i; p++) {
                        a -= this.getMatriisi()[p][i] * this.getMatriisi()[j][p];
                        
                    }
                    hajotelma[j][i] = a / this.getMatriisi()[i][i];
                    
                }
               
                for (int i = j; i< this.matriisi[0].length; i++) {
                    double a = this.getMatriisi()[j][i];
                    for (int p = 0; p < j; p++) {
                        a -= this.getMatriisi()[p][i] * this.getMatriisi()[j][p];
                    }
                    hajotelma[j][i] = a;
                    
                }
        }  
           return hajotelma;
        } else {
            throw new IllegalArgumentException("Matriisi ei ole neliömatriisi!");
        }
       
    }
    
    public double[][] getL() {
        return this.l;
    }
    
    public double[][] getU() {
        return this.u;
    }
    
    public void setL(double[][] l) {
        this.l = l;
    }
    
    public void setU(double[][] u) {
        this.u = u;
    }
    
    @Override
    public double[][] getMatriisi() {
        return this.matriisi;
    }
}
