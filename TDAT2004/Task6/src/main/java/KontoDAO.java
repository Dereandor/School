import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.List;

public class KontoDAO {
    private EntityManagerFactory emf;
    
    public KontoDAO(EntityManagerFactory emf, boolean reset) {
        this.emf = emf;
        EntityManager em = getEM();
        if(reset) {
            try {
                em.getTransaction().begin();
                em.createNativeQuery("TRUNCATE TABLE KONTO").executeUpdate();
            } finally {
                lukkEM(em);
            }
        }
    }
    
    private EntityManager getEM(){
        return emf.createEntityManager();
    }
    
    private void lukkEM(EntityManager em){
        if (em != null && em.isOpen()) em.close();
    }
    
    public void nyKonto(Konto konto) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(konto);
            em.getTransaction().commit();
        } finally {
            lukkEM(em);
        }
    }
    
    public List<Konto> getAlleKontoer() {
        EntityManager em = getEM();
        try {
            Query q = em.createQuery("select OBJECT(o) FROM Konto o");
            return q.getResultList();
        } finally {
            lukkEM(em);
        }
    }
    
    public Konto getKonto(String kontonummer) {
        EntityManager em = getEM();
        int konto = Integer.parseInt(kontonummer);
        try {
            return em.find(Konto.class, kontonummer);
        } finally {
            lukkEM(em);
        }
    }
    
    public void endreKonto(Konto konto) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            Konto k = em.merge(konto);
            em.getTransaction().commit();
        } catch (RollbackException | OptimisticLockException e){
            System.out.println("An optimistic lock exception occured");
        } finally {
            lukkEM(em);
        }
    }
    
    public void slettKonto(String kontonummer) {
        EntityManager em = getEM();
        try {
            Konto k = getKonto(kontonummer);
            em.getTransaction().begin();
            em.remove(k);
            em.getTransaction().commit();
        } finally {
            lukkEM(em);
        }
    }
    
    public List<Konto> getKontoMerEnn(double saldo) {
        EntityManager em = getEM();
        try {
            Query q = em.createQuery("SELECT OBJECT(k) FROM Konto k WHERE k.saldo >= :saldo");
            q.setParameter("saldo", saldo);
            return q.getResultList();
        } finally {
            lukkEM(em);
        }
    }
    
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = null;
        KontoDAO fasade = null;
        System.out.println("starter");
        try {
            emf = Persistence.createEntityManagerFactory("KontoPU");
            
            System.out.println("Konstruktor ferdig: " + emf);
            fasade = new KontoDAO(emf, true);
            System.out.println("konstruktor ferdig");
            
            System.out.println("oppretter kontoer");
            Konto konto01 = new Konto("1234", 200, "Bernt");
            Konto konto02 = new Konto("1111", 100, "Erling");
            Konto konto03 = new Konto("5678", 0, "Max");
            
            fasade.nyKonto(konto01);
            fasade.nyKonto(konto02);
            fasade.nyKonto(konto03);
            
        } finally {
            assert emf != null;
            emf.close();
        }
    }
    
}
