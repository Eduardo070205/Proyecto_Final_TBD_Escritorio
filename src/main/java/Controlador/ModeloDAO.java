/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;
import Modelo.Modelo;

/**
 *
 * @author Eduardo
 */
public class ModeloDAO {
    
    ConexionBD con = ConexionBD.getInstancia();
    
    public boolean agregarModelo(Modelo modelo){
        
        String sql = "INSERT INTO modelos(nombre_modelo, año_modelo, fabricante, numero_cilindros, numero_puertas, peso_kg, capacidad_pasajeros, color_base, pais_fabricacion)"
                + "VALUES(?,?,?,?,?,?,?,?,?);";
        
        return con.ejecutarInstruccionLMD(sql, 
                
                modelo.getNombreModelo(),
                modelo.getAnioModelo(),
                modelo.getFabricante(),
                modelo.getNumeroCilindros(),
                modelo.getNumeroPuertas(),
                modelo.getPeso(),
                modelo.getCatidadPasajeros(),
                modelo.getColor(),
                modelo.getPaisFabricacion()
                
        );
        
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
