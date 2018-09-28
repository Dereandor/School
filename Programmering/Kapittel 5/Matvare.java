
import static javax.swing.JOptionPane.*;
class Matvare {
	private final String navn;
	private final double energi;
	private final double fett;
	private final double carbs;

	public Matvare(String navn, double energi, double fett, double carbs){
		this.navn = navn;
		this.energi = energi;
		this.fett = fett;
		this.carbs = carbs;
	}
	public String getNavn(){
		return navn;
	}
	public double getFett(double gram){
		return fett;
	}
	public double getCarbs(double gram){
		return carbs;
	}
	public double getEnergiKJ(double gram){
		return energi * gram * 0.01;
	}
	public double getEnergiKcal(double gram){
		return energi * gram * 0.01 * 4.18;
	}
}