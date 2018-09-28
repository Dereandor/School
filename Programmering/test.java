import static javax.swing.JOptionPane.*;

class test {

	public static void main(String[]args) {

		 int tall = 3;

int tall2 = -1;

       switch (tall){

           case 1:

               tall2 = 1;

 

           case 2:

               tall2 = 2;

 

           case 3:

               tall2 = 3;

 

           case 4:

               tall2 = 4;

 

               break;

           default:

               System.out.println("default");

               break;

       }

       if(tall == tall2){

           System.out.print("like");

       }else{

           System.out.print("ulike");

       }
	}
}