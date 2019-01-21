package dp8.arv.grensenitt;

import static lib.Out.*;

public class InterfaceKlient {

	public static void main(String[] args) {
		out(MyInterface.hello);
				
		MyInterface mi = new MyInterface() {			
			@Override
			public void sayHello() {
				out("Hello from InterfaceKlient!");				
			}
		};
		mi.sayHello();
	}

}
