import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        KontoDAO fasade = null;
        try {
            emf = Persistence.createEntityManagerFactory("KontoPU");
            fasade = new KontoDAO(emf, true);
            
            System.out.println("oppretter kontoer");
            Konto konto01 = new Konto("1234", 200, "Bernt");
            Konto konto02 = new Konto("1111", 100, "Erling");
            Konto konto03 = new Konto("5678", 0, "Max");
    
            fasade.nyKonto(konto01);
            fasade.nyKonto(konto02);
            fasade.nyKonto(konto03);
            
            List<Konto> kontoList = fasade.getKontoMerEnn(0);
            System.out.println("Kontoer med større saldo enn 50kr");
            
            if(kontoList.size () != 0) {
                for (Konto k : kontoList) {
                    System.out.println(k.toString());
                }
            }
            
            System.out.println("endring av navn");
            System.out.println("endrer " + kontoList.get(0).getEier());
            kontoList.get(0).setEier("Mekker");
            fasade.endreKonto(kontoList.get(0));
            System.out.println("nytt navn: " + kontoList.get(0).getEier());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(emf != null) {
                emf.close();
            }
        }
    }
}
