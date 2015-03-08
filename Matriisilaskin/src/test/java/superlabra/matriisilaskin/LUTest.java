package superlabra.matriisilaskin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anna
 */
public class LUTest {
    private double[][] m1;
    private double[][] m2;
    private double[][] m3;
    private double[][] m4;
    private double[][] m5;
    
    private Matriisi x;
    private Matriisi y;
    private Matriisi z;
    private Matriisi u;
    private Matriisi t;
    
    private LU laskin;
     
    public LUTest() {
   
    }
    
    @Before
    public void setUp() {
        
        this.laskin = new LU();
        
        this.m1 = new double[][] {{2,0,-5},{1,6,100}};
        this.m2 = new double[][] {{4,3},{6,3}};
        this.m3 = new double[][] {{5}};
        this.m4 = new double[][] {{2,3,1,5},{6,13,5,19},
                                 {2,19,10,23},{4,10,11,31}};
        this.m5 = new double[][] {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        
        this.x = new Matriisi(m1);
        this.y = new Matriisi(m2);
        this.z = new Matriisi(m3);
        this.u = new Matriisi(m4);
        this.t = new Matriisi(m5);
        
        doDoolittle();
    }
    /**
     * Muuttaa matriisit LU -hajotelmamatriisiksi.
     */
    public void doDoolittle() {
        y = laskin.doolittle(y);
        u = laskin.doolittle(u);
        t = laskin.doolittle(t);
        
    }
    @Test
    public void doolittleToimii() {
        double[][] apu1 = {{4,3},{1.5,-1.5}};
        double[][] apu2 = {{2,3,1,5},{3,4,2,4},{1,4,1,2},{2,1,7,3}};
        double[][] apu3 = {{2,-1,-2},{-2,4,-1},{-2,-1,3}};

        assertArrayEquals(apu1, y.getMatriisi());
        assertArrayEquals(apu2, u.getMatriisi());
        assertArrayEquals(apu3, t.getMatriisi());
  
       
    }

    @Test
    public void getLToimii() {
        
        double[][] apu1 = {{1,0},{1.5,1}};
        double[][] apu2 = {{1,0,0,0},{3,1,0,0},{1,4,1,0},{2,1,7,1}};
        double[][] apu3 = {{1,0,0},{-2,1,0},{-2,-1,1}};
        
        assertArrayEquals(apu1, laskin.getL(y).getMatriisi());
        assertArrayEquals(apu2, laskin.getL(u).getMatriisi());
        assertArrayEquals(apu3, laskin.getL(t).getMatriisi());
    }
    
    @Test
    public void getUToimii() {
    
        double[][] apu1 = {{4,3},{0,-1.5}};
        double[][] apu2 = {{2,3,1,5},{0,4,2,4},{0,0,1,2},{0,0,0,3}};
        double[][] apu3 = {{2,-1,-2},{0,4,-1},{0,0,3}};
        
        assertArrayEquals(apu1, laskin.getU(y).getMatriisi());
        assertArrayEquals(apu2, laskin.getU(u).getMatriisi());
        assertArrayEquals(apu3, laskin.getU(t).getMatriisi());
    }
//    
    @Test
    public void determinanttiToimii() {
        
        assertEquals(-6, laskin.determinantti(y), 0.001);
        assertEquals(24, laskin.determinantti(u), 0.001);
        assertEquals(24, laskin.determinantti(t), 0.001);
    }
    
   
    @Test
    public void AonLUnTulo() {
        double[][] tulo1 = {{4,3},{6,3}};
        double[][] tulo2 = {{2,3,1,5},{6,13,5,19},{2,19,10,23},{4,10,11,31}};
        double[][] tulo3 = {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        
        assertArrayEquals(tulo1, laskin.getL(y).matriisitulo(laskin.getU(y)).getMatriisi());
        assertArrayEquals(tulo2, laskin.getL(u).matriisitulo(laskin.getU(u)).getMatriisi());
        assertArrayEquals(tulo3, laskin.getL(t).matriisitulo(laskin.getU(t)).getMatriisi());
    }
    
    
   
    
//    @Test
//    public void kaanteismatriisiToimii() {
//        double[][] inv1 = {{-0.5,0.5},{1,-0.666666666667}}; //oikea tulos
//        double[][] inv2 = {{42.375,-14.875,3.75,-0.5}, // oikea tulos
//                           {-6.25,2.25,-0.5,0},
//                           {61.6666666667,-22,5.6666666667,-0.6666666667},
//                           {-25.3333333333,9,-2.3333333333,0.3333333333}};
//        double[][] inv3 = {{0.4375,0.125,-0.15625}, //oikea tulos
//                           {0.208333333333,0.25,-0.1458333333333},
//                           {0.166666666667 ,0,0.08333333333}};
//        
//        System.out.println("inv1:");
//        laskin.kaanteismatriisi(y); //algoritmin tulos
//        System.out.println(y.toString());
//        System.out.println("inv2");
//        laskin.kaanteismatriisi(u); //algoritmin tulos
//        System.out.println(u.toString());
//        System.out.println("inv3");
//        laskin.kaanteismatriisi(t); //algoritmin tulos
//        System.out.println(t.toString());
        
//        assertArrayEquals(inv1, y.getMatriisi());
//        assertArrayEquals(inv2, u.getMatriisi());
//        assertArrayEquals(inv3, t.getMatriisi());
//       }
    
}
