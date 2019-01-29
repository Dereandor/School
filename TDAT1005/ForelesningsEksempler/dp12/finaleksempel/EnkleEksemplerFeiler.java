package dp12.finaleksempel;

 /*final*/class PersonalLoan {
	public final String getName() {
		return "personal loan";
	}
}

class CheapPersonalLoan extends PersonalLoan {// Kompileringsfeil
	
}


public class EnkleEksemplerFeiler {

	public static final String LOAN = "loan";

	public static void main(String[] args) {
//		LOAN = new String("loan"); //Kompileringsfeil
	}
}
