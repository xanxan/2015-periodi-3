package superlabra.matriisilaskin;

/**
 * LUmatriisiluokan tehtävänä on laskea annetun matriisin determinantti ja käänteismatriisi LU-hajotelman avulla.
 * @author anna
 * @param leveys matriisin leveys
 * @param pituus matriisin pituus
 * @param matriisi annettu matriisi
 */
public class LUmatriisi implements Matriisirajapinta {
   
    private double[][] matriisi;
    
    
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
     * koontarkistus varmistaa, että matriisi on neliömatriisi (nxn).
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
//            
           for (int j = 0; j < this.getPituus(); j++) {
                for (int i = 0; i < j; i++) {
                    double a = this.getMatriisi()[j][i];
                    for (int p = 0; p < i; p++) {
                        a -= this.getMatriisi()[p][i] * this.getMatriisi()[j][p];
                        
                    }
                    hajotelma[j][i] = a / this.getMatriisi()[i][i];
                    
                }
               
                for (int i = j; i< this.getLeveys(); i++) {
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
    

    /**
     * getL() erottaa hajoitelman L-matriisin ja se suoritetaan LU -matriisille.
     * @return l-matriisi
     */
    public double[][] getL() {
        double[][] l = new double[this.getPituus()][this.getLeveys()];
        for (int i = 0; i< this.getPituus(); i++) {
            for (int j=0; j<this.getLeveys(); j++) {
                if (i == j) {
                    l[i][j] = 1;
                } else if (i<j) {
                    l[i][j] = 0;
                } else {
                    l[i][j] = this.getMatriisi()[i][j];
                }
            }
        }
        
        return l;
    }
    /**
     * getU() erottaa hajoitelman U-matriisin ja se suoritetaan LU -matriisille.
     * @return u-matriisi
     */
    public double[][] getU() {
        double[][] u = this.getMatriisi();
        for (int i = 0; i< this.getPituus(); i++) {
            for (int j=0; j<this.getLeveys(); j++) {
                if (i > j) {
                    u[i][j] = 0;
                }  else {
                    u[i][j] = this.getMatriisi()[i][j];
                }
            }
        }
        return u;
    }
    public static void tulosta(double[] matriisi) { //testauskäyttöön, ei kuulu oikeaan koodiin
         
         for (int i = 0; i < matriisi.length; i++) {
             System.out.print("[ ");
            
                System.out.print(matriisi[i] + " ");
            
             System.out.println(" ]");
        }
       
    }
    public static void tulosta(double[][] matriisi) { //testauskäyttöön, ei kuulu oikeaan koodiin
         
         for (int i = 0; i < matriisi.length; i++) {
             System.out.print("[ ");
            for (int j = 0; j < matriisi[0].length; j++) {
                System.out.print(matriisi[i][j] + " ");
            }
             System.out.println(" ]");
        }
       
    }
    /**
     * determinantti() laskee valmiiksi hajautetun matriisin determinantin.
     * @return determinanttiluku
     */
    public double determinantti() {
        
        double[][] apu = this.getU(); //haetaan hajautuksen U-matriisi
        double determinantti = 1;
        for (int i = 0; i < apu.length; i++) {
            determinantti *= apu[i][i];
        }
        return determinantti;
    }
    /**
     * kaanteismatriisi laskee matriisin käänteismatriisin siitä muodostetun lu-hajotelman avulla.
     * @return käänteismatriisi
     */
    public double[][] kaanteismatriisi() {
        double[] x = new double[this.getPituus()];
        double[] b = new double[this.getPituus()];
        for (int i = 0; i< this.getPituus(); i++) {
            for (int j = 0; j<this.getLeveys(); j++) {
                if (i==j){
                    b[j] = 1;
                } else {
                    b[j] = 0;
                }
               
            }
        
            x[0]=b[0];
            for (int k = 1; k < this.getPituus(); k++) {
                double s = 0;
                System.out.println("x = " ); //debug
                tulosta(x); // debug
                for (int j = 0; j < k; j++) {
                     s += this.getMatriisi()[k][j] * x[j];
                     tulosta(this.getMatriisi()); //debug
                     System.out.println(this.getMatriisi()[k][j]); //debug
                     System.out.println("s: " + s); //debug
                }
                x[k] = b[k]-s;
                System.out.println("x="); //debug
                tulosta(x); // debug
            } //back substitution to solve Ux = d
            x[this.getPituus()-1] = x[this.getPituus()-1] / this.getMatriisi()[this.getPituus()-1][this.getLeveys()-1];
            for (int k = this.getPituus()-2; k>-1; k--) {
                int s = 0;
                for (int j = k+1; j<this.getPituus(); j++) {
                    s += this.getMatriisi()[k][j] * x[j];
                }
                x[k] = (x[k] -s)/this.getMatriisi()[k][k];
            }
        
            for (int j = 0; j<this.getPituus(); j++) {
                this.getMatriisi()[j][i] = x[j];
            }
        }
    
        return this.getMatriisi();
    }
    @Override
    public double[][] getMatriisi() {
        return this.matriisi;
    }
}
