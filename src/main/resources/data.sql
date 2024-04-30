INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO adresa (id, broj, ulica) VALUES (1, 6, 'Trg Dositeja Oradovica');
INSERT INTO adresa (id, broj, ulica) VALUES (2, 36, 'Laze Nancica');
INSERT INTO adresa (id, broj, ulica) VALUES (3, 60, 'Bulevar Oslobodjenja');

INSERT INTO trotinet (id, iznajmljen, maksimalna_brzina, nivo_baterije, sifra, adresa_id) VALUES (1, 0, 25, 85, 'T0001', 1);
INSERT INTO trotinet (id, iznajmljen, maksimalna_brzina, nivo_baterije, sifra, adresa_id) VALUES (2, 1, 30, 35, 'T0002', 2);
INSERT INTO trotinet (id, iznajmljen, maksimalna_brzina, nivo_baterije, sifra, adresa_id) VALUES (3, 0, 25, 9, 'T0003', 3);
INSERT INTO trotinet (id, iznajmljen, maksimalna_brzina, nivo_baterije, sifra) VALUES (4, 0, 25, 67, 'T0004');

INSERT INTO rezervacija (id, email, vreme_iznajmljivanja, trotinet_id) VALUES (1, 'mirko@gmail.com', '2024-03-26 20:14:04', 2);

