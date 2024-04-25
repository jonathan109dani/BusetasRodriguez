SET SERVEROUTPUT ON;

--Correr SP_OBTENER_RUTAS_POR_CONDUCTOR
DECLARE
    v_cedula_conductor VARCHAR2(100); 
    v_cursor SYS_REFCURSOR; 
    
    v_columna1 TAB_RUTA.placa%TYPE; -- Reemplaza 'columna1' con el nombre de la primera columna de la tabla TAB_RUTA
    v_columna2 TAB_RUTA.id_escuela%TYPE;
    
BEGIN
    v_cedula_conductor := '51'; 
    
    PKG_OBTENER_RUTAS_POR_CONDUCTOR.SP_OBTENER_RUTAS_POR_CONDUCTOR(
        p_cedula_conductor => v_cedula_conductor,
        p_rutas => v_cursor
    );
    
    DBMS_OUTPUT.PUT_LINE('Resultados de las rutas para el conductor con cédula ' || v_cedula_conductor || ':');
    LOOP
        FETCH v_cursor INTO v_columna1, v_columna2;
        EXIT WHEN v_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Placa del vehiculo: ' || v_columna1 || ', Num. escuela: ' || v_columna2);

    END LOOP;
    CLOSE v_cursor;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr SP_OBTENER_VEHICULOS_POR_CLIENTE
DECLARE
    v_cedula_cliente VARCHAR2(20); 
    v_cursor SYS_REFCURSOR; 
    
    v_placa VARCHAR(20);
    
BEGIN
    v_cedula_cliente := '12';
    
    SP_OBTENER_VEHICULOS_POR_CLIENTE(
        p_cedula_cliente => v_cedula_cliente,
        p_vehiculos => v_cursor
    );
    
    DBMS_OUTPUT.PUT_LINE('Vehículos asociados al cliente con cédula ' || v_cedula_cliente || ':');
    LOOP
        FETCH v_cursor INTO v_placa; 
        EXIT WHEN v_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Placa: ' || v_placa );

    END LOOP;
    
    CLOSE v_cursor;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr SP_CALCULAR_CLIENTES_POR_ESCUELA
DECLARE
    v_escuela_id NUMBER; 
    v_cantidad_clientes NUMBER; 
    
BEGIN
    v_escuela_id := 1; 
    
    PKG_CLIENTES_POR_ESCUELA.SP_CALCULAR_CLIENTES_POR_ESCUELA(
        p_escuela_id => v_escuela_id,
        p_cantidad_clientes => v_cantidad_clientes
    );
    
    DBMS_OUTPUT.PUT_LINE('Cantidad de clientes asociados a la escuela con ID ' || v_escuela_id || ': ' || v_cantidad_clientes);
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr funcion CALCULAR_SALARIO
DECLARE
    v_cedula_empleado VARCHAR2(100) := '51'; 
    v_mes VARCHAR2(100) := 'ENERO';
    v_salario_total NUMBER;
BEGIN
    v_salario_total := CALCULAR_SALARIO(v_cedula_empleado, v_mes);
    
    DBMS_OUTPUT.PUT_LINE('El salario total para el empleado con cédula ' || v_cedula_empleado || ' en el mes ' || v_mes || ' es: ' || v_salario_total);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr funcion CALCULAR_INGRESOS
DECLARE
    v_mes VARCHAR2(100) := 'ENERO';
    v_total_ingresos NUMBER;
BEGIN
    v_total_ingresos := CALCULAR_INGRESOS(v_mes);
    
    DBMS_OUTPUT.PUT_LINE('Los ingresos totales para el mes ' || v_mes || ' son: ' || v_total_ingresos);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr funcion VERIFICAR_QUEJA_REGISTRADA
DECLARE
    v_cedula_cliente VARCHAR2(100) := '11';
    v_queja_registrada BOOLEAN;
BEGIN
    v_queja_registrada := VERIFICAR_QUEJA_REGISTRADA(v_cedula_cliente);
    
    IF v_queja_registrada THEN
        DBMS_OUTPUT.PUT_LINE('Se ha registrado al menos una queja para el cliente con cédula ' || v_cedula_cliente);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No se ha registrado ninguna queja para el cliente con cédula ' || v_cedula_cliente);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Correr funcion VERIFICAR_DISPONIBILIDAD_ASIENTOS
DECLARE
    v_placa VARCHAR2(100) := 'BFF151';
    v_asientos_disponibles NUMBER;
BEGIN
    v_asientos_disponibles := VERIFICAR_DISPONIBILIDAD_ASIENTOS(v_placa);
    
    DBMS_OUTPUT.PUT_LINE('Número de asientos disponibles para el vehículo con placa ' || v_placa || ': ' || v_asientos_disponibles);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
