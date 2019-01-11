package dp1.innkapsling;

import static lib.Out.*;

public class KontoKlient {

	public static void main(String[] args) {
		Konto k = new Konto(123,"Ola Normann",0);
		
		out(k.getSaldo());

	}

}
