package superlabra.matriisilaskin;

/**
 * Tämä luokka muuntaa syötteenä saadun merkkijonon taulukkomatriisiksi ja
 * tallettaa sen.
 *
 * @author anna
 */
public class Matriisivarasto {

    private Matriisi[] varasto; // matriisit talletetaan tähän.

    public Matriisivarasto() {
        this.varasto = new Matriisi[50];
    }

    /**
     * Lisää uuden matriisin varastoon.
     */
    public void lisaaVarastoon(Matriisi m) {
        varasto[this.matriisejaVarastossa()] = m;
    }

    /**
     * Etsii matriisin varastosta nimen avulla.
     *
     * @param nimi matriisin nimi
     * @return matriisi
     */
    public Matriisi etsiVarastosta(String nimi) {

        for (Matriisi m : varasto) {
            if (m == null) {
                return null;
            } else if (m.getNimi().equals(nimi)) {
                return m;
            }
        }
        return null;
    }

    /**
     * matriisejaVarastossa() palauttaa tallatettujen matriisin lukumäärän.
     *
     * @return matriisien lukumäärä
     */
    public int matriisejaVarastossa() {
        int luku = 0;
        for (int i = 0; i < varasto.length; i++) {
            if (varasto[i] == null) {
                break;

            } else {
                luku++;
            }
        }
        return luku;
    }

    /**
     * muutaMatriisiksi muuttaa annetun merkkijonon matriisitaulukoksi.
     *
     * @param merkkijono annettu merkkijono
     * @param pituus matriisin pituus
     * @param leveys matriisin leveys
     * @return Matriisi-olio
     */
    public Matriisi muutaMatriisiksi(String merkkijono) {

        int i = 0;
        int j = 0;

        String[] rivit = merkkijono.split(";");
        String[] apu = rivit[0].split(" "); // saadaan matriisin leveys
        double[][] matriisi = new double[rivit.length][apu.length];

        for (String rivi : rivit) {
            String[] alkiot = rivi.split(" ");
            if (alkiot.length != apu.length) { // jos rivit eivät ole samanpituiset
                throw new IllegalArgumentException();
            }
            for (String alkio : alkiot) {
                try {
                    matriisi[i][j] = Double.parseDouble(alkio); // HUOM! jos alkio on 0.0001 tai sitä pienempi luku,
                    j++;                                        // tulostaa ohjelma sen muodossa '1.0E-4'.
                } catch (Exception e) { // jos sisältää vääriä merkkejä
                    return null;
                }
            }
            i++;
            j = 0;
        }

        return new Matriisi(matriisi);
    }

}
