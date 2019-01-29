


DROP TABLE IF EXISTS Medlem;
DROP TABLE IF EXISTS Leiligheter;
DROP TABLE IF EXISTS Bygninger;
DROP TABLE IF EXISTS Adresser;
DROP TABLE IF EXISTS Borettslag;

-- Hvert borettslag er oppdelt i hus/blokker med egne adresser,
CREATE TABLE Borettslag(
  bl_id INTEGER AUTO_INCREMENT PRIMARY KEY,
  navn VARCHAR(30) NOT NULL,
  etablering VARCHAR(4) NOT NULL
);

-- Adresser og postnummer
CREATE TABLE Adresser(
  adresse VARCHAR(30) NOT NULL PRIMARY KEY,
  postnr VARCHAR(4) NOT NULL
);

-- Hus/blokk beskrives ved antall etasjer og antall leiligheter.
CREATE TABLE Bygninger(
  byggid INTEGER AUTO_INCREMENT PRIMARY KEY ,
  ant_etasjer INTEGER NOT NULL,
  ant_leil INTEGER NOT NULL,
  bl_id INTEGER,
  adresse VARCHAR(30)
);

-- Leilighetene beskrives vha av antall rom og antall m2, etasje, og et leilighetsnummer.
CREATE TABLE Leiligheter (
  leilighetsnr VARCHAR(10) NOT NULL PRIMARY KEY,
  ant_rom INTEGER NOT NULL,
  ant_m2 INTEGER NOT NULL,
  etasje INTEGER NOT NULL,
  byggid INTEGER NOT NULL
);

-- medlemmer kan ha 0 eller 1 lelighet
CREATE TABLE Medlem(
  medlemsnr INTEGER AUTO_INCREMENT PRIMARY KEY,
  fornavn VARCHAR(30) NOT NULL,
  etternavn VARCHAR(30) NOT NULL,
  leilighetsnr VARCHAR(10)
);


ALTER TABLE Medlem AUTO_INCREMENT=1000;

ALTER TABLE Bygninger ADD CONSTRAINT Bygninger_fk1 FOREIGN KEY(bl_id) REFERENCES Borettslag(bl_id);
ALTER TABLE Bygninger ADD CONSTRAINT Bygninger_fk2 FOREIGN KEY (adresse) REFERENCES Adresser(adresse);
ALTER TABLE Leiligheter ADD CONSTRAINT Leiligheter_fk FOREIGN KEY (byggid) REFERENCES Bygninger(byggid);
ALTER TABLE Medlem ADD CONSTRAINT Medlem_fk FOREIGN KEY (leilighetsnr) REFERENCES Leiligheter(leilighetsnr);

-- insert borettslag
INSERT INTO Borettslag(bl_id, navn, etablering) VALUES(default, 'Test 1', '1990');
INSERT INTO Borettslag(bl_id, navn, etablering) VALUES(default, 'Test 2', '1992');

-- insert adresser
INSERT INTO Adresser(adresse, postnr) VALUES( 'Ratesvingen 12', '7038');
INSERT INTO Adresser(adresse, postnr) VALUES( 'Ratesvingen 14', '7038');
INSERT INTO Adresser(adresse, postnr) VALUES( 'Ratesvingen 16', '7038');
INSERT INTO Adresser(adresse, postnr) VALUES( 'Ratesvingen 18', '7038');

-- insert bygninger
INSERT INTO Bygninger(byggid, ant_etasjer, ant_leil, bl_id, adresse) VALUES(default, '6', '48', '1', 'Ratesvingen 12');
INSERT INTO Bygninger(byggid, ant_etasjer, ant_leil, bl_id, adresse) VALUES(default, '6', '48', '1', 'Ratesvingen 14');
INSERT INTO Bygninger(byggid, ant_etasjer, ant_leil, bl_id, adresse) VALUES(default, '4', '16', '2', 'Ratesvingen 16');
INSERT INTO Bygninger(byggid, ant_etasjer, ant_leil, bl_id, adresse) VALUES(default, '4', '16', '2', 'Ratesvingen 18');


-- insert leiligheter
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('A101', '2', '40', '1', '1');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('A102', '2', '40', '1', '1');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('A201', '3', '70', '2', '1');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('A202', '3', '70', '2', '1');

INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('B101', '2', '40', '1', '2');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('B102', '2', '40', '1', '2');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('B201', '3', '70', '2', '2');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('B202', '3', '70', '2', '2');

INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('C101', '2', '40', '1', '3');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('C102', '2', '40', '1', '3');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('C201', '3', '70', '2', '3');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('C202', '3', '70', '2', '3');

INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('D101', '2', '40', '1', '4');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('D102', '2', '40', '1', '4');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('D201', '3', '70', '2', '4');
INSERT INTO Leiligheter(leilighetsnr, ant_rom, ant_m2, etasje, byggid) VALUES('D202', '3', '70', '2', '4');


-- insert medlemmer
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Arne', 'Arnesen', 'A101');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Bernt', 'Berntsen', 'A102');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Chris', 'Christophersen', 'A201');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Dennis', 'Dennisen', 'A202');

INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Erik', 'Eriksen', 'B101');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Fredrik', 'Fredriksen', 'B102');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Geir', 'Geirsen', 'B201');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Helge', 'Helgesen', 'B202');

INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Ivar', 'Ivarsen', 'C101');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Jonas', 'Jonasen', 'C102');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Knut', 'Knutsen', 'C201');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Lars', 'Larsen', 'C202');

INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Mads', 'Madsen', 'D101');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Nils', 'Nilsen', 'D102');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Ove', 'Ovesen', 'D201');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn, leilighetsnr) VALUES(default, 'Per', 'Pershaug', 'D202');

INSERT INTO Medlem(medlemsnr, fornavn, etternavn) VALUES(default, 'Roger', 'Rogersen');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn) VALUES(default, 'Sigurd', 'Sigurdsen');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn) VALUES(default, 'Trond', 'Trondshaug');
INSERT INTO Medlem(medlemsnr, fornavn, etternavn) VALUES(default, 'Ulf', 'Ulfdal');