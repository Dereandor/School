import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Task34 {
    
    public static Thread transfer(Konto fra, Konto til, double sum, KontoDAO kontoDAO) {
        Transfer trans = new Transfer(fra, til, sum, kontoDAO);
        Thread t1 = new Thread(trans);
        t1.start();
        return t1;
    }
    
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        KontoDAO kontoDAO = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("KontoPU");
            kontoDAO = new KontoDAO(emf, true);
    
            ArrayList<Thread> threads = new ArrayList<>();
    
            Konto konto01 = new Konto("1234", 200, "Bernt");
            Konto konto02 = new Konto("1111", 100, "Erling");
            Konto konto03 = new Konto("5678", 0, "Max");
    
            System.out.println(konto01 + "\n" + konto02);
            
            threads.add(transfer(konto01, konto02, 20, kontoDAO));
            threads.add(transfer(konto02, konto01, 30, kontoDAO));
            
            for(Thread t : threads) {
                t.join();
            }
    
            List<Konto> alle = kontoDAO.getAlleKontoer();
            for (Konto k : alle) {
                System.out.println(k);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(emf != null) {
                emf.close();
            }
        }
    }
}
