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
        
        String merkkijono = "4,3,1.5,100;6,3,0,0.004;3,70,-4,1";
        
        System.out.println("Merkkijono: " + merkkijono);
        
        double[][] oikea = new double[][] {{4,3,1.5,100},{6,3,0,0.004},{3,70,-4,1}};
        
        Matriisi matriisi = varasto.muutaMatriisiksi(merkkijono, 3, 4);
        
        System.out.println("Matriisi: ");
        System.out.println(matriisi.toString());
        
        assertArrayEquals(oikea, matriisi.getMatriisi());
        
     }
     /**
      * Testi varmistaa, että virheellinen syöte heittää poikkeuksen.
      */
     @Test (expected=IllegalArgumentException.class)
     public void muutaMatriisiksiHylkääVirheellisenSyötteen() {
         String merkkijono = "1,s;o,5;X,£";
         varasto.muutaMatriisiksi(merkkijono, 2, 2);
       
     }
     /**
      * Testi varmistaa, että liian pieni pituus ja/tai leveys heittää poikkeuksen.
      */
     @Test (expected=IndexOutOfBoundsException.class)
     public void vaarankokoinenMatriisiHeittaaPoikkeuksen() {
         String merkkijono = "1,2,3;4,5,6;7,8,9";
         varasto.muutaMatriisiksi(merkkijono, 2, 2);
     }
     
}
