// En klassemetode som summerer to tabeller som argumenter
// og returnerer en tabell med summen av hvert element i de to tabellene

class tabellSum{
	public static int[] sumTabell(int[] t1, int[] t2){
		if(t1.length == t2.length){ 			// sjekker at tabellene er like lange
			int[] sumTab = new int[t1.length]; 	// oppretter en ny tabell
			for(int i=0; i<t1.length; i++){
				sumTab[i] = t1[i] + t2[i];		// summer elementene
			} // end for løkke
			return sumTab;						// returnerer sumtabellen
		}
		else{
			return null;
		} // end if-else

	} // end sumTabell
} // end class tabellSum








class Opg914{
	public static void main(String[] args){

		int[] t3 = {1,2,3,4};
		int[] t4 = {3,2,1,6};
		int[] totalSum = tabellSum.sumTabell(t3, t4);

		if (totalSum != null){
			for(int i=0; i < totalSum.length; i++){
				 System.out.print(totalSum[i]);
				 System.out.print("   ");

			}
		}else System.out.println("Tabellene er ikke like lange");

	} // end main
} // end class Opg914

