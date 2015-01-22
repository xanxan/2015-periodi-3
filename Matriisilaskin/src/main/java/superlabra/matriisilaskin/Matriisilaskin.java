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
        int m1 [][] = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        int m2 [][] = {{3,5,9},
                       {5,8,2},
                       {7,2,0}};
        
        Normimatriisi matriisi1 = new Normimatriisi(m1);
        Normimatriisi matriisi2 = new Normimatriisi(m2);
        
        System.out.println("Matriisi 1:");
        tulosta(matriisi1.getMatriisi());
        System.out.println("Matriisi 2:");
        tulosta(matriisi2.getMatriisi());
        
        System.out.println("Matriisi 1 * 5:");
        tulosta(matriisi1.skalaaritulo(5));
        System.out.println("Matriisi 2 * 2:");
        tulosta(matriisi2.skalaaritulo(2));
        
        System.out.println("Matriisi1 + matriisi2:");
     
        tulosta(matriisi1.matriisiensumma(matriisi2));
        System.out.println("Matriisi1 - matriisi2:");
        tulosta(matriisi1.matriisienerotus(matriisi2));
          
        System.out.println("M1 * M2:");
        tulosta(matriisi1.matriisitulo(matriisi2));
        
    }
    
    public static void tulosta(int[][] matriisi) {
         
         for (int i = 0; i < matriisi.length; i++) {
             System.out.print("[ ");
            for (int j = 0; j < matriisi[0].length; j++) {
                System.out.print(matriisi[i][j] + " ");
            }
             System.out.println(" ]");
        }
        
        
    
    }
}
