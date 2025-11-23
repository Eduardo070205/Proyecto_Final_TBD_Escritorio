/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;
import Modelo.Modelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class ModeloDAO {
    
    String mensaje;
    
    ConexionBD con = ConexionBD.getInstancia();
    
    public boolean agregarModelo(Modelo modelo){
        
        try {
        
            Connection cn = ConexionBD.getInstancia().getConexion();

            CallableStatement cs = cn.prepareCall("CALL validacion_datos_modelo(?,?,?,?,?,?,?,?,?)");

            cs.setString(1, modelo.getNombreModelo());
            cs.setShort(2,  modelo.getAnioModelo());
            cs.setString(3, modelo.getFabricante());
            cs.setShort(4,  modelo.getNumeroCilindros());
            cs.setShort(5,  modelo.getNumeroPuertas());
            cs.setDouble(6, modelo.getPeso());
            cs.setShort(7,  modelo.getCatidadPasajeros());
            cs.setString(8, modelo.getColor());
            cs.setString(9, modelo.getPaisFabricacion());

            cs.execute();

            return true;

        } catch (SQLException e) {
        
          
            if (e instanceof org.postgresql.util.PSQLException) {

                org.postgresql.util.PSQLException pgEx = (org.postgresql.util.PSQLException) e;

                if (pgEx.getServerErrorMessage() != null) {
                    mensaje = pgEx.getServerErrorMessage().getMessage();  // Mensaje limpio del RAISE
                } else {
            
                    mensaje = pgEx.getMessage();
                }

            } else {
                mensaje = e.getMessage();
            }

            return false;
        }
        
    }
    
    public String mostrarMensaje(){
        
        return mensaje;
        
    }
    
    public boolean eliminarModelo(int idModelo){
        
        String sql = "DELETE FROM modelos WHERE id_modelo = ?";
        
        return con.ejecutarInstruccionLMD(sql, idModelo);
        
    }
    
    public boolean actualizarModelo(Modelo modelo, int idModelo){
        
        String sql = "UPDATE modelos SET nombre_modelo = ?, año_modelo = ?, fabricante = ?, numero_cilindros = ?, numero_puertas = ?, peso_kg = ?, capacidad_pasajeros = ?, color_base = ?, pais_fabricacion = ? WHERE id_modelo = ?;";
        
        return con.ejecutarInstruccionLMD(sql, 
                
                modelo.getNombreModelo(),
                modelo.getAnioModelo(),
                modelo.getFabricante(),
                modelo.getNumeroCilindros(),
                modelo.getNumeroPuertas(),
                modelo.getPeso(),
                modelo.getCatidadPasajeros(),
                modelo.getColor(),
                modelo.getPaisFabricacion(),
                idModelo
        
        );
        
        
    }
    
}
