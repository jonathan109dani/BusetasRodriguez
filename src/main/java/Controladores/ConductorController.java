/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ConexionBD.Conexion;
import Modelos.Conductor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ConductorController {
    private final Conexion conexion;

    public ConductorController() {
        // Aquí es donde puedes cargar el controlador JDBC
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: no se pudo encontrar el controlador JDBC.");
            e.printStackTrace();
        }

        // Luego puedes crear una instancia de ConexionDB
        this.conexion = new Conexion("jdbc:oracle:thin:@localhost:1521:orcl", "proyecto", "proyecto");
    }

    public void agregarConductor(Conductor conductor) {
        try {
            conexion.setConexion();
            String sql = "INSERT INTO TAB_CONDUCTOR (CEDULA, NOMBRE, APELLIDO1, APELLIDO2) VALUES (?, ?, ?, ?)";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, conductor.getCedula());
            statement.setString(2, conductor.getNombre());
            statement.setString(3, conductor.getApellido1());
            statement.setString(4, conductor.getApellido2());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public List<Conductor> obtenerTodosConductores() {
        List<Conductor> conductores = new ArrayList<>();
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_CONDUCTOR";
            conexion.setConsulta(sql);

            ResultSet resultSet = conexion.getResultado();
            while (resultSet.next()) {
                Conductor conductor = new Conductor();
                conductor.setCedula(resultSet.getString("CEDULA"));
                conductor.setNombre(resultSet.getString("NOMBRE"));
                conductor.setApellido1(resultSet.getString("APELLIDO1"));
                conductor.setApellido2(resultSet.getString("APELLIDO2"));
                conductores.add(conductor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return conductores;
    }

    public Conductor obtenerConductorPorCedula(String cedula) {
        Conductor conductor = null;
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_CONDUCTOR WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cedula);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                conductor = new Conductor();
                conductor.setCedula(resultSet.getString("CEDULA"));
                conductor.setNombre(resultSet.getString("NOMBRE"));
                conductor.setApellido1(resultSet.getString("APELLIDO1"));
                conductor.setApellido2(resultSet.getString("APELLIDO2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return conductor;
    }

    public void actualizarConductor(Conductor conductor) {
        try {
            conexion.setConexion();
            String sql = "UPDATE TAB_CONDUCTOR SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ? WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, conductor.getNombre());
            statement.setString(2, conductor.getApellido1());
            statement.setString(3, conductor.getApellido2());
            statement.setString(4, conductor.getCedula());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void eliminarConductor(String cedula) {
        try {
            conexion.setConexion();
            String sql = "DELETE FROM TAB_CONDUCTOR WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cedula);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }
}