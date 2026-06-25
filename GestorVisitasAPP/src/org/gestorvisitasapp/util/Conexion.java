package org.gestorvisitasapp.util;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class Conexion {
    private static Conexion instancia; 
            
    private static final String URL = "jdbc:mysql://localhost:3306/gestor_visitantes_in4cm"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "angelpopo18"; 
    
    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            System.err.println("Error Driver: " + e.getMessage()); 
        }
    }    
    
    
    public static synchronized Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion(); 
        }
        return instancia; 
    }
    
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD); 
    }
}
