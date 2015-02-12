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
       Matriisi matriisi = new Matriisi(m);
       
        System.out.println("Alkuperäinen matriisi:");
        System.out.println(matriisi.toString());
        
        laskin.doolittle(matriisi);
        
        Matriisi l = new Matriisi(laskin.getL(matriisi).getMatriisi());
        Matriisi u = new Matriisi(laskin.getU(matriisi).getMatriisi());
        
        System.out.println("L matriisi:");
        System.out.println(l.toString());
        
        System.out.println("U matriisi:");
        System.out.println(u.toString());
        
        System.out.println("A = LU:");
        System.out.println(l.matriisitulo(u).toString());
        
    }
    
    
}
