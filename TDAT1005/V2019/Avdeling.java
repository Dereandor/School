package V2019;

import java.util.ArrayList;

public class Avdeling{	
	private ArrayList<Ansatt> ansatte = new ArrayList<Ansatt>();
	private ArrayList	<Pasient> pasienter = new ArrayList<Pasient>();

	private String avdelingsNavn;
	
	public void setAvdelingsNavn(String avdelingsNavn) {
		this.avdelingsNavn = avdelingsNavn;
	}

	public String getAvdelingsNavn() {
		return avdelingsNavn;
	}

	public Avdeling(String navn) {
		avdelingsNavn=navn;
	}

	public ArrayList<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(ArrayList<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}

	public ArrayList<Pasient> getPasienter() {
		return pasienter;
	}

	public void setPasienter(ArrayList<Pasient> pasienter) {
		this.pasienter = pasienter;
	}

    @Override
  public boolean equals(Object o) {
        boolean retVal = false;

        if (o instanceof Avdeling){
        	Avdeling a = (Avdeling) o;
            retVal = a.getAvdelingsNavn().equalsIgnoreCase(this.getAvdelingsNavn());
        	//retVal = a.getAvdelingsNavn()==this.getAvdelingsNavn();
        }

     return retVal;
  }
    
	
	@Override
	public String toString() {

		String ansattStr="";
		String pasienterStr="";
		String separator="";
		
		for (int i=0;i<ansatte.size();i++) {
			ansattStr+=separator+ansatte.get(i).toString();
			separator=",";
		}

		separator="";
		for (int i=0;i<pasienter.size();i++) {
			pasienterStr+=separator+pasienter.get(i).toString();
			separator=",";
		}
		
		return "[Avdeling="+avdelingsNavn+", "+ ansattStr + ", "+pasienterStr + "]";
	}
}
