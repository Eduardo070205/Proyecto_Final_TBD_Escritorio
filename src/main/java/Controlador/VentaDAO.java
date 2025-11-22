/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;

import Modelo.Venta;

/**
 *
 * @author Eduardo
 */
public class VentaDAO {
    
    ConexionBD con = ConexionBD.getInstancia();
    
    public boolean agregarVenta(Venta venta){
        
        String sql = "INSERT INTO ventas(fecha_venta, precio_final, forma_pago, id_cliente, id_empleado, id_vehiculo) VALUES(?,?,?,?,?,?);";
        
        return con.ejecutarInstruccionLMD(sql,
                
            venta.getFechaVenta(),
            venta.getPrecioFinal(),
            venta.getFormaPago(),
            venta.getIdCliente(),
            venta.getIdEmpleado(),
            venta.getIdVehiculo()
                
        );
        
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
