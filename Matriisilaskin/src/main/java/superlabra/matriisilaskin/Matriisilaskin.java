package superlabra.matriisilaskin;

/**
 * Hello world!
 *
 */
public class Matriisilaskin 
{
    public static void main( String[] args )
    {
         // Testikenttä 
        double[][] m1 = new double[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        double[][] m2 = new double[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        Matriisi M1 = new Matriisi(m1);
        Matriisi M2 = new Matriisi(m2);
        System.out.println(M1.strassentulo(M2).toString());
        Kayttoliittyma k = new Kayttoliittyma();
//        k.Kaynnista();
//       LU laskin = new LU();
//       
//       double[][] m = new double[][] {{2,-1,-2},{-4,6,3},{-4,-2,8}};
//       Matriisi matriisi1 = new Matriisi(m);
//       
//        System.out.println("Alkuperäinen matriisi:");
//        System.out.println(matriisi1.toString());
//        
//        laskin.doolittle(matriisi1);
//        
//        Matriisi l = new Matriisi(laskin.getL(matriisi1).getMatriisi());
//        Matriisi u = new Matriisi(laskin.getU(matriisi1).getMatriisi());
//        
//        System.out.println("L matriisi:");
//        System.out.println(l.toString());
//        
//        System.out.println("U matriisi:");
//        System.out.println(u.toString());
//        
//        System.out.println("A = LU:");
//        System.out.println(l.matriisitulo(u).toString());
//        
//        double[][] n = new double[][] {{4,3},{6,3}};
//        Matriisi matriisi2  = new Matriisi(n);
//        laskin.doolittle(matriisi2);
//        matriisi2.transpoosi();
//        laskin.kaanteismatriisi(matriisi2);
//        matriisi2.transpoosi();
//        System.out.println(matriisi2.toString());
//        
//        Matriisivarasto varasto = new Matriisivarasto();
//        System.out.println("Merkkijono: 4,3,1.5,100;6,3,0,0.004;3,70,-4,1");
//        String merkkijono = "3,4;5, ;8,7";
//        Matriisi matriisi = varasto.muutaMatriisiksi(merkkijono, 3, 2);
//        System.out.println(matriisi.toString());
        
    }
    
    
}
