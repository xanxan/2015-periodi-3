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
       LU laskin = new LU();
       
       double[][] m = new double[][] {{2,-1,-2},{-4,6,3},{-4,-2,8}};
       Matriisi matriisi1 = new Matriisi(m);
       
        System.out.println("Alkuperäinen matriisi:");
        System.out.println(matriisi1.toString());
        
        laskin.doolittle(matriisi1);
        
        Matriisi l = new Matriisi(laskin.getL(matriisi1).getMatriisi());
        Matriisi u = new Matriisi(laskin.getU(matriisi1).getMatriisi());
        
        System.out.println("L matriisi:");
        System.out.println(l.toString());
        
        System.out.println("U matriisi:");
        System.out.println(u.toString());
        
        System.out.println("A = LU:");
        System.out.println(l.matriisitulo(u).toString());
        
        double[][] n = new double[][] {{4,3},{6,3}};
        Matriisi matriisi2  = new Matriisi(n);
        laskin.doolittle(matriisi2);
        matriisi2.transpoosi();
        laskin.kaanteismatriisi(matriisi2);
        matriisi2.transpoosi();
        System.out.println(matriisi2.toString());
        
    }
    
    
}
