import csv
import re
import math


"""
A program for calculating the densities of all the elements based on input .CSV-files
The calculated density is compared to the stated density, and a distance between each
atom in an element is inferred from the difference.
NOTE: We had to update element 16 (Sulfur) as the stated calculated radius was "00".
We assume this was a spelling mistake. 
"""

regex_decimal_only = r"\d+\.?\d*"  # Used when parsing data (String) to separate decimal numbers from text
U = 1.66053906660 * math.pow(10, -27)  # Atomic weight in kg
pico_to_centi = pow(10, 10)  # Convert from piko magnitude to centi magnitude
centi_to_pico = pow(10,-10)


class Element:

    def __init__(self, atomic_no, symbol, name, empirical_atomic_radius, calculated_atomic_radius):
        self.atomicNo = atomic_no
        self.symbol = symbol
        self.name = name
        self.empirical_atomic_radius = empirical_atomic_radius  # cm
        self.calculated_atomic_radius = calculated_atomic_radius  # cm
        self.stated_density = None  # g/cm^3
        self.empirical_density = None  # g/cm^3
        self.calculated_density = None  # g/cm^3 This is calculated in this program
        self.mass = None  # g
        self.empirical_distance_between_atoms = None  # cm
        self.calculated_distance_between_atoms = None  # cm
        self.stated_atoms_per_volume = None # Zetta-atoms/ cm^3
        self.empirical_atoms_per_volume = None # Zetta-atoms/ cm^3
        self.calculated_atoms_per_volume = None # Zetta-atoms/ cm^3


    def printOut(self):
        if(self.stated_density == None):
            self.stated_density = "no data"
        if(self.stated_atoms_per_volume == None):
            self.stated_atoms_per_volume = "no data"
        print('{:<20} {:<20} {:<20} {:>30} {:>30} {:>30} {:>30} {:>30} {:>30} {:>30}'.format(self.atomicNo, self.name, self.stated_density, self.empirical_density, self.calculated_density, self.empirical_distance_between_atoms, self.calculated_distance_between_atoms, self.stated_atoms_per_volume, self.empirical_atoms_per_volume, self.calculated_atoms_per_volume))


    def setDistanceBetweenAtoms(self):
        # Empirical
        if(self.mass != "no data" and self.stated_density != "no data" and self.empirical_atomic_radius != "no data"):
            r = ((3*self.mass)/(4*math.pi*self.stated_density))**(1/3)
            d = float(r) - float(self.empirical_atomic_radius) #Distance between atoms EMPIRICAL
            self.empirical_distance_between_atoms = d

            v = (4 / 3) * math.pi * math.pow(r, 3)  # 🔴
            m = self.mass

            p = m / v
            self.empirical_density = p

            atoms_per_volume = (1/v) * math.pow(10,-21)
            self.empirical_atoms_per_volume = atoms_per_volume

        else:
            self.empirical_density = "no data"
            self.empirical_atoms_per_volume = "no data"
            self.empirical_distance_between_atoms = "no data"

        # Calculated
        if(self.mass != "no data" and self.stated_density != "no data" and self.calculated_atomic_radius != "no data"):
            r = ((3 * self.mass) / (4 * math.pi * self.stated_density)) ** (1 / 3)
            d = float(r) - float(self.calculated_atomic_radius)
            self.calculated_distance_between_atoms = d

            v = (4 / 3) * math.pi * math.pow(r, 3)  # 🔴
            m = self.mass

            p = m/v
            self.calculated_density = p

            atoms_per_volume = (1 / v) * math.pow(10, -21)
            self.calculated_atoms_per_volume = atoms_per_volume
        else:
            self.calculated_density = "no data"
            self.calculated_atoms_per_volume = "no data"
            self.calculated_distance_between_atoms = "no data"


if __name__ == '__main__':

    periodic_table = []

    '''
    Create elements based on parsed csv-data
    '''
    with open('atomicRadii.csv', newline='') as csvfile:
        lines = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in lines:
            if(row[0].startswith("atomic number")):
                continue
            else:
                if(row[3] == "no data" and row[4] == "no data"):
                    element = Element(row[0], row[1], row[2], row[3], row[4])
                    periodic_table.append(element)
                elif (row[3] == "no data" and row[4] != "no data"):
                    element = Element(row[0], row[1], row[2], row[3], float(row[4]) / pico_to_centi)
                    periodic_table.append(element)
                elif (row[4] == "no data" and row[3] != "no data"):
                    element = Element(row[0], row[1], row[2], float(row[3]) / pico_to_centi, row[4])
                    periodic_table.append(element)
                else:
                    element = Element(row[0], row[1], row[2], (float(row[3]) / pico_to_centi), (float(row[4]) / pico_to_centi))
                    periodic_table.append(element)

    '''
    Add empirical data to elements based on csv-data
    '''
    with open('numericDensities.csv', newline='') as csvfile:
        lines = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in lines:
            if(row[0].startswith("Name")):
                continue
            else:
                for element in periodic_table:
                    if(element.atomicNo == row[4]):

                        #read in number of  atoms per volume unit
                        regex_atoms_per_volume = re.search(regex_decimal_only, row[3])
                        if(regex_atoms_per_volume):     
                            element.stated_atoms_per_volume = float(regex_atoms_per_volume.group())
                        else:
                            element.stated_atoms_per_volume = "no data"

                        #reads in stated density  g/cm^3
                        regex_stated_density = re.search(regex_decimal_only, row[2])
                        if(regex_stated_density):

                            element.stated_density = float(regex_stated_density.group())

                        else:
                            element.stated_density = "no data"


    '''
    Add mass to elements based on csv-data and calculate volume & (calculated)density
    '''
    with open('atomic_weight.csv', newline='') as csvfile:
        lines = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in lines:
            for element in periodic_table:
                if(element.atomicNo == row[0]):
                    regex_mass = re.search(regex_decimal_only, row[4])
                    if(regex_mass):
                        element.mass = (float(regex_mass.group()) * U) * 1000#convert to grams
                    else:
                        element.mass = "no data"

    #print table header
    print('{:<20} {:<20} {:<20} {:>30} {:>30} {:>30} {:>30} {:>30} {:>30} {:>30}'.format("ATOMIC_NR", "NAME", "STATED_DENSITY", "EMP.DENSITY", "CALC.DENSITY", "EMP.DIST BETWEEN ATOMS", "CALC.DIST BETWEEN ATOMS", "STATED ATOMS PR VOL", "EMP ATOMS PR VOL", "CALC. ATOMS PR VOL"))

    for element in periodic_table:
        element.setDistanceBetweenAtoms()
        print(element.printOut(), end="\r")