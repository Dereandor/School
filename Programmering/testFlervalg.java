import static javax.swing.JOptionPane.*;

class testFlervalg {

    public static void main(String[]args){

        int a = 3;

        int b = 6;

        int c = 2;

 

        int x = (a - c + b);

        if (x < 2 * a){ 
			System.out.println("B: " + b); 
		} else if (x > 2 * a){
			System.out.println("X : " + x);
		} else { 
			System.out.println ("C: " + c); 
		}

      }

}