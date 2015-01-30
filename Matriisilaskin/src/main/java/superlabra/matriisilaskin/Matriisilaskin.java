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
        double m2 [][] = {{1,3,-2},
                       {0,-4,12},
                       {0,-2,7}};
        double m1 [][] = {{4,3},
                       {6,3}};
        
        Normimatriisi matriisi1 = new Normimatriisi(m1);
        Normimatriisi matriisi2 = new Normimatriisi(m2);
        LUmatriisi matriisi3 = new LUmatriisi(m1);
        
        System.out.println("Matriisi 1:");
        tulosta(matriisi1.getMatriisi());
//        System.out.println("Matriisi 2:");
//        tulosta(matriisi2.getMatriisi());
//        
//        System.out.println("doolittle");
//        LUmatriisi m4 = new LUmatriisi(matriisi3.doolittle());
//        tulosta(m4.getMatriisi());
//        
//        System.out.println("");
//        
//        System.out.println("hajotelmat");
//        tulosta(m4.getL());
//        tulosta(m4.getU());
           tulosta(matriisi3.doolittle());
          System.out.println("jee  " + matriisi3.determinantti());;
    }
    
    
    public static void tulosta(double[][] matriisi) {
         
         for (int i = 0; i < matriisi.length; i++) {
             System.out.print("[ ");
            for (int j = 0; j < matriisi[0].length; j++) {
                System.out.print(matriisi[i][j] + " ");
            }
             System.out.println(" ]");
        }
       
    }
}
