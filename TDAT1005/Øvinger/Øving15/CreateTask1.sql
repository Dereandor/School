DROP TABLE IF EXISTS kandidatkval;
DROP TABLE IF EXISTS jobbhistorikk;
DROP TABLE IF EXISTS oppdrag;
DROP TABLE IF EXISTS kvalifikasjoner;
DROP TABLE IF EXISTS kandidater;
DROP TABLE IF EXISTS bedrifter;


CREATE TABLE kandidater(
  kandidatid integer not null auto_increment PRIMARY KEY ,
  fornavn varchar(30) not null,
  etternavn varchar(30) not null,
  telefon varchar(15),
  epost varchar(30)
);

CREATE TABLE kandidatkval(
  kandidatid integer not null,
  kvalifikasjonsid integer not null
);

CREATE TABLE bedrifter(
  orgnr integer not null PRIMARY KEY ,
  orgnavn varchar(30) not null,
  telefon varchar(15),
  epost varchar(30)
);

CREATE TABLE oppdrag(
  oppdragsnr integer not null PRIMARY KEY ,
  orgnr integer not null,
  kvalifikasjonsid integer,
  startdato DATE,
  sluttdato DATE
);

CREATE TABLE kvalifikasjoner(
  kvalifikasjonsid integer not null PRIMARY KEY,
  beskrivelse varchar(30)
);

CREATE TABLE jobbhistorikk(
  jobbnr integer not null PRIMARY KEY ,
  oppdragsnr integer not null,
  kandidatid integer not null,
  fakt_startdato DATE,
  fakt_sluttdato DATE,
  ant_timer integer
);

ALTER TABLE kandidatkval
  ADD CONSTRAINT kandidatkval_fk1 FOREIGN KEY(kandidatid)
  REFERENCES kandidater(kandidatid);

ALTER TABLE kandidatkval
  ADD CONSTRAINT kandidatkva_fk2 FOREIGN KEY (kvalifikasjonsid)
references kvalifikasjoner(kvalifikasjonsid);

ALTER TABLE oppdrag
ADD CONSTRAINT oppdrag_fk1 FOREIGN KEY(orgnr)
REFERENCES bedrifter(orgnr);

ALTER TABLE oppdrag
ADD CONSTRAINT oppdrag_fk2 FOREIGN KEY(kvalifikasjonsid)
references kvalifikasjoner(kvalifikasjonsid);

ALTER TABLE jobbhistorikk
ADD CONSTRAINT jobbhisorikk_fk1 FOREIGN KEY (oppdragsnr)
references oppdrag(oppdragsnr);

ALTER TABLE jobbhistorikk
ADD CONSTRAINT jobbhistorikk_fk2 FOREIGN KEY(kandidatid)
references kandidater(kandidatid);

INSERT INTO kandidater(fornavn, etternavn, telefon, epost) VALUES('Ole', 'Olsen', '+4712345678', 'ole@post.no');
INSERT INTO kandidater(fornavn, etternavn, telefon, epost) VALUES('Arne', 'Arnesen', '+4712341551', 'arne@post.no');
INSERT INTO kandidater(fornavn, etternavn, telefon, epost) VALUES('Kari', 'Olsen', '+4799112244', 'kari@post.no');

INSERT INTO bedrifter(orgnr, orgnavn, telefon, epost) VALUES(12345678, 'rør og rot as', '+4711223344', 'post@rorogrot.no');
INSERT INTO bedrifter(orgnr, orgnavn, telefon, epost) VALUES(22446688, 'berntsen as', '+4722114433', 'post@berntsen.no');
INSERT INTO bedrifter(orgnr, orgnavn, telefon, epost) VALUES(99668833, 'incog as', '+4711889944', 'post@incog.no');

INSERT INTO kvalifikasjoner(kvalifikasjonsid, beskrivelse) VALUES(1, 'førerkort');
INSERT INTO kvalifikasjoner(kvalifikasjonsid, beskrivelse) values (2, 'resepsjon');
INSERT INTO kvalifikasjoner(kvalifikasjonsid, beskrivelse) values (3, 'rørlegger');

INSERT INTO kandidatkval(kandidatid, kvalifikasjonsid) VALUES (1, 1);
INSERT INTO kandidatkval(kandidatid, kvalifikasjonsid) VALUES (1, 3);
INSERT INTO kandidatkval(kandidatid, kvalifikasjonsid) VALUES (2, 1);
INSERT INTO kandidatkval(kandidatid, kvalifikasjonsid) VALUES (2, 2);
INSERT INTO kandidatkval(kandidatid, kvalifikasjonsid) VALUES (3, 2);

INSERT INTO oppdrag(oppdragsnr, orgnr, kvalifikasjonsid, startdato, sluttdato) VALUES (1, 12345678, 3, DATE('2018-10-10'), DATE('2019-10-10'));
INSERT INTO oppdrag(oppdragsnr, orgnr, kvalifikasjonsid, startdato, sluttdato) VALUES (2, 22446688, 2, DATE('2018-06-05'), DATE('2018-12-31'));
INSERT INTO oppdrag(oppdragsnr, orgnr, kvalifikasjonsid, startdato, sluttdato) VALUES (3, 99668833, null, DATE('2018-01-01'), DATE('2018-03-02'));

INSERT INTO jobbhistorikk(jobbnr, oppdragsnr, kandidatid, fakt_startdato, fakt_sluttdato, ant_timer) VALUES (1, 2, 3, DATE('2018-06-05'), DATE('2018-12-31'), 640);
INSERT INTO jobbhistorikk(jobbnr, oppdragsnr, kandidatid, fakt_startdato, fakt_sluttdato, ant_timer) VALUES (2, 3, 2, DATE('2018-01-01'), DATE('2018-03-02'), 320);
