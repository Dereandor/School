package V2019;

import java.util.ArrayList;
import static lib.Out.*;


public class Sykehus implements ISykehus{
	private ArrayList<Avdeling> avdelinger = new ArrayList<Avdeling>();

	private final String sykehusNavn;
	
	public Sykehus(String navn) {
		this.sykehusNavn=navn;
	}
	
	public String getSykehusNavn() {
		return sykehusNavn;
	}
		
	public ArrayList<Avdeling> getAvdelinger() {
		return avdelinger;
	}

	public void setAvdelinger(ArrayList<Avdeling> avdelinger) {
		this.avdelinger = avdelinger;
	}

	@Override
	public String toString() {
		String avdelingerStr="";
		String separator="";
		
		for (int i=0;i<avdelinger.size();i++) {
			avdelingerStr+=separator+avdelinger.get(i).toString();
			separator=",";
		}
		
		return "[Sykehus="+sykehusNavn+", avdelinger=" + avdelingerStr+ "]";
	}

	@Override
	public boolean registrer(Object o) {
		boolean registrert=false;
		
		if (o instanceof Avdeling) {
			Avdeling a = (Avdeling)o;
			if (!avdelinger.contains(a)) {
				avdelinger.add(a);
				out("Avdeling "+a.getAvdelingsNavn()+" registrert");
				registrert=true;
			} else {
				out("Avdelingen "+a.getAvdelingsNavn()+" finnes allerede");
			}			
		}
		return registrert;
	}

	@Override
	public boolean fjern(Object o) {
		boolean fjernet=false;
		
		if (o instanceof Avdeling) {
			Avdeling a = (Avdeling)o;
			if (avdelinger.contains(a)) {
				avdelinger.remove(a);
				out("Avdeling "+a.getAvdelingsNavn()+" fjernet");
				fjernet=true;
			}			
		}

		if (o instanceof Pasient) {
			Pasient p = (Pasient)o;
			
			for (int i=0;i<avdelinger.size();i++) {
				if (avdelinger.get(i).getPasienter().contains(p)) {
					avdelinger.get(i).getPasienter().remove(p);
					out("Pasient "+p.getFullNavn()+" fjernet");
					fjernet=true;
					break;
				}
			}
		}
		
		if (o instanceof Ansatt) {
			Ansatt a = (Ansatt)o;
			
			for (int i=0;i<avdelinger.size();i++) {
				if (avdelinger.get(i).getAnsatte().contains(a)) {
					avdelinger.get(i).getAnsatte().remove(a);
					out("Ansatt "+a.getFullNavn()+" fjernet");
					fjernet=true;
					break;
				}
			}
		}
		return fjernet;
	}
}
