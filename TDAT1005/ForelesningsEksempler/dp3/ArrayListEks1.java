package dp3;

import java.util.ArrayList;

import com.sun.glass.ui.CommonDialogs.Type;

import static lib.Out.*;

public class ArrayListEks1 {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		
		al1.add(10);
		al1.add(20);
		
		out(al1.get(0) instanceof Integer);

	}

}
