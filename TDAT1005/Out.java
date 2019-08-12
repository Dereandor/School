package lib;

import java.util.ArrayList;

public class Out {

	//boolean
	public static void out(boolean i) {
		System.out.println(""+i);
	}

	public static void out(boolean[] i) {
		for (int n=0;n<i.length;n++) {
			System.out.println(""+i[n]);
		}
	}

	//char
	public static void out(char i) {
		System.out.println(""+i);
	}

	public static void out(char[] i) {
		for (int n=0;n<i.length;n++) {
			System.out.println(""+i[n]);
		}
	}
	
	//Strings
	public static void out(String p) {
		System.out.println(p);
	}

	public static void out(String[] p) {
		for (int n=0;n<p.length;n++) {
			System.out.println(""+p[n]);
		}
	}

	
	//int
	public static void out(int i) {
		System.out.println(""+i);
	}

	//int 1D
	public static void out(int[] i) {
		String separator = "";
		for (int n=0;n<i.length;n++) {
			System.out.print(separator+i[n]);
			separator = ",";
		}
	}

	//int 2D
	public static void out(int[][] i) {
		for (int n=0;n<i.length;n++) {
			out("");
			out(i[n]);
		}
	}

	//int 3D
	public static void out(int[][][] i) {
		for (int n=0;n<i.length;n++) {
			out(i[n]);
		}
	}
	
	//double
	public static void out(double i) {
		System.out.println(""+i);
	}
	
	public static void out(double[] i) {
		for (int n=0;n<i.length;n++) {
			System.out.println(""+i[n]);
		}
	}
	
	//float
	public static void out(float i) {
		System.out.println(""+i);
	}
	
	public static void out(float[] i) {
		for (int n=0;n<i.length;n++) {
			System.out.println(""+i[n]);
		}
	}
	
	//Object
	public static void out(Object[] objects) {
		for (Object object:objects) {
			if (object==null) {
				System.out.println(object);
			}else {
				System.out.println(object.toString());
			}
		}
	}
	
	//ArrayList
	public static void out(ArrayList<Object> objects) {
		for (Object object:objects) {
			System.out.println(object.toString());
		}
	}
	
}
