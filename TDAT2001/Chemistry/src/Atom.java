import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Atom {
    
    private static double AMC = 1.66 * Math.pow(10, -27); //Atomic mass constant in kg
    private double avocado = 6.022 * Math.pow(10, 23); // Avogadro's number
    
    private int atomicNo;
    private String atomicSymbol;
    private String name;
    private double empiricalRadius;
    private double calculatedRadius;
    private double density;
    private double empiricalDensity;
    private double calculatedDensity;
    private double mass;
    private double empiricalDistance;
    private double calculatedDistance;
    private double atomsVolume;
    private double empiricalAtomsVolume;
    private double calculatedAtomsVolume;
    
    public Atom(int atomicNo, String atomicSymbol, String name, double empiricalRadius, double calculatedRadius) {
        this.atomicNo = atomicNo;
        this.atomicSymbol = atomicSymbol;
        this.name = name;
        this.empiricalRadius = empiricalRadius;
        this.calculatedRadius = calculatedRadius;
        this.density = 0;
        this.empiricalDensity = 0;
        this.calculatedDensity = 0;
        this.mass = 0;
        this.empiricalDistance = 0;
        this.calculatedDistance = 0;
        this.atomsVolume = 0;
        this.empiricalAtomsVolume = 0;
        this.calculatedAtomsVolume = 0;
    }
    
    public static void distance(Atom a) {
        //Calculating volume and density to estimate distance between atoms based on EMPIRICAL radius from given data
        if(a.mass != 0 && a.density != 0 && a.empiricalRadius != 0) {
            double radius = Math.cbrt((3.0*a.mass)/(4.0*Math.PI*a.density));
            //System.out.println(radius);
            double temp = radius - a.empiricalRadius;
            //System.out.println(temp);
            a.empiricalDistance = temp;
            
            double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);
            a.empiricalDensity = a.mass / volume;
            
            a.empiricalAtomsVolume = (1.0/volume) * Math.pow(10, -21);
            
        } else {
            a.empiricalDistance = 0;
            a.empiricalDensity = 0;
            a.empiricalAtomsVolume = 0;
        }
        
        //Calculating volume and density to estimate distance between atoms based on CALCULATED radius from given data
        if (a.mass != 0 && a.density != 0 && a.calculatedRadius != 0) {
            double radius = Math.cbrt((3.0*a.mass)/(4.0*Math.PI*a.density));
            a.calculatedDistance = radius - a.calculatedRadius;
            
            double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);
            a.calculatedDensity = a.mass / volume;
            
            a.calculatedAtomsVolume = (1.0/volume) * Math.pow(10, -21);
        } else {
            a.calculatedDistance = 0;
            a.calculatedDensity = 0;
            a.calculatedAtomsVolume = 0;
        }
    
    }
    
    public static void main(String[] args) {
    
        ArrayList<Atom> atoms = new ArrayList<>();
        
        BufferedReader br = null;
        String line = "";
        String splitter = ",";
        
        //Read file with atomic radii and create arraylist of all elements
        try {
            br = new BufferedReader(new FileReader("atomicRadius.csv"));
            
            while((line = br.readLine()) != null) {
                if (line.contains("atomic")) {
                    continue;
                } else {
                    String[] data = line.split(splitter);
                    if (data[3].contains("no data") && data[4].contains("no data")) {
                        atoms.add(new Atom(Integer.parseInt(data[0]), data[1], data[2], 0, 0)) ;
                    } else if (data[3].contains("no data") && !(data[4].contains("no data"))) {
                        double temp4 = Math.pow(10, -10) * (Double.parseDouble(data[4]));
                        atoms.add(new Atom(Integer.parseInt(data[0]), data[1], data[2], 0, temp4));
                    } else if (!(data[3].contains("no data")) && data[4].contains("no data")) {
                        double temp3 = Math.pow(10, -10) * (Double.parseDouble(data[3]));
                        atoms.add(new Atom(Integer.parseInt(data[0]), data[1], data[2], temp3, 0));
                    } else {
                        double temp3 = Math.pow(10, -10) * (Double.parseDouble(data[3]));
                        double temp4 = Math.pow(10, -10) * (Double.parseDouble(data[4]));
                        atoms.add(new Atom(Integer.parseInt(data[0]), data[1], data[2], temp3, temp4));
                    }
                
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //read file with densities and add to correct elements in arraylist
        try {
            br = new BufferedReader(new FileReader("densities.csv"));
    
            while ((line = br.readLine()) != null) {
                if(line.contains("Name")) {
                    continue;
                } else {
                    String[] data = line.split(splitter);
                    for (Atom a: atoms) {
                        if (a.atomicNo == Integer.parseInt(data[4])) {
                            String[] temp2 = data[2].split(" ");
                            String[] temp3 = data[3].split(" ");
                            if(temp2.length == 1 && !(temp2[0].equals("Unknown"))) {
                                a.density = Double.parseDouble(temp2[0]);
                            } else {
                                a.density = 0;
                            }
                            if (temp3.length == 1 && !(temp3[0].equals("Unknown"))) {
                                a.atomsVolume = Double.parseDouble(temp3[0]);
                            } else {
                                a.atomsVolume = 0;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //read file with atomic weights and add to correct elements in arraylist
        try {
            br = new BufferedReader(new FileReader("atomicWeightTable.csv"));
            
            while ((line = br.readLine()) != null) {
                if (line.contains("Name")) {
                    continue;
                } else {
                    String[] data = line.split(";");
                    for (Atom a : atoms) {
                        if (a.atomicNo == Integer.parseInt(data[0])) {
                            double temp =
                            a.mass = (Double.parseDouble(data[1]) * AMC) * 1000; //multiply by atomic mass constant and convert to grams.
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //run all atoms in array through distance calculator
        for (Atom a : atoms) {
            distance(a);
        }
    
        System.out.printf("%20s%20s%20s%30s%30s%30s%30s%30s%30s%30s%30s%30s%30s%30s", "AtomicNo", "Symbol", "Name", "empiricalRadius", "calculatedRadius", "density", "empiricalDensity", "calculatedDensity", "mass", "empiricalDistance", "calculatedDistance", "atomsVolume", "empiricalAtomsVolume", "calculatedAtomsVolume");
        System.out.println("");
        
        for (Atom a : atoms) {
            System.out.printf("%20d%20s%20s%30e%30e%30e%30e%30e%30e%30e%30e%30e%30e%30e", a.atomicNo, a.atomicSymbol, a.name, a.empiricalRadius, a.calculatedRadius, a.density, a.empiricalDensity, a.calculatedDensity, a.mass, a.empiricalDistance, a.calculatedDistance, a.atomsVolume, a.empiricalAtomsVolume, a.calculatedAtomsVolume);
            System.out.println("");
        }
    }
}
