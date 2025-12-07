/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class BDHelper {

    private ConexionBD conexion = ConexionBD.getInstancia();

    public ResultSet ejecutarConsulta(String sql) throws Exception {
        Statement st = conexion.getConexion().createStatement();
        return st.executeQuery(sql);
    }

    public void ejecutarActualizacion(String sql) throws Exception {
        Statement st = conexion.getConexion().createStatement();
        st.executeUpdate(sql);
    }

    public Connection getConexion(){
        return conexion.getConexion();
    }
}

