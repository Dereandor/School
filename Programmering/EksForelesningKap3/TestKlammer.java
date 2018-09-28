class TestKlammer{
	public static void main (String[] args){
	    int a = -10;
	    int b = 20;
	    if (a > 0) {
	          if (b > 10) b = 10;
	    }
	    else a = 0;
	    System.out.println(a + " " + b);


	    int c = -10;
		int d = 20;
		if (c > 0)
		      if (d > 10) d = 10;
		else c = 0;
		System.out.println(c + " " + d);

	}
}