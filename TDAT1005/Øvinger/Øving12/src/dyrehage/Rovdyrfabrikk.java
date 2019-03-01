package dyrehage;

public class Rovdyrfabrikk {



    public SkandinaviskeRovdyr nyBinne(String navn, int ankommetDato, int fDato, String adresse){
        return new Hunnindivid("Brunbjoern", "Ursus arctos", "Ursidae", ankommetDato, navn, fDato, true, adresse, 0);
    }

    public SkandinaviskeRovdyr nyHannbjoern(String navn, int ankommetDato, int fDato, String adresse){
        return new Hannindivid("Brunbjoern", "Ursus arctos", "Ursidae", ankommetDato, navn, fDato, true, adresse);
    }

    public SkandinaviskeRovdyr nyUlvetispe(String navn, int ankommetDato, int fDato, String adresse) {
        return new Hunnindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, navn, fDato, true, adresse, 0);
    }

    public SkandinaviskeRovdyr nyUlvehann(String navn, int ankommetDato, int fDato, String adresse) {
        return new Hannindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, navn, fDato, true, adresse);
    }

}