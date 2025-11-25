/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IPrecioService {
    
    List<Double> obtenerPrecios(List<String> vehiculos);
    
}
