package dp4.sortering.register.a;

import static lib.Out.out;

import dp4.register.a_b.Register;
import dp4.register.a_b.Utstyr;

public class RegisterKlient {
	private static void initialiserRegister(Register mittRegister) {
		Utstyr[] uTab = new Utstyr[5];
		uTab[0] = new Utstyr("blyant", "Kontor AS", 5, 15);
		uTab[1] = new Utstyr("binders", "Kontor AS", 30, 5);
		uTab[2] = new Utstyr("skriveblokk", "Kontor AS", 20, 5);
		uTab[3] = new Utstyr("viskelær", "Kontor AS", 40, 10);
		uTab[4] = new Utstyr("penn", "Kontor AS", 200, 50);

		for (int i = 0; i < uTab.length; i++) {
			if (mittRegister.regNyttUtstyr(uTab[i])) {
				out("Registrering ok");
			} else {
				out("Registrering ikke ok");
			}
		}		
	}

	public static void main(String[] args) {
		Register mittRegister  = new Register();

		initialiserRegister(mittRegister);
		
		out("\nFør sortering:");
		out(mittRegister);
		
		mittRegister.sorter();
				
		out("\nEtter sortering:");
		out(mittRegister);
	}
}
