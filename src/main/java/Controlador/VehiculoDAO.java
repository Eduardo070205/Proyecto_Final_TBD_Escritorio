/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;
import Modelo.Vehiculo;

/**
 *
 * @author Eduardo
 */
public class VehiculoDAO {
    
    ConexionBD con = ConexionBD.getInstancia();
    
    // ============================= ALTAS ==============================
    
    public boolean agregarVehiculo(Vehiculo vehiculo){
        
        String sql = "INSERT INTO vehiculos(id_vehiculo, numero_serie, id_modelo, fecha_fabricacion, precio, kilometraje, fecha_entrada, tipo, estado) VALUES(?,?,?,?,?,?,?,?,?) ";
        
        return con.ejecutarInstruccionLMD(sql, 
                
            vehiculo.getIdVehiculo(),
            vehiculo.getNumSerie(),
            vehiculo.getIdModelo(),
            vehiculo.getFechaFabricacion(),
            vehiculo.getPrecio(),
            vehiculo.getKilometraje(),
            vehiculo.getFehcaEntrada(),
            vehiculo.getTipo(),
            vehiculo.getEstado()
                
        );
        
    }
    
    public boolean eliminarVehiculo(String numVehiculo){
        
        String sql = "DELETE FROM vehiculos WHERE id_vehiculo = ?;";
        
        return con.ejecutarInstruccionLMD(sql, numVehiculo);
        
        
        
    }
    
    public boolean editarVehiculo(Vehiculo vehiculo){
        
        String sql = "UPDATE vehiculos SET numero_serie = ?, id_modelo = ?, fecha_fabricacion = ?, precio = ?, kilometraje = ?, fecha_entrada = ?, tipo = ?, estado = ? WHERE id_vehiculo = ?";
        
        return con.ejecutarInstruccionLMD(sql, 
                
            vehiculo.getNumSerie(),
            vehiculo.getIdModelo(),
            vehiculo.getFechaFabricacion(),
            vehiculo.getPrecio(),
            vehiculo.getKilometraje(),
            vehiculo.getFehcaEntrada(),
            vehiculo.getTipo(),
            vehiculo.getEstado(),
            vehiculo.getIdVehiculo()    
                
        );
        
    }
    
    
}
