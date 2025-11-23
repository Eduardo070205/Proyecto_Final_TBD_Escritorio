/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;

import Modelo.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Eduardo
 */
public class VentaDAO {
    
    String mensaje;
    
    ConexionBD con = ConexionBD.getInstancia();
    
    public boolean agregarVenta(Venta venta) {
        try {

            Connection cn = ConexionBD.getInstancia().getConexion();

            CallableStatement cs = cn.prepareCall("CALL validacion_precio_final(?,?,?,?,?)");

            cs.setDouble(1, venta.getPrecioFinal());
            cs.setString(2, venta.getFormaPago());
            cs.setString(3, venta.getIdCliente());
            cs.setString(4, venta.getIdEmpleado());
            cs.setString(5, venta.getIdVehiculo());

            cs.execute();
        

            return true;

        } catch (SQLException e) {

            
            if (e instanceof org.postgresql.util.PSQLException) {

                org.postgresql.util.PSQLException pgEx = (org.postgresql.util.PSQLException) e;

                if (pgEx.getServerErrorMessage() != null) {
                    mensaje = pgEx.getServerErrorMessage().getMessage();
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

    
    public boolean eliminarVenta(int id_venta){
        
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        
        return con.ejecutarInstruccionLMD(sql, id_venta);
        
    }
    
    public boolean actualizarVenta(Venta venta, int id_venta){
        
        String sql = "UPDATE ventas SET fecha_venta = ?, precio_final = ?, forma_pago = ?, id_cliente = ?, id_empleado = ?, id_vehiculo = ? WHERE id_venta = ?";
        
        return con.ejecutarInstruccionLMD(sql, 
          
            venta.getFechaVenta(),
            venta.getPrecioFinal(),
            venta.getFormaPago(),
            venta.getIdCliente(),
            venta.getIdEmpleado(),
            venta.getIdVehiculo(),
            id_venta
                
        );
        
    }
    
    
}
