USE policlinica;

DROP VIEW IF EXISTS medici;
DROP VIEW IF EXISTS asistenti_medicali;
DROP VIEW IF EXISTS pacienti;
DROP VIEW IF EXISTS istoric;
DROP VIEW IF EXISTS orar;
DROP VIEW IF EXISTS economisti;
DROP VIEW IF EXISTS specializari;
DROP VIEW IF EXISTS receptioneri;
DROP VIEW IF EXISTS consultatii;
DROP VIEW IF EXISTS programari;
DROP VIEW IF EXISTS rapoarte_medicale;
DROP VIEW IF EXISTS inspectori_resurse_umane;
DROP VIEW IF EXISTS medic_orar;

CREATE VIEW medici AS
    SELECT 
        utilizator.nume,
        utilizator.prenume,
        medic.idSpecializare,
        medic.grad,
        medic.competente,
        medic.postDidactic,
        medic.titluStiintific,
        utilizator.salariuNeg,
        utilizator.ore
    FROM
        utilizator,
        medic,
        specializare
    WHERE
        utilizator.CNP = medic.idMedic
            AND medic.idSpecializare = specializare.idSpecializare
    ORDER BY nume ASC;

CREATE VIEW asistenti_medicali AS
    SELECT 
        utilizator.nume,
        utilizator.prenume,
        asistent_medical.tip,
        asistent_medical.grad,
        asistent_medical.unitate
    FROM
        utilizator,
        asistent_medical,
        unitate_medicala
    WHERE
        asistent_medical.idAsistent = utilizator.CNP
            AND asistent_medical.unitate = unitate_medicala.denumire
    ORDER BY nume ASC;

CREATE VIEW pacienti AS
    SELECT 
        pacient.idPacient,
        pacient.nume,
        pacient.prenume,
        consultatie.idConsultatie,
        consultatie.pret
    FROM
        pacient,
        consultatie
    WHERE
        consultatie.idPacient = pacient.idPacient
    ORDER BY nume ASC;

CREATE VIEW istoric AS
    SELECT DISTINCT
        pacient.idPacient,
        pacient.nume,
        pacient.prenume,
        consultatie.idConsultatie,
        consultatie.pret,
        consultatie.idMedic
    FROM
        pacient,
        consultatie,
        utilizator
    WHERE
        consultatie.idPacient = pacient.idPacient
            AND consultatie.idMedic = utilizator.CNP
    ORDER BY CNP ASC;

CREATE VIEW orar AS
    SELECT 
        program_unitate.zi,
        program_unitate.oraDeschidere,
        program_unitate.oraInchidere,
        unitate_medicala.denumire
    FROM
        program_unitate,
        unitate_medicala
    WHERE
        unitate_medicala.denumire = program_unitate.unitate
    ORDER BY denumire ASC;

CREATE VIEW economisti AS
    SELECT 
        economist.idEconomist,
        economist.unitate,
        utilizator.nume,
        utilizator.prenume
    FROM
        economist,
        utilizator
    WHERE
        economist.idEconomist = utilizator.CNP
    ORDER BY unitate ASC;

CREATE VIEW specializari AS
    SELECT 
        specializare.idSpecializare,
        specializare.denumire,
        specializare.pret
    FROM
        specializare
    ORDER BY idSpecializare ASC , pret DESC;

CREATE VIEW receptioneri AS
    SELECT 
        receptioner.idReceptioner,
        receptioner.unitate,
        utilizator.nume,
        utilizator.prenume
    FROM
        receptioner,
        utilizator
    WHERE
        receptioner.idReceptioner = utilizator.CNP
    ORDER BY unitate ASC;

CREATE VIEW consultatii AS
    SELECT 
        consultatie.idConsultatie,
        consultatie.idPacient,
        pacient.nume,
        pacient.prenume,
        consultatie.idMedic,
        consultatie.durata,
        consultatie.pret
    FROM
        consultatie,
        utilizator,
        pacient
    WHERE
        consultatie.idMedic = utilizator.CNP
            AND consultatie.idPacient = pacient.idPacient
    ORDER BY idConsultatie ASC;

CREATE VIEW programari AS
    SELECT 
        programare.idConsultatie,
        programare.ora,
        programare.unitate
    FROM
        programare, orar_medic, medic
    WHERE
        medic.idMedic = orar_medic.idMedic
    ORDER BY ora ASC;

CREATE VIEW rapoarte_medicale AS
    SELECT DISTINCT
        raport_medical.idRaport,
        raport_medical.idConsultatie,
        consultatie.idPacient,
        pacient.nume,
        pacient.prenume,
        utilizator.nume,
        utilizator.prenume,
        consultatie.idMedic,
        raport_medical.idAsistent,
        raport_medical.istoric,
        raport_medical.simptome,
        raport_medical.diagnostic,
        raport_medical.recomandari
    FROM
        raport_medical,
        asistent_medical,
        consultatie,
        pacient,
        medic
    WHERE
        asistent_medical.idAsistent = raport_medical.idAsistent
            AND consultatie.idPacient = pacient.idPacient
            AND raport_medical.idConsultatie = consultatie.idConsultatie
    ORDER BY idRaport;

CREATE VIEW inspectori_resurse_umane AS
    SELECT 
        inspector_resurse_umane.idInspector,
        utilizator.nume,
        utilizator.prenume
    FROM
        inspector_resurse_umane,
        utilizator
    WHERE
        inspector_resurse_umane.idInspector = utilizator.CNP
    ORDER BY nume;
    
-- SELECT * FROM medici;
-- SELECT * FROM asistenti_medicali;
-- SELECT * FROM istoric;
-- SELECT * FROM orar;
-- SELECT * FROM economisti;

-- SELECT * FROM rapoarte_medicale;

-- SELECT * FROM receptioneri;
-- SELECT * FROM consultatii;
-- SELECT * FROM programari;
-- SELECT * FROM rapoarte_medicale;
-- SELECT * FROM inspectori_resurse_umane;