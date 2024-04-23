/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import ConexionBD.Conexion;
import Modelos.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class VehiculoController {
    private final Conexion conexion;

    public VehiculoController() {
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

    public void agregarVehiculo(Vehiculo vehiculo) {
        try {
            conexion.setConexion();
            String sql = "INSERT INTO TAB_VEHICULO (PLACA, MODELO, MARCA, CAPACIDAD) VALUES (?, ?, ?, ?)";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, vehiculo.getPlaca());
            statement.setString(2, vehiculo.getModelo());
            statement.setString(3, vehiculo.getMarca());
            statement.setInt(4, vehiculo.getCapacidad());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public List<Vehiculo> obtenerTodosVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_VEHICULO";
            conexion.setConsulta(sql);

            ResultSet resultSet = conexion.getResultado();
            while (resultSet.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPlaca(resultSet.getString("PLACA"));
                vehiculo.setModelo(resultSet.getString("MODELO"));
                vehiculo.setMarca(resultSet.getString("MARCA"));
                vehiculo.setCapacidad(resultSet.getInt("CAPACIDAD"));
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return vehiculos;
    }

    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        Vehiculo vehiculo = null;
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_VEHICULO WHERE PLACA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, placa);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setPlaca(resultSet.getString("PLACA"));
                vehiculo.setModelo(resultSet.getString("MODELO"));
                vehiculo.setMarca(resultSet.getString("MARCA"));
                vehiculo.setCapacidad(resultSet.getInt("CAPACIDAD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return vehiculo;
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        try {
            conexion.setConexion();
            String sql = "UPDATE TAB_VEHICULO SET MODELO = ?, MARCA = ?, CAPACIDAD = ? WHERE PLACA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, vehiculo.getModelo());
            statement.setString(2, vehiculo.getMarca());
            statement.setInt(3, vehiculo.getCapacidad());
            statement.setString(4, vehiculo.getPlaca());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void eliminarVehiculo(String placa) {
        try {
            conexion.setConexion();
            String sql = "DELETE FROM TAB_VEHICULO WHERE PLACA = ?";
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