package dp4.grensesnitt.eksempel1;

import static lib.Out.out;

public class Dog implements Animal {

   public void eat() {
      out("Dog eats");
   }

   public void travel() {
      out("Dog travels");
   } 

   public int noOfLegs() {
      return 4;
   }
} 