/* Spiller.java GS 2009-09-02

* Løsningsforslag øving 4
* - Terning spillet 100.
*/
import java.util.*;

class Spiller{
	String navn;
	int sumPoeng;
	final int VINNER_SUM = 100;

	/* konstruktør */
	public Spiller(String navn){
		this.navn = navn;
		sumPoeng = 0;
	}

	public String getNavn(){
		return navn;
	}

	public int getSumPoeng(){
		return sumPoeng;
	}

	/*  */
	public void kastTerning(){
		Random terning = new Random();
		int terningkast = terning.nextInt(6) + 1;
		sumPoeng += terningkast;
	}

	/* vinnersummet må bli eksakt 100 */
	public void kastTerningAvansert(){
			Random terning = new Random();
			int terningkast = terning.nextInt(6) + 1;

			int tmp = sumPoeng + terningkast;
			if (tmp > VINNER_SUM){
				sumPoeng -= terningkast;
			}else{
				sumPoeng += terningkast;
			}
	}

	public boolean isFerdig(){
		if (sumPoeng >= VINNER_SUM){
			return true;
		} else{
			return false;
		}
	}

	public String toString(){
		return navn + " " + sumPoeng;
	}

	public static void main(String[] args){
		Spiller anne = new Spiller("Anne");
		Spiller berit = new Spiller("Berit");

		boolean vinner = false;
		int rundenr = 1;
		while (!vinner){
			anne.kastTerningAvansert();
			if (anne.isFerdig()){
				vinner = true;
			}else {
				berit.kastTerningAvansert();
				if (berit.isFerdig()){
					vinner = true;
				}
			}
			rundenr++;
			System.out.println(rundenr + ": " + anne + "\t" + berit);
		} // while
	}
}
