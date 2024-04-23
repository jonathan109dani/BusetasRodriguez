/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ConexionBD.Conexion;
import Modelos.Ruta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class RutaController {
    private final Conexion conexion;

    public RutaController() {
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

    public void agregarRuta(Ruta ruta) {
        try {
            conexion.setConexion();
            String sql = "INSERT INTO TAB_RUTA (PLACA, ID_ESCUELA) VALUES (?, ?)";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, ruta.getPlaca());
            statement.setInt(2, ruta.getID_Escuela());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public List<Ruta> obtenerTodasRutas() {
        List<Ruta> rutas = new ArrayList<>();
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_RUTA";
            conexion.setConsulta(sql);

            ResultSet resultSet = conexion.getResultado();
            while (resultSet.next()) {
                Ruta ruta = new Ruta();
                ruta.setPlaca(resultSet.getString("PLACA"));
                ruta.setID_Escuela(resultSet.getInt("ID_ESCUELA"));
                rutas.add(ruta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return rutas;
    }

    public Ruta obtenerRutaPorPlaca(String placa) {
        Ruta ruta = null;
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_RUTA WHERE PLACA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, placa);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ruta = new Ruta();
                ruta.setPlaca(resultSet.getString("PLACA"));
                ruta.setID_Escuela(resultSet.getInt("ID_ESCUELA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return ruta;
    }

    public void actualizarRuta(Ruta ruta) {
        try {
            conexion.setConexion();
            String sql = "UPDATE TAB_RUTA SET ID_ESCUELA = ? WHERE PLACA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setInt(1, ruta.getID_Escuela());
            statement.setString(2, ruta.getPlaca());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void eliminarRuta(String placa) {
        try {
            conexion.setConexion();
            String sql = "DELETE FROM TAB_RUTA WHERE PLACA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, placa);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }
}