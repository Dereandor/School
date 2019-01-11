package dp2;

import java.util.Random;
import static lib.Out.*;

public class RandomExample {

	public static void main(String[] args) {
		
		int max =4;
		
		Random randomNum = new Random();
		
		int generated = randomNum.nextInt(max);
		
		out(generated);
	}

}
