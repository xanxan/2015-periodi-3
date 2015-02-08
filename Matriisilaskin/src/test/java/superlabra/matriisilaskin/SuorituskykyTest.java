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
    public void testMatriisienSumma1000x1000() {
        
        double[][] matriisi1 = generoiMatriisi(1000, 1000);
        double[][] matriisi2 = generoiMatriisi(1000, 1000);
        
        Normimatriisi m1 = new Normimatriisi(matriisi1);
        Normimatriisi m2 = new Normimatriisi(matriisi2);
        
        long aloitusaika = System.nanoTime();
        m1.matriisiensumma(m2);
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 1000x1000: " + kulunut);
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
    @Test
    public void testTranspoosi4000x3000() {
        
        double[][] matriisi1 = generoiMatriisi(4000, 300);
       
        
        Normimatriisi m1 = new Normimatriisi(matriisi1);
        
        
        long aloitusaika = System.nanoTime();
        m1.transpoosi();
        long lopetusaika = System.nanoTime();
        long kulunut = lopetusaika - aloitusaika;
        
        System.out.println("Matriisilla 4000x3000: " + kulunut);
        assertTrue(kulunut < 200000000);
        
    }


}
