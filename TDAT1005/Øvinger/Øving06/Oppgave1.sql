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
--    Hvilke relasjonsoperasjoner krever at operandene er unionkompatible?
--    Sett opp SQL-spørringer som utfører disse operasjonene, et eksempel på hver. Beskriv med egne ord hva spørringene gir deg svaret på.
