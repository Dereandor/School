package dp4.register.a_b;

import static lib.Out.*;

public class RegisterKlient {

	public static void main(String[] args) {
		Register mittRegister  = new Register();

		
		mittRegister.regNyttUtstyr(new Utstyr("blyant", "Kontor AS", 5, 15));
		mittRegister.regNyttUtstyr(new Utstyr("binders", "Kontor AS", 30, 5));
		mittRegister.regNyttUtstyr(new Utstyr("skriveblokk", "Kontor AS", 20, 5));
		
		out("\nUtskrift 1: ");
		out(mittRegister);
		
		out("\nUtskrift 2: ");
		out(mittRegister.finnAntallRegistrert());
		
		Utstyr s = mittRegister.finnUtstyr(0);
		out("\nUtskrift 3: ");
		out(s);
		
		out("\nUtskrift 4:");
		out(mittRegister.lagBestillingsliste());
		
	}
}
