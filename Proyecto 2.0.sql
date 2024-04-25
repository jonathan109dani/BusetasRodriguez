--Paquete con SP que devuelve las rutas de un conductor
CREATE OR REPLACE PACKAGE PKG_OBTENER_RUTAS_POR_CONDUCTOR AS
    PROCEDURE SP_OBTENER_RUTAS_POR_CONDUCTOR (
        p_cedula_conductor IN VARCHAR2,
        p_rutas OUT SYS_REFCURSOR
    );
END PKG_OBTENER_RUTAS_POR_CONDUCTOR;
/
CREATE OR REPLACE PACKAGE BODY PKG_OBTENER_RUTAS_POR_CONDUCTOR AS
    PROCEDURE SP_OBTENER_RUTAS_POR_CONDUCTOR (
        p_cedula_conductor IN VARCHAR2,
        p_rutas OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_rutas FOR
    SELECT R.*
    FROM TAB_RUTA R
    JOIN TAB_VEHICULO_CONDUCTOR VC ON R.PLACA = VC.PLACA
    WHERE VC.CEDULA = p_cedula_conductor;
    END;
END PKG_OBTENER_RUTAS_POR_CONDUCTOR;

--SP que recibe la cedula del cliente y devuelve los vehiculos asignados
CREATE OR REPLACE PROCEDURE SP_OBTENER_VEHICULOS_POR_CLIENTE (
    p_cedula_cliente IN VARCHAR2,
    p_vehiculos OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_vehiculos FOR
    SELECT V.*
    FROM TAB_VEHICULO V
    JOIN TAB_VEHICULO_CLIENTE VC ON V.PLACA = VC.PLACA
    WHERE VC.CEDULA_CLIENTE = p_cedula_cliente;
END;

--SP que recibe la placa y devuelve los conductores
CREATE OR REPLACE PROCEDURE SP_OBTENER_CONDUCTORES_POR_VEHICULO (
    p_placa_vehiculo IN VARCHAR2,
    p_conductores OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_conductores FOR
    SELECT C.*
    FROM TAB_CONDUCTOR C
    JOIN TAB_VEHICULO_CONDUCTOR VC ON C.CEDULA = VC.CEDULA
    WHERE VC.PLACA = p_placa_vehiculo;
END;

--Paquete que busca los clientes por escuela
CREATE OR REPLACE PACKAGE PKG_CLIENTES_POR_ESCUELA AS
    PROCEDURE SP_CALCULAR_CLIENTES_POR_ESCUELA (
        p_escuela_id IN NUMBER,
        p_cantidad_clientes OUT NUMBER
    );
END PKG_CLIENTES_POR_ESCUELA;
/
CREATE OR REPLACE PACKAGE BODY PKG_CLIENTES_POR_ESCUELA AS
    PROCEDURE SP_CALCULAR_CLIENTES_POR_ESCUELA (
        p_escuela_id IN NUMBER,
        p_cantidad_clientes OUT NUMBER
    )
    AS
        CURSOR c_rutas IS
            SELECT *
            FROM TAB_RUTA
            WHERE ID_ESCUELA = p_escuela_id;

        v_cantidad_clientes_temp NUMBER := 0;
    BEGIN
        p_cantidad_clientes := 0;

        FOR ruta_rec IN c_rutas LOOP
            FOR vehiculo_rec IN (SELECT C.CANTIDAD_CLIENTES
                                  FROM TAB_VEHICULO_CLIENTE VC
                                  JOIN TAB_CLIENTE C ON VC.CEDULA_CLIENTE = C.CEDULA
                                  WHERE VC.PLACA = ruta_rec.PLACA)
            LOOP
                v_cantidad_clientes_temp := v_cantidad_clientes_temp + vehiculo_rec.CANTIDAD_CLIENTES;
            END LOOP;

            p_cantidad_clientes := p_cantidad_clientes + v_cantidad_clientes_temp;

            v_cantidad_clientes_temp := 0;
        END LOOP;
    END;
END PKG_CLIENTES_POR_ESCUELA;

--Clientes que no han sido asignados
CREATE OR REPLACE PROCEDURE SP_OBTENER_CLIENTES_NO_ASIGNADOS (
    p_clientes_no_asignados OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_clientes_no_asignados FOR
    SELECT *
    FROM TAB_CLIENTE C
    WHERE NOT EXISTS (
        SELECT 1
        FROM TAB_VEHICULO_CLIENTE VC
        WHERE VC.CEDULA_CLIENTE = C.CEDULA
    );
END;

--Vistas contar la cantidad de veces que los usuarios
--hacen insert/delete/update en la tabla CLIENTE/VEHICULO/ESCUELA/CONDUCTOR

CREATE OR REPLACE VIEW V_AUD_CONDUCTOR AS
SELECT USUARIO,
       COUNT(CASE WHEN ACCION LIKE '%INSERT%' THEN 1 END) AS NUM_INSERT,
       COUNT(CASE WHEN ACCION LIKE '%DELETE%' THEN 1 END) AS NUM_DELETE,
       COUNT(CASE WHEN ACCION LIKE '%UPDATE%' THEN 1 END) AS NUM_UPDATE
FROM TAB_AUD_CONDUCTOR
GROUP BY USUARIO;
/
CREATE OR REPLACE VIEW V_AUD_ESCUELA AS
SELECT USUARIO,
       COUNT(CASE WHEN ACCION LIKE '%INSERT%' THEN 1 END) AS NUM_INSERT,
       COUNT(CASE WHEN ACCION LIKE '%DELETE%' THEN 1 END) AS NUM_DELETE,
       COUNT(CASE WHEN ACCION LIKE '%UPDATE%' THEN 1 END) AS NUM_UPDATE
FROM TAB_AUD_ESCUELA
GROUP BY USUARIO;
/
CREATE OR REPLACE VIEW V_AUD_VEHICULO AS
SELECT USUARIO,
       COUNT(CASE WHEN ACCION LIKE '%INSERT%' THEN 1 END) AS NUM_INSERT,
       COUNT(CASE WHEN ACCION LIKE '%DELETE%' THEN 1 END) AS NUM_DELETE,
       COUNT(CASE WHEN ACCION LIKE '%UPDATE%' THEN 1 END) AS NUM_UPDATE
FROM TAB_AUD_VEHICULO
GROUP BY USUARIO;
/
CREATE OR REPLACE VIEW V_AUD_CLIENTE AS
SELECT USUARIO,
       COUNT(CASE WHEN ACCION LIKE '%INSERT%' THEN 1 END) AS NUM_INSERT,
       COUNT(CASE WHEN ACCION LIKE '%DELETE%' THEN 1 END) AS NUM_DELETE,
       COUNT(CASE WHEN ACCION LIKE '%UPDATE%' THEN 1 END) AS NUM_UPDATE
FROM TAB_AUD_CLIENTE
GROUP BY USUARIO;
/

--Nuevas tablas

CREATE TABLE TAB_SALARIO (
    cedula VARCHAR2(20) PRIMARY KEY,
    salario NUMBER(10, 2),
    fecha_ingreso DATE
);

CREATE TABLE TAB_QUEJAS (
    placa VARCHAR2(20),
    comentario VARCHAR2(1000),
    fecha DATE
);

CREATE TABLE TAB_NOMINA (
    cedula VARCHAR2(20),
    mes VARCHAR2(20),
    cantidad_km NUMBER(10, 2)
);
--Vista cantidad de quejas por placa
CREATE OR REPLACE VIEW V_QUEJAS_PLACAS AS
SELECT placa, COUNT(*) AS q_quejas
FROM TAB_QUEJAS
GROUP BY placa;

--Funciones

--Funcion calcular salario
CREATE OR REPLACE FUNCTION CALCULAR_SALARIO(cedula_empleado VARCHAR2, mes VARCHAR2)
RETURN NUMBER
AS
    v_salario TAB_SALARIO.salario%TYPE;
    v_cantidad_km TAB_NOMINA.cantidad_km%TYPE;
    v_salario_total NUMBER;
BEGIN
    
    SELECT salario INTO v_salario
    FROM TAB_SALARIO
    WHERE cedula = cedula_empleado;

    SELECT cantidad_km INTO v_cantidad_km
    FROM TAB_NOMINA
    WHERE cedula = cedula_empleado AND mes = mes;

    v_salario_total := v_salario * v_cantidad_km;

    RETURN v_salario_total;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    RETURN NULL;
END;

--Funcion para calcular ingresos de empresa
CREATE OR REPLACE FUNCTION CALCULAR_INGRESOS(mes VARCHAR2)
RETURN NUMBER
AS
    v_total_ingresos NUMBER := 0;
BEGIN
    -- Tarifa regular de 1000 por km
    SELECT SUM(cantidad_km * 1000) INTO v_total_ingresos
    FROM TAB_NOMINA
    WHERE TO_CHAR(mes, 'MM') = mes;

    RETURN v_total_ingresos;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;

--Agregar la columna cedula_cliente a la tabla de quejas
ALTER TABLE TAB_QUEJAS
ADD cedula_cliente VARCHAR2(20);

--Buscar si un cliente tiene queja
CREATE OR REPLACE FUNCTION VERIFICAR_QUEJA_REGISTRADA(p_cedula_cliente VARCHAR2)
RETURN BOOLEAN
IS
    v_cantidad_quejas NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_cantidad_quejas
    FROM TAB_QUEJAS
    WHERE cedula_cliente = p_cedula_cliente;

    IF v_cantidad_quejas > 0 THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

--Funcion para verificar disponibilidad
CREATE OR REPLACE FUNCTION VERIFICAR_DISPONIBILIDAD_ASIENTOS(p_placa VARCHAR2)
RETURN NUMBER
IS
    v_capacidad NUMBER;
    v_cantidad_clientes NUMBER;
    v_asientos_disponibles NUMBER;
BEGIN

    SELECT capacidad INTO v_capacidad
    FROM TAB_VEHICULO
    WHERE placa = p_placa;

    SELECT SUM(cantidad_clientes) INTO v_cantidad_clientes
    FROM TAB_CLIENTE
    WHERE cedula IN (SELECT cedula_cliente FROM TAB_VEHICULO_CLIENTE WHERE placa = p_placa);

    v_asientos_disponibles := v_capacidad - COALESCE(v_cantidad_clientes, 0);

    RETURN v_asientos_disponibles;
END;
/

CREATE OR REPLACE FUNCTION VERIFICAR_DISPONIBILIDAD_ASIENTOS(p_placa VARCHAR2)
RETURN NUMBER
IS
    v_capacidad NUMBER;
    v_cantidad_clientes NUMBER := 0;
    v_asientos_disponibles NUMBER;
BEGIN
    -- Cursor 1
    DECLARE
        CURSOR cur_capacidad IS
            SELECT capacidad
            FROM TAB_VEHICULO
            WHERE placa = p_placa;
    BEGIN
        OPEN cur_capacidad;
        FETCH cur_capacidad INTO v_capacidad;
        CLOSE cur_capacidad;
    END;

    -- Cursor 2
    DECLARE
        CURSOR cur_cantidad_clientes IS
            SELECT SUM(cantidad_clientes) AS total_clientes
            FROM TAB_CLIENTE
            WHERE cedula IN (SELECT cedula_cliente FROM TAB_VEHICULO_CLIENTE WHERE placa = p_placa);
    BEGIN
        OPEN cur_cantidad_clientes;
        FETCH cur_cantidad_clientes INTO v_cantidad_clientes;
        CLOSE cur_cantidad_clientes;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_cantidad_clientes := 0;
    END;

    v_asientos_disponibles := v_capacidad - COALESCE(v_cantidad_clientes, 0);

    RETURN v_asientos_disponibles;
END;
/

-- Paquete para obtener los conductores de un vehiculo 

CREATE OR REPLACE PACKAGE PKG_OBTENER_CONDUCTORES_POR_VEHICULO AS
    PROCEDURE SP_OBTENER_CONDUCTORES_POR_VEHICULO (
        p_placa IN VARCHAR2,
        p_conductores OUT SYS_REFCURSOR
    );
END PKG_OBTENER_CONDUCTORES_POR_VEHICULO;
/

CREATE OR REPLACE PACKAGE BODY PKG_OBTENER_CONDUCTORES_POR_VEHICULO AS
    PROCEDURE SP_OBTENER_CONDUCTORES_POR_VEHICULO (
        p_placa IN VARCHAR2,
        p_conductores OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_conductores FOR
        SELECT C.*
        FROM TAB_CONDUCTOR C
        JOIN TAB_VEHICULO_CONDUCTOR VC ON C.CEDULA = VC.CEDULA
        WHERE VC.PLACA = p_placa;
    END;
END PKG_OBTENER_CONDUCTORES_POR_VEHICULO;

-- Paquete para obtener los vehiculos de una escuela

CREATE OR REPLACE PACKAGE PKG_OBTENER_VEHICULOS_POR_ESCUELA AS
    PROCEDURE SP_OBTENER_VEHICULOS_POR_ESCUELA (
        p_id_escuela IN NUMBER,
        p_vehiculos OUT SYS_REFCURSOR
    );
END PKG_OBTENER_VEHICULOS_POR_ESCUELA;
/

CREATE OR REPLACE PACKAGE BODY PKG_OBTENER_VEHICULOS_POR_ESCUELA AS
    PROCEDURE SP_OBTENER_VEHICULOS_POR_ESCUELA (
        p_id_escuela IN NUMBER,
        p_vehiculos OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_vehiculos FOR
        SELECT V.*
        FROM TAB_VEHICULO V
        JOIN TAB_RUTA R ON V.PLACA = R.PLACA
        WHERE R.ID_ESCUELA = p_id_escuela;
    END;
END PKG_OBTENER_VEHICULOS_POR_ESCUELA;

-- Paquete para obtener los clientes de una ruta

CREATE OR REPLACE PACKAGE PKG_OBTENER_CLIENTES_POR_RUTA AS
    PROCEDURE SP_OBTENER_CLIENTES_POR_RUTA (
        p_placa IN VARCHAR2,
        p_clientes OUT SYS_REFCURSOR
    );
END PKG_OBTENER_CLIENTES_POR_RUTA;
/

CREATE OR REPLACE PACKAGE BODY PKG_OBTENER_CLIENTES_POR_RUTA AS
    PROCEDURE SP_OBTENER_CLIENTES_POR_RUTA (
        p_placa IN VARCHAR2,
        p_clientes OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_clientes FOR
        SELECT C.*
        FROM TAB_CLIENTE C
        JOIN TAB_VEHICULO_CLIENTE VC ON C.CEDULA = VC.CEDULA_CLIENTE
        WHERE VC.PLACA = p_placa;
    END;
END PKG_OBTENER_CLIENTES_POR_RUTA;

-- Paquete para obtener las escuelas sin rutas

CREATE OR REPLACE PACKAGE PKG_ESCUELAS_SIN_RUTAS AS
    PROCEDURE SP_ESCUELAS_SIN_RUTAS (
        p_escuelas OUT SYS_REFCURSOR
    );
END PKG_ESCUELAS_SIN_RUTAS;
/

CREATE OR REPLACE PACKAGE BODY PKG_ESCUELAS_SIN_RUTAS AS
    PROCEDURE SP_ESCUELAS_SIN_RUTAS (
        p_escuelas OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_escuelas FOR
        SELECT E.*
        FROM TAB_ESCUELA E
        WHERE NOT EXISTS (
            SELECT 1
            FROM TAB_RUTA R
            WHERE R.ID_ESCUELA = E.ID_ESCUELA
        );
    END;
END PKG_ESCUELAS_SIN_RUTAS;

-- Paquete para obtener las rutas sin conductores

CREATE OR REPLACE PACKAGE PKG_RUTAS_SIN_CONDUCTORES AS
    PROCEDURE SP_RUTAS_SIN_CONDUCTORES (
        p_rutas OUT SYS_REFCURSOR
    );
END PKG_RUTAS_SIN_CONDUCTORES;
/

CREATE OR REPLACE PACKAGE BODY PKG_RUTAS_SIN_CONDUCTORES AS
    PROCEDURE SP_RUTAS_SIN_CONDUCTORES (
        p_rutas OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_rutas FOR
        SELECT R.*
        FROM TAB_RUTA R
        WHERE NOT EXISTS (
            SELECT 1
            FROM TAB_VEHICULO_CONDUCTOR VC
            WHERE VC.PLACA = R.PLACA
        );
    END;
END PKG_RUTAS_SIN_CONDUCTORES;

-- Paquete para obtener los vehiculos sin conductores

CREATE OR REPLACE PACKAGE PKG_VEHICULOS_SIN_CONDUCTORES AS
    PROCEDURE SP_VEHICULOS_SIN_CONDUCTORES (
        p_vehiculos OUT SYS_REFCURSOR
    );
END PKG_VEHICULOS_SIN_CONDUCTORES;
/

CREATE OR REPLACE PACKAGE BODY PKG_VEHICULOS_SIN_CONDUCTORES AS
    PROCEDURE SP_VEHICULOS_SIN_CONDUCTORES (
        p_vehiculos OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_vehiculos FOR
        SELECT V.*
        FROM TAB_VEHICULO V
        WHERE NOT EXISTS (
            SELECT 1
            FROM TAB_VEHICULO_CONDUCTOR VC
            WHERE VC.PLACA = V.PLACA
        );
    END;
END PKG_VEHICULOS_SIN_CONDUCTORES;

-- Paquete para obtener los conductores sin vehículos asignados

CREATE OR REPLACE PACKAGE PKG_CONDUCTORES_SIN_VEHICULO AS
    PROCEDURE SP_CONDUCTORES_SIN_VEHICULO (
        p_conductores OUT SYS_REFCURSOR
    );
END PKG_CONDUCTORES_SIN_VEHICULO;
/

CREATE OR REPLACE PACKAGE BODY PKG_CONDUCTORES_SIN_VEHICULO AS
    PROCEDURE SP_CONDUCTORES_SIN_VEHICULO (
        p_conductores OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_conductores FOR
        SELECT C.*
        FROM TAB_CONDUCTOR C
        WHERE NOT EXISTS (
            SELECT 1
            FROM TAB_VEHICULO_CONDUCTOR VC
            WHERE VC.CEDULA = C.CEDULA
        );
    END;
END PKG_CONDUCTORES_SIN_VEHICULO;

-- Paquete para obtener los vehículos sin clientes asignados

CREATE OR REPLACE PACKAGE PKG_VEHICULOS_SIN_CLIENTES AS
    PROCEDURE SP_VEHICULOS_SIN_CLIENTES (
        p_vehiculos OUT SYS_REFCURSOR
    );
END PKG_VEHICULOS_SIN_CLIENTES;
/

CREATE OR REPLACE PACKAGE BODY PKG_VEHICULOS_SIN_CLIENTES AS
    PROCEDURE SP_VEHICULOS_SIN_CLIENTES (
        p_vehiculos OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN p_vehiculos FOR
        SELECT V.*
        FROM TAB_VEHICULO V
        WHERE NOT EXISTS (
            SELECT 1
            FROM TAB_VEHICULO_CLIENTE VC
            WHERE VC.PLACA = V.PLACA
        );
    END;
END PKG_VEHICULOS_SIN_CLIENTES;

-- SP para obtener las rutas sin vehículos asignados

CREATE OR REPLACE PROCEDURE SP_RUTAS_SIN_VEHICULO (
    p_rutas OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_rutas FOR
    SELECT R.*
    FROM TAB_RUTA R
    WHERE NOT EXISTS (
        SELECT 1
        FROM TAB_VEHICULO V
        WHERE V.PLACA = R.PLACA
    );
END;

-- SP para obtener los clientes sin vehículos asignados

CREATE OR REPLACE PROCEDURE SP_CLIENTES_SIN_VEHICULO (
    p_clientes OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_clientes FOR
    SELECT C.*
    FROM TAB_CLIENTE C
    WHERE NOT EXISTS (
        SELECT 1
        FROM TAB_VEHICULO_CLIENTE VC
        WHERE VC.CEDULA_CLIENTE = C.CEDULA
    );
END;

-- SP para obtener las escuelas con rutas sin conductores asignados

CREATE OR REPLACE PROCEDURE SP_ESCUELAS_RUTAS_SIN_CONDUCTORES (
    p_escuelas OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_escuelas FOR
    SELECT DISTINCT E.*
    FROM TAB_ESCUELA E
    JOIN TAB_RUTA R ON E.ID_ESCUELA = R.ID_ESCUELA
    WHERE NOT EXISTS (
        SELECT 1
        FROM TAB_VEHICULO_CONDUCTOR VC
        WHERE VC.PLACA = R.PLACA
    );
END;