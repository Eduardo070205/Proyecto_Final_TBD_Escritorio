/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JComboBox;

/**
 *
 * @author Eduardo
 */
public class Precios {
    
    public void asignarPrecios(JComboBox combo){
        
        for(int  i = 100000; i <= 1000000; i = i+100000){
            
            combo.addItem(String.valueOf(i) );
            
        }
        
        
    }
    
    public void asignarPrecioVenta(JComboBox combo){
        
        for(int i = 100000; i <= 2000000; i = i+200000){
            
            combo.addItem(String.valueOf(i) );
            
        }
        
    }
    
}
