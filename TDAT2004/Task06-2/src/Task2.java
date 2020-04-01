import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        KontoDAO fasade = null;
        try {
            emf = Persistence.createEntityManagerFactory("KontoPersistence");
            fasade = new KontoDAO(emf, true);
            
            System.out.println("oppretter kontoer");
            Konto konto01 = new Konto("1234 1234 1234 1234", 200, "Bernt");
            Konto konto02 = new Konto("1111 2222 3333 4444", 100, "Erling");
            Konto konto03 = new Konto("1234 5678 1234 5678", 0, "Max");
            
            List<Konto> kontoList = fasade.getKontoMerEnn(50);
            System.out.println("Kontoer med større salde enn 50kr");
            for (Konto k : kontoList) {
                System.out.println(k.toString());
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
