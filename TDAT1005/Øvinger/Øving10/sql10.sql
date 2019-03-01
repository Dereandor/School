-- oppgave 1 Finn alle borettslag etablert i årene 1975-1985.
SELECT * FROM borettslag
WHERE etabl_aar BETWEEN 1975 and 1985;

-- oppgave 2Skriv ut en liste over andelseiere. Listen skal ha linjer som ser slik ut (tekster i kursiv er data fra databasen):
-- "fornavn etternavn, ansiennitet: ansiennitet år".
-- Listen skal være sortert på ansiennitet, de med lengst ansiennitet øverst.
SELECT fornavn, etternavn, ansiennitet FROM andelseier
ORDER BY ansiennitet DESC;

-- oppgave 3 I hvilket år ble det eldste borettslaget etablert?
SELECT MIN(etabl_aar) AS Oldest
FROM borettslag;

-- oppgave 4 Finn adressene til alle bygninger som inneholder leiligheter med minst tre rom.
SELECT bygn_adr FROM bygning
LEFT JOIN leilighet l on bygning.bygn_id = l.bygn_id
WHERE ant_rom >2;

-- oppgave 5 Finn antall bygninger i borettslaget "Tertitten".
SELECT COUNT(b.bolag_navn) FROM bygning
left join borettslag b on bygning.bolag_navn = b.bolag_navn
WHERE b.bolag_navn='Tertitten';

-- oppgave 6 Lag en liste som viser antall bygninger i hvert enkelt borettslag.
-- Listen skal være sortert på borettslagsnavn. Husk at det kan finnes borettslag uten bygninger - de skal også med.
SELECT b.bolag_navn, COUNT(bygn_id) FROM borettslag
left join bygning b on borettslag.bolag_navn = b.bolag_navn
GROUP BY b.bolag_navn DESC;

-- oppgave 7 Finn antall leiligheter i borettslaget "Tertitten".
SELECT count(leil_nr) FROM leilighet
left join bygning b on leilighet.bygn_id = b.bygn_id
left join borettslag b2 on b.bolag_navn = b2.bolag_navn
WHERE b.bolag_navn='Tertitten';

-- oppgave 8 Hvor høyt kan du bo i borettslaget "Tertitten"?
select MAX(ant_etasjer) FROM bygning
left join borettslag b on bygning.bolag_navn = b.bolag_navn
WHERE b.bolag_navn='Tertitten';

-- oppgave 9 Finn navn og nummer til andelseiere som ikke har leilighet.
SELECT fornavn, etternavn, telefon FROM andelseier
left join leilighet l on andelseier.and_eier_nr = l.and_eier_nr
WHERE andelseier.and_eier_nr NOT IN(SELECT and_eier_nr FROM leilighet);

-- oppgave 10 Finn antall andelseiere pr borettslag, sortert etter antallet. Husk at det kan finnes borettslag uten andelseiere - de skal også med.
SELECT b.bolag_navn, COUNT(and_eier_nr) FROM borettslag
left join bygning b on borettslag.bolag_navn = b.bolag_navn
left join leilighet l on b.bygn_id = l.bygn_id
GROUP BY b.bolag_navn DESC;

-- oppgave 11 Skriv ut en liste over alle andelseiere. For de som har leilighet, skal leilighetsnummeret skrives ut.
SELECT andelseier.*, l.leil_nr from andelseier
left join leilighet l on andelseier.and_eier_nr = l.and_eier_nr;

-- oppgave 12 Hvilke borettslag har leiligheter med eksakt 4 rom?
SELECT b.bolag_navn from borettslag
left join bygning b on borettslag.bolag_navn = b.bolag_navn
left join leilighet l on b.bygn_id = l.bygn_id
WHERE l.ant_rom>3
GROUP BY b.bolag_navn;

-- oppgave 13 Skriv ut en liste over antall andelseiere pr postnr og poststed, begrenset til de som bor i leiligheter tilknyttet et borettslag.
-- Husk at postnummeret til disse er postnummeret til bygningen de bor i, og ikke postnummeret til borettslaget.
-- Du trenger ikke ta med poststeder med 0 andelseiere. (Ekstraoppgave: Hva hvis vi vil ha med poststeder med 0 andelseiere?)
select poststed.*, COUNT(l.and_eier_nr) from poststed
left join bygning b on poststed.postnr = b.postnr
left join borettslag b2 on b.bolag_navn = b2.bolag_navn
left join leilighet l on b.bygn_id = l.bygn_id
GROUP BY poststed.postnr;