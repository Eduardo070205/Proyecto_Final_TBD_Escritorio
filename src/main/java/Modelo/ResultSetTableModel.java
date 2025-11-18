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

    public ResultSetTableModel(String driver, String url, String consulta)
            throws SQLException, ClassNotFoundException {

        // Cargar el driver de PostgreSQL
        Class.forName("org.postgresql.Driver");

        // Conectarse a PostgreSQL
        conexion = DriverManager.getConnection(url, "eduardo", "Eduardo10");
        // CAMBIA "postgres" y "1234" por tu usuario y contraseña reales

        instruccion = conexion.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        conectadoALaBaseDeDatos = true;

        establecerConsulta(consulta);
    }

    @Override
    public Class getColumnClass(int columna) {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            String nombreClase = metaDatos.getColumnClassName(columna + 1);
            return Class.forName(nombreClase);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Object.class;
    }

    @Override
    public int getColumnCount() {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            return metaDatos.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getColumnName(int columna) {
        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        try {
            return metaDatos.getColumnName(columna + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
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
            e.printStackTrace();
        }

        return "";
    }

    public void establecerConsulta(String consulta)
            throws SQLException {

        if (!conectadoALaBaseDeDatos)
            throw new IllegalStateException("No hay conexion a la base de datos");

        conjuntoResultados = instruccion.executeQuery(consulta);
        metaDatos = conjuntoResultados.getMetaData();

        conjuntoResultados.last();
        numeroDeFilas = conjuntoResultados.getRow();

        fireTableStructureChanged();
    }

    public void desconectarDeLaBaseDeDatos() {
        try {
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conectadoALaBaseDeDatos = false;
        }
    }
}

