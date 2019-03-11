public class Valuta {
    private String name;
    private double value;
    private int unit;

    public Valuta(String name, double value, int unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double beregnTilNOK(double antall) {
        return antall * value / unit;
    }

    public double beregnFraNOK(double antall) {
        return antall / value * unit;
    }
}
/*
            new Valuta("Euro", 8.10, 1),
            new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1),
            new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100),
            new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100),
            new Valuta("Norske kroner", 100, 100)
 */
