import org.eclipse.persistence.exceptions.OptimisticLockException;

public class Transfer implements Runnable {
    
    private Konto fra;
    private Konto til;
    private double sum;
    private KontoDAO kontoDAO;
    
    public Transfer(Konto fra, Konto til, double sum, KontoDAO kontoDAO) {
        this.fra = fra;
        this.til = til;
        this.sum = sum;
        this.kontoDAO =kontoDAO;
    }
    
    @Override
    public void run() {
        fra.trekk(sum);
        til.setSaldo(til.getSaldo() + sum);
        try {
            kontoDAO.endreKonto(fra);
            kontoDAO.endreKonto(til);
        } catch (OptimisticLockException o) {
            o.printStackTrace();
        }
    }
}
