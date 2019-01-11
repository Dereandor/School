package dp2.kap7;

public class Student {

	private final String poststed; //postnr+mellomrom+stedsnavn
	private  int studnr;
	
	public void setStudnr(int studnr) {
		this.studnr = studnr;
	}

	public Student(String poststed, int studnr) {
		this.poststed = poststed;
		this.studnr = studnr;
	}
	
	public String getPoststed() {
		return poststed;
	}
	
	public int getStudnr() {
		return studnr;
	}
	
	public String getStedsnavn( ) {
		int sisteBlanke = poststed.lastIndexOf(' ');
		String sted = poststed.substring(sisteBlanke+1);
		return sted;
	}
	
	public String toString() {
		return "Poststed: "+poststed+", studentnr: "+studnr;
	}
}
