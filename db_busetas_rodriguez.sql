--------------------------------------------------------
--  File created - Wednesday-March-20-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TAB_AUD_CLIENTE
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_AUD_CLIENTE" 
   (	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"USUARIO" VARCHAR2(150 BYTE), 
	"ACCION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_AUD_CONDUCTOR
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_AUD_CONDUCTOR" 
   (	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"USUARIO" VARCHAR2(150 BYTE), 
	"ACCION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_AUD_ESCUELA
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_AUD_ESCUELA" 
   (	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"USUARIO" VARCHAR2(150 BYTE), 
	"ACCION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_AUD_VEHICULO
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_AUD_VEHICULO" 
   (	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"USUARIO" VARCHAR2(150 BYTE), 
	"ACCION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_CLIENTE
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_CLIENTE" 
   (	"CEDULA" VARCHAR2(20 BYTE), 
	"NOMBRE" VARCHAR2(25 BYTE), 
	"APELLIDO1" VARCHAR2(25 BYTE), 
	"APELLIDO2" VARCHAR2(25 BYTE), 
	"UBICACION" VARCHAR2(255 BYTE), 
	"CANTIDAD_CLIENTES" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_CONDUCTOR
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_CONDUCTOR" 
   (	"CEDULA" VARCHAR2(20 BYTE), 
	"NOMBRE" VARCHAR2(25 BYTE), 
	"APELLIDO1" VARCHAR2(25 BYTE), 
	"APELLIDO2" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_ESCUELA
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_ESCUELA" 
   (	"ID_ESCUELA" NUMBER, 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"UBICACION" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_RUTA
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_RUTA" 
   (	"PLACA" VARCHAR2(20 BYTE), 
	"ID_ESCUELA" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_VEHICULO
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_VEHICULO" 
   (	"PLACA" VARCHAR2(20 BYTE), 
	"MODELO" VARCHAR2(20 BYTE), 
	"MARCA" VARCHAR2(20 BYTE), 
	"CAPACIDAD" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_VEHICULO_CLIENTE
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_VEHICULO_CLIENTE" 
   (	"PLACA" VARCHAR2(20 BYTE), 
	"CEDULA_CLIENTE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TAB_VEHICULO_CONDUCTOR
--------------------------------------------------------

  CREATE TABLE "JONA"."TAB_VEHICULO_CONDUCTOR" 
   (	"PLACA" VARCHAR2(20 BYTE), 
	"CEDULA" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into JONA.TAB_AUD_CLIENTE
SET DEFINE OFF;
REM INSERTING into JONA.TAB_AUD_CONDUCTOR
SET DEFINE OFF;
REM INSERTING into JONA.TAB_AUD_ESCUELA
SET DEFINE OFF;
REM INSERTING into JONA.TAB_AUD_VEHICULO
SET DEFINE OFF;
REM INSERTING into JONA.TAB_CLIENTE
SET DEFINE OFF;
REM INSERTING into JONA.TAB_CONDUCTOR
SET DEFINE OFF;
REM INSERTING into JONA.TAB_ESCUELA
SET DEFINE OFF;
REM INSERTING into JONA.TAB_RUTA
SET DEFINE OFF;
REM INSERTING into JONA.TAB_VEHICULO
SET DEFINE OFF;
REM INSERTING into JONA.TAB_VEHICULO_CLIENTE
SET DEFINE OFF;
REM INSERTING into JONA.TAB_VEHICULO_CONDUCTOR
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index TAB_AUD_CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_AUD_CLIENTE_PK" ON "JONA"."TAB_AUD_CLIENTE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_AUD_CONDUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_AUD_CONDUCTOR_PK" ON "JONA"."TAB_AUD_CONDUCTOR" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_AUD_ESCUELA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_AUD_ESCUELA_PK" ON "JONA"."TAB_AUD_ESCUELA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_AUD_VEHICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_AUD_VEHICULO_PK" ON "JONA"."TAB_AUD_VEHICULO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_CLIENTE_PK" ON "JONA"."TAB_CLIENTE" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_CONDUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_CONDUCTOR_PK" ON "JONA"."TAB_CONDUCTOR" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ESCUELA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."ESCUELA_PK" ON "JONA"."TAB_ESCUELA" ("ID_ESCUELA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index RUTA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."RUTA_PK" ON "JONA"."TAB_RUTA" ("PLACA", "ID_ESCUELA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_VEHICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_VEHICULO_PK" ON "JONA"."TAB_VEHICULO" ("PLACA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_VEHICULO_CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_VEHICULO_CLIENTE_PK" ON "JONA"."TAB_VEHICULO_CLIENTE" ("PLACA", "CEDULA_CLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TAB_VEHICULO_CONDUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JONA"."TAB_VEHICULO_CONDUCTOR_PK" ON "JONA"."TAB_VEHICULO_CONDUCTOR" ("PLACA", "CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger TRG_INSERT_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_INSERT_CLIENTE" 
AFTER INSERT ON TAB_CLIENTE
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CLIENTE (USUARIO, ACCION)
    VALUES (USER(), 'INSERT');
END;
/
ALTER TRIGGER "JONA"."TRG_INSERT_CLIENTE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_UPDATE_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_UPDATE_CLIENTE" 
AFTER UPDATE ON TAB_CLIENTE
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CLIENTE (USUARIO, ACCION)
    VALUES (USER(), 'UPDATE');
END;
/
ALTER TRIGGER "JONA"."TRG_UPDATE_CLIENTE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_DELETE_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_DELETE_CLIENTE" 
BEFORE DELETE ON TAB_CLIENTE
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CLIENTE (USUARIO, ACCION)
    VALUES (USER(), 'DELETE');
END;
/
ALTER TRIGGER "JONA"."TRG_DELETE_CLIENTE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_INSERT_CONDUCTOR
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_INSERT_CONDUCTOR" 
AFTER INSERT ON TAB_CONDUCTOR
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CONDUCTOR (USUARIO, ACCION)
    VALUES (USER(), 'INSERT');
END;
/
ALTER TRIGGER "JONA"."TRG_INSERT_CONDUCTOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_UPDATE_CONDUCTOR
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_UPDATE_CONDUCTOR" 
AFTER UPDATE ON TAB_CONDUCTOR
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CONDUCTOR (USUARIO, ACCION)
    VALUES (USER(), 'UPDATE');
END;
/
ALTER TRIGGER "JONA"."TRG_UPDATE_CONDUCTOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_DELETE_CONDUCTOR
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_DELETE_CONDUCTOR" 
BEFORE DELETE ON TAB_CONDUCTOR
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_CONDUCTOR (USUARIO, ACCION)
    VALUES (USER(), 'DELETE');
END;
/
ALTER TRIGGER "JONA"."TRG_DELETE_CONDUCTOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_INSERT_ESCUELA
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_INSERT_ESCUELA" 
AFTER INSERT ON TAB_ESCUELA
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_ESCUELA (USUARIO, ACCION)
    VALUES (USER(), 'INSERT');
END;
/
ALTER TRIGGER "JONA"."TRG_INSERT_ESCUELA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_UPDATE_ESCUELA
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_UPDATE_ESCUELA" 
AFTER UPDATE ON TAB_ESCUELA
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_ESCUELA (USUARIO, ACCION)
    VALUES (USER(), 'UPDATE');
END;
/
ALTER TRIGGER "JONA"."TRG_UPDATE_ESCUELA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_DELETE_ESCUELA
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_DELETE_ESCUELA" 
BEFORE DELETE ON TAB_ESCUELA
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_ESCUELA (USUARIO, ACCION)
    VALUES (USER(), 'DELETE');
END;
/
ALTER TRIGGER "JONA"."TRG_DELETE_ESCUELA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_INSERT_VEHICULO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_INSERT_VEHICULO" 
AFTER INSERT ON TAB_VEHICULO
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_VEHICULO (USUARIO, ACCION)
    VALUES (USER(), 'INSERT');
END;
/
ALTER TRIGGER "JONA"."TRG_INSERT_VEHICULO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_UPDATE_VEHICULO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_UPDATE_VEHICULO" 
AFTER UPDATE ON TAB_VEHICULO
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_VEHICULO (USUARIO, ACCION)
    VALUES (USER(), 'UPDATE');
END;
/
ALTER TRIGGER "JONA"."TRG_UPDATE_VEHICULO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRG_DELETE_VEHICULO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "JONA"."TRG_DELETE_VEHICULO" 
BEFORE DELETE ON TAB_VEHICULO
FOR EACH ROW
BEGIN
    INSERT INTO TAB_AUD_VEHICULO (USUARIO, ACCION)
    VALUES (USER(), 'DELETE');
END;
/
ALTER TRIGGER "JONA"."TRG_DELETE_VEHICULO" ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_AUD_CLIENTE
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_AUD_CLIENTE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_AUD_CLIENTE" ADD CONSTRAINT "TAB_AUD_CLIENTE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_AUD_CONDUCTOR
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_AUD_CONDUCTOR" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_AUD_CONDUCTOR" ADD CONSTRAINT "TAB_AUD_CONDUCTOR_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_AUD_ESCUELA
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_AUD_ESCUELA" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_AUD_ESCUELA" ADD CONSTRAINT "TAB_AUD_ESCUELA_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_AUD_VEHICULO
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_AUD_VEHICULO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_AUD_VEHICULO" ADD CONSTRAINT "TAB_AUD_VEHICULO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_CLIENTE
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_CLIENTE" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_CLIENTE" ADD CONSTRAINT "TAB_CLIENTE_PK" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_CONDUCTOR
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_CONDUCTOR" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_CONDUCTOR" ADD CONSTRAINT "TAB_CONDUCTOR_PK" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_ESCUELA
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_ESCUELA" MODIFY ("ID_ESCUELA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_ESCUELA" ADD CONSTRAINT "ESCUELA_PK" PRIMARY KEY ("ID_ESCUELA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_RUTA
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_RUTA" MODIFY ("PLACA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_RUTA" MODIFY ("ID_ESCUELA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_RUTA" ADD CONSTRAINT "RUTA_PK" PRIMARY KEY ("PLACA", "ID_ESCUELA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_VEHICULO
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_VEHICULO" MODIFY ("PLACA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_VEHICULO" ADD CONSTRAINT "TAB_VEHICULO_PK" PRIMARY KEY ("PLACA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_VEHICULO_CLIENTE
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_VEHICULO_CLIENTE" MODIFY ("PLACA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_VEHICULO_CLIENTE" MODIFY ("CEDULA_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_VEHICULO_CLIENTE" ADD CONSTRAINT "TAB_VEHICULO_CLIENTE_PK" PRIMARY KEY ("PLACA", "CEDULA_CLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAB_VEHICULO_CONDUCTOR
--------------------------------------------------------

  ALTER TABLE "JONA"."TAB_VEHICULO_CONDUCTOR" MODIFY ("PLACA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_VEHICULO_CONDUCTOR" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "JONA"."TAB_VEHICULO_CONDUCTOR" ADD CONSTRAINT "TAB_VEHICULO_CONDUCTOR_PK" PRIMARY KEY ("PLACA", "CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
