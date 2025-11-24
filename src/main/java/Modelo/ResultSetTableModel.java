/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eduardo
 */
import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel {

    private Connection conexion;
    private Statement instruccion;
    private ResultSet conjuntoResultados;
    private ResultSetMetaData metaDatos;

    private int numeroDeFilas;
    private boolean conectadoALaBaseDeDatos = false;

    // 🔹 Constructor MODIFICADO para NO crear nueva conexión
    public ResultSetTableModel(Connection conexion, String consulta)
            throws SQLException {

        this.conexion = conexion;

        instruccion = conexion.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        conectadoALaBaseDeDatos = true;

        establecerConsulta(consulta);
    }

    @Override
    public Class<?> getColumnClass(int columna) {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            return Class.forName(metaDatos.getColumnClassName(columna + 1));
        } catch (Exception e) {
            return Object.class;
        }
    }

    @Override
    public int getColumnCount() {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            return metaDatos.getColumnCount();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public String getColumnName(int columna) {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            return metaDatos.getColumnName(columna + 1);
        } catch (SQLException e) {
            return "";
        }
    }

    @Override
    public int getRowCount() {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        return numeroDeFilas;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            conjuntoResultados.absolute(fila + 1);
            return conjuntoResultados.getObject(columna + 1);
        } catch (SQLException e) {
            return null;
        }
    }

    public void establecerConsulta(String consulta) throws SQLException {

        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        conjuntoResultados = instruccion.executeQuery(consulta);
        metaDatos = conjuntoResultados.getMetaData();

        conjuntoResultados.last();
        numeroDeFilas = conjuntoResultados.getRow();

        fireTableStructureChanged();
    }

    // 🔹 NO cerramos la conexión aquí (solo Statement y ResultSet)
    public void cerrarRecursos() {
        try {
            if (conjuntoResultados != null) conjuntoResultados.close();
            if (instruccion != null) instruccion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


