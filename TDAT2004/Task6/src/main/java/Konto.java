import java.util.*;
import javax.persistence.*;
import java.io.*;

@Entity
public class Konto implements Serializable {
    @Id
    //@GeneratedValue
    private String kontonummer;
    private double saldo;
    private String eier;
    @Version
    private int version;
    
    public Konto() {
    
    }
    
    public Konto(String kontonummer, double saldo, String eier) {
        this.kontonummer = kontonummer;
        this.saldo = saldo;
        this.eier = eier;
    }
    
    public void trekk(double sum) {
        saldo -= sum;
    }
    
    public void settInn(double sum) {
        saldo += sum;
    }
    
    public String getKontonummer() {
        return kontonummer;
    }
    
    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getEier() {
        return eier;
    }
    
    public void setEier(String eier) {
        this.eier = eier;
    }
    
    @Override
    public String toString() {
        return "Konto{" +
                "kontonummer='" + kontonummer + '\'' +
                ", saldo=" + saldo +
                ", eier='" + eier + '\'' +
                '}';
    }
}
