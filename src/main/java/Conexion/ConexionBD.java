/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
    
    private PreparedStatement pstm;
    private ResultSet rs;

    String mensaje;
    
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
    
    
    public void reconectar() {
    try {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Reconexión exitosa");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public boolean ejecutarInstruccionLMD(String sql, Object... parametros){

        boolean res = false;

        try {

            pstm = conexion.prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {

                pstm.setObject(i + 1, parametros[i]);

            }

            if(pstm.executeUpdate() >= 1){
                res = true;
            }

        } catch (SQLException e) {

            if (e instanceof SQLIntegrityConstraintViolationException) {

                mensaje = "Error, clave primaria repetida";

            }
            
            mensaje = e.toString();
            
            System.err.println(mensaje);
;
            
            System.out.println("Error en la ejecucion de la instruccion SQL jajajaja");
        }

        return res;

    }



    public ResultSet ejecutarInstruccionSQL(String sql, Object... parametros){

        rs = null;

        try {

            pstm = conexion.prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {

                pstm.setObject(i + 1, parametros[i]);

            }

            rs = pstm.executeQuery();

        } catch (SQLException e) {

            System.out.println("Error en la ejecucion de la instruccion SQL");
            
            mensaje = e.toString();

        }

        return rs;

    }
    
    public void mostrarError(Component padre) {

        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);

    }
    
}
