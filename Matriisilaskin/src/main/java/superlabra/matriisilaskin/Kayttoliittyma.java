package superlabra.matriisilaskin;

import java.util.Scanner;

/**
 *  Tekstikäyttöliittymän lopullinen toteutus tulee tänne.
 * @author anna
 */
public class Kayttoliittyma {
        private Matriisi m;
        private Matriisivarasto varasto;
        private Scanner lukija;
        private LU laskin;
    
        public Kayttoliittyma() {
            this.lukija = new Scanner(System.in);
            this.varasto = new Matriisivarasto();
            this.laskin = new LU();
        }
        
        public void Kaynnista() {
            
            
            System.out.println("Matriisilaskin \n");
            
            while(true) {
                System.out.println("Anna komento:");
            
                String komento = lukija.nextLine();
            
                if (komento.equals("x")) {
                    uusiMatriisi();
                } else if (komento.equals("tulo")) {
                    matriisientulo(); 
                } else if (komento.equals("skalaaritulo")) {
                    skalaaritulo();
                } else if (komento.equals("plus")) {
                    yhteenlasku();
                } else if (komento.equals("miinus")) {
                    vahennyslasku();
                } else if (komento.equals("transpoosi")) {
                    transpoosi();
                } else if (komento.equals("determinantti")) {
                    determinantti();
                } else if (komento.equals("l")) {
                    alakolmiomatriisi();
                } else if (komento.equals("u")) {
                    ylakolmiomatriisi();
                } else if (komento.equals("inv")) {
                    kaanteismatriisi();
                } else if (komento.equals("q")){
                    break;
                } 
            
            }
        }
        
        public void uusiMatriisi() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            System.out.println("Anna matriisin pituus ja leveys:");
            int pituus = Integer.parseInt(lukija.nextLine());
            int leveys = Integer.parseInt(lukija.nextLine());
            System.out.println("Syötä matriisi muodossa 1,2;3,4");
            String matriisi = lukija.nextLine();
            Matriisi m = this.varasto.muutaMatriisiksi(matriisi, pituus, leveys);
            m.setNimi(nimi);
            this.varasto.lisaaVarastoon(m);
            System.out.println(nimi + "= \n" + m.toString());
            
        }
        
        public void skalaaritulo() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            System.out.println("Anna vakiokerroin:");
            double kerroin = Double.parseDouble(lukija.nextLine());
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi tulo = m.skalaaritulo(kerroin);
            System.out.println("tulo = \n" + tulo.toString());
            tallenna(tulo);
        
        }
        
        public void matriisientulo() {
            System.out.println("Anna ensimmäisen matriisin nimi:");
            String nimi1 = lukija.nextLine();
            System.out.println("Anna toisen matriisin nimi:");
            String nimi2 = lukija.nextLine();
            Matriisi m1 = varasto.etsiVarastosta(nimi1);
            Matriisi m2 = varasto.etsiVarastosta(nimi2);
            Matriisi tulo = m1.matriisitulo(m2);
            System.out.println("tulo = \n" + tulo.toString());
            tallenna(tulo);
        }
        
        public void yhteenlasku() {
            System.out.println("Anna ensimmäisen matriisin nimi:");
            String nimi1 = lukija.nextLine();
            System.out.println("Anna toisen matriisin nimi:");
            String nimi2 = lukija.nextLine();
            Matriisi m1 = varasto.etsiVarastosta(nimi1);
            Matriisi m2 = varasto.etsiVarastosta(nimi2);
            Matriisi summa = m1.matriisiensumma(m2);
            System.out.println("summa = \n" + summa.toString());
            tallenna(summa);
        }
        
        public void vahennyslasku() {
            System.out.println("Anna ensimmäisen matriisin nimi:");
            String nimi1 = lukija.nextLine();
            System.out.println("Anna toisen matriisin nimi:");
            String nimi2 = lukija.nextLine();
            Matriisi m1 = varasto.etsiVarastosta(nimi1);
            Matriisi m2 = varasto.etsiVarastosta(nimi2);
            Matriisi erotus = m1.matriisienerotus(m2);
            System.out.println("erotus = \n" + erotus.toString());
            tallenna(erotus);
        }
        public void transpoosi() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi transpoosi = m.transpoosi();
            System.out.println("transpoosi = \n" + transpoosi.toString());
            tallenna(transpoosi);
        }
        
        public void determinantti() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi d = laskin.doolittle(m);
            Double det = laskin.determinantti(d);
            System.out.println("Matriisin " + nimi + "determinantti = " + det);
        }
        
        public void alakolmiomatriisi() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi d = laskin.getL(laskin.doolittle(m));
            System.out.println("L-matriisi = \n" + d.toString());
            tallenna(d);
        }
        
        public void ylakolmiomatriisi() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi d = laskin.getU(laskin.doolittle(m));
            System.out.println("U-matriisi = \n" + d.toString());
            tallenna(d);
        }
        
        public void kaanteismatriisi() {
            System.out.println("Anna matriisin nimi:");
            String nimi = lukija.nextLine();
            Matriisi m = varasto.etsiVarastosta(nimi);
            Matriisi inv = laskin.kaanteismatriisi(laskin.doolittle(m));
            System.out.println("Käänteismatriisi = \n" + inv.toString());
            tallenna(inv);
        }
        public void tallenna(Matriisi m) {
            System.out.println("Tallenna matriisi? (k/enter)");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("k")) {
                System.out.println("Anna nimi:");
                String nimi = lukija.nextLine();
                m.setNimi(nimi);
                varasto.lisaaVarastoon(m); 
            }
                
        }
        
        
}
