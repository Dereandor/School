
-- Sett opp en SELECT-setning som er UNION mellom alle forlag med Oslo-nummer (telefonnummer begynner med 2) og alle som ikke er Oslo-nummer.
-- Får du med forlaget med NULL-verdi på telefonnummer? Hvis ikke, utvid unionen med en mengde til.
SELECT * from forlag
where telefon='2*'
union
select * from forlag
where telefon!='2*'
union
select * from forlag
where telefon IS null  ;

-- Sett opp SQL-setninger som finner gjennomsnittlig alder på forfattere der fødselsåret er oppgitt.
-- For forfattere der dødsåret ikke er oppgitt, skal du kun ta med de som er født etter 1900.  Tips for å få ut året i år:
-- MySQL: SELECT YEAR(CURRENT_DATE) FROM ... hvilken tabell som helst ...
select (
           (SELECT sum('2019' - fode_aar) from forfatter where fode_aar>'1900' AND dod_aar IS NULL AND fode_aar IS NOT NULL)
           +
           (SELECT sum(dod_aar - fode_aar) from forfatter where dod_aar IS NOT NULL AND fode_aar IS NOT NULL) )
         /
       (SELECT count(*) from forfatter where (fode_aar IS NOT NULL AND fode_aar>'1900') or (dod_aar IS NOT NULL AND fode_aar IS NOT NULL));


-- Sett opp SQL-setninger som finner hvor stor andel av forfatterne som ble med i beregningene under b).
SELECT (select count(*) from forfatter where (fode_aar IS NOT NULL AND fode_aar>'1900') or (dod_aar IS NOT NULL AND fode_aar IS NOT NULL))
         /
       (select count(*) from forfatter);