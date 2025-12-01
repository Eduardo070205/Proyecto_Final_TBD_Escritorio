/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conexion.ConexionBD;
import Controlador.ModeloDAO;
import Controlador.VehiculoDAO;
import Controlador.VentaDAO;
import Modelo.ResultSetTableModel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;

/**
 *
 * @author Eduardo
 */
public class Recursos extends javax.swing.JFrame{
  
    ConexionBD con = ConexionBD.getInstancia();
    
    public Precios precios = new Precios();
    
    public AsignacionesCombos asignarCombo = new AsignacionesCombos();
    
    public Fechas fechas = new Fechas();
    
    public Validacion validar = new Validacion();
    
    
    public void generarReporte(String modelo) {
        
        Connection cn = con.getConexion(); 
        
        if (cn == null) {
            System.out.println("No se pudo conectar a la base de datos");
            return;
        }

        try {
            PreparedStatement ps = cn.prepareStatement(
                "SELECT total_vendido_modelo(?) AS total_vendido"
            );
            ps.setInt(1, Integer.parseInt(modelo));
            
            String nombreArchivo = "reporte_ventas_modelo_" + modelo + ".pdf";
            File archivo = new File(nombreArchivo);

            
            DynamicReports.report()
                    .setDataSource(ps.executeQuery()) 
                    .columns(
                            Columns.column("Total de ventas", "total_vendido", DataTypes.bigDecimalType())
                    )
                    .title(
                            Components.image(getClass().getResource("/img/LOGO_chico.png")).setFixedDimension(120, 120),
                            Components.text("Reporte de ventas del modelo: " + modelo)) 
                    .pageFooter(Components.pageXofY()) 
                    .toPdf(new FileOutputStream("reporte_ventas_modelo_"+ modelo +".pdf")); 

            
            
            if (Desktop.isDesktopSupported()) {
                         
                Desktop.getDesktop().open(archivo);
                
                JOptionPane.showMessageDialog(this, "Se genero el reporte correctamente");
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void mostrarInternal(JInternalFrame internal){
        
        internal.setVisible(true);
        
        internal.toFront();
        
    }
    
    public void accionCancelar(JInternalFrame intenal){
        
        
        
    }
    
    public void recrearVista(String nombreVista, String consultaSQL) {

        String sqlDrop = "DROP VIEW IF EXISTS " + nombreVista + " CASCADE";
        String sqlCreate = "CREATE VIEW " + nombreVista + " AS " + consultaSQL;

        try (Statement stmt = con.getConexion().createStatement()) {

            stmt.executeUpdate(sqlDrop);
            stmt.executeUpdate(sqlCreate);

            System.out.println("Vista recreada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void cargarVistaEnTabla(JTable tabla, String nombreVista) {
        
        final String CONTROLADOR_JDBC = "org.postgresql.Driver";
        final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
        String CONSULTA = "SELECT * FROM " + nombreVista;

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(

                con.getConexion(),
                CONSULTA
                    
            );

            tabla.setModel(modelo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void agregarClientesEmpleados(JComboBox combo, char tipo){
        
        
        for(int i = 1; i <=5; i++){
            
            if(tipo == 'C'){
                
                combo.addItem("CL00" + i);
                
            }else if (tipo == 'E'){
                
                combo.addItem("EM0" + i);
                
            }
            
        }
        
    }
    
    
    public void restablecer(JComponent... componentes){

        for(JComponent c : componentes){

            if(c instanceof JTextField) {

                ((JTextField) c).setText("");

            }
            if(c instanceof JComboBox<?>){

                ((JComboBox<?>) c).setSelectedIndex(0);

            }
            if(c instanceof JRadioButton){

                ((JRadioButton) c).setSelected(true);

            }
            if(c instanceof JSpinner){
                
                ((JSpinner) c).setValue(0);
                
            }

        }

    }

    public void actualizarTabla(JTable tabla, String tablaBaseDatos) {
        
        String clave = "id_" + tablaBaseDatos.substring(0, tablaBaseDatos.length()-1);

        final String CONTROLADOR_JDBC = "org.postgresql.Driver";
        final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
        final String CONSULTA = "SELECT * FROM " + tablaBaseDatos + " ORDER BY " + clave + ";";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(
               
                con.getConexion(),   
                CONSULTA
            );

            tabla.setModel(modelo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void actualizarTablaConFiltro(JTable tabla, String tablaBaseDatos, String campo, String valor, char tipo){
        
        
        final String CONTROLADOR_JDBC = "org.postgresql.Driver";
        final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
        String CONSULTA = null;
        
        
        if(tipo == 'T'){
                    
            CONSULTA = "SELECT * FROM " + tablaBaseDatos + " WHERE " + campo + " LIKE '" + valor + "%';";
            
        }else if(tipo == 'N'){
            
          
            CONSULTA = "SELECT * FROM " + tablaBaseDatos + " WHERE " + campo + " = " + valor + ";";
            
        }else if(tipo == 'O'){
            
             CONSULTA = "SELECT * FROM " + tablaBaseDatos + " WHERE " + campo + " < " + valor + ";";
            
        }else if(tipo == 'A'){
            
             CONSULTA = "SELECT * FROM " + tablaBaseDatos + " WHERE extract(year from " + campo + ") = " + valor + ";";
            
        }else if(tipo == 'M'){
            
             CONSULTA = "SELECT * FROM " + tablaBaseDatos + " WHERE extract(month from " + campo + ") = " + valor + ";";
            
        }
        
        else{
            
            CONSULTA = "SELECT * FROM " + tablaBaseDatos + ";";
            
        }
        
     
        try {
            ResultSetTableModel modelo = new ResultSetTableModel(
                con.getConexion(),
                CONSULTA
            );

            tabla.setModel(modelo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void ocultarInternal(JInternalFrame internalVisible, JInternalFrame... internals){
        
        for(JInternalFrame i : internals){
            
            i.setVisible(false);
            
        }
        
        internalVisible.setVisible(true);
        
    }
    
    public void cambiarColorBoton(JButton... btnMenu){
        
        for(JButton i : btnMenu){
            
            i.setBackground(new java.awt.Color(227,211,163));
            
        }
        
    }
    
    public void desabilitarComponenetes(JComponent componente_activo, JComponent... componente){
        
        for(JComponent c : componente){
            
            c.setEnabled(false);
            
        }
        
        componente_activo.setEnabled(true);
        
    }
    
}


