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
     private Normimatriisi x;
   
    public LUmatriisiTest() {
         this.x = new Normimatriisi(m1);
    }
    
    

  

    /**
     * Test of skalaaritulo method, of class LUmatriisi.
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

    
}
