/* Kake.java  GS + 1ing 02.09.2009*/
class Kake {
  /*********************************/
  /* Attributter - Objektvariabler */
  /*********************************/
	private String ingrediens1;
	private String ingrediens2;
	private int str;
	private String navn;
	private String smak;

  /* Konstruktør */
  public Kake(String ingrediens1, String ingrediens2, int str, String navn, String smak){
	 this.ingrediens1 = ingrediens1;
	 this.ingrediens2 = ingrediens2;
	 this.str = str;
	 this.navn = navn;
	 this.smak = smak;
  }


  /*********************************/
  /* Operasjoner - Metoder:*/
  /*********************************/

  /* Tilgangsmetoder */
  public String getIngrediens1(){
	  return ingrediens1;
  }

  public String getIngrediens2(){
  	  return ingrediens2;
  }

  public int getStr(){
	  return str;
  }

  public String getNavn(){
	  return navn;
  }

  public String getSmak(){
	  return smak;
  }

  /* Objektmetoder */
   public int getAntKakestykker(){
	   int antStk;
	   if (str > 30) {
		   return 20;
	   } else if (str >= 28){
		   return 20;
	   } else if (str >= 24){
		   return 15;
	   } else {
		   return 5;
	   }
   }

   public String toString(){
	   String res = navn + "\n";
	   res += "Ingredienser: " + ingrediens1 + ", " + ingrediens2;
	   res += "\nStørrelse: " + str + "cm";
	   res += "\nKaken smaker " + smak;
	   return res;
   }
}