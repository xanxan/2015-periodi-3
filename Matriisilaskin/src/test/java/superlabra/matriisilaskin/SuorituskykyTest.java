package superlabra.matriisilaskin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
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
public class SuorituskykyTest {
    private LU laskin;
    
    public SuorituskykyTest() {
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
    
    public long getNaiivinMatriisitulonAika(int sivu) {
        double[][] matriisi1 = generoiMatriisi(sivu, sivu);
        double[][] matriisi2 = generoiMatriisi(sivu, sivu);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        
        return kulunutAika(aloitusaika);
    }
    
    public long getStrassentulonAika(int sivu) {
        double[][] matriisi1 = generoiMatriisi(sivu, sivu);
        double[][] matriisi2 = generoiMatriisi(sivu, sivu);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        
        return kulunutAika(aloitusaika);
    }
     
    @Before
    public void setUp() {
        this.laskin = new LU();
    }
    
    @Test
    public void naiivinMatriisitulonAika1x1a() {
        double[][] matriisi1 = generoiMatriisi(1, 1);
        double[][] matriisi2 = generoiMatriisi(1, 1);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulon vakioaika 1x1: " + kulunut);
    }
    @Test
    public void naiivinMatriisitulonAika10x10() {
        
        double[][] matriisi1 = generoiMatriisi(10, 10);
        double[][] matriisi2 = generoiMatriisi(10, 10);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulo 10x10: " + kulunut);
        assertTrue(kulunut <= Math.pow(getNaiivinMatriisitulonAika(1), 3));
        
    }
    @Test
    public void naiivinMatriisitulonAika50x50() {
        
        double[][] matriisi1 = generoiMatriisi(50, 50);
        double[][] matriisi2 = generoiMatriisi(50, 50);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulo 50x50: " + kulunut);
        assertTrue(kulunut <= Math.pow(getNaiivinMatriisitulonAika(5), 3));
        
    }
    @Test
    public void naiivinMatriisitulonAika100x100() {
        
        double[][] matriisi1 = generoiMatriisi(100, 100);
        double[][] matriisi2 = generoiMatriisi(100, 100);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulo 100x100: " + kulunut);
        assertTrue(kulunut <= Math.pow(getNaiivinMatriisitulonAika(10), 3));
        
    }
      @Test
    public void naiivinMatriisitulonAika500x500() {
        
        double[][] matriisi1 = generoiMatriisi(500, 500);
        double[][] matriisi2 = generoiMatriisi(500, 500);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulo 500x500: " + kulunut);
        assertTrue(kulunut <= Math.pow(getNaiivinMatriisitulonAika(50), 3));
        
    }
    
    @Test
    public void naiivinMatriisitulonAika1000x1000() {
        double[][] matriisi1 = generoiMatriisi(1000, 1000);
        double[][] matriisi2 = generoiMatriisi(1000, 1000);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Matriisitulo 1000x1000: " + kulunut);
        assertTrue(kulunut <= Math.pow(getNaiivinMatriisitulonAika(100), 3));
    }
    
    @Test
    public void strassentulonAika1x1() {
        double[][] matriisi1 = generoiMatriisi(1, 1);
        double[][] matriisi2 = generoiMatriisi(1, 1);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 1x1: " + kulunut);
        
    }
    
    @Test
    public void strassentulonAika10x10() {
        double[][] matriisi1 = generoiMatriisi(10, 10);
        double[][] matriisi2 = generoiMatriisi(10, 10);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 10x10: " + kulunut);
        assertTrue(kulunut <= Math.pow(getStrassentulonAika(1), 2.8074));
    }
    
     @Test
    public void strassentulonAika50x50() {
        double[][] matriisi1 = generoiMatriisi(50, 50);
        double[][] matriisi2 = generoiMatriisi(50, 50);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 50x50: " + kulunut);
        assertTrue(kulunut <= Math.pow(getStrassentulonAika(5), 2.8074));
    }
    @Test
    public void strassentulonAika100x100() {
        double[][] matriisi1 = generoiMatriisi(100, 100);
        double[][] matriisi2 = generoiMatriisi(100, 100);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 100x100: " + kulunut);
        assertTrue(kulunut <= Math.pow(getStrassentulonAika(10), 2.8074));
    }
      @Test
    public void strassentulonAika500x500() {
        double[][] matriisi1 = generoiMatriisi(500, 500);
        double[][] matriisi2 = generoiMatriisi(500, 500);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 500x500: " + kulunut);
        assertTrue(kulunut <= Math.pow(getStrassentulonAika(50), 2.8074));
    }
    
    @Test
    public void strassentulonAika1000x1000() {
        double[][] matriisi1 = generoiMatriisi(1000, 1000);
        double[][] matriisi2 = generoiMatriisi(1000, 1000);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.strassentulo(m2);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Strassentulo 1000x1000: " + kulunut);
        assertTrue(kulunut <= Math.pow(getStrassentulonAika(100), 2.8074));
    }
    
    @Test
    public void testMatriisienSumma1000x1000() {
        
        double[][] matriisi1 = generoiMatriisi(1000, 1000);
        double[][] matriisi2 = generoiMatriisi(1000, 1000);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisiensumma(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 1000x1000: " + kulunut);
        assertTrue(kulunut < 30000000);
        
    }
    
    @Test
    public void testMatriisikertolasku10x50X40x10() {
        
        double[][] matriisi1 = generoiMatriisi(10, 50);
        double[][] matriisi2 = generoiMatriisi(40, 10);
        
        Matriisi m1 = new Matriisi(matriisi1);
        Matriisi m2 = new Matriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisitulo(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 10x50X40x10: " + kulunut);
        assertTrue(kulunut < 3000000);
        
    }
    @Test
    public void testTranspoosi4000x3000() {
        
        double[][] matriisi1 = generoiMatriisi(4000, 300);
       
        
        Matriisi m1 = new Matriisi(matriisi1);
        
        
        long aloitusaika = System.nanoTime();
        m1.transpoosi();
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 4000x3000: " + kulunut);
        assertTrue(kulunut < 300000000);
        
    }

    @Test
    public void testdoolittle10x10() {
        
        double[][] matriisi1 = generoiMatriisi(10, 10);
        Matriisi m = new Matriisi(matriisi1);
        long aloitusaika = System.nanoTime();
        
        laskin.doolittle(m);
        
        
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Doolittle matriisilla 10x10: " + kulunut);
        assertTrue(kulunut < 300000);
        
    }
    
      @Test
    public void testdoolittle100x100() {
        
        double[][] matriisi1 = generoiMatriisi(100, 100);
        Matriisi m = new Matriisi(matriisi1);
       
        
        long aloitusaika = System.nanoTime();
        this.laskin.doolittle(m);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Doolittle matriisilla 100x100: " + kulunut);
        assertTrue(kulunut < 90000000);
        
    }
    
      @Test
    public void testdoolittle500x500() {
        
        double[][] matriisi1 = generoiMatriisi(500, 500);
        Matriisi m = new Matriisi(matriisi1);
       
        
        long aloitusaika = System.nanoTime();
        this.laskin.doolittle(m);
        long kulunut = kulunutAika(aloitusaika);
        
        System.out.println("Doolittle matriisilla 500x500: " + kulunut);
        assertTrue(kulunut < 900000000);
        
    }

}
