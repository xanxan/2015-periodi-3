package superlabra.matriisilaskin;

import java.util.Random;
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
    private double[][] m4 = {{5}};
    private double[][] m5 = {{1,2,3}};
   
    private Normimatriisi x;
    private Normimatriisi y;
    private Normimatriisi z;
    private Normimatriisi k;
    private Normimatriisi i;
    
    public NormimatriisiTest() {
        this.x = new Normimatriisi(m1);
        this.y = new Normimatriisi(m2);
        this.z = new Normimatriisi(m3);
        this.k = new Normimatriisi(m4);
        this.i = new Normimatriisi(m5);
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
    public long kulunutAika(long aloitusaika) {
        return System.nanoTime() - aloitusaika;
    }
    @Test
    public void testMatriisikertolasku10x10() {
        
        double[][] matriisi1 = generoiMatriisi(10, 10);
        double[][] matriisi2 = generoiMatriisi(10, 10);
        
        Normimatriisi m1 = new Normimatriisi(matriisi1);
        Normimatriisi m2 = new Normimatriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 10x10: " + kulunut);
        assertTrue(kulunut < 200000);
        
    }
    
    @Test
    public void testMatriisikertolasku100x100() {
        
        double[][] matriisi1 = generoiMatriisi(100, 100);
        double[][] matriisi2 = generoiMatriisi(100, 100);
        
        Normimatriisi m1 = new Normimatriisi(matriisi1);
        Normimatriisi m2 = new Normimatriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 100x100: " + kulunut);
        assertTrue(kulunut < 20000000);
        
    }
    
    @Test
    public void testMatriisikertolasku10x50X40x10() {
        
        double[][] matriisi1 = generoiMatriisi(10, 50);
        double[][] matriisi2 = generoiMatriisi(40, 10);
        
        Normimatriisi m1 = new Normimatriisi(matriisi1);
        Normimatriisi m2 = new Normimatriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 10x50X40x10: " + kulunut);
        assertTrue(kulunut < 2000000);
        
    }
    /**
     * Test of skalaaritulo method, of class Normimatriisi.
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
               
             assertEquals(ma[i][j], x.skalaaritulo(a)[i][j], 0.001);
             assertEquals(m1[i][j], x.skalaaritulo(b)[i][j], 0.001);
             assertEquals(mc[i][j], x.skalaaritulo(c)[i][j], 0.001);
             assertEquals(md[i][j], x.skalaaritulo(d)[i][j], 0.001);
       
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
        Normimatriisi t = new Normimatriisi(tyhja);
        
        assertFalse(x.koontarkistus(t));
        assertFalse(x.onkoKerrottavissa(t));
    }
    
    @Test
    public void testMatriisiensumma() {
        
         double[][] summa = {{7,0,5},
                         {-3,3,101}};
         
         assertArrayEquals(summa, x.matriisiensumma(y));
         
         
         
    }

    /**
     * Test of matriisienerotus method, of class Normimatriisi.
     */
    @Test
    public void testMatriisienerotus() {
          double[][] erotus = {{-3,0,-15},
                           {5,9,99}};
         
          assertArrayEquals(erotus, x.matriisienerotus(y));
    }

    /**
     * Test of matriisitulo method, of class Normimatriisi.
     */
    @Test
    public void testMatriisitulo() {
          double[][] tulo1 = {{-4,-3,1},
                         {86,27,91}};
          double[][] tulo2 = {{5,10,15}};
          
          assertArrayEquals(tulo1, z.matriisitulo(y));
          assertArrayEquals(tulo2, k.matriisitulo(i));
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
        
        double[][] transpoosi = {{0,10},
                              {1, -9}};
        double[][] yksi = {{5}};
        assertArrayEquals(transpoosi, z.transpoosi());
        assertArrayEquals(yksi, k.transpoosi());
        
    }
}
