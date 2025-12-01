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
public class Fechas {
    
    public void asignarFechas(JComboBox comboAnio, JComboBox comboMes){
        
        comboAnio.removeAllItems();
        comboMes.removeAllItems();
       
        
        for(int i = 2025; i > 1900; i--){
            
            comboAnio.addItem(Integer.toString(i));
            
        }
        
        comboMes.addItem("Enero");
        comboMes.addItem("Febrero");
        comboMes.addItem("Marzo");
        comboMes.addItem("Abril");
        comboMes.addItem("Mayo");
        comboMes.addItem("Junio");
        comboMes.addItem("Julio");
        comboMes.addItem("Agosto");
        comboMes.addItem("Septiembre");
        comboMes.addItem("Octubre");
        comboMes.addItem("Noviembre");
        comboMes.addItem("Diciembre");
        
        
 
    }
     
    public void anioBisiesto(int anio, int valorMes, JComboBox comboDias){
        
        
        comboDias.removeAllItems();
        
        valorMes = valorMes + 1;
        
        if(valorMes == 1 || valorMes == 3 || valorMes == 5 || valorMes == 7 || valorMes == 8 || valorMes == 10 || valorMes == 12){
            
            for(int x = 1; x <= 31; x++){
                
                comboDias.addItem(x);
                
            }
            
        }else if(valorMes == 2){
            
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
   
                for(int x = 1; x <= 29; x++){
                
                    comboDias.addItem(x);
                
                }
            
            } else{
                
                for(int x = 1; x <= 28; x++){
                
                    comboDias.addItem(x);
                
                }
                
            }
            
        }else{
            
            for(int x = 1; x <= 30; x++){
                
                comboDias.addItem(x);
                
            }           
            
        }
        
    } 
    
    public void asignarMeses(JComboBox combo){
        
        combo.addItem("Enero");
        combo.addItem("Febrero");
        combo.addItem("Marzo");
        combo.addItem("Abril");
        combo.addItem("Mayo");
        combo.addItem("Junio");
        combo.addItem("Julio");
        combo.addItem("Agosto");
        combo.addItem("Septiembre");
        combo.addItem("Octubre");
        combo.addItem("Noviembre");
        combo.addItem("Diciembre");
        
        
    }
     
    
}
