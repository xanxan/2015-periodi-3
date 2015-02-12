package superlabra.matriisilaskin;

/**
 * LU-luokka on laskukone, joka suorittaa LU-hajotelman operaatiot matriiseille.
 * @author anna
 */
public class LU {
   
    public LU() {
    
    }
    
    /**
     * metodi toteuttaa doolittle algoritmin, siis hajauttaa matriisin.
     * @param m matriisi joka hajoitetaan LU-matriisiksi.
     * @return hajotelma matriisi
     */
    public Matriisi doolittle(Matriisi m) { 
     
        if (m.onNelio()) {
//       
           
           double[][] h = m.getMatriisi(); //palautettava hajotelmamatriisi
//            
           for (int j = 0; j < m.getPituus(); j++) {
                for (int i = 0; i < j; i++) {
                    double a = m.getMatriisi()[j][i];
                    for (int p = 0; p < i; p++) {
                        a -= m.getMatriisi()[p][i] * m.getMatriisi()[j][p];
                        
                    }
                    h[j][i] = a / m.getMatriisi()[i][i];
                    
                }
               
                for (int i = j; i< m.getLeveys(); i++) {
                    double a = m.getMatriisi()[j][i];
                    for (int p = 0; p < j; p++) {
                        a -= m.getMatriisi()[p][i] * m.getMatriisi()[j][p];
                    }
                    h[j][i] = a;
                    
                }
            }  
          
           return new Matriisi(h);
        } else {
            throw new IllegalArgumentException("Matriisi ei ole neliömatriisi!");
        }
       
    }
    

    /**
     * getL() palauttaa hajoitelman L-matriisin.
     * @param m hajautettu matriisi
     * @return l-matriisi
     */
    public Matriisi getL(Matriisi m) {
        double[][] l = new double[m.getPituus()][m.getLeveys()];
        for (int i = 0; i< m.getPituus(); i++) {
            for (int j=0; j<m.getLeveys(); j++) {
                if (i == j) {
                    l[i][j] = 1;
                } else if (i<j) {
                    l[i][j] = 0;
                } else {
                    l[i][j] = m.getMatriisi()[i][j];
                }
            }
        }
        
        return new Matriisi(l);
    }
    /**
     * getU() palauttaa hajoitelman U-matriisin.
     * @param m hajautettu matriisi
     * @return u-matriisi
     */
    public Matriisi getU(Matriisi m) {
        double[][] u = m.getMatriisi();
        for (int i = 0; i < m.getPituus(); i++) {
            for (int j=0; j < m.getLeveys(); j++) {
                if (i > j) {
                    u[i][j] = 0;
                }  else {
                    u[i][j] = m.getMatriisi()[i][j];
                }
            }
        }
        return new Matriisi(u);
    }
    
    
    /**
     * determinantti() laskee hajautetun matriisin determinantin.
     * @param m hajautettu matriisi
     * @return determinanttiluku
     */
    public double determinantti(Matriisi m) {
        
        double[][] apu = this.getU(m).getMatriisi(); //haetaan hajautuksen U-matriisi
        double determinantti = 1;
        for (int i = 0; i < apu.length; i++) {
            determinantti *= apu[i][i];
        }
        return determinantti;
    }
    /**
     * kaanteismatriisi laskee matriisin käänteismatriisin LU-hajotelmasta.
     * @param m hajautettu matriisi
     * @return käänteismatriisi
     */
    public Matriisi kaanteismatriisi(Matriisi m) {
        double[] x = new double[m.getPituus()];
        double[] b = new double[m.getPituus()];
        for (int i = 0; i < m.getPituus(); i++) {
            for (int j = 0; j < m.getLeveys(); j++) {
                if (i==j){
                    b[j] = 1;
                } else {
                    b[j] = 0;
                }
               
            }
        
            x[0]=b[0];
            for (int k = 1; k < m.getPituus(); k++) {
                double s = 0;
               
                for (int j = 0; j < k; j++) {
                     s += m.getMatriisi()[k][j] * x[j];
                    
                }
                x[k] = b[k]-s;
             
            } //back substitution to solve Ux = d
            x[m.getPituus()-1] = x[m.getPituus()-1] / m.getMatriisi()[m.getPituus()-1][m.getLeveys()-1];
            for (int k = m.getPituus()-2; k>-1; k--) {
                double s = 0;
                for (int j = k+1; j < m.getPituus(); j++) {
                    s += m.getMatriisi()[k][j] * x[j];
                }
                x[k] = (x[k] -s)/m.getMatriisi()[k][k];
            }
        
            for (int j = 0; j < m.getPituus(); j++) {
                m.getMatriisi()[j][i] = x[j];
            }
        }
    
        return new Matriisi(m.getMatriisi());
    }
    
    
   
}
