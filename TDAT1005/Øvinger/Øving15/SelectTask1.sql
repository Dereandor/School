
    -- Lag en liste over alle bedriftene. Navn, telefon og epost til bedriften skal skrives ut.
SELECT orgnavn, telefon, epost FROM bedrifter;

    -- Lag en liste over alle oppdragene. Om hvert oppdrag skal du skrive ut oppdragets nummer samt navn og telefonnummer til bedriften som tilbyr oppdraget.
select oppdrag.oppdragsnr, bedrifter.orgnavn, bedrifter.telefon from oppdrag
left join bedrifter b on oppdrag.orgnr = b.orgnr;


    -- Lag en liste over kandidater og kvalifikasjoner. Kandidatnavn og kvalifikasjonsbeskrivelse skal med i utskriften i tillegg til løpenumrene som identifiserer kandidat og kvalifikasjon.
select kandidatid, kvalifikasjonsid, kvalifikasjoner.beskrivelse, kandidater.fornavn, kandidater.etternavn from kandidatkval
natural join kvalifikasjoner
natural join kandidater;

    -- Som oppgave 3), men få med de kandidatene som ikke er registrert med kvalifikasjoner.
select kandidatid, kvalifikasjonsid, kvalifikasjoner.beskrivelse, kandidater.fornavn, kandidater.etternavn from kandidatkval
  natural join kvalifikasjoner
  natural join kandidater
where kandidatid = 0;


    -- Skriv ut jobbhistorikken til en bestemt vikar, gitt kandidatnr. Vikarnavn, sluttdato, oppdragsnr og bedriftsnavn skal med.
select k.fornavn, k.etternavn, jobbhistorikk.fakt_sluttdato, jobbhistorikk.oppdragsnr, b.orgnavn from jobbhistorikk
left join kandidater k on jobbhistorikk.kandidatid = k.kandidatid
left join oppdrag o on jobbhistorikk.oppdragsnr = o.oppdragsnr
left join bedrifter b on o.orgnr = b.orgnr
where jobbhistorikk.kandidatid = 2;
