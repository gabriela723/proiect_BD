SELECT * FROM utilizator;
select * FROM specializare;
SELECT * FROM program_unitate;

CALL creeareParola("1987654321", "1234");
CALL creeareParola("1326457981", "1234");
CALL creeareParola("5432198765", "1234");
CALL creeareParola("5678943215", "1234");
CALL creeareParola("2198765432", "1234");
CALL afisareUnitati();
CALL medici();
CALL pacienti();
CALL pacienti();
CALL gasireFunctieUtilizator("1234567891");
CALL actualizareSalariu( "1234567891", "100");
CALL actualizareNrOre("1234567891", "200");
CALL parafareRaport("1", "1234567891");
CALL afisareProgram("Regina Maria");
CALL afisareUnitati();
CALL adaugareProgramare("1" , "Regina Maria", "2023-01-10", "18:00:00");
CALL adaugareProgramare("2","Pasteur", "2023-01-10","12:30:00");
CALL adaugareProgramare("3","Napoca", "2023-01-10", "12:30:00");
CALL adaugareProgramare("4","Napoca", "2023-01-11", "12:30:00");

CALL adaugareConsultatie("00:30:00",  "2345678912","3", "1", "Regina Maria");
CALL adaugareServiciuMedical("15", "oftalmologie");
CALL costConsultatie("1", "2345678912", "3");
CALL creeareParola("1234567891", "passwordTest123");
CALL creeareParola("1326457981", "1234");
CALL programDeLucru("1234567891");
CALL programDeLucruAsistent("5678943215");
CALL plataConsultatie("2");
CALL determinarePret("2", "3");
CALL determinareFond("Pasteur");
CALL adaugareUtilizator("6020201235", "25dec", "Morcov", "Andreea", "str Portocalelor, nr 16", "0756567892", "mrc_andreea@yahoo.com", "100", "asistent_medical");
CALL adaugareUtilizator("6020201273", "lalala", "Pasca", "Razvan", "str Horea, nr 16", "0756500092", "prazvan@yahoo.com", "500", "medic");
CALL adaugareMedic("6020201273", "5", "medic", "specialist", "891", "agil", "", "profesor");
CALL adaugareAsistentMedical("6020201235", "generalist", "secundar", "asistent", "Pasteur"); 
CALL adaugarePacient("Silasi","Andrei", "1900");
CALL programMedic("1234567891");
INSERT INTO utilizator(CNP, nume, prenume, concediuStart, concediuFinal)
VALUES ("1234567890", "xyz", "bfhd", "2022-06-01", "2022-06-15");
CALL afisareConcediu("1234567890");
CALL achitareConsultatie("1");
CALL afisareFond("Regina Maria");
CALL profitMedic("2345678912");
CALL afisareSalarii("1234567891");
CALL adaugareUnitate("cvhd", "bvdukc", 100.00);
CALL stergereUnitate("cvhd");
CALL adaugareServiciuMedical1( "rinoplastie", "3000");
CALL stergereServiciuMedical("15","rinoplastie");
CALL adaugareProgramUnitate("Regina Maria", "Luni", "08:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Marti", "08:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Miercuri", "08:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Joi", "08:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Vineri", "08:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Sambata", "10:00", "22:00");
CALL adaugareProgramUnitate("Regina Maria", "Duminica", "10:00", "22:00");
CALL adaugareRaportMedical("9876543219", "1", "sanatos clinic", "migrene", "-", "-");

CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-04-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-05-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-06-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-07-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-08-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-09-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-10-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-11-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2022-12-01");
CALL plataSalariu("7891234567" ,"2000", "Regina Maria", "2023-01-01");

CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-05-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-06-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-07-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-08-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-09-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-10-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-11-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2022-12-01");
CALL plataSalariu("5432198765" ,"1680", "Pasteur", "2023-01-01");


CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-04-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-05-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-06-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-07-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-08-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-09-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-10-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-11-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2022-12-01");
CALL plataSalariu("2198765432" ,"1440", "Napoca", "2023-01-01");


CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-02-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-03-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-04-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-05-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-06-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-07-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-08-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-09-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-10-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-11-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2022-12-01");
CALL plataSalariu("5678943215" ,"5000", "Regina Maria", "2023-01-01");

CALL plataSalariu("1234567891" ,"3000", "Regina Maria", "2022-02-01");
CALL plataSalariu("1234567891" ,"3000", "Regina Maria", "2022-03-01");
CALL plataSalariu("1234567891" ,"5000", "Regina Maria", "2022-04-01");
CALL plataSalariu("1234567891" ,"1000", "Regina Maria", "2022-05-01");
CALL plataSalariu("1234567891" ,"3440", "Napoca", "2022-06-01");
CALL plataSalariu("1234567891" ,"4440", "Napoca", "2022-07-01");
CALL plataSalariu("1234567891" ,"2140", "Napoca", "2022-08-01");
CALL plataSalariu("1234567891" ,"1440", "Napoca", "2022-09-01");
CALL plataSalariu("1234567891" ,"1980", "Pasteur", "2022-10-01");
CALL plataSalariu("1234567891" ,"1680", "Pasteur", "2022-11-01");

CALL adaugareConsultatie("00:30:00",  "3456789123","8", "2", "Pasteur");
CALL adaugareConsultatie("00:45:00",  "4567891234","10", "3", "Napoca");

CALL adaugareRaportMedical("5678943215", "2", "sanatos clinic", "migrene", "-", "parasinus");
CALL adaugareRaportMedical("9876543219", "3", "sanatos clinic", "migrene", "-", "nurofen");

CALL emitereBonFiscal("1", "4321987654", "1");
CALL determinarePret("2", "8");
CALL emitereBonFiscal("2", "3219876543", "2");
CALL determinarePret("3", "10");
CALL emitereBonFiscal("3", "2198765432", "3");


-- CALL stergereAngajat("8765432198", "Borlea", "Larisa");
-- CALL stergereAngajat("1234567891", "Baila", "Lucian");
-- CALL stergereAngajat("7654321987", "Petric", "Andrei");