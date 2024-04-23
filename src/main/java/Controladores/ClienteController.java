/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import ConexionBD.Conexion;
import Modelos.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ClienteController {
    private final Conexion conexion;

    public ClienteController() {
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

    public void agregarCliente(Cliente cliente) {
        try {
            conexion.setConexion();
            String sql = "INSERT INTO TAB_CLIENTE (CEDULA, NOMBRE, APELLIDO1, APELLIDO2, UBICACION, CANTIDAD_CLIENTES) VALUES (?, ?, ?, ?, ?, ?)";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cliente.getCedula());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
            statement.setString(5, cliente.getUbicacion());
            statement.setInt(6, cliente.getCantidadClientes());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_CLIENTE";
            conexion.setConsulta(sql);

            ResultSet resultSet = conexion.getResultado();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(resultSet.getString("CEDULA"));
                cliente.setNombre(resultSet.getString("NOMBRE"));
                cliente.setApellido1(resultSet.getString("APELLIDO1"));
                cliente.setApellido2(resultSet.getString("APELLIDO2"));
                cliente.setUbicacion(resultSet.getString("UBICACION"));
                cliente.setCantidadClientes(resultSet.getInt("CANTIDAD_CLIENTES"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return clientes;
    }

    public Cliente obtenerClientePorCedula(String cedulaCliente) {
        Cliente cliente = null;
        try {
            conexion.setConexion();
            String sql = "SELECT * FROM TAB_CLIENTE WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cedulaCliente);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setCedula(resultSet.getString("CEDULA"));
                cliente.setNombre(resultSet.getString("NOMBRE"));
                cliente.setApellido1(resultSet.getString("APELLIDO1"));
                cliente.setApellido2(resultSet.getString("APELLIDO2"));
                cliente.setUbicacion(resultSet.getString("UBICACION"));
                cliente.setCantidadClientes(resultSet.getInt("CANTIDAD_CLIENTES"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return cliente;
    }

    public void actualizarCliente(Cliente cliente) {
        try {
            conexion.setConexion();
            String sql = "UPDATE TAB_CLIENTE SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?, UBICACION = ?, CANTIDAD_CLIENTES = ? WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido1());
            statement.setString(3, cliente.getApellido2());
            statement.setString(4, cliente.getUbicacion());
            statement.setInt(5, cliente.getCantidadClientes());
            statement.setString(6, cliente.getCedula());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void eliminarCliente(String cedulaCliente) {
        try {
            conexion.setConexion();
            String sql = "DELETE FROM TAB_CLIENTE WHERE CEDULA = ?";
            conexion.setConsulta(sql);

            PreparedStatement statement = conexion.getConsulta();
            statement.setString(1, cedulaCliente);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
    }
}