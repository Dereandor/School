DROP TABLE resultat;
DROP TABLE student;
DROP TABLE fag;
DROP TABLE poststed;
DROP TABLE ansatt;

CREATE TABLE student(
  studnr INTEGER,
  fornavn VARCHAR(30) NOT NULL,
  etternavn VARCHAR(30) NOT NULL,
  adresse VARCHAR(30) NOT NULL,
  postnr SMALLINT NOT NULL,
  CONSTRAINT student_pk PRIMARY KEY(studnr));  

CREATE TABLE poststed(
  postnr SMALLINT,
  sted VARCHAR(20) NOT NULL,
  CONSTRAINT poststed_pk PRIMARY KEY(postnr));    

CREATE TABLE ansatt(
  idnr INTEGER,
  fornavn VARCHAR(30) NOT NULL,
  ettenavn VARCHAR(30) NOT NULL,
  leder INTEGER,
  CONSTRAINT ansatt_pk PRIMARY KEY(idnr));  
  
CREATE TABLE fag(
  fagkode CHAR(6),
  fagnavn VARCHAR(30) NOT NULL,
  CONSTRAINT fag_pk PRIMARY KEY(fagkode));

CREATE TABLE resultat(
  studnr INTEGER,
  fagkode CHAR(6),
  karakter CHAR(1),
  CONSTRAINT resultat_pk PRIMARY KEY(studnr, fagkode));

ALTER TABLE student
  ADD CONSTRAINT student_fk1 FOREIGN KEY (postnr)
  REFERENCES poststed(postnr);
  
ALTER TABLE resultat
  ADD CONSTRAINT resultat_fk1 FOREIGN KEY (studnr)
  REFERENCES student(studnr);
  
ALTER TABLE resultat
  ADD CONSTRAINT resultat_fk2 FOREIGN KEY (fagkode)
  REFERENCES fag(fagkode);
  
ALTER TABLE ansatt
  ADD CONSTRAINT ansatt_fk1 FOREIGN KEY (leder)
  REFERENCES ansatt(idnr);

--////////////////////////////////////////////////////////////////////////////////////
-- INSERT, etc

delete from poststed;
INSERT INTO poststed VALUES(1870, 'Ørje');
INSERT INTO poststed VALUES(7025, 'Trondheim');
select * from poststed;

insert into student VALUES(123, 'Ole', 'Olsen', 'xxx', 1870);
insert into student VALUES(125, 'Ole', 'Olsen', 'xxx', 1880);



--////////////////////////////////////////////////////////////////////////////////////
-- Surrogatnøkkel som primærnøkkel, bruk av UNIQUE
CREATE TABLE student(
  id INTEGER AUTO_INCREMENT,
  studnr UNTEGER,
  fornavn VARCHAR(30) NOT NULL,
  etternavn VARCHAR(30) NOT NULL,
  adresse VARCHAR(30) NOT NULL,
  postnr SMALLINT NOT NULL,
  CONSTRAINT student_pk PRIMARY KEY(studnr),
  CONSTRAINT student_uniq UNIQUE(id));  

INSERT INTO student values(DEFAULT, 4567, 'Ole', 'Olsen', 'xxxx', 789);
INSERT INTO student values(DEFAULT, 6666, 'Anne', 'Vik', 'xxxx', 7689);
