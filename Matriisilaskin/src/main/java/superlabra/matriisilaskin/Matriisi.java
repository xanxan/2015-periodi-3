package superlabra.matriisilaskin;

import superlabra.matriisilaskin.Matriisirajapinta;

/**
 * Matriisiolio -luokka. Sisältää matriisitaulukon, nimen, pituuden ja leveyden.
 * Laskee kaikille matriiseille mahdolliset operaatiot ja suorittaa apumetodit.
 *
 * @author anna
 */
public class Matriisi implements Matriisirajapinta {

    private final double[][] matriisi;
    private String nimi = null;

    public Matriisi(double[][] matriisi) {
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
     *
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
     *
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
     *
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
     * matriisitulo laskee kahden matriisin tulon O(n^3) algoritmilla.
     * apumuuttuja apu laskee kerrottujen solujen tulot yhteen.
     *
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
                        apu += this.matriisi[i][k] * m2.matriisi[k][j];
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
     * strassentulo laskee kahden suurikokoisen matriisin tulon strassen
     * algoritmilla.
     *
     * @param m2 kerrottava matriisi
     * @return tulomatriisi
     */
    public Matriisi strassentulo(Matriisi m2) {
        if (this.onkoKerrottavissa(m2)) {

            Matriisi A = this.laajennaMatriisi();
            Matriisi B = m2.laajennaMatriisi();

            if (A.getLeveys() < 100 && B.getLeveys() < 100) { // Jos matriisien koko on pienempi kuin 100x100, naiivi tapa on tehokkaampi.  
                Matriisi tulo = A.matriisitulo(B);
                return pienennaMatriisi(tulo.getMatriisi(), this.getPituus(), m2.getLeveys());
            } else {
                // Laajennetaan matriisi 2^n potenssiin ja jaetaan matriisi A alamatriiseihin A11, A12, A21, A22
                Matriisi A11 = A.alamatriisi(0, 0);
                Matriisi A12 = A.alamatriisi(A.getLeveys() / 2, 0);
                Matriisi A21 = A.alamatriisi(0, A.getPituus() / 2);
                Matriisi A22 = A.alamatriisi(A.getLeveys() / 2, A.getPituus() / 2);
                // ja matriisi B alamatriiseihin B11, B12, B21, B22.
                Matriisi B11 = B.alamatriisi(0, 0);
                Matriisi B12 = B.alamatriisi(B.getLeveys() / 2, 0);
                Matriisi B21 = B.alamatriisi(0, B.getPituus() / 2);
                Matriisi B22 = B.alamatriisi(B.getLeveys() / 2, B.getPituus() / 2);
                // P1 = (A11+A22)*(B11+B22) kutsutaan strassentuloa rekursiivisesti
                Matriisi P1 = A11.matriisiensumma(A22).strassentulo(B11.matriisiensumma(B22));
                // P2 = (A21+A22)*B11 kutsutaan strassentuloa rekursiivisesti
                Matriisi P2 = A21.matriisiensumma(A22).strassentulo(B11);
                // P3 = A11*(B12-B22) kutsutaan strassentuloa rekursiivisesti
                Matriisi P3 = A11.strassentulo(B12.matriisienerotus(B22));
                // P4 = A22*(B21-B11) kutsutaan strassentuloa rekursiivisesti
                Matriisi P4 = A22.strassentulo(B21.matriisienerotus(B11));
                // P5 = (A11+A12)*B22 kutsutaan strassentuloa rekursiivisesti
                Matriisi P5 = A11.matriisiensumma(A12).strassentulo(B22);
                // P6 = (A21-A11)*(B11+B12) kutsutaan strassentuloa rekursiivisesti
                Matriisi P6 = A21.matriisienerotus(A11).strassentulo(B11.matriisiensumma(B12));
                // P7 = (A12-A22)*(B21+B22) kutsutaan strassentuloa rekursiivisesti
                Matriisi P7 = A12.matriisienerotus(A22).strassentulo(B21.matriisiensumma(B22));

                // C11 = P1+P4-P5+P7
                Matriisi C11 = P1.matriisiensumma(P4).matriisienerotus(P5).matriisiensumma(P7);
                // C12 = P3+P5
                Matriisi C12 = P3.matriisiensumma(P5);
                // C21 = P2+P4
                Matriisi C21 = P2.matriisiensumma(P4);
                // C22 = P1-P2+P3+P6
                Matriisi C22 = P1.matriisienerotus(P2).matriisiensumma(P3).matriisiensumma(P6);

                // Kootaan alamatriisit C11, C12, C21, C22 matriisiksi C ja return.
                double[][] C = new double[C11.getPituus() + C21.getPituus()][C11.getLeveys() + C12.getLeveys()];
                liitaMatriisiin(C, C11, 0, C11.getLeveys(), 0, C11.getPituus());
                liitaMatriisiin(C, C12, C11.getLeveys(), C12.getLeveys() + C11.getLeveys(), 0, C12.getPituus());
                liitaMatriisiin(C, C21, 0, C21.getLeveys(), C11.getPituus(), C11.getPituus() + C21.getPituus());
                liitaMatriisiin(C, C22, C21.getLeveys(), C21.getLeveys() + C22.getLeveys(), C12.getPituus(), C12.getPituus() + C22.getPituus());

                return pienennaMatriisi(C, this.getPituus(), m2.getLeveys());
            }
        } else {
            throw new IllegalArgumentException("Et voi kertoa vääränkokoisia matriiseja!");
        }
    }

    /**
     * Transpoosi() laskee matriisin transpoosin.
     *
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

    //          Matriisiluokan laskuoperaatioiden apumetodit
    /**
     * Poistaa tulomatriisista ylimääräiset sarakkeet.
     *
     * @param m1 pienennettävä matriisi
     * @param leveys oikea leveys
     * @param pituus oikea pituus
     * @return oikeankokoinen matriisi
     */
    public Matriisi pienennaMatriisi(double[][] m1, int leveys, int pituus) {
        double[][] m2 = new double[pituus][leveys];
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < leveys; j++) {
                m2[i][j] = m1[i][j];
            }
        }
        return new Matriisi(m2);
    }

    /**
     * Liittää kerrotun alamatriisin lopulliseen tulomatriisiin.
     *
     * @param m tulomatriisi johon liitetään
     * @param alamatriisi liitettävä alamatriisi
     * @param alkuleveys mistä asti matriisi liitetään
     * @param loppuleveys mihin asti matriisi liitetään
     * @param alkupituus miltä riviltä matriisi liitetään
     * @param loppupituus mihin riville matriisi liitetään
     */
    public void liitaMatriisiin(double[][] m, Matriisi alamatriisi, int alkuleveys, int loppuleveys, int alkupituus, int loppupituus) {
        int x = 0;
        int y = 0;
        for (int i = alkupituus; i < loppupituus; i++) {
            for (int j = alkuleveys; j < loppuleveys; j++) {
                m[i][j] = alamatriisi.getMatriisi()[y][x];
                x++;
            }
            y++;
            x = 0;
        }
    }

    /**
     * Palauttaa matriisin alaneliömatriisin.
     *
     * @param alkuleveys mistä sarakkeesta asti erotetaan.
     * @param alkupituus mistä rivistä alkaen erotetaan.
     * @return alamatriisi.
     */
    public Matriisi alamatriisi(final int alkuleveys, final int alkupituus) {
        double[][] matriisi = new double[this.getPituus() / 2][this.getLeveys() / 2];
        int x = alkuleveys;
        int y = alkupituus;
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi[0].length; j++) {
                matriisi[i][j] = this.getMatriisi()[y][x];
                x++;
            }
            y++;
            x = alkuleveys;

        }
        return new Matriisi(matriisi);
    }

    /**
     * palauttaa annetun matriisin 2^n * 2^n muodossa.
     *
     * @param m annettu matriisi.
     * @return 2^n*2^n matriisi.
     */
    public Matriisi laajennaMatriisi() {

        int sivu = Matriisi.seuraavaKahdenPotenssi(Math.max(this.getPituus(), this.getLeveys()));
        double[][] matriisi = new double[sivu][sivu];

        for (int i = 0; i < this.getPituus(); i++) {
            for (int j = 0; j < this.getLeveys(); j++) {
                matriisi[i][j] = this.getMatriisi()[i][j];
            }
        }

        return new Matriisi(matriisi);
    }

    /**
     * onkokerrottavissa tarkistaa, että matriisien koot mahdollistavat
     * matriisikertolaskun.
     *
     * @param m2
     * @return boolean
     */
    public boolean onkoKerrottavissa(Matriisi m2) {

        return this.getLeveys() == m2.getPituus();
    }

    /**
     * koontarkistus varmistaa, että kaksi matriisia ovat samankokoiset
     * (molemmat nxm).
     *
     * @param m2 verrattava matriisi
     * @return true jos koot täsmäävät, muuten false.
     */
    public boolean koontarkistus(Matriisi m2) {

        return this.getLeveys() == m2.getLeveys() && this.getPituus() == m2.getPituus();
    }

    /**
     * onNelio() varmistaa, että matriisi on neliömatriisi (nxn).
     *
     * @return true jos koot täsmäävät, muuten false.
     */
    public boolean onNelio() {
        return this.getPituus() == this.getLeveys();
    }

    /**
     * kahdenPotenssi() palauttaa annetusta vakiosta seuraavan kahden potenssin.
     *
     * @param n tutkittava luku.
     * @return luku joka on kahden potenssi.
     */
    public static int seuraavaKahdenPotenssi(int n) {
        int apu = Integer.highestOneBit(n);
        if (apu == n) {
            return n;
        } else {
            return apu * 2;
        }

    }

}
