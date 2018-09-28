
import static javax.swing.JOptionPane.*;
class RepLokke{
	public static void main(String[] args){

		String tallLest = showInputDialog("Skriv inn et tall: ");
		int tall = Integer.parseInt(tallLest);

		int pos = 0;
		int neg = 0;

		while (tall != 0){
			if(tall > 0){
				pos++; //	pos = pos +1;
			}else{
				neg++;
			} //if-else
			tallLest = showInputDialog("Skriv inn et tall: ");
			tall = Integer.parseInt(tallLest);
		}// while
		showMessageDialog(null, "Antal pos: " + pos + ", antall neg: " + neg);

	} // main
} // class