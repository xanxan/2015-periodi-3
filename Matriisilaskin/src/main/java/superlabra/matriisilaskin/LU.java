package superlabra.matriisilaskin;

/**
 * LU-luokka on laskukone, joka suorittaa LU-hajotelman operaatiot matriiseille.
 * Nämä operaatiot ovat omassa luokassaan siksi, että A = LU ei päde kaikille
 * matriiseille. Determinantti kuitenkin lasketaan tässä ohjelmassa kaikille
 * matriiseille doolittlen avulla.
 *
 * @author anna
 */
public class LU {

    /**
     * metodi toteuttaa doolittle algoritmin, siis hajauttaa matriisin.
     *
     * @param m matriisi joka hajoitetaan LU-matriisiksi.
     * @return hajotelma matriisi
     */
    public static Matriisi doolittle(Matriisi m) {
        Matriisi kopio = LU.kopioi(m.getMatriisi());

        if (kopio.onNelio()) {
            double[][] h = kopio.getMatriisi(); //palautettava hajotelmamatriisi

            for (int j = 0; j < kopio.getPituus(); j++) {
                for (int i = 0; i < j; i++) {
                    double a = kopio.getMatriisi()[j][i];
                    for (int p = 0; p < i; p++) {
                        a -= kopio.getMatriisi()[p][i] * kopio.getMatriisi()[j][p];
                    }
                    h[j][i] = a / kopio.getMatriisi()[i][i];
                }
                for (int i = j; i < kopio.getLeveys(); i++) {
                    double a = kopio.getMatriisi()[j][i];
                    for (int p = 0; p < j; p++) {
                        a -= kopio.getMatriisi()[p][i] * kopio.getMatriisi()[j][p];
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
     *
     * @param m hajautettu matriisi
     * @return l-matriisi
     */
    public static Matriisi getL(Matriisi m) {
        Matriisi kopio = kopioi(m.getMatriisi());
        double[][] l = new double[kopio.getPituus()][kopio.getLeveys()];
        for (int i = 0; i < kopio.getPituus(); i++) {
            for (int j = 0; j < kopio.getLeveys(); j++) {
                if (i == j) {
                    l[i][j] = 1;
                } else if (i < j) {
                    l[i][j] = 0;
                } else {
                    l[i][j] = kopio.getMatriisi()[i][j];
                }
            }
        }

        return new Matriisi(l);
    }

    /**
     * getU() palauttaa hajoitelman U-matriisin.
     *
     * @param m hajautettu matriisi
     * @return u-matriisi
     */
    public static Matriisi getU(Matriisi m) {
        Matriisi kopio = kopioi(m.getMatriisi());
        double[][] u = kopio.getMatriisi();
        for (int i = 0; i < kopio.getPituus(); i++) {
            for (int j = 0; j < kopio.getLeveys(); j++) {
                if (i > j) {
                    u[i][j] = 0;
                } else {
                    u[i][j] = kopio.getMatriisi()[i][j];
                }
            }
        }
        return new Matriisi(u);
    }

    /**
     * Apumetodi joka kopioi matriisin uudeksi olioksi. Käytetään jotta
     * operaatiot eivät tallentaisi muutoksia alkuperäiseen matriisiin.
     *
     * @param m alkuperäinen matriisi.
     * @return kopiomatriisi
     */
    private static Matriisi kopioi(double[][] m) {
        double[][] kopio = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                kopio[i][j] = m[i][j];
            }
        }
        return new Matriisi(kopio);
    }

    /**
     * determinantti() laskee hajautetun matriisin determinantin.
     *
     * @param m hajautettu matriisi
     * @return determinanttiluku
     */
    public static double determinantti(Matriisi m) {
        Matriisi kopio = kopioi(m.getMatriisi());
        double[][] apu = LU.getU(kopio).getMatriisi(); //haetaan hajautuksen U-matriisi
        double determinantti = 1;

        for (int i = 0; i < apu.length; i++) {
            determinantti *= apu[i][i];
        }

        return determinantti;
    }
//    /**
//     * kaanteismatriisi laskee matriisin käänteismatriisin LU-hajotelmasta.
//     * @param m hajautettu matriisi
//     * @return käänteismatriisi
//     */
//    public static Matriisi kaanteismatriisi(Matriisi m) {
//        Matriisi kopio = kopioi(m.getMatriisi());
//        double[][] inv = kopio.getMatriisi(); // palautettava käänteismatriisi
//        double[] x = new double[m.getPituus()]; // sarakematriisi x
//        double[] b = new double[m.getPituus()]; // sarakematriisi b
//        for (int i = 0; i < m.getPituus(); i++) {
//            for (int j = 0; j < m.getLeveys(); j++) {
//                if (i==j){
//                    b[j] = 1;
//                } else {
//                    b[j] = 0;
//                }
//               
//            }
//        
//            x[0]=b[0];
//            for (int k = 1; k < m.getPituus(); k++) {
//                double s = 0;

//                for (int j = 0; j < k; j++) {
//                     s += inv[k][j] * x[j];
//                    
//                }
//                x[k] = b[k]-s;
//             
//            } //back substitution to solve Ux = d
//            x[m.getPituus()-1] = x[m.getPituus()-1] / inv[m.getPituus()-1][m.getLeveys()-1];
//            for (int k = m.getPituus()-2; k>-1; k--) {
//                double s = 0;
//                for (int j = k+1; j < m.getPituus(); j++) {
//                    s += inv[k][j] * x[j];
//                }
//                x[k] = (x[k] -s)/inv[k][k];
//            }
//        
//            for (int j = 0; j < m.getPituus(); j++) {
//                inv[j][i] = x[j];
//            }
//        }
//    
//        return new Matriisi(inv);
//    }
}
