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
public class LUmatriisiTest {
    private double[][] m1 = {{2,0,-5},
                         {1,6,100}};
    private double[][] m2 = {{4,3},
                       {6,3}};
    private double[][] m3 = {{5}};
     private LUmatriisi x;
     private LUmatriisi y;
     private LUmatriisi z;
     
    public LUmatriisiTest() {
         this.x = new LUmatriisi(m1);
         this.y = new LUmatriisi(m2);
         this.z = new LUmatriisi (m3);
    }
    
    @Test
    public void tesDoolittle() {
        double[][] apu = {{4,3},{1.5,-1.5}};
        assertArrayEquals(apu, y.doolittle());
    }

    @Test
    public void testGetL() {
        y.doolittle();
        double[][] apu = {{1,0},{1.5,1}};
        assertArrayEquals(apu, y.getL());
    }
    
    @Test
    public void testGetU() {
        y.doolittle();
        double[][] apu = {{4,3},{0,-1.5}};
        assertArrayEquals(apu, y.getU());
    }
    
    @Test
    public void testDeterminantti() {
        y.doolittle();
        assertEquals(-6, y.determinantti(), 0.001);
    }
    
    @Test
    public void testKoontarkistus() {
        assertTrue(y.koontarkistus());
        assertTrue(z.koontarkistus());
    }

    /**
     * Test of skalaaritulo method, of class LUmatriisi.
     */
    @Test
    public void testSkalaaritulo() {
        int a = 0; int b = 1; int c = 5; int d = -100;
       
       double[][] ma = new double[2][2];
       double[][] mc = {{20,15},
                    {30,15}};
       double[][] md = {{-400,-300},
                     {-600,-300}};
       
       assertArrayEquals(ma, y.skalaaritulo(a));
       assertArrayEquals(m2, y.skalaaritulo(b));
       assertArrayEquals(mc, y.skalaaritulo(c));
       assertArrayEquals(md, y.skalaaritulo(d));
    }

    
}
