INSERT INTO TAB_CONDUCTOR(cedula,nombre,apellido1,apellido2)
VALUES('100','Kevin','Castro','Lara');
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('51', 50000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('52', 52000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('53', 51000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('54', 56000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('89', 480000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('88', 700000.00, TO_DATE('2024-04-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_SALARIO (cedula, salario, fecha_ingreso)
VALUES ('100', 999000.00, TO_DATE('2023-08-01', 'YYYY-MM-DD'));
/
INSERT INTO TAB_QUEJAS (placa, comentario, fecha, cedula_cliente)
VALUES ('BFF151', 'Chofer temerario', SYSDATE,'11');
/
INSERT INTO TAB_ESCUELA(id_escuela,nombre,ubicacion)
VALUES(5,'Escuela Santa Cecilia','Cristo Rey');


SELECT * FROM TAB_CLIENTE;
SELECT * FROM TAB_aud_ESCUELA;
SELECT * FROM TAB_CONDUCTOR;
SELECT * FROM TAB_VEHICULO;
SELECT * FROM TAB_RUTA;



--Funcion para calcular la cantidad de clientes por escuela 1/11
CREATE OR REPLACE FUNCTION CALCULAR_CLIENTES_POR_ESCUELA
RETURN SYS_REFCURSOR
IS 
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT e.ID_ESCUELA, e.NOMBRE AS NOMBRE_ESCUELA, SUM(c.CANTIDAD_CLIENTES)
    FROM TAB_ESCUELA e
    LEFT JOIN TAB_CLIENTE c ON e.UBICACION = c.UBICACION
    GROUP BY e.ID_ESCUELA, e.NOMBRE;
    RETURN v_cursor;
END;
/
SET SERVEROUTPUT ON;
DECLARE
    v_cursor SYS_REFCURSOR;
    v_id_escuela TAB_ESCUELA.ID_ESCUELA%TYPE;
    v_nombre_escuela TAB_ESCUELA.NOMBRE%TYPE;
    v_cantidad_total_clientes NUMBER;
BEGIN
    v_cursor := CALCULAR_CLIENTES_POR_ESCUELA();
    
    LOOP
        FETCH v_cursor INTO v_id_escuela,v_nombre_escuela, v_cantidad_total_clientes;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_nombre_escuela || ' - CANTIDAD DE CLIENTES: ' || v_cantidad_total_clientes);
    END LOOP;
    CLOSE v_cursor;
END;
/
--Funcion  para verificar la calcular la cantidad de clientes registrados por ubicacion 2/11
CREATE OR REPLACE FUNCTION CALCULAR_CLIENTES_REGISTRADOS_UBICACION
RETURN SYS_REFCURSOR
IS 
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT UBICACION, COUNT(*) AS CLIENTES_REGISTRADOS
    FROM TAB_CLIENTE
    GROUP BY UBICACION;
    RETURN v_cursor;
END;
SET SERVEROUTPUT ON;
DECLARE
    v_cursor SYS_REFCURSOR;
    v_ubicacion TAB_CLIENTE.UBICACION%TYPE;
    v_cantidad_clientes NUMBER;
BEGIN
    v_cursor := CALCULAR_CLIENTES_REGISTRADOS_UBICACION();
    LOOP
        FETCH v_cursor INTO v_ubicacion, v_cantidad_clientes;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Ubicación: ' || v_ubicacion || ', Cantidad de Clientes registrados: ' || v_cantidad_clientes);
    END LOOP;
    CLOSE v_cursor;
END;
/

--Funcion para calcular el tiempo del conductor trabajado en la empresa 3/11
CREATE OR REPLACE FUNCTION CALCULAR_TIEMPO_TRABAJADO(cedula_conductor IN VARCHAR2)
RETURN NUMBER
IS
    v_tiempo_trabajado NUMBER;
BEGIN
    SELECT ROUND(MONTHS_BETWEEN(SYSDATE,FECHA_INGRESO))
    INTO v_tiempo_trabajado
    FROM TAB_SALARIO
    WHERE CEDULA = cedula_conductor;
    RETURN v_tiempo_trabajado;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END;
/
--prueba con bloque plsql
DECLARE
    v_tiempo_trabajado NUMBER;
BEGIN
    v_tiempo_trabajado := calcular_tiempo_trabajado('100');
    DBMS_OUTPUT.PUT_LINE('Tiempo trabajado: ' || v_tiempo_trabajado || ' meses');
END;
/
--Funcion para calcular la cantidad de conductores en la empresa 4/11
CREATE OR REPLACE FUNCTION CALCULAR_CANTIDAD_CONDUCTORES
RETURN NUMBER
IS
    v_cantidad_conductores NUMBER;
BEGIN 
    SELECT COUNT(*)
    INTO v_cantidad_conductores
    FROM TAB_CONDUCTOR;
    
    RETURN v_cantidad_conductores;
END;
/


--bloque pl sql
DECLARE
    v_cantidad_conductores NUMBER;
BEGIN
    v_cantidad_conductores := CALCULAR_CANTIDAD_CONDUCTORES();
    DBMS_OUTPUT.PUT_LINE('Cantidad de conductores en la empresa: ' || v_cantidad_conductores);
END;
/

--Funcion para calcular el numero de quejas 5/11
CREATE OR REPLACE FUNCTION CALCULAR_CANTIDAD_QUEJAS
RETURN NUMBER
IS
    v_cantidad_quejas NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_cantidad_quejas
    FROM TAB_QUEJAS;
    
    RETURN v_cantidad_quejas;
END;
DECLARE
    v_cantidad_quejas NUMBER;
BEGIN
    v_cantidad_quejas := CALCULAR_CANTIDAD_QUEJAS();
    DBMS_OUTPUT.PUT_LINE('Total de quejas: ' || v_cantidad_quejas);
END;
/
--Funcion para verificar la cantidad de clientes totales 6/11
CREATE OR REPLACE FUNCTION VERIFICAR_TOTAL_CLIENTE
RETURN NUMBER
IS
    v_total_c NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total_c
    FROM TAB_CLIENTE;
    RETURN v_total_c;
END;
DECLARE
    v_total_c NUMBER;
BEGIN
    v_total_c := VERIFICAR_TOTAL_CLIENTE();
    DBMS_OUTPUT.PUT_LINE('Total de clientes: ' || v_total_c);
END;
--Funcion para verificar la capacidad total de todos los vehiculos 7/11
CREATE OR REPLACE FUNCTION VERIFICAR_CAPACIDAD_VEHICULO
RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT PLACA, MARCA, CAPACIDAD
    FROM TAB_VEHICULO;
    RETURN v_cursor;
END;
/
DECLARE
    v_cursor SYS_REFCURSOR;
    v_placa TAB_VEHICULO.PLACA%TYPE;
    v_marca TAB_VEHICULO.MARCA%TYPE;
    v_capacidad TAB_VEHICULO.CAPACIDAD%TYPE;
BEGIN
    v_cursor := VERIFICAR_CAPACIDAD_VEHICULO();
    LOOP
        FETCH v_cursor INTO v_placa, v_marca, v_capacidad;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Placa: ' || v_placa || ', Marca: ' || v_marca || ', Capacidad: ' || v_capacidad);
    END LOOP;
    CLOSE v_cursor;
END;
/

--Funcion mostrar conductores asignados, nombre, placa, marca 12
CREATE OR REPLACE FUNCTION MOSTRAR_CONDUCTOR_ASIGNADO
RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT c.NOMBRE || ' ' || c.APELLIDO1 AS NOMBRE_CONDUCTOR,
           vc.PLACA,
           v.MARCA
    FROM TAB_CONDUCTOR c
    JOIN TAB_VEHICULO_CONDUCTOR vc ON c.CEDULA = vc.CEDULA
    JOIN TAB_VEHICULO v ON vc.PLACA = v.PLACA;
    RETURN v_cursor;
END;
/
DECLARE
    v_cursor SYS_REFCURSOR;
    v_nombre_conductor VARCHAR2(100);
    v_placa TAB_VEHICULO_CONDUCTOR.PLACA%TYPE;
    v_marca TAB_VEHICULO.MARCA%TYPE;
BEGIN

    v_cursor := MOSTRAR_CONDUCTOR_ASIGNADO();
    
    LOOP
        FETCH v_cursor INTO v_nombre_conductor, v_placa, v_marca;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Conductor del Viaje: ' || v_nombre_conductor || ', Placa: ' || v_placa || ', Marca: ' || v_marca);
    END LOOP;
    CLOSE v_cursor;
END;
/

--Funcion nominas mensuales 13
CREATE OR REPLACE FUNCTION VERIFICAR_TOTAL_ESCUELAS
RETURN NUMBER
IS
    v_total_e NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total_e
    FROM TAB_ESCUELA;
    RETURN v_total_e;
END;
DECLARE
    v_total_e NUMBER;
BEGIN
    v_total_e := VERIFICAR_TOTAL_ESCUELAS();
    DBMS_OUTPUT.PUT_LINE('Total de escuelas en ruta: ' || v_total_e);
END;


--Funcion mostrar salario base por numero de cedula 14
CREATE OR REPLACE FUNCTION MOSTRAR_SALARIO_CONDUCTOR
RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT c.NOMBRE, s.SALARIO
    FROM TAB_CONDUCTOR c
    JOIN TAB_SALARIO s ON c.CEDULA = s.CEDULA;
    
    RETURN v_cursor;
END;
/
DECLARE
    v_cursor SYS_REFCURSOR;
    v_nombre TAB_CONDUCTOR.NOMBRE%TYPE;
    v_salario TAB_SALARIO.SALARIO%TYPE;
BEGIN
    v_cursor := MOSTRAR_SALARIO_CONDUCTOR();
    LOOP
        FETCH v_cursor INTO v_nombre, v_salario;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Nombre del conductor: ' || v_nombre || ', Salario: ' || v_salario);
    END LOOP;
    CLOSE v_cursor;
END;
/


--Funcion que muestra los datos de los conductores
CREATE OR REPLACE FUNCTION MOSTRAR_DATOS_DE_CONDUCTORES
RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR;
BEGIN
    OPEN v_cursor FOR
    SELECT *
    FROM TAB_CONDUCTOR;
    RETURN v_cursor;
END;
/
DECLARE
    v_cursor SYS_REFCURSOR;
    v_cedula TAB_CONDUCTOR.CEDULA%TYPE;
    v_nombre TAB_CONDUCTOR.NOMBRE%TYPE;
    v_apellido1 TAB_CONDUCTOR.APELLIDO1%TYPE;
    v_apellido2 TAB_CONDUCTOR.APELLIDO2%TYPE;
BEGIN
    v_cursor := MOSTRAR_DATOS_DE_CONDUCTORES();
    LOOP
        FETCH v_cursor INTO v_cedula, v_nombre, v_apellido1, v_apellido2;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Cedula: ' || v_cedula || ', Nombre: ' || v_nombre || ', Apellido1: ' || v_apellido1 || ', Apellido2: ' || v_apellido2);
    END LOOP;
    
    -- Cerrar el cursor
    CLOSE v_cursor;
END;
/
