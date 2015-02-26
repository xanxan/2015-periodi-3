package superlabra.matriisilaskin;

import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author anna
 */
public class MatriisiTest {
    private double[][] m1;
    private double[][] m2;
    private double[][] m3;
    private double[][] m4;
    private double[][] m5;
    private double[][] m6;
   
    private Matriisi x;
    private Matriisi y;
    private Matriisi z;
    private Matriisi k;
    private Matriisi i;
    private Matriisi j;
    
    public MatriisiTest() {
       
    }
    private double[][] lukujonomatriisi(int leveys, int pituus) {
        int luku = 1;
        double[][] matriisi = new double[pituus][leveys];
        for (double[] matriisi1 : matriisi) {
            for (int j = 0; j<matriisi[0].length; j++) {
                matriisi1[j] = luku;
                luku++;
            }
        }
        return matriisi;
    }
    private double[][] generoiMatriisi(int leveys, int pituus) {
        
        Random r = new Random();
        double[][] matriisi = new double[pituus][leveys];
        
        for (double[] matriisi1 : matriisi) {
            for (int j = 0; j<matriisi[0].length; j++) {
                matriisi1[j] = r.nextDouble();
            }
        }
        
        return matriisi;
        
    }
    
    @Before
    public void setUp() {
        this.m1 = new double[][] {{2,0,-5},{1,6,100}};
        this.m2 = new double[][] {{5,0,10},{-4,-3,1}};
        this.m3 = new double[][] {{0,1},{10,-9}};
        this.m4 = new double[][] {{5}};
        this.m5 = new double[][] {{1,2,3}};
        this.m6 = new double[][] {{-1.5,0.004,2},{6.1,0,1.5}};
        
        this.x = new Matriisi(m1);
        this.y = new Matriisi(m2);
        this.z = new Matriisi(m3);
        this.k = new Matriisi(m4);
        this.i = new Matriisi(m5);
        this.j = new Matriisi(m6);
    }
    
    
    /**
     * Test of skalaaritulo method, of class Matriisi.
     */
    @Test
    public void testSkalaaritulo() { // liukuluvussa 0.0/-0.0 ongelma korjataan myöhemmin
       
       
       int a = 0; int b = 1; int c = 5; int d = -100;
       
       double[][] ma = new double[2][3];
       double[][] mc = {{10,0,-25},
                    {5,30,500}};
       double[][] md = {{-200,0,500},
                     {-100,-600,-10000}};
       
       for (int i = 0; i < x.getPituus(); i++) {
           for (int j = 0; j < x.getLeveys(); j++) {
               
             assertEquals(ma[i][j], x.skalaaritulo(a).getMatriisi()[i][j], 0.001);
             assertEquals(m1[i][j], x.skalaaritulo(b).getMatriisi()[i][j], 0.001);
             assertEquals(mc[i][j], x.skalaaritulo(c).getMatriisi()[i][j], 0.001);
             assertEquals(md[i][j], x.skalaaritulo(d).getMatriisi()[i][j], 0.001);
       
           }
       }
    }
    
    @Test
    public void testOnkoKerrottavissa() {
        assertTrue(k.onkoKerrottavissa(i));
        assertFalse(i.onkoKerrottavissa(k));
        
    }
    
    @Test
    public void testKoontarkistusTyhjälläMatriisilla() {
        double[][]  tyhja= {{}};
        Matriisi t = new Matriisi(tyhja);
        
        assertFalse(x.koontarkistus(t));
        assertFalse(x.onkoKerrottavissa(t));
    }
    
    @Test
    public void testMatriisiensumma() {
        
         double[][] summa = {{7,0,5},
                         {-3,3,101}};
         
         assertArrayEquals(summa, x.matriisiensumma(y).getMatriisi());
         
         
         
    }

    /**
     * Test of matriisienerotus method, of class Matriisi.
     */
    @Test
    public void testMatriisienerotus() {
          double[][] erotus = {{-3,0,-15},
                           {5,9,99}};
         
          assertArrayEquals(erotus, x.matriisienerotus(y).getMatriisi());
    }

    /**
     * Test of matriisitulo method, of class Matriisi.
     */
    @Test
    public void testMatriisitulo() {
          double[][] tulo1 = {{-4,-3,1},
                         {86,27,91}};
          double[][] tulo2 = {{5,10,15}};
          
          assertArrayEquals(tulo1, z.matriisitulo(y).getMatriisi());
          assertArrayEquals(tulo2, k.matriisitulo(i).getMatriisi());
    }
    @Test
    public void testDesimaaliMatriisitulo() {
        double[][] tulo1 = {{6.1,0,1.5},{-69.9,0.04,6.5}};
        assertArrayEquals(tulo1, z.matriisitulo(j).getMatriisi());
    }
    @Test
    public void strassentuloToimii() {
        double[][] m1 = {{1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1}};
        double[][] m2 = {{1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1}};
        double[][] tulo = {{4,4,4,4}, 
                           {4,4,4,4}, 
                           {4,4,4,4},
                           {4,4,4,4}};
        Matriisi m = new Matriisi(m1);
        Matriisi n = new Matriisi(m2);
        
        assertArrayEquals(tulo, m.strassentulo(n).getMatriisi());
    }
    @Test
    public void isoMatriisituloToimii() {
        double[][] m1 = lukujonomatriisi(10,6);
        double[][] m2 = lukujonomatriisi(5,10);
        double[][] tulo = {{1705, 1760, 1815, 1870, 1925}, 
                           {4055, 4210, 4365, 4520, 4675}, 
                           {6405, 6660, 6915, 7170, 7425},
                           {8755, 9110, 9465, 9820, 10175}, 
                           {11105, 11560, 12015, 12470, 12925}, 
                           {13455, 14010, 14565, 15120, 15675}};
        Matriisi m = new Matriisi(m1);
        Matriisi n = new Matriisi(m2);
        
        assertArrayEquals(tulo, m.matriisitulo(n).getMatriisi());
    }
    /**
     * Test of koontarkistus method, of class Matriisi.
     */
    @Test
    public void testKoontarkistus() {
          
          assertTrue(x.koontarkistus(y));
          assertFalse(y.koontarkistus(z));
    }
    
    @Test
    public void testTranspoosi() {
        
        double[][] transpoosi = {{0,10},
                              {1, -9}};
        double[][] yksi = {{5}};
        assertArrayEquals(transpoosi, z.transpoosi().getMatriisi());
        assertArrayEquals(yksi, k.transpoosi().getMatriisi());
        
    }
    
    @Test
    public void kahdenPotenssiToimii() {
        assertEquals(1024, Matriisi.seuraavaKahdenPotenssi(513));
        assertEquals(512, Matriisi.seuraavaKahdenPotenssi(512));
        assertEquals(0, Matriisi.seuraavaKahdenPotenssi(0));
        assertEquals(1, Matriisi.seuraavaKahdenPotenssi(1));
        assertEquals(2, Matriisi.seuraavaKahdenPotenssi(2));
        assertEquals(8, Matriisi.seuraavaKahdenPotenssi(5));
        assertEquals(2048, Matriisi.seuraavaKahdenPotenssi(2048));
        assertEquals(4096, Matriisi.seuraavaKahdenPotenssi(2586));
        assertEquals(2048, Matriisi.seuraavaKahdenPotenssi(2047));
    }   
}
