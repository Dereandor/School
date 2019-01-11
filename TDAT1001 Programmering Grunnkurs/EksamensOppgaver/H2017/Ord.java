class Ord {

    //2a
    private String ord;
    private String[] def;

    //2b
    public Ord(String ord, String[] def) {
        this.ord = ord;
        this.def = def;
    }

    //2c
    public String getOrd() {
        return ord;
    }

    public String[] getDef() {
        return def;
    }
    //2d
    public boolean equals(Object o) {
        //sjekker om o er et ord
        if (!(o instanceof Ord)) {
            return false;
        }
        //sjekker om o referer til det samme objektet
        if (o == this) {
            return true;
        }
        //sjekker at o eksisterer
        if (o = null) {
            return false;
        }
        //setter opp et ord objekt
        Ord test = (Ord) o;
        //sjekker om ordene er like selv om det er små eller store bokstaver.
        if(ord.toLowerCase().equals(test.getOrd().toLowerCase())) {
            return true;
        }

        return false;//ordene er ikke like
    }

    //2e
    public String toString() {
        String result = ord + ":\n";
        for(int i = 0; i<def.length; i++) {
            String temp = i;
            result += (i+1) + ". " + temp + "\n";
        }
        return result;
    }

    //2f
    public void utvid() {
        String[] nyDef = new String[def.length + 1];
        for(int i = 0; i < def.length; i++) {
            nyDef[i] = def[i];
        }

        def = nyDef;
    }

    //2g
    public boolean leggTilDef(String nyDef) {
        for(int i = 0; i < def.length; i++) {
            if(nyDef.toLowerCase().equals(def[i].toLowerCase())) {
                return false;
            }
        }
        if(nyDef = null) {
            return false;
        }

        utvid();
        def[def.length - 1] = nyDef;
        return true;
    }
}
