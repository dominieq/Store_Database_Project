-- Generated by Oracle SQL Developer Data Modeler 18.3.0.268.1208
--   at:        2019-01-25 20:47:45 CET
--   site:      Oracle Database 12cR2
--   type:      Oracle Database 12cR2



CREATE TABLE dostawa (
    nrfaktury             INTEGER NOT NULL,
    datarozpocz�cia       DATE,
    datarealizacji        DATE,
    dostawca_iddostawcy   INTEGER NOT NULL
);

ALTER TABLE dostawa ADD CONSTRAINT dostawa_pk PRIMARY KEY ( nrfaktury );

CREATE TABLE dostawca (
    iddostawcy   INTEGER NOT NULL,
    nazwa        VARCHAR2(40 CHAR) NOT NULL,
    adres        VARCHAR2(100 CHAR) NOT NULL,
    telefon      VARCHAR2(15 CHAR) NOT NULL,
    mail         VARCHAR2(50 CHAR)
);

ALTER TABLE dostawca ADD CONSTRAINT dostawca_pk PRIMARY KEY ( iddostawcy );

CREATE TABLE kategoria (
    idkategorii      INTEGER NOT NULL,
    nazwakategorii   VARCHAR2(40 CHAR) NOT NULL
);

ALTER TABLE kategoria ADD CONSTRAINT kategoria_pk PRIMARY KEY ( idkategorii );

CREATE TABLE kurier (
    idkuriera   INTEGER NOT NULL,
    telefon     VARCHAR2(15 CHAR) NOT NULL
);

ALTER TABLE kurier ADD CONSTRAINT kurier_pk PRIMARY KEY ( idkuriera );

CREATE TABLE magazyn (
    idmagazynu               INTEGER NOT NULL,
    adres                    VARCHAR2(100 CHAR) NOT NULL,
    pracownik_idpracownika   INTEGER NOT NULL
);

CREATE UNIQUE INDEX magazyn__idx ON
    magazyn (
        pracownik_idpracownika
    ASC );

ALTER TABLE magazyn ADD CONSTRAINT magazyn_pk PRIMARY KEY ( idmagazynu );

CREATE TABLE odbiorca (
    idodbiorcy   INTEGER NOT NULL,
    imi�         VARCHAR2(20 CHAR) NOT NULL,
    nazwisko     VARCHAR2(30 CHAR) NOT NULL,
    adres        VARCHAR2(100 CHAR) NOT NULL,
    telefon      VARCHAR2(15 CHAR) NOT NULL
);

ALTER TABLE odbiorca ADD CONSTRAINT odbiorca_pk PRIMARY KEY ( idodbiorcy );

CREATE TABLE podpunkty_dostawy (
    dostawa_nrfaktury        INTEGER NOT NULL,
    sm_towar_idtowaru        INTEGER NOT NULL,
    smy_magazyn_idmagazynu   INTEGER NOT NULL,
    ilo��                    INTEGER NOT NULL
);

ALTER TABLE podpunkty_dostawy
    ADD CONSTRAINT relation_20_pk PRIMARY KEY ( dostawa_nrfaktury,
                                                sm_towar_idtowaru,
                                                smy_magazyn_idmagazynu );

CREATE TABLE podpunkty_zam�wienia (
    z_nrzam�wienia          INTEGER NOT NULL,
    sm_towar_idtowaru       INTEGER NOT NULL,
    sm_magazyn_idmagazynu   INTEGER NOT NULL,
    ilo��                   INTEGER NOT NULL
);

ALTER TABLE podpunkty_zam�wienia
    ADD CONSTRAINT relation_21_pk PRIMARY KEY ( z_nrzam�wienia,
                                                sm_towar_idtowaru,
                                                sm_magazyn_idmagazynu );

CREATE TABLE pracownik (
    idpracownika   INTEGER NOT NULL,
    imi�           VARCHAR2(20 CHAR) NOT NULL,
    nazwisko       VARCHAR2(30 CHAR) NOT NULL,
    adres          VARCHAR2(100 CHAR) NOT NULL,
    telefon        VARCHAR2(15 CHAR),
    mail           VARCHAR2(50 CHAR),
    pesel          VARCHAR2(11 CHAR) NOT NULL
);

ALTER TABLE pracownik ADD CONSTRAINT pracownik_pk PRIMARY KEY ( idpracownika );

CREATE TABLE producent (
    idproducenta   INTEGER NOT NULL,
    nazwa          VARCHAR2(40 CHAR) NOT NULL,
    adres          VARCHAR2(100 CHAR),
    mail           VARCHAR2(50 CHAR),
    telefon        VARCHAR2(15),
    witryna        VARCHAR2(30)
);

ALTER TABLE producent ADD CONSTRAINT producent_pk PRIMARY KEY ( idproducenta );

CREATE TABLE stan_magazynowy (
    ilo��                INTEGER NOT NULL,
    towar_idtowaru       INTEGER NOT NULL,
    magazyn_idmagazynu   INTEGER NOT NULL
);

CREATE INDEX stan_magazynowy__idx ON
    stan_magazynowy (
        towar_idtowaru
    ASC,
        magazyn_idmagazynu
    ASC,
        ilo��
    ASC );

CREATE INDEX stan_magazynowy__idxv1 ON
    stan_magazynowy (
        magazyn_idmagazynu
    ASC,
        towar_idtowaru
    ASC,
        ilo��
    ASC );

ALTER TABLE stan_magazynowy ADD CONSTRAINT stan_magazynowy_pk PRIMARY KEY ( towar_idtowaru,
                                                                            magazyn_idmagazynu );

CREATE TABLE towar (
    idtowaru                 INTEGER NOT NULL,
    nazwa                    VARCHAR2(25 CHAR) NOT NULL,
    cenadetaliczna           NUMBER(12, 2),
    cenaproducenta           NUMBER(12, 2),
    producent_idproducenta   INTEGER NOT NULL,
    kategoria_idkategorii    INTEGER NOT NULL
);

CREATE INDEX towar__idx ON
    towar (
        nazwa
    ASC,
        idtowaru
    ASC );

ALTER TABLE towar ADD CONSTRAINT towar_pk PRIMARY KEY ( idtowaru );

CREATE TABLE zam�wienie (
    nrzam�wienia          INTEGER NOT NULL,
    datazam�wienia        DATE NOT NULL,
    datarealizacji        DATE,
    kurier_idkuriera      INTEGER NOT NULL,
    odbiorca_idodbiorcy   INTEGER NOT NULL
);

CREATE INDEX zam�wienie__idx ON
    zam�wienie (
        odbiorca_idodbiorcy
    ASC,
        nrzam�wienia
    ASC );

ALTER TABLE zam�wienie ADD CONSTRAINT zam�wienie_pk PRIMARY KEY ( nrzam�wienia );

ALTER TABLE dostawa
    ADD CONSTRAINT dostawa_dostawca_fk FOREIGN KEY ( dostawca_iddostawcy )
        REFERENCES dostawca ( iddostawcy );

ALTER TABLE magazyn
    ADD CONSTRAINT magazyn_pracownik_fk FOREIGN KEY ( pracownik_idpracownika )
        REFERENCES pracownik ( idpracownika );

ALTER TABLE podpunkty_dostawy
    ADD CONSTRAINT r_20_dostawa_fk FOREIGN KEY ( dostawa_nrfaktury )
        REFERENCES dostawa ( nrfaktury );

ALTER TABLE podpunkty_dostawy
    ADD CONSTRAINT r_20_stan_magazynowy_fk FOREIGN KEY ( sm_towar_idtowaru,
                                                         smy_magazyn_idmagazynu )
        REFERENCES stan_magazynowy ( towar_idtowaru,
                                     magazyn_idmagazynu );

ALTER TABLE podpunkty_zam�wienia
    ADD CONSTRAINT r_21_stan_magazynowy_fk FOREIGN KEY ( sm_towar_idtowaru,
                                                         sm_magazyn_idmagazynu )
        REFERENCES stan_magazynowy ( towar_idtowaru,
                                     magazyn_idmagazynu );

ALTER TABLE podpunkty_zam�wienia
    ADD CONSTRAINT r_21_zam�wienie_fk FOREIGN KEY ( z_nrzam�wienia )
        REFERENCES zam�wienie ( nrzam�wienia );

ALTER TABLE stan_magazynowy
    ADD CONSTRAINT sm_magazyn_fk FOREIGN KEY ( magazyn_idmagazynu )
        REFERENCES magazyn ( idmagazynu );

ALTER TABLE stan_magazynowy
    ADD CONSTRAINT sm_towar_fk FOREIGN KEY ( towar_idtowaru )
        REFERENCES towar ( idtowaru );

ALTER TABLE towar
    ADD CONSTRAINT towar_kategoria_fk FOREIGN KEY ( kategoria_idkategorii )
        REFERENCES kategoria ( idkategorii );

ALTER TABLE towar
    ADD CONSTRAINT towar_producent_fk FOREIGN KEY ( producent_idproducenta )
        REFERENCES producent ( idproducenta );

ALTER TABLE zam�wienie
    ADD CONSTRAINT zam�wienie_kurier_fk FOREIGN KEY ( kurier_idkuriera )
        REFERENCES kurier ( idkuriera );

ALTER TABLE zam�wienie
    ADD CONSTRAINT zam�wienie_odbiorca_fk FOREIGN KEY ( odbiorca_idodbiorcy )
        REFERENCES odbiorca ( idodbiorcy );

ALTER TABLE dostawa
    ADD CONSTRAINT dostawa_dostawca_fk FOREIGN KEY ( dostawca_iddostawcy )
        REFERENCES dostawca ( iddostawcy );

ALTER TABLE magazyn
    ADD CONSTRAINT magazyn_pracownik_fk FOREIGN KEY ( pracownik_idpracownika )
        REFERENCES pracownik ( idpracownika );

ALTER TABLE podpunkty_dostawy
    ADD CONSTRAINT r_20_dostawa_fk FOREIGN KEY ( dostawa_nrfaktury )
        REFERENCES dostawa ( nrfaktury );

ALTER TABLE podpunkty_dostawy
    ADD CONSTRAINT r_20_stan_magazynowy_fk FOREIGN KEY ( sm_towar_idtowaru,
                                                         smy_magazyn_idmagazynu )
        REFERENCES stan_magazynowy ( towar_idtowaru,
                                     magazyn_idmagazynu );

ALTER TABLE podpunkty_zam�wienia
    ADD CONSTRAINT r_21_stan_magazynowy_fk FOREIGN KEY ( sm_towar_idtowaru,
                                                         sm_magazyn_idmagazynu )
        REFERENCES stan_magazynowy ( towar_idtowaru,
                                     magazyn_idmagazynu );

ALTER TABLE podpunkty_zam�wienia
    ADD CONSTRAINT r_21_zam�wienie_fk FOREIGN KEY ( z_nrzam�wienia )
        REFERENCES zam�wienie ( nrzam�wienia );

ALTER TABLE stan_magazynowy
    ADD CONSTRAINT sm_magazyn_fk FOREIGN KEY ( magazyn_idmagazynu )
        REFERENCES magazyn ( idmagazynu );

ALTER TABLE stan_magazynowy
    ADD CONSTRAINT sm_towar_fk FOREIGN KEY ( towar_idtowaru )
        REFERENCES towar ( idtowaru );

ALTER TABLE towar
    ADD CONSTRAINT towar_kategoria_fk FOREIGN KEY ( kategoria_idkategorii )
        REFERENCES kategoria ( idkategorii );

ALTER TABLE towar
    ADD CONSTRAINT towar_producent_fk FOREIGN KEY ( producent_idproducenta )
        REFERENCES producent ( idproducenta );

ALTER TABLE zam�wienie
    ADD CONSTRAINT zam�wienie_kurier_fk FOREIGN KEY ( kurier_idkuriera )
        REFERENCES kurier ( idkuriera );

ALTER TABLE zam�wienie
    ADD CONSTRAINT zam�wienie_odbiorca_fk FOREIGN KEY ( odbiorca_idodbiorcy )
        REFERENCES odbiorca ( idodbiorcy );

CREATE SEQUENCE dostawa_nrfaktury_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER dostawa_nrfaktury_trg BEFORE
    INSERT ON dostawa
    FOR EACH ROW
    WHEN ( new.nrfaktury IS NULL )
BEGIN
    :new.nrfaktury := dostawa_nrfaktury_seq.nextval;
END;
/

CREATE SEQUENCE dostawca_iddostawcy_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER dostawca_iddostawcy_trg BEFORE
    INSERT ON dostawca
    FOR EACH ROW
    WHEN ( new.iddostawcy IS NULL )
BEGIN
    :new.iddostawcy := dostawca_iddostawcy_seq.nextval;
END;
/

CREATE SEQUENCE kategoria_idkategorii_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER kategoria_idkategorii_trg BEFORE
    INSERT ON kategoria
    FOR EACH ROW
    WHEN ( new.idkategorii IS NULL )
BEGIN
    :new.idkategorii := kategoria_idkategorii_seq.nextval;
END;
/

CREATE SEQUENCE kurier_idkuriera_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER kurier_idkuriera_trg BEFORE
    INSERT ON kurier
    FOR EACH ROW
    WHEN ( new.idkuriera IS NULL )
BEGIN
    :new.idkuriera := kurier_idkuriera_seq.nextval;
END;
/

CREATE SEQUENCE magazyn_idmagazynu_seq START WITH 1 MINVALUE 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER magazyn_idmagazynu_trg BEFORE
    INSERT ON magazyn
    FOR EACH ROW
BEGIN
    :new.idmagazynu := magazyn_idmagazynu_seq.nextval;
END;
/

CREATE SEQUENCE odbiorca_idodbiorcy_seq START WITH 1 MINVALUE 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER odbiorca_idodbiorcy_trg BEFORE
    INSERT ON odbiorca
    FOR EACH ROW
BEGIN
    :new.idodbiorcy := odbiorca_idodbiorcy_seq.nextval;
END;
/

CREATE SEQUENCE pracownik_idpracownika_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER pracownik_idpracownika_trg BEFORE
    INSERT ON pracownik
    FOR EACH ROW
    WHEN ( new.idpracownika IS NULL )
BEGIN
    :new.idpracownika := pracownik_idpracownika_seq.nextval;
END;
/

CREATE SEQUENCE producent_idproducenta_seq START WITH 1 MINVALUE 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER producent_idproducenta_trg BEFORE
    INSERT ON producent
    FOR EACH ROW
BEGIN
    :new.idproducenta := producent_idproducenta_seq.nextval;
END;
/

CREATE SEQUENCE seq_towar START WITH 1 MINVALUE 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER towar_idtowaru_trg BEFORE
    INSERT ON towar
    FOR EACH ROW
BEGIN
    :new.idtowaru := seq_towar.nextval;
END;
/

CREATE SEQUENCE zam�wienie_nrzam�wienia_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER zam�wienie_nrzam�wienia_trg BEFORE
    INSERT ON zam�wienie
    FOR EACH ROW
    WHEN ( new.nrzam�wienia IS NULL )
BEGIN
    :new.nrzam�wienia := zam�wienie_nrzam�wienia_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            13
-- CREATE INDEX                             5
-- ALTER TABLE                             37
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          10
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                         10
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0