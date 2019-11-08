/*
Testdata for Database
*/
/*
 Kategorier
 */
INSERT INTO category VALUES('Teknologi');
INSERT INTO category VALUES('Sport');
INSERT INTO category VALUES('Politikk');
INSERT INTO category VALUES('Natur');
INSERT INTO category VALUES('Spill');
INSERT INTO category VALUES('Mat & Drikke');
INSERT INTO category VALUES('Reise');
INSERT INTO category VALUES('Økonomi');
INSERT INTO category VALUES('TV, Film & Musikk');
INSERT INTO category VALUES('Helse & Livvstil');
INSERT INTO category VALUES('Motor');
/*
 Artikler
 */
INSERT INTO article
VALUES(DEFAULT,
       'Første artikkel',
       DEFAULT,
       'Første artikkel testet og fungerer på nettsiden, alle sier seg fornøyde',
       'https://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/thumbs-up.png',
       TRUE,
       0,
       'Teknologi');
INSERT INTO article
VALUES(DEFAULT,
       'Smeltet hamster',
       DEFAULT,
       'Hamster smeltet i solen',
       'https://static.boredpanda.com/blog/wp-content/uploads/2017/03/58bebe85895f7_VWpibar__605.jpg',
       FALSE,
       0,
       'Natur');

