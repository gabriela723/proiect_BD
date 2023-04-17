DROP DATABASE IF EXISTS policlinica;
CREATE DATABASE IF NOT EXISTS policlinica;
USE policlinica;

CREATE TABLE IF NOT EXISTS unitate_medicala (
    denumire VARCHAR(50),
    adresa VARCHAR(256),
    serviciiOferite VARCHAR(256),
    fond DECIMAL(20 , 2),
    PRIMARY KEY (denumire)
);

CREATE TABLE IF NOT EXISTS program_unitate (
    zi VARCHAR(10),
    oraDeschidere TIME,
    oraInchidere TIME,
    unitate VARCHAR(50),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
);

CREATE TABLE IF NOT EXISTS utilizator (
    CNP VARCHAR(10),
    parola VARCHAR(20),
    nume VARCHAR(50),
    prenume VARCHAR(50),
    adresa VARCHAR(256),
    nrTelefon VARCHAR(10),
    email VARCHAR(256),
    IBAN DECIMAL(20,2),
    nrContract VARCHAR(50),
    dataAngajarii DATE,
    functia VARCHAR(25),
    salariuNeg DECIMAL(10 , 2),
    ore INT,
    concediuStart DATE,
    concediuFinal DATE,
    PRIMARY KEY (CNP)
);

CREATE TABLE IF NOT EXISTS specializare (
    idSpecializare int AUTO_INCREMENT,
    denumire VARCHAR(256),
	pret DECIMAL(10, 2),
    PRIMARY KEY (idSpecializare)
);

CREATE TABLE IF NOT EXISTS medic (
    idMedic VARCHAR(10),
    idSpecializare int,
    functia VARCHAR(25),
    grad VARCHAR(10),
    codParafa VARCHAR(10),
    competente VARCHAR(256),
    titluStiintific VARCHAR(30),
    postDidactic VARCHAR(30),
	PRIMARY KEY (idMedic),
    FOREIGN KEY (idMedic)
        REFERENCES utilizator (CNP),
    FOREIGN KEY (idSpecializare)
        REFERENCES specializare (idSpecializare)
);

CREATE TABLE IF NOT EXISTS asistent_medical (
    idAsistent VARCHAR(10),
    tip VARCHAR(10),
    grad VARCHAR(10),
    functia VARCHAR(25),
    unitate VARCHAR(50),
    PRIMARY KEY (idAsistent),
    FOREIGN KEY (idAsistent)
        REFERENCES utilizator (CNP),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
);

CREATE TABLE IF NOT EXISTS receptioner (
    idReceptioner VARCHAR(10),
    functia VARCHAR(25),
    unitate VARCHAR(50),
    FOREIGN KEY (idReceptioner)
        REFERENCES utilizator (CNP),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire),
    PRIMARY KEY (idReceptioner)
);

CREATE TABLE IF NOT EXISTS economist (
    idEconomist VARCHAR(10),
    functia VARCHAR(25),
    unitate VARCHAR(50),
    FOREIGN KEY (idEconomist)
        REFERENCES utilizator (CNP),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
);

CREATE TABLE IF NOT EXISTS inspector_resurse_umane (
    idInspector VARCHAR(10),
    FOREIGN KEY (idInspector)
        REFERENCES utilizator (CNP)
);

CREATE TABLE IF NOT EXISTS pacient (
    idPacient int auto_increment,
    nume VARCHAR(50),
    prenume VARCHAR(50),
    IBAN DECIMAL(20,2),
    PRIMARY KEY (idPacient)
);

CREATE TABLE IF NOT EXISTS orar_medic (
    idMedic VARCHAR(10),
    oraStart TIME,
    oraFinal TIME,
    zi DATE,
    unitate VARCHAR(50),
    PRIMARY KEY (oraStart),
    FOREIGN KEY (idMedic)
        REFERENCES medic (idMedic),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
);

CREATE TABLE IF NOT EXISTS programare (
    idConsultatie INT auto_increment,
    zi DATE,
    unitate VARCHAR(50),
    ora TIME,
    PRIMARY KEY(idConsultatie),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
    -- FOREIGN KEY (ora)
       --  REFERENCES orar_medic (oraStart)
);

CREATE TABLE IF NOT EXISTS administrator(
	idAdmin VARCHAR(10),
    functia VARCHAR(25),
    unitate VARCHAR(50),
    FOREIGN KEY(idAdmin) REFERENCES utilizator(CNP),
    FOREIGN KEY(unitate) REFERENCES unitate_medicala(denumire)
);

CREATE TABLE IF NOT EXISTS superAdministrator(
	idSuperAdmin VARCHAR(10),
    functia VARCHAR(25),
    unitate VARCHAR(50),
    FOREIGN KEY(idSuperAdmin) REFERENCES utilizator(CNP),
    FOREIGN KEY(unitate) REFERENCES unitate_medicala(denumire)
);

CREATE TABLE IF NOT EXISTS consultatie (
    idConsultatie INT auto_increment,
    durata TIME,
    pret DECIMAL(10, 2),
    idMedic VARCHAR(10),
    idSpecializare INT,
    idPacient INT,
    denumireUnitate VARCHAR(50),
    FOREIGN KEY (idMedic)
        REFERENCES medic (idMedic),
    FOREIGN KEY (idPacient)
        REFERENCES pacient (idPacient),
	FOREIGN KEY (idConsultatie)
		REFERENCES programare(idConsultatie),
	FOREIGN KEY (idSpecializare)
		REFERENCES specializare(idSpecializare),
    PRIMARY KEY (idConsultatie)
);

CREATE TABLE IF NOT EXISTS salarii (
    idAngajat VARCHAR(10),
    suma DECIMAL(10 , 2),
    unitate VARCHAR(50),
    luna DATE,
    FOREIGN KEY (idAngajat)
        REFERENCES utilizator (CNP),
    FOREIGN KEY (unitate)
        REFERENCES unitate_medicala (denumire)
);

CREATE TABLE IF NOT EXISTS bon_fiscal (
    idConsultatie INT,
    idReceptioner VARCHAR(10),
    idPacient INT,
    FOREIGN KEY (idConsultatie)
        REFERENCES consultatie (idConsultatie),
    FOREIGN KEY (idReceptioner)
        REFERENCES receptioner (idReceptioner)
);

CREATE TABLE IF NOT EXISTS raport_medical (
    idAsistent VARCHAR(10),
    idConsultatie INT,
    istoric VARCHAR(256),
    simptome VARCHAR(256),
    diagnostic VARCHAR(256),
    recomandari VARCHAR(256),
    codParafa VARCHAR(10),
    FOREIGN KEY (idAsistent)
        REFERENCES asistent_medical (idAsistent),
    FOREIGN KEY (idConsultatie)
        REFERENCES consultatie (idConsultatie)
);