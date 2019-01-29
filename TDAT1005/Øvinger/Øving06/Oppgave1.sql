-- a) Lag en SQL-spørring som utfører operasjonene seleksjon og projeksjon på tabellen Bok
SELECT * FROM bok;

SELECT DISTINCT tittel
FROM bok;

-- b) Lag en SQL-spørring som utfører operasjonen produkt på tabellene Forlag og Bok. Beskriv resultatet med egne ord.
SELECT * FROM bok, forlag;

-- c) Lag SQL-spørringer som utfører operasjonene likhetsforening (equijoin) og naturlig forening (natural join) på tabellene Forlag og Bok.
--    Hva forteller resultatet?

SELECT * FROM bok JOIN forlag f on bok.forlag_id = f.forlag_id; -- likhetsforening

Select * FROM bok NATURAL JOIN forlag;

-- d) Finn eksempler på attributter eller kombinasjoner av attributter som er unionkompatible.
/*
For at to tabeller skal være unionkompatible må antall kolonner of kolonnerekkefølge være lik i begge tabeller
SELECT må resultere i samme antall kolonner, navnene kan være forskjellige og de må ikke ha samme størrelse
og datatype.
 */
--    Hvilke relasjonsoperasjoner krever at operandene er unionkompatible?
--  UNION SNITT OG DIFFERANSE
--    Sett opp SQL-spørringer som utfører disse operasjonene, et eksempel på hver. Beskriv med egne ord hva spørringene gir deg svaret på.

SELECT DISTINCT bok.forlag_id FROM bok JOIN forlag
  ON(bok.forlag_id = forlag.forlag_id);
-- finner felles rader i tabellene bok og forlag

SELECT forlag.forlag_id FROM forlag
  LEFT JOIN bok ON (bok.forlag_id = forlag.forlag_id)
WHERE bok.forlag_id IS NULL:
-- finner forskjellen mellom de to tabellene.
