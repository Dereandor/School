-- a) List ut all informasjon (ordrehode og ordredetalj) om ordrer for leverandør nr 44.
SELECT * FRom ordrehode
left join ordredetalj o on ordrehode.ordrenr = o.ordrenr
Where levnr='44';

-- b) Finn navn og by ("LevBy") for leverandører som kan levere del nummer 1.
Select navn, levby from levinfo
left join prisinfo p on levinfo.levnr = p.levnr
left join delinfo d on p.delnr = d.delnr
where d.delnr=1;

-- c) Finn nummer, navn og pris for den leverandør som kan levere del nummer 201 til billigst pris.
select navn, p.levnr, pris FROM levinfo
left join prisinfo p on levinfo.levnr = p.levnr
left join delinfo d on p.delnr = d.delnr
where d.delnr='201'
order by pris asc
limit 1;

-- d) Lag fullstendig oversikt over ordre nr 16, med ordrenr, dato, delnr, beskrivelse, kvantum, (enhets-)pris og beregnet beløp (=pris*kvantum).
select o.ordrenr, dato, d.delnr, beskrivelse, kvantum, pris, kvantum*pris from ordredetalj
left join ordrehode o on ordredetalj.ordrenr = o.ordrenr
left join delinfo d on ordredetalj.delnr = d.delnr
left join prisinfo p on d.delnr = p.delnr
where o.ordrenr=16;

-- e) Finn delnummer og leverandørnummer for deler som har en pris som er høyere enn prisen for del med katalognr X7770.
select prisinfo.delnr, levnr from prisinfo
left join delinfo d on prisinfo.delnr = d.delnr
where pris >(select pris from prisinfo where katalognr='X7770')
order by  pris;

-- f)
-- i) Tenk deg at tabellen levinfo skal deles i to. Sammenhengen mellom by og fylke skal tas ut av tabellen.
-- Det er unødvendig å lagre fylketilhørigheten for hver forekomst av by. Lag én ny tabell som inneholder byer og fylker.
-- Fyll denne med data fra levinfo. Lag også en tabell som er lik levinfo unntatt kolonnen Fylke. (Denne splittingen av tabellen levinfo gjelder bare i denne oppgaven.
-- I resten av oppgavesettet antar du at du har den opprinnelige levinfo-tabellen.)
-- ii) Lag en virtuell tabell (view) slik at brukerne i størst mulig grad kan jobbe på samme måte mot de to nye tabellene som den gamle.
-- Prøv ulike kommandoer mot tabellen (select, update, delete, insert). Hvilke begrensninger, hvis noen, har brukerne i forhold til tidligere?
CREATE VIEW levinfo_old AS
SELECT * FROM levinfo
natural join byfylke b;

-- g) Anta at en vurderer å slette opplysningene om de leverandørene som ikke er representert i Prisinfo-tabellen.
-- Finn ut hvilke byer en i tilfelle ikke får leverandør i. (Du skal ikke utføre slettingen.) (Tips: Svaret skal bli kun én by, "Ål".)
SELECT levby from levinfo l
where l.levby not in(select levby from levinfo natural join prisinfo);

-- h) Finn leverandørnummer for den leverandør som kan levere ordre nr 18 til lavest totale beløp (vanskelig).

-- hvem kan levere en eller flere av delene på listen:
  alter VIEW deliver18compl AS
  SELECT levnr, p.pris, p.delnr, kvantum, pris*kvantum from ordredetalj
                                                              natural join prisinfo p -- on levinfo.levnr = p.levnr
  where ordrenr='18';

-- hvem kan levere alle delene på listen:
  alter VIEW deliver18complete AS
  SELECT * from deliver18compl
  where levnr='6' OR levnr='82'
  order by levnr;

-- hvem kan levere til lavest pris:
SELECT levnr, SUM(pris*kvantum) as total from deliver18complete
group by levnr
order by total
limit 1;

