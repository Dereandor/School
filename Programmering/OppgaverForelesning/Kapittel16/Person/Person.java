/**
 * Person.java

 * @author gs
 */

public class Person {

	private int persnr;
    private String fornavn;
    private String etternavn;

    public String getEtternavn() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public int getPersonnr() {
        return persnr;
    }
    public void setPersonnr(int personnr) {
        this.persnr = personnr;
    }


    public Person(int personnr, String fornavn, String etternavn) {
        this.persnr = personnr;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {
    	// sjekker om obj ikke er tom
        if (obj == null) {
            return false;
        }
        // sjekker at de to objektene som sammenlignes er av samme type
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Person other = (Person) obj;
        if (this.persnr != other.persnr) {
            return false;
        }

        // sjekker at fornavn ikke lik null og om de to fornavnene er like
        if(this.fornavn !=  null && other.fornavn != null){
        	if (!this.fornavn.equals(other.etternavn)){
        		return false;
        	}
        } else { // null pointer exception
        	return false;
        }
        if(this.etternavn !=  null && other.etternavn != null){
        	if (!this.etternavn.equals(other.etternavn)){
        		return false;
        	}
        } else {  // null pointer exception
        	return false;
        }
       /* if ((this.fornavn == null) ? (other.fornavn != null) : !this.fornavn.equals(other.fornavn)) {
            return false;
        }
        if ((this.etternavn == null) ? (other.etternavn != null) : !this.etternavn.equals(other.etternavn)) {
            return false;
        }*/
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public String toString() {
        return persnr + " " + fornavn + " " + etternavn;
    }


}
