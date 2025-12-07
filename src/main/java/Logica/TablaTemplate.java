/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.ResultSetTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Eduardo
 */
public abstract class TablaTemplate {

    protected abstract String obtenerConsulta(String tablaBaseDatos);

    public void actualizarTabla(JTable tabla, String tablaBaseDatos, Connection con) {

        String consulta = obtenerConsulta(tablaBaseDatos);

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(
                    con,
                    consulta
            );

            tabla.setModel(modelo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
