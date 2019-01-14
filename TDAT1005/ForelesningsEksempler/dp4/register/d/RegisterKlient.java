package dp4.register.d;

import static lib.Out.out;

public class RegisterKlient {

	private static void initialiserRegister(Register mittRegister) {

		boolean registrert = mittRegister.regNyttUtstyr("blyant", "Kontor AS", 5, 15)
				&& mittRegister.regNyttUtstyr("binders", "Kontor AS", 30, 5)
				&& mittRegister.regNyttUtstyr("skriveblokk", "Kontor AS", 20, 5)
				&& mittRegister.regNyttUtstyr("viskelær", "Kontor AS", 40, 10)
				&& mittRegister.regNyttUtstyr("penn", "Kontor AS", 200, 50);

		if (registrert) {
			out("Registrering ok");
		} else {
			out("Registrering ikke ok");
		}
	}

	public static void main(String[] args) {
		Register mittRegister = new Register();

		initialiserRegister(mittRegister);
	}
}
