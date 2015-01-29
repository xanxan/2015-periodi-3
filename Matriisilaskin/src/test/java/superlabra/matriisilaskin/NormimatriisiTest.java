package superlabra.matriisilaskin;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author anna
 */
public class NormimatriisiTest {
    private double[][] m1 = {{2,0,-5},
                         {1,6,100}};
    private double[][] m2 = {{5,0,10},
                         {-4,-3,1}};
    private double[][] m3 = {{0,1},
                         {10,-9}};
   
    private Normimatriisi x;
    private Normimatriisi y;
    private Normimatriisi z;
    
    public NormimatriisiTest() {
        this.x = new Normimatriisi(m1);
        this.y = new Normimatriisi(m2);
        this.z = new Normimatriisi(m3);
    }
    
 

    

    /**
     * Test of skalaaritulo method, of class Normimatriisi.
     */
    @Test
    public void testSkalaaritulo() {
       
       
       int a = 0; int b = 1; int c = 5; int d = -100;
       
       int[][] ma = new int[2][3];
       int[][] mc = {{10,0,-25},
                    {5,30,500}};
       int[][] md = {{-200,0,500},
                     {-100,-600,-10000}};
       
       assertArrayEquals(ma, x.skalaaritulo(a));
       assertArrayEquals(m1, x.skalaaritulo(b));
       assertArrayEquals(mc, x.skalaaritulo(c));
       assertArrayEquals(md, x.skalaaritulo(d));
       

    }

    /**
     * Test of matriisiensumma method, of class Normimatriisi.
     */
    @Test
    public void testMatriisiensumma() {
        
         int[][] summa = {{7,0,5},
                         {-3,3,101}};
         
         assertArrayEquals(summa, x.matriisiensumma(y));
         
         
         
    }

    /**
     * Test of matriisienerotus method, of class Normimatriisi.
     */
    @Test
    public void testMatriisienerotus() {
          int[][] erotus = {{-3,0,-15},
                           {5,9,99}};
         
          assertArrayEquals(erotus, x.matriisienerotus(y));
    }

    /**
     * Test of matriisitulo method, of class Normimatriisi.
     */
    @Test
    public void testMatriisitulo() {
          int[][] tulo = {{-4,-3,1},
                         {86,27,91}};
          
          assertArrayEquals(tulo, z.matriisitulo(y));
    }

    /**
     * Test of koontarkistus method, of class Normimatriisi.
     */
    @Test
    public void testKoontarkistus() {
          
          assertTrue(x.koontarkistus(y));
          assertFalse(y.koontarkistus(z));
    }
    
    @Test
    public void testTranspoosi() {
        int[][] transpoosi = {{0,10},
                              {1, -9}};
        assertArrayEquals(transpoosi, z.transpoosi());
        
    }
}
