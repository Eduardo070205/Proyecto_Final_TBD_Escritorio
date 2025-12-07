/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import Ventanas.VentanaLogin;
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
public class ConexionBD{

    private static ConexionBD instancia;
    private Connection conexion;
    
    private PreparedStatement pstm;
    private ResultSet rs;

    private boolean conectado = false;
    
    String mensaje;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
    private String usuario = "";
    private String contraseña = "";
   

  
    private ConexionBD() {
  
        conexion = null;
        conectado = false;
    }
    
    public boolean conectar() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, usuario, contraseña);
                conectado = true;
            }
            return true;
        } catch (SQLException e) {
            conectado = false;
            e.printStackTrace();
            return false;
        }
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
    
    
    public void reconectar() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, usuario, contraseña);
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
            
            String sqlState = e.getSQLState(); // código SQLSTATE

            if ("23503".equals(sqlState)) {
                
                mensaje = "No se puede eliminar este vehículo/modelo porque ya está asociado a una venta.";
            }
            
            //mensaje = e.toString();
            
            System.err.println(mensaje);
;
            
            System.out.println("Error en la ejecucion de la instruccion SQL jajajaja");
        }

        return res;

    }
    
    public void cerrarConexion() {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (pstm != null && !pstm.isClosed()) {
                pstm.close();
            }
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conectado = false;
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
