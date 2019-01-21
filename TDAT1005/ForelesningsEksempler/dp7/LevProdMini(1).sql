DELETE FROM leveranse;
DELETE FROM produkt;
DELETE FROM leverandor;

-- Legger inn eksempeldata
INSERT INTO leverandor(lev_nr, lev_navn, status, lev_by)  VALUES(1, 'Svendsen', 20, 'Lillehammer');
INSERT INTO leverandor(lev_nr, lev_navn, status, lev_by)  VALUES(2, 'Jensen', 10, 'Porsgrunn');    
INSERT INTO leverandor(lev_nr, lev_navn, status, lev_by)  VALUES(3, 'Bø', 30, 'Porsgrunn');

INSERT INTO produkt(prod_nr, prod_navn, kode, vekt, prod_by) VALUES(1, 'synåler', 'rød', 12, 'Lillehammer');
INSERT INTO produkt(prod_nr, prod_navn, kode, vekt, prod_by) VALUES(2, 'binders', 'grønn', 17, 'Porsgrunn');

INSERT INTO leveranse(lev_nr, prod_nr, antall) VALUES(1, 1, 300);
INSERT INTO leveranse(lev_nr, prod_nr, antall) VALUES(2, 1, 300);

