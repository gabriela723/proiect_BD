INSERT INTO specializare (denumire, pret) VALUES
("ecografie", "100"), ("endoscopie digestiva", "120"), 
("ecocardiografie", "200"), ("cardiologie", "100"), 
("cardiologie interventionala", "300"), ("bronhoscopie", "130"), 
("EEG", "500"), ("dializa", "150"), 
("chirurgie laparoscopica", "400"), ("chirurgie toracica", "700"), 
("chirurgie spinala", "800"), ("litotritie extracorporeala", "750"), 
("explorarea computer tomograf", "50"), ("explorarea computer imagistica prin rezonanta magnetica", "90");



INSERT INTO unitate_medicala(denumire, adresa, serviciiOferite, fond)
VALUES ("Regina Maria", "Cluj, Calea Dorobantilor 29", "consultatii", "0");

INSERT INTO unitate_medicala(denumire, adresa, serviciiOferite, fond)
VALUES ("Pasteur", "Cluj, Republicii 73", "consultatii", "0");

INSERT INTO unitate_medicala(denumire, adresa, serviciiOferite, fond)
VALUES ("Napoca", "Cluj,  Mihai Viteazu, 14-20", "consultatii","0");



INSERT INTO program_unitate(zi, oraDeschidere, oraInchidere, unitate) VALUES
("Luni", "08:00:00", "22:00:00", "Regina Maria"), ("Marti", "08:00:00", "22:00:00", "Regina Maria"),
("Miercuri", "08:00:00", "22:00:00", "Regina Maria"), ("Joi", "08:00:00", "22:00:00", "Regina Maria"),
("Vineri", "08:00:00", "20:00:00", "Regina Maria"), ("Sambata", "10:00:00", "18:00:00", "Regina Maria");

INSERT INTO program_unitate(zi, oraDeschidere, oraInchidere, unitate) VALUES
("Luni", "08:00:00", "22:00:00", "Napoca"), ("Marti", "08:00:00", "22:00:00", "Napoca"),
("Miercuri", "08:00:00", "22:00:00", "Napoca"), ("Joi", "08:00:00", "22:00:00", "Napoca"),
("Vineri", "08:00:00", "20:00:00", "Napoca"), ("Sambata", "10:00:00", "18:00:00", "Napoca");

INSERT INTO program_unitate(zi, oraDeschidere, oraInchidere, unitate) VALUES
("Luni", "08:00:00", "22:00:00", "Pasteur"), ("Marti", "08:00:00", "22:00:00", "Pasteur"),
("Miercuri", "08:00:00", "22:00:00", "Pasteur"), ("Joi", "08:00:00", "22:00:00", "Pasteur"),
("Vineri", "08:00:00", "20:00:00", "Pasteur"), ("Sambata", "10:00:00", "18:00:00", "Pasteur");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("1234567891", "Baila" , "Lucian", "Cluj, str Fabricii", "0762626897", "1","500","bailalucian@gmail.com",
"2022-01-22", "medic", "100", "10");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("1234567891", 1, "medic", "primar", "1234567891", "calm", "doctor in stiinte medicale", "lector");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("2345678912", "Popescu" , "Marian", "Cluj, str Fabricii de chibrituri", "0762626894", "2","500","popescumariann@gmail.com",
"2022-01-28", "medic", "98", "30");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("2345678912", 3, "medic", "specialist", "2345678912", "rabdator", NULL, NULL);

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("3456789123", "Popovici" , "Andrei", "Cluj, str Andrei Saguna", "0775626894", "3","500","popoviciandrei@gmail.com",
"2022-02-28", "medic", "56", "50");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("3456789123", 14, "medic", "primar", "3456789123", "C1 limba engleza", "doctorand in stiinte medicale", "lector");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("4567891234", "Ticudean" , "Tudor", "Cluj, str Aurel Vlaicu", "0775926894", "4","500","tudorticudean@gmail.com",
"2022-02-01", "medic", "120", "52");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("4567891234", 1, "medic", "primar", "4567891234", "eficient", NULL, "profesor");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("5678912345", "Stavar" , "Sebastian", "Cluj, str Baritiu", "0775926890", "5","500","stavarsebastian@gmail.com",
"2022-02-05", "medic", "111", "34");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("5678912345", 7, "medic", "primar", "5678912345", "calm, rabdator, eficient", NULL, NULL);

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("6789123456", "Baila" , "Iulia", "Mures, str Lalelelor", "0775936890", "6","500","bailaiulia@gmail.com",
"2022-02-25", "medic", "112", "35");
INSERT INTO medic(idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic) VALUES
("6789123456", 4, "medic", "specialist", "6789123456", "calm", NULL, "profesor");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("7891234567", "Baila" , "Andrei", "Mures, str Ghioceilor", "0775936898", "7","100","bailaandrei@gmail.com",
"2022-03-25", "asistent", "50", "40");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("7891234567", "generalist", "principal", "asistent", "Regina Maria");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("5678943215", "Durcau" , "Rares", "Aiud, str Gara", "0720235684", "25" ,"100","raresdurcau25@gmail.com",
"2022-01-01", "asistent", "100", "50");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("5678943215", "generalist", "principal", "asistent", "Regina Maria");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("8912345678", "Costea" , "Andrei", "Alba, str Primaverii", "0775936877", "8","100","andreicostea@gmail.com",
"2022-03-27", "asistent", "57", "40");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("8912345678", "laborator", "secundar", "asistent", "Pasteur");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("9123456789", "Costea" , "Marcel", "Alba, strPrincipala", "0775933877", "9","100","costeamarcel@gmail.com",
"2022-03-29", "asistent", "20", "40");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("9123456789", "radiologie", "secundar", "asistent", "Pasteur");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("9876543219", "Duse" , "Alexandra", "Bucuresti, str Toamnei", "0775343877", "10","100","dusealexandra@gmail.com",
"2022-04-29", "asistent", "25", "40");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("9876543219", "radiologie", "secundar", "asistent", "Napoca");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("8765432198", "Borlea" , "Larisa", "Alba, str Motilor", "0775383877", "11","100","borlealarisa@gmail.com",
"2022-04-12", "asistent", "27", "40");
INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate) VALUES
("8765432198", "generalist", "principal", "asistent", "Napoca");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("7654321987", "Petric" , "Andrei", "Alba, str Motilor", "0775393877", "12","700","petricandreea@gmail.com",
"2022-04-15", "economist", "200", "40");
INSERT INTO economist (idEconomist, functia, unitate) VALUES
("7654321987", "economist", "Regina Maria");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("6543219876", "Petric" , "Dinuta", "Cluj, str Motilor", "0775293877", "13", "700", "petricdinuta@gmail.com",
"2022-04-19", "economist", "44", "40");
INSERT INTO economist (idEconomist, functia, unitate) VALUES
("6543219876", "economist", "Napoca");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("5432198765", "Mates" , "Cosmin", "Cluj, str Fabricii de Zahar", "0775298877", "14", "700", "cosminmates@gmail.com",
"2022-04-23", "economist", "42", "40");
INSERT INTO economist (idEconomist, functia, unitate) VALUES
("5432198765", "economist", "Pasteur");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES 
("4321987654", "Mates" , "Andrada", "Cluj, str Ardeilor", "0776298877", "15", "200", "andradamates@gmail.com",
"2022-05-03", "receptioner", "54", "40");
INSERT INTO receptioner (idReceptioner, functia, unitate) VALUES
("4321987654", "receptioner", "Regina Maria");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("3219876543", "Moldovan" , "Sergiu", "Alba Iulia, str Cetate", "0777561230", "898","200","sergiumoldovan@gmai.com",
"2022-03-01", "receptioner", "50", "30");
INSERT INTO receptioner (idReceptioner, functia, unitate) VALUES
("3219876543", "receptioner", "Pasteur");

INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("2198765432", "Oltean" , "Magdalena", "Onesti, str Lunga", "0745692755", "665", "200","magdanelaoltean1@gmail.com",
"2022-03-01", "receptioner", "48", "30");
INSERT INTO receptioner (idReceptioner, functia, unitate) VALUES
("2198765432", "receptioner", "Napoca");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("1987654321", "Bic" , "Nectarie", "Aiud, str Avram Iancu", "0766734950", "420", "1000","bicnectarie02@gmail.com",
"2020-02-11", "inspector_resurse_umane", "60", "15");
INSERT INTO inspector_resurse_umane(idInspector) VALUES
("1987654321");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("1326457981", "Toma" , "Ioan", "Cluj, str Centru", "0765892314", "565", "1200","tomaioantoma@gmail.com",
"2020-03-01", "administrator", "100", "10");
INSERT INTO administrator (idAdmin, functia, unitate) VALUES
("1326457981", "administrator", "Regina Maria");



INSERT INTO utilizator (CNP, nume, prenume, adresa, nrTelefon, nrContract, IBAN, email, dataAngajarii, functia, salariuNeg, ore) VALUES  
("2459861370", "Alexa" , "Gabriel", "Cluj, str Matiesi", "0745567123", "100", "1700","gabrielalexag@gmail.com",
"2021-11-29", "super administrator", "105", "10");
INSERT INTO administrator (idAdmin, functia, unitate) VALUES
("2459861370", "super administrator", "Regina Maria");

INSERT INTO pacient (nume, prenume, IBAN) VALUES
( "Pintea", "Madalin", "2000");

INSERT INTO pacient ( nume, prenume, IBAN) VALUES
( "Stan", "Laurentiu", "2000");

INSERT INTO pacient ( nume, prenume, IBAN) VALUES
( "Manea", "Alexandra", "2000");

INSERT INTO pacient ( nume, prenume, IBAN) VALUES
( "Eminescu", "George", "2000");

INSERT INTO pacient ( nume, prenume, IBAN) VALUES
( "Stan", "Laurentiu", "2000");



INSERT INTO orar_medic(idMedic, oraStart, oraFinal, zi, unitate) VALUES
("1234567891", "08:00:00", "08:15:00", "2022-12-17", "Regina Maria");

INSERT INTO orar_medic(idMedic, oraStart, oraFinal, zi, unitate) VALUES
("1234567891", "08:30:00", "09:00:00", "2022-12-17", "Pasteur");

-- INSERT INTO orar_medic(idMedic, oraStart, oraFinal, zi, unitate) VALUES
-- ("3456789123", "08:30:00", "09:00:00", "2022-12-17", "Napoca");

INSERT INTO salarii (idAngajat, suma , unitate, luna) VALUES ("1234567891", "10200", "Regina Maria", "2022-12-01");
INSERT INTO salarii (idAngajat, suma , unitate, luna) VALUES ("1234567891", "10000", "Pasteur", "2023-01-01");

INSERT INTO salarii (idAngajat, suma , unitate, luna) VALUES ("1987654321", "6000", null, "2022-12-01");
INSERT INTO salarii (idAngajat, suma , unitate, luna) VALUES ("1987654321", "6000", null, "2023-01-01");