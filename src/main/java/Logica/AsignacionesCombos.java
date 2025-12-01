/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author Eduardo
 */
public class AsignacionesCombos {
    
    public void asignacionTipos(JComboBox combo){
        
        combo.addItem("Nuevo");
        combo.addItem("Usado");
        
    }

    public void asignacionDisponibilidad(JComboBox combo){
        
        combo.addItem("Disponible");
        combo.addItem("Vendido");
        
    }
    
    public void asignacionCilindros(JComboBox combo){
        
        for(int i = 2; i <= 12; i = i+2){
            
            combo.addItem(String.valueOf(i));
                        
        }
        
    }
    
    public void asignarTipoPago(JComboBox combo){
        
        combo.addItem("Contado");
        combo.addItem("Financiamiento");
        
    }
    
}
