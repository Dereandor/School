-- a) Bruk SQL til å finne navnene til alle forlagene. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT DISTINCT forlag_navn FROM forlag;

-- b) Bruk SQL til å finne eventuelle forlag (forlag_id er nok) som ikke har gitt ut bøker. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT DISTINCT forlag.forlag_id FROM forlag
LEFT JOIN bok b on forlag.forlag_id = b.forlag_id
WHERE b.forlag_id IS NULL;

-- c) Bruk SQL til å finne forfattere som er født i 1948. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT * FROM forfatter WHERE fode_aar = 1948;

-- d) Bruk SQL til å finne navn og adresse til forlaget som har gitt ut boka 'Generation X'. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT forlag_navn, adresse FROM forlag
LEFT JOIN bok b on forlag.forlag_id = b.forlag_id
where b.tittel = 'Generation X';

-- e) Bruk SQL til å finne titlene på bøkene som Hamsun har skrevet. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT tittel FROM bok
RIGHT JOIN bok_forfatter bf on bok.bok_id = bf.bok_id
RIGHT JOIN forfatter f on bf.forfatter_id = f.forfatter_id
where f.etternavn = 'Hamsun';

-- f) Bruk SQL til å finne informasjon om bøker og forlagene som har utgitt dem.
--    Én linje i oversikten skal inneholde bokas tittel og utgivelsesår, samt forlagets navn, adresse og telefonnummer.
--    Forlag som ikke har gitt ut noen bøker skal også med i listen. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
SELECT tittel, utgitt_aar, forlag_navn, adresse, telefon FROM bok
RIGHT JOIN forlag f on bok.forlag_id = f.forlag_id;
