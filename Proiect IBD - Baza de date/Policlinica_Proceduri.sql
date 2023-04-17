use policlinica;
SET SQL_SAFE_UPDATES = 0;

DROP PROCEDURE IF EXISTS actualizareSalariu;
DROP PROCEDURE IF EXISTS actualizareNrOre;
DROP PROCEDURE IF EXISTS parafareRaport;
DROP PROCEDURE IF EXISTS adaugareProgramare;
DROP PROCEDURE IF EXISTS adaugareFond;
DROP PROCEDURE IF EXISTS calculPret;
DROP PROCEDURE IF EXISTS creeareParola;

DELIMITER //
CREATE PROCEDURE pacienti()
BEGIN
	SELECT idPacient, nume, prenume from pacient;
END //
DELIMITER;


DELIMITER //
CREATE PROCEDURE medici()
BEGIN
	SELECT CNP, nume, prenume from utilizator JOIN medic where medic.idMedic = utilizator.CNP;
END //
DELIMITER;


DELIMITER //
CREATE PROCEDURE utilizatori()
BEGIN
	SELECT CNP from utilizator;
END //
DELIMITER;

DELIMITER //
CREATE PROCEDURE gasireFunctieUtilizator(IN CNP VARCHAR(10))
BEGIN
	SELECT functia FROM utilizator WHERE utilizator.CNP = CNP;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE login(IN CNP VARCHAR(10), IN parola VARCHAR(20))
BEGIN
	SELECT CNP FROM utilizator WHERE utilizator.CNP = CNP AND utilizator.parola = parola;
END //
DELIMITER ;

DELIMITER //

CREATE PROCEDURE actualizareSalariu(IN CNP VARCHAR(10), IN x DECIMAL(10,2))
BEGIN
    UPDATE utilizator SET salariuNeg = x WHERE utilizator.CNP=CNP ;
END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE actualizareNrOre(IN CNP VARCHAR(10), IN x INT)
BEGIN
    UPDATE utilizator SET ore = x WHERE utilizator.CNP=CNP ;
END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE parafareRaport(IN idRaport VARCHAR(10),IN x VARCHAR(10))
BEGIN
    UPDATE raport_medical SET codParafa = x WHERE raport_medical.idConsultatie=idRaport AND codParafa = NULL;
END //

DELIMITER ;


DELIMITER //
CREATE PROCEDURE afisareRapoarte()
BEGIN
    SELECT idConsultatie FROM raport_medical;
END //
DELIMITER ;
call afisareRapoarte();

DELIMITER //

DELIMITER //
CREATE PROCEDURE afisareProgram( in denumire VARCHAR(50))
BEGIN
    SELECT program_unitate.zi, program_unitate.oraDeschidere, program_unitate.oraInchidere 
    FROM program_unitate
    WHERE program_unitate.unitate=denumire;
END //
DELIMITER ;



DELIMITER //

CREATE PROCEDURE adaugareFond(in x DECIMAL(20,2), in nume VARCHAR(50))
BEGIN
    UPDATE unitate_medicala SET fond = x WHERE unitate_medicala.denumire = nume;
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE afisareUnitati()
BEGIN
	SELECT denumire FROM unitate_medicala;
END //
DELIMITER;


DELIMITER //
CREATE PROCEDURE afisareSpecializari()
BEGIN
	SELECT denumire, idSpecializare FROM specializare;
END //
DELIMITER ;
CALL afisareSpecializari();


DELIMITER //

CREATE PROCEDURE adaugareProgramare( in id INT ,in nume VARCHAR(50),  in zi DATE, in ora TIME)
BEGIN
    INSERT INTO programare (idConsultatie, Unitate, zi, ora) VALUES (id,nume, zi, ora);
    END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE adaugareConsultatie( in ora TIME, in idM VARCHAR(10), in idS VARCHAR(10), in idP INT, denumireUnitate VARCHAR(50))
BEGIN
    INSERT INTO consultatie( durata, idMedic, idSpecializare, idPacient, denumireUnitate) VALUES ( ora ,idM, idS, idP, denumireUnitate);
    END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE adaugareServiciuMedical(in id BIGINT , in nume varchar(256))
BEGIN
    INSERT INTO specializare( idSpecializare, denumire) VALUES (id, nume);
    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE adaugareServiciuMedical1(in nume varchar(256), in pret DECIMAL(10, 2))
BEGIN
    INSERT INTO specializare(denumire, pret) VALUES (nume, pret);
    END //

DELIMITER ;




DELIMITER //

CREATE PROCEDURE adaugareAngajat(in CNP BIGINT , in nume VARCHAR (50), in prenume VARCHAR(50), in adresa VARCHAR(256), in nrT VARCHAR(10), in email VARCHAR(256), in IBAN DECIMAL(20,2), in nrC VARCHAR(50), in dataa DATE , in func VARCHAR(25), in salar DECIMAL(10,2), in ore INT)
BEGIN
    INSERT INTO utilizator(CNP, nume, prenume, adresa, nrTelefon, email, IBAN, nrContract, dataAngajarii, functia, salariuNeg, ore) VALUES
    (CNP, nume, prenume, adresa, nrT, email, IBAN, nrC, dataa, func, salar, ore);
    
    END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE stergereAngajat(in CNP VARCHAR(10) , in nume VARCHAR (50), in prenume VARCHAR(50))
BEGIN
    DELETE FROM orar_medic WHERE CNP=orar_medic.idMedic;
	DELETE FROM salarii WHERE CNP=salarii.idAngajat;
     DELETE FROM medic WHERE CNP=medic.idMedic;
    DELETE FROM asistent_medical WHERE asistent_medical.idAsistent=CNP;
    DELETE FROM receptioner WHERE receptioner.idReceptioner=CNP;
    DELETE FROM economist WHERE economist.idEconomist=CNP;
     DELETE FROM inspector_resurse_umane WHERE inspector_resurse_umane.idInspector=CNP;
    DELETE FROM administrator WHERE administrator.idAdmin=CNP;

    DELETE FROM utilizator WHERE CNP = utilizator.CNP;
    END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE emitereBonFiscal(in idConsultatie INT , in idReceptioner VARCHAR(10), in idPacient INT)
BEGIN
    INSERT INTO bon_fiscal(idConsultatie, idReceptioner, idPacient) VALUES (idConsultatie, idReceptioner, idPacient);
    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE costConsultatie(in idC INT,in idM VARCHAR(10), in idS VARCHAR(10) )
BEGIN
	UPDATE consultatie SET 
    pret = (SELECT pret FROM specializare, medic  WHERE specializare.idSpecializare=idS AND medic.idSpecializare=idS AND medic.idMedic=idM);
    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE creeareParola(in CNP VARCHAR(10), in x VARCHAR(20))
BEGIN
	UPDATE utilizator SET
    parola = x WHERE utilizator.CNP = CNP;
END //
DELIMITER ;


DELIMITER //

CREATE PROCEDURE programDeLucru (in CNP VARCHAR(10))
BEGIN 
	SELECT nume, prenume, zi, oraStart, oraFinal, unitate FROM utilizator, orar_medic WHERE CNP=utilizator.CNP AND CNP=orar_medic.idMedic;
END//
DELIMITER ;



DELIMITER //

CREATE PROCEDURE programDeLucruAsistent (in CNP VARCHAR(10))
BEGIN 
	SELECT nume, prenume, unitate_medicala.denumire, program_unitate.zi, program_unitate.oraDeschidere, program_unitate.oraInchidere FROM utilizator, asistent_medical, unitate_medicala, program_unitate 
    WHERE CNP=utilizator.CNP AND idAsistent=CNP AND asistent_medical.unitate=unitate_medicala.denumire AND unitate_medicala.denumire=program_unitate.unitate;
END//
DELIMITER ;

DELIMITER //

CREATE PROCEDURE determinarePret(IN idC INT , IN idS VARCHAR(10))
BEGIN
	UPDATE consultatie SET consultatie.pret=(SELECT specializare.pret FROM specializare WHERE specializare.idSpecializare=idS) WHERE idC=consultatie.idConsultatie;
END//

DELIMITER;

DELIMITER //
CREATE PROCEDURE plataConsultatie( in idC INT)
BEGIN 
	-- UPDATE unitate_medicala SET fond = (SELECT consultatie.pret FROM consultatie where idC=idConsultatie)
    -- WHERE unitate_medicala.denumire=(SELECT programare.unitate FROM programare  WHERE idC=programare.idConsultatie);
    
    -- UPDATE unitate_medicala SET fond=(SELECT SUM(consultatie.pret) FROM  consultatie where idC=idConsultatie +
    -- SELECT unitate_medicala.fond FROM unitate_medicala, consulatie WHERE idConsultatie=idC AND unitate_medicala.denumire=consultatie.denumireUnitate) ;
END//

DELIMITER ;

DELIMITER //
CREATE PROCEDURE determinareFond( in denumire VARCHAR(50))
BEGIN 

	SELECT unitate_medicala.denumire, unitate_medicala.fond FROM unitate_medicala WHERE denumire=unitate_medicala.denumire;
END //
DELIMITER ;



DELIMITER //
CREATE PROCEDURE adaugareUtilizator( in CNP VARCHAR(10),  in parola VARCHAR(20), in nume VARCHAR(50), in prenume VARCHAR(50), in adresa VARCHAR(256), in nrTelefon VARCHAR(10), in email VARCHAR(256), in IBAN DECIMAL(20,2), in functia VARCHAR(25))
BEGIN
	INSERT INTO utilizator (CNP, parola, nume, prenume, adresa, nrTelefon, email, IBAN, functia)
    VALUES (CNP, parola, nume, prenume, adresa , nrTelefon, email, IBAN, functia);

END //

DELIMITER ;

DELIMITER  //
CREATE PROCEDURE adaugareMedic(in idMedic VARCHAR(10), in idSpecizalizare VARCHAR(10), in functia VARCHAR(25), in grad VARCHAR(10), in codParafa VARCHAR(10), in competente VARCHAR(256), in titluStiintific VARCHAR(30), in postDidactic VARCHAR(30))
BEGIN
	INSERT INTO medic (idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic)
    VALUES (idMedic, idSpecializare, functia, grad, codParafa, competente, titluStiintific, postDidactic);
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareAsistentMedical( in idAsistent VARCHAR(10), in tip VARCHAR(10), in grad VARCHAR(10), in functia VARCHAR(25), in unitate VARCHAR(50))
BEGIN
	INSERT INTO asistent_medical(idAsistent, tip, grad, functia, unitate)
    VALUES (idAsistent, tip, grad, functia, unitate);

END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareReceptioner(in idReceptioner VARCHAR(10), in functia VARCHAR(25), in unitate VARCHAR(50))
BEGIN 
	INSERT INTO receptioner(idReceptioner, functia, unitate)
    VALUES (idReceptioner, functia, unitate);
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareEconomist(in idEconomist VARCHAR(10), in functia VARCHAR(50), in unitate VARCHAR(50))
BEGIN 
	INSERT INTO economist (idEconomist, functia, unitate)
    VALUES (idEconomist, functia, unitate);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareInspector(in idInspector VARCHAR(10))
BEGIN 
	INSERT INTO inspector_resurse_umane (idInspector)
    VALUES (idInspector);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareAdmin(in idAdmin VARCHAR(10), in functia VARCHAR(25), in unitate VARCHAR(50))
BEGIN 
	INSERT INTO administrator (idAdmin, functia, unitate)
    VALUES (idAdmin, functia, unitate);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE adaugarePacient(  in nume VARCHAR(50), in prenume VARCHAR(50), in IBAN DECIMAL(20,3))
BEGIN
	INSERT INTO pacient (nume, prenume, IBAN)
    VALUES (nume, prenume, IBAN);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE programMedic(in idMedic VARCHAR(10))
BEGIN 
	SELECT utilizator.nume, utilizator.prenume,orar_medic.zi, orar_medic.unitate, orar_medic.oraStart, orar_medic.oraFinal 
    FROM utilizator, orar_medic WHERE orar_medic.idMedic=idMedic AND utilizator.CNP=idMedic;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE afisareConcediu(in CNP VARCHAR(10))
BEGIN 
	SELECT utilizator.nume, utilizator.prenume, utilizator.concediuStart, utilizator.concediuFinal FROM utilizator
    WHERE utilizator.CNP=CNP;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE achitareConsultatie(in idConsultatie INT)
BEGIN 
	
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE afisareFond(in denumire VARCHAR(50))
BEGIN
	SELECT unitate_medicala.fond FROM unitate_medicala WHERE unitate_medicala.denumire=denumire;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE profitMedic(in idMedic VARCHAR(10))
BEGIN
	SELECT utilizator.nume, utilizator.prenume , salarii.suma, salarii.unitate FROM utilizator, salarii
    WHERE utilizator.CNP=idMedic AND salarii.idAngajat=idMedic;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE afisareSalarii(in idAngajat VARCHAR(10))
BEGIN
	SELECT utilizator.nume, utilizator.prenume , salarii.suma, salarii.luna FROM utilizator, salarii
    WHERE utilizator.CNP=idAngajat AND salarii.idAngajat=idAngajat;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareUnitate(in denumire VARCHAR(50), in adresa VARCHAR(256), in fond DECIMAL(20 , 2))
BEGIN 
	INSERT INTO unitate_medicala(denumire, adresa , fond)
    VALUES (denumire, adresa , fond);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE stergereUnitate(in denumire VARCHAR(50))
BEGIN 
	DELETE FROM unitate_medicala WHERE unitate_medicala.denumire=denumire;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE stergereServiciuMedical( in idSpecializare INT, in denumire VARCHAR(256))
BEGIN 
	DELETE FROM specializare WHERE specializare.denumire=denumire AND specializare.idSpecializare=idSpecializare;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareProgramUnitate(in unitate VARCHAR(50), in zi VARCHAR(10), in oraDeschidere TIME,in oraInchidere TIME)
BEGIN 
	DELETE FROM program_unitate WHERE program_unitate.unitate=unitate AND program_unitate.zi=zi;
    INSERT INTO program_unitate (unitate,zi ,oraDeschidere, oraInchidere)
    VALUES (unitate,zi ,oraDeschidere, oraInchidere);
END //
DELIMITER ;
 
DELIMITER //
CREATE PROCEDURE adaugareRaportMedical(in idAsistent VARCHAR(10), in idConsultatie INT, in istoric VARCHAR(256), in simptome VARCHAR(256), in  diagnostic VARCHAR(256), in recomandari VARCHAR(256))
BEGIN 
	INSERT INTO raport_medical (idAsistent, idConsultatie, istoric, simptome, diagnostic, recomandari)
    VALUES  (idAsistent, idConsultatie, istoric, simptome, diagnostic, recomandari);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE plataSalariu( in  idAngajat VARCHAR(10), in suma DECIMAL(10 , 2), in unitate VARCHAR(50), in luna DATE)
BEGIN
	INSERT INTO salarii( idAngajat, suma, unitate, luna)
    VALUES ( idAngajat, suma, unitate, luna);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE adaugareOrarMedic (in idMedic VARCHAR(10), in oraStart TIME, in oraFinal TIME, in zi DATE, in unitate VARCHAR(50))
BEGIN 
	INSERT INTO orar_medic(idMedic, oraStart, oraFinal, zi, unitate)
    VALUES (idMedic, oraStart, oraFinal, zi, unitate);
END //
DELIMITER ;
