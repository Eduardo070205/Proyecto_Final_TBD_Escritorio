/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Eduardo
 */

public abstract class ConsultaFactory {
    public abstract PreparedStatement createStatement(Connection cn, Object dato) throws Exception;
}
