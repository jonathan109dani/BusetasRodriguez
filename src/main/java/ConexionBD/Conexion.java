/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andi
 */
public class Conexion {
    private PreparedStatement consulta = null;
    private ResultSet resultado = null;
    private String url;
    private String username;
    private String password;
    private Connection conexion;
   
    
    public Conexion(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public void setConsulta(String sql) {
        try {
            this.conexion = DriverManager.getConnection(url, username, password);
            this.consulta = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Error al establecer la consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public PreparedStatement getConsulta() {
        return consulta;
    }
    
    public ResultSet getResultado() {
        try {
            return consulta.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al obtener el resultado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public void setConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //driver de la base de datos
            url ="jdbc:oracle:thin:@localhost:1521:orcl";
            username = "proyecto";
            password = "proyecto";
            conexion = DriverManager.getConnection(url,username,password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrarConexion() {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar el resultado: " + e.getMessage());
                e.printStackTrace();
            }
        }

        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la consulta: " + e.getMessage());
                e.printStackTrace();
            }
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }  
}
