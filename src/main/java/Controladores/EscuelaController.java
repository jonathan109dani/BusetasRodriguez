/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ConexionBD.Conexion;
import Modelos.Escuela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class EscuelaController {
    private final Conexion conexion;

    public EscuelaController() {
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

    public void agregarEscuela(Escuela escuela) {
        try {
            conexion.setConexion();
            String sql = "INSERT INTO TAB_ESCUELA (ID_ESCUELA, NOMBRE, UBICACION) VALUES (?, ?, ?)";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, escuela.getID_Escuela());
            statement.setString(2, escuela.getNombre());
            statement.setString(3, escuela.getUbicacion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public List<Escuela> obtenerTodasEscuelas() {
        List<Escuela> escuelas = new ArrayList<>();
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_ESCUELA";
            conexion.setConsulta(sql);

            ResultSet resultSet = conexion.getResultado();
            while (resultSet.next()) {
                Escuela escuela = new Escuela();
                escuela.setID_Escuela(resultSet.getString("ID_ESCUELA"));
                escuela.setNombre(resultSet.getString("NOMBRE"));
                escuela.setUbicacion(resultSet.getString("UBICACION"));
                escuelas.add(escuela);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return escuelas;
    }

    public Escuela obtenerEscuelaPorID(String idEscuela) {
        Escuela escuela = null;
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_ESCUELA WHERE ID_ESCUELA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, idEscuela);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                escuela = new Escuela();
                escuela.setID_Escuela(resultSet.getString("ID_ESCUELA"));
                escuela.setNombre(resultSet.getString("NOMBRE"));
                escuela.setUbicacion(resultSet.getString("UBICACION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return escuela;
    }

    public void actualizarEscuela(Escuela escuela) {
        try {
            conexion.setConexion();
            String sql = "UPDATE TAB_ESCUELA SET NOMBRE = ?, UBICACION = ? WHERE ID_ESCUELA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, escuela.getNombre());
            statement.setString(2, escuela.getUbicacion());
            statement.setString(3, escuela.getID_Escuela());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void eliminarEscuela(int idEscuela) {
        try {
            conexion.setConexion();
            String sql = "DELETE FROM TAB_ESCUELA WHERE ID_ESCUELA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setInt(1, idEscuela);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }
}