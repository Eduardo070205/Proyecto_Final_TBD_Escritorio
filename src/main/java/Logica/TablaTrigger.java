/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Eduardo
 */
public class TablaTrigger extends TablaTemplate {

    @Override
    protected String obtenerConsulta(String tablaBaseDatos) {
    
        return "SELECT * FROM " + tablaBaseDatos + ";";
    }
    
}
