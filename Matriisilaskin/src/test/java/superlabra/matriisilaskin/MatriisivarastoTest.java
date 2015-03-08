/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.matriisilaskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anna
 */
public class MatriisivarastoTest {
    private Matriisivarasto varasto;
    
    public MatriisivarastoTest() {
    }
    
    @Before
    public void setUp() {
        this.varasto = new Matriisivarasto();
   
    }
    
    

    /**
     * Tämä testi testaa, että muutaMatriisiksi palauttaa oikean matriisin ja
     * että metodi osaa myös käsitellä erikoismerkit oikein, eikä kaadu. 
     */
     @Test
     public void muutaMatriisiksiPalauttaaOikeanMatriisin() {
        
        String merkkijono = "4 3 1.5 100;6 3 0 0.004;3 70 -4 1";
        
        System.out.println("Merkkijono: " + merkkijono);
        
        double[][] oikea = new double[][] {{4,3,1.5,100},{6,3,0,0.004},{3,70,-4,1}};
        
        Matriisi matriisi = varasto.muutaMatriisiksi(merkkijono);
        
        System.out.println("Matriisi: ");
        System.out.println(matriisi.toString());
        
        assertArrayEquals(oikea, matriisi.getMatriisi());
        
     }
     /**
      * Testi varmistaa, että virheellinen syöte heittää poikkeuksen.
      */
     @Test 
     public void muutaMatriisiksiHylkääVirheellisenSyötteen() {
         String merkkijono = "1 s;o 5;X £";
         assertEquals(null, varasto.muutaMatriisiksi(merkkijono));
         
     }
     /**
      * Testi varmistaa, että erikokoiset leveydet heittävät poikkeuksen.
      */
     @Test (expected=IllegalArgumentException.class)
     public void vaarankokoinenMatriisiHeittaaPoikkeuksen() {
         String merkkijono = "1 2 3;4 5 6;7 8";
         varasto.muutaMatriisiksi(merkkijono);
     }
     /**
      * matriisejaVarastossa palauttaa oikean luvun.
      */
     @Test
     public void matriisejaVarastossaToimii() {
         double[][] m = new double[1][2];
         Matriisi matriisi1 = new Matriisi(m);
         Matriisi matriisi2 = new Matriisi(m);
         Matriisi matriisi3 = new Matriisi(m);
         
         assertEquals(0, varasto.matriisejaVarastossa());
         varasto.lisaaVarastoon(matriisi1);
         assertEquals(1, varasto.matriisejaVarastossa());
         varasto.lisaaVarastoon(matriisi2);
         assertEquals(2, varasto.matriisejaVarastossa());
         varasto.lisaaVarastoon(matriisi3);
         assertEquals(3, varasto.matriisejaVarastossa());
     }
     /**
      * testi lisää matriisin varastoon ja haettaessa palauttaa sen.
      */
     @Test
     public void etsiVarastostaJaLisaaVarastoonToimii() {
         double[][] m = {{1,2},{3,4}};
         Matriisi matriisi = new Matriisi(m);
         
         matriisi.setNimi("a");
         varasto.lisaaVarastoon(matriisi);
         
         assertArrayEquals(m, varasto.etsiVarastosta("a").getMatriisi());
     }
     /**
      * etsiVarastosta palauttaa null, kun matriisia ei löydy.
      */
     @Test
     public void etsiVarastostaPalauttaaNull() {
         String nimi = "nimi";
         assertEquals(null, varasto.etsiVarastosta(nimi));
     }
}
