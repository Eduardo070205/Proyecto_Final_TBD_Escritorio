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

    private static ConexionBD instancia;
    private Connection conexion;

    private static final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
    private static final String USER = "eduardo";
    private static final String PASSWORD = "Eduardo10";

    // Constructor privado para impedir instancias externas
    private ConexionBD() {
        try {
            Class.forName("org.postgresql.Driver"); // cargar driver
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            System.out.println("Error al conectar a la BD:");
            e.printStackTrace();
        }
    }

    // Obtener la instancia única
    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Obtener conexión
    public Connection getConexion() {
        return conexion;
    }
}
