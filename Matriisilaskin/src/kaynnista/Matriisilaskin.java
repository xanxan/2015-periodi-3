package kaynnista;

/**
 *
 * @author anna
 */
public class Matriisilaskin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testikenttä 
        int m1 [][] = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        int m2 [][] = {{3,5,9},
                       {5,8,2},
                       {7,2,0}};
        
        Normimatriisi matriisi1 = new Normimatriisi(3, 3, m1);
        Normimatriisi matriisi2 = new Normimatriisi(3, 3, m2);
        
        System.out.println("Matriisi 1:");
        tulosta(3, 3, matriisi1.getMatriisi());
        System.out.println("Matriisi 2:");
        tulosta(3, 3, matriisi2.getMatriisi());
        
        System.out.println("Matriisi 1 * 5:");
        tulosta(3, 3, matriisi1.skalaaritulo(5));
        System.out.println("Matriisi 2 * 2:");
        tulosta(3, 3, matriisi2.skalaaritulo(2));
        
        System.out.println("Matriisi1 + matriisi2:");
     
        tulosta(3, 3, matriisi1.matriisiensumma(matriisi2));
        System.out.println("Matriisi1 - matriisi2:");
        tulosta(3, 3, matriisi1.matriisienerotus(matriisi2));
            
        
    }
    
    public static void tulosta(int p, int l, int[][] matriisi) {
         
         for (int i = 0; i < p; i++) {
             System.out.print("[ ");
            for (int j = 0; j < l; j++) {
                System.out.print(matriisi[i][j] + " ");
            }
             System.out.println(" ]");
        }
        
        
    }
}
