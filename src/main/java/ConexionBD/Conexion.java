/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fidelitas
 */
public class Conexion {
    private Connection conn = null;
    private String url, user, pass;
    
    public Conexion(){
        conectar();
    }
    public void conectar(){
        
        try {
        Class.forName("OracleThin"); //driver de la base de datos
        url ="jdbc:oracle:thin:@localhost:1521:orcl";
        user = "proyecto";
        pass = "proyecto";
        conn = DriverManager.getConnection(url,user,pass);
        System.out.println("Conectado");
        }catch(Exception e){
            System.out.println("No se pudo conectar. Verifique");
        }
        
    }
    public void desconectar(){
        try {
            conn.close();
        }catch (Exception e){
            System.out.println("No se pudo desconectar. Verifique");
        }
    }
    
    
    
    
}
