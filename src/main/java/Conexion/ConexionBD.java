/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eduardo
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
    private static final String USER = "eduardo";
    private static final String PASSWORD = "Eduardo10";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a PostgreSQL");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar:");
            e.printStackTrace();
            return null;
        }
    }
    
}
