/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Modelo.Vehiculo;
import Conexion.ConexionBD;
import Controlador.ModeloDAO;
import Controlador.VehiculoDAO;
import Controlador.VentaDAO;
import Modelo.Venta;
import Modelo.Modelo;
import Modelo.ResultSetTableModel;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.*;


/**
 *
 * @author Eduardo
 */
public class VentanaInicio extends javax.swing.JFrame {
   
    
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    
    ModeloDAO modeloDAO = new ModeloDAO();
    
    VentaDAO ventaDAO = new VentaDAO();
    
    ConexionBD con = ConexionBD.getInstancia();
    
    LocalDate hoy = LocalDate.now();
    
    ResultSet rs;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaInicio.class.getName());

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        internalHome.setVisible(true);
        internalVehiculos.setVisible(false);
        internalModelos.setVisible(false);
        internalVentas.setVisible(false);
        internalProximamente.setVisible(false);
        internalAgregarAutos.setVisible(false);
        internalModificarAutos.setVisible(false);
        
        desabilitarComponenetes(radioTodosBusqueda, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboAnioBusqueda1, comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);
        
        
        asignarFechas(comboAnioAgregar, comboMesAgregar);
        
        asignarFechas(comboAnioModificar, comboMesModificar);
        
        asignarFechas(comboAnioEntradaModificar, comboMesEntradaModificar);
        
        asignarFechas(comboVentasAnioActualizar, comboVentasMesActualizar);
        
        actualizarTabla(tablaVehiculos, "vehiculos");
        
        for(int i = 2025; i > 1900; i--){
            
            comboAnioBusqueda1.addItem(Integer.toString(i));
            comboAnioModeloBuscar.addItem(Integer.toString(i));
            comboModelosAnioAgregar.addItem(Integer.toString(i));
            comboModelosAnioActualizar.addItem(Integer.toString(i));
            
        }
        
        comboPrecioBusqueda1.addItem("100000");
        comboPrecioBusqueda1.addItem("200000");
        comboPrecioBusqueda1.addItem("300000");
        comboPrecioBusqueda1.addItem("400000");
        comboPrecioBusqueda1.addItem("500000");
        comboPrecioBusqueda1.addItem("600000");
        comboPrecioBusqueda1.addItem("700000");
        comboPrecioBusqueda1.addItem("800000");
        comboPrecioBusqueda1.addItem("900000");
        comboPrecioBusqueda1.addItem("1000000");
        
        comboTipoBusqueda.addItem("Nuevo");
        comboTipoBusqueda.addItem("Usado");
        comboTipoAgregar.addItem("Nuevo");
        comboTipoAgregar.addItem("Usado");
        comboTipoModificar.addItem("Nuevo");
        comboTipoModificar.addItem("Usado");
        
        
        
        
        
        comboEstadoBusqueda.addItem("Disponible");
        comboEstadoBusqueda.addItem("Vendido");
        comboEstadoModificar.addItem("Disponible");
        comboEstadoModificar.addItem("Vendido");
        
        desabilitarComponenetes(radioTodosModelos, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda);
        
        
      
        
        actualizarTabla(tablaModelos, "modelos");
        
        for(int i = 0; i < tablaModelos.getRowCount(); i++){
            
            comboModeloBusqueda.addItem(tablaModelos.getValueAt(i, 0).toString());
            
            comboModeloAgregar.addItem(tablaModelos.getValueAt(i, 0).toString());
            
            comboModeloModificar.addItem(tablaModelos.getValueAt(i, 0).toString());
            
     
            
        }
        
        
        // ================================ Modelos ======================================
        
        
        for(int i = 2; i <= 12; i = i+2){
            
            comboNumeroCilindrosBuscar.addItem(Integer.toString(i));
            comboModelosCilindrosAgregar.addItem(Integer.toString(i));
            comboModelosCilindrosActualizar.addItem(Integer.toString(i));
            
        }
        
        //=============================== Ventas ====================================
        
        
        comboVentasMesBuscar.addItem("Enero");
        comboVentasMesBuscar.addItem("Febrero");
        comboVentasMesBuscar.addItem("Marzo");
        comboVentasMesBuscar.addItem("Abril");
        comboVentasMesBuscar.addItem("Mayo");
        comboVentasMesBuscar.addItem("Junio");
        comboVentasMesBuscar.addItem("Julio");
        comboVentasMesBuscar.addItem("Agosto");
        comboVentasMesBuscar.addItem("Septiembre");
        comboVentasMesBuscar.addItem("Octubre");
        comboVentasMesBuscar.addItem("Noviembre");
        comboVentasMesBuscar.addItem("Diciembre");
        
        
        
        
         desabilitarComponenetes(radioTodosVentas, comboVentasPagoBuscar, comboVentasMesBuscar, cajaIDVentasBuscar, comboVentasPrecioBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
        
        
        actualizarTabla(tablaVentas, "ventas");
        actualizarTabla(tablaVehiculos, "vehiculos");
        
        comboVentasPrecioBuscar.addItem("200000");
        comboVentasPrecioBuscar.addItem("400000");
        comboVentasPrecioBuscar.addItem("600000");
        comboVentasPrecioBuscar.addItem("800000");
        comboVentasPrecioBuscar.addItem("1000000");
        comboVentasPrecioBuscar.addItem("1200000");
        comboVentasPrecioBuscar.addItem("1400000");
        comboVentasPrecioBuscar.addItem("1600000");
        comboVentasPrecioBuscar.addItem("1800000");
        comboVentasPrecioBuscar.addItem("2000000");
        
        comboVentasPagoBuscar.addItem("Contado");
        comboVentasPagoBuscar.addItem("Financiamiento");
        comboVentasFormaAgregar.addItem("Contado");
        comboVentasFormaAgregar.addItem("Financiamiento");
        comboVentasFormaActualizar.addItem("Contado");
        comboVentasFormaActualizar.addItem("Financiamiento");
        
        agregarClientesEmpleados(comboVentasClienteBuscar, 'C');
        
        agregarClientesEmpleados(comboVentasEmpleadoBuscar, 'E');
        
        agregarClientesEmpleados(comboVentasClienteAgregar, 'C');
        
        agregarClientesEmpleados(comboVentasEmpleadoAgregar, 'E');
        
        agregarClientesEmpleados(comboVentasClienteActualizar, 'C');
        
        agregarClientesEmpleados(comboVentasEmpleadoActualizar, 'E');
        
        
        for(int i = 0; i < tablaVehiculos.getRowCount(); i++){
            
            comboVentasVehiculosBuscar.addItem(tablaVehiculos.getValueAt(i, 0).toString());
            comboVentasvehiculoAgregar.addItem(tablaVehiculos.getValueAt(i, 0).toString());
            comboVentasvehiculoActualizar.addItem(tablaVehiculos.getValueAt(i, 0).toString());
            
            
        }

        
        pack();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBusquedaVehiculos = new javax.swing.ButtonGroup();
        groupBusquedaModelos = new javax.swing.ButtonGroup();
        groupBusquedaVentas = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        sidePane = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnVehiculos = new javax.swing.JButton();
        btnModelos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnDocumentacion = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        internalHome = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        btnHomeGrafica = new javax.swing.JButton();
        btnHomeVista = new javax.swing.JButton();
        btnHomeReporte = new javax.swing.JButton();
        btnHomeHistorialPrecios = new javax.swing.JButton();
        btnHomeVehiculosEliminados = new javax.swing.JButton();
        internalVehiculos = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnModificarVehiculos = new javax.swing.JButton();
        btnAgregarVehiculos = new javax.swing.JButton();
        btnEliminarVehiculos = new javax.swing.JButton();
        cajaNumVehiculoBuscar = new javax.swing.JTextField();
        radioTipoBusqueda = new javax.swing.JRadioButton();
        radioModeloBusqueda = new javax.swing.JRadioButton();
        cajaNumSerieBuscar = new javax.swing.JTextField();
        comboModeloBusqueda = new javax.swing.JComboBox<>();
        radioNumSerieBusqueda = new javax.swing.JRadioButton();
        comboEstadoBusqueda = new javax.swing.JComboBox<>();
        radioNumVehiculoBusqueda = new javax.swing.JRadioButton();
        comboTipoBusqueda = new javax.swing.JComboBox<>();
        radioTodosBusqueda = new javax.swing.JRadioButton();
        radioPrecioBusqueda1 = new javax.swing.JRadioButton();
        comboPrecioBusqueda1 = new javax.swing.JComboBox<>();
        radioAnioBusqueda1 = new javax.swing.JRadioButton();
        comboAnioBusqueda1 = new javax.swing.JComboBox<>();
        radioEstadoBusqueda1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        internalModelos = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaModelos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminarModelos = new javax.swing.JButton();
        btnAgregarModelos = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnActualizarModelos = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        radioNumeroCilindros = new javax.swing.JRadioButton();
        radioidModeloBusqueda = new javax.swing.JRadioButton();
        cajaNombreModeloBusqueda = new javax.swing.JTextField();
        radioNombreModelo = new javax.swing.JRadioButton();
        comboAnioModeloBuscar = new javax.swing.JComboBox<>();
        radioAnioModeloBuscar = new javax.swing.JRadioButton();
        radioFabricanteModelo = new javax.swing.JRadioButton();
        comboNumeroCilindrosBuscar = new javax.swing.JComboBox<>();
        radioPais = new javax.swing.JRadioButton();
        radioNumeroPuertas = new javax.swing.JRadioButton();
        radioPeso = new javax.swing.JRadioButton();
        radioPasajeros = new javax.swing.JRadioButton();
        radioTodosModelos = new javax.swing.JRadioButton();
        cajaFabricanteModeloBusqueda = new javax.swing.JTextField();
        cajaPaisModeloBusqueda = new javax.swing.JTextField();
        cajaIDModeloBusqueda = new javax.swing.JTextField();
        cajaModeloPesoBusqueda = new javax.swing.JTextField();
        cajaModeloPasajerosBusqueda = new javax.swing.JTextField();
        cajaModeloPuertasBusqueda = new javax.swing.JTextField();
        internalVentas = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnEliminarVentas = new javax.swing.JButton();
        btnAgregarVentas = new javax.swing.JButton();
        btnActualizarVentas = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        radioIDVentaVentas = new javax.swing.JRadioButton();
        radioTodosVentas = new javax.swing.JRadioButton();
        cajaIDVentasBuscar = new javax.swing.JTextField();
        comboVentasVehiculosBuscar = new javax.swing.JComboBox<>();
        radioMesVentas = new javax.swing.JRadioButton();
        comboVentasMesBuscar = new javax.swing.JComboBox<>();
        radioPrecioVentas = new javax.swing.JRadioButton();
        comboVentasPrecioBuscar = new javax.swing.JComboBox<>();
        radioIdClienteVentas = new javax.swing.JRadioButton();
        comboVentasClienteBuscar = new javax.swing.JComboBox<>();
        radioIDEmpleadoVentas = new javax.swing.JRadioButton();
        comboVentasEmpleadoBuscar = new javax.swing.JComboBox<>();
        radioIDVehiculoVentas = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        radioVentasPagoBuscar = new javax.swing.JRadioButton();
        comboVentasPagoBuscar = new javax.swing.JComboBox<>();
        internalProximamente = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        internalAgregarAutos = new javax.swing.JInternalFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cajaNumVehiculoAgregar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cajaNumSerieAgregar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboModeloAgregar = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboAnioAgregar = new javax.swing.JComboBox<>();
        comboMesAgregar = new javax.swing.JComboBox<>();
        comboDiaAgregar = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        comboTipoAgregar = new javax.swing.JComboBox<>();
        btnAgregarAgregar = new javax.swing.JButton();
        btnRestaurarAgregar = new javax.swing.JButton();
        btnCancelarAgregar = new javax.swing.JButton();
        cajaPrecioAgregar = new javax.swing.JTextField();
        cajaKilometrajeAgregar = new javax.swing.JTextField();
        internalModificarAutos = new javax.swing.JInternalFrame();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cajaNumSerieModificar = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comboModeloModificar = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comboAnioModificar = new javax.swing.JComboBox<>();
        comboMesModificar = new javax.swing.JComboBox<>();
        comboDiaModificar = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        comboTipoModificar = new javax.swing.JComboBox<>();
        comboEstadoModificar = new javax.swing.JComboBox<>();
        btnActualizarModificar = new javax.swing.JButton();
        btnCancelarModificar = new javax.swing.JButton();
        comboAnioEntradaModificar = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        comboMesEntradaModificar = new javax.swing.JComboBox<>();
        comboDiaEntradaModificar = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cajaPrecioModificar = new javax.swing.JTextField();
        cajaKilometrajeModificar = new javax.swing.JTextField();
        internalAgregarModelos = new javax.swing.JInternalFrame();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cajaModelosPaisAgregar = new javax.swing.JTextField();
        cajaModelosNombreAgregar = new javax.swing.JTextField();
        cajaModelosFabricanteAgregar = new javax.swing.JTextField();
        cajaModelosColorAgregar = new javax.swing.JTextField();
        comboModelosCilindrosAgregar = new javax.swing.JComboBox<>();
        comboModelosAnioAgregar = new javax.swing.JComboBox<>();
        btnModelosCancelarAgregar = new javax.swing.JButton();
        btnModelosAgregarAgregar = new javax.swing.JButton();
        btnModelosRestaurarAgregar = new javax.swing.JButton();
        cajaModelosPasajerosAgregar = new javax.swing.JTextField();
        cajaModelosPuertasAgregar = new javax.swing.JTextField();
        cajaModelosPesoAgregar = new javax.swing.JTextField();
        internalCambiosModelos = new javax.swing.JInternalFrame();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cajaModelosPaisActualizar = new javax.swing.JTextField();
        cajaModelosNombreActualizar = new javax.swing.JTextField();
        cajaModelosFabricanteActualizar = new javax.swing.JTextField();
        cajaModelosColorActualizar = new javax.swing.JTextField();
        comboModelosCilindrosActualizar = new javax.swing.JComboBox<>();
        comboModelosAnioActualizar = new javax.swing.JComboBox<>();
        btnModelosCancelarActualizar = new javax.swing.JButton();
        btnModelosActualizarActualizar = new javax.swing.JButton();
        cajaModelosPasajerosActualizar = new javax.swing.JTextField();
        cajaModelosPuertasActualizar = new javax.swing.JTextField();
        cajaModelosPesoActualizar = new javax.swing.JTextField();
        internalAltasVentas = new javax.swing.JInternalFrame();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cajaVentasPrecioAgregar = new javax.swing.JTextField();
        comboVentasvehiculoAgregar = new javax.swing.JComboBox<>();
        comboVentasFormaAgregar = new javax.swing.JComboBox<>();
        comboVentasClienteAgregar = new javax.swing.JComboBox<>();
        comboVentasEmpleadoAgregar = new javax.swing.JComboBox<>();
        btnVentasCancelarAgregar = new javax.swing.JButton();
        btnVentasAgregarAgregar = new javax.swing.JButton();
        btnVentasRestaurarAgregar = new javax.swing.JButton();
        internalActualizarVentas = new javax.swing.JInternalFrame();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        cajaVentasPrecioActualizar = new javax.swing.JTextField();
        comboVentasvehiculoActualizar = new javax.swing.JComboBox<>();
        comboVentasDiaActualizar = new javax.swing.JComboBox<>();
        comboVentasClienteActualizar = new javax.swing.JComboBox<>();
        comboVentasEmpleadoActualizar = new javax.swing.JComboBox<>();
        btnVentasCancelarActualizar = new javax.swing.JButton();
        btnVentasActualizarActualizar = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        comboVentasFormaActualizar = new javax.swing.JComboBox<>();
        comboVentasAnioActualizar = new javax.swing.JComboBox<>();
        comboVentasMesActualizar = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        internalVehiculosEliminados = new javax.swing.JInternalFrame();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVehiculosEliminados = new javax.swing.JTable();
        btnVehiculosEliminadosCerrar = new javax.swing.JButton();
        internalHistorialPrecios = new javax.swing.JInternalFrame();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaHistorialPrecios = new javax.swing.JTable();
        btnHistorialPreciosCerrar = new javax.swing.JButton();
        internalHomeVista = new javax.swing.JInternalFrame();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaVista = new javax.swing.JTable();
        btnVistaCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autos Amistosos");
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePane.setBackground(new java.awt.Color(247, 227, 178));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\LOGO_chico.png")); // NOI18N
        sidePane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 140, 140));

        btnCerrarSesion.setBackground(new java.awt.Color(227, 211, 163));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cerrar_sesion.png")); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        sidePane.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, 40));

        btnHome.setBackground(new java.awt.Color(214, 198, 152));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 0, 0));
        btnHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\home.png")); // NOI18N
        btnHome.setText("Home");
        btnHome.setToolTipText("");
        btnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        sidePane.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 220, 40));

        btnVehiculos.setBackground(new java.awt.Color(227, 211, 163));
        btnVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        btnVehiculos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\carro.png")); // NOI18N
        btnVehiculos.setText("Vehículos");
        btnVehiculos.setToolTipText("");
        btnVehiculos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculosActionPerformed(evt);
            }
        });
        sidePane.add(btnVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 220, 40));

        btnModelos.setBackground(new java.awt.Color(227, 211, 163));
        btnModelos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModelos.setForeground(new java.awt.Color(0, 0, 0));
        btnModelos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\modelo.png")); // NOI18N
        btnModelos.setText("Modelos");
        btnModelos.setToolTipText("");
        btnModelos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnModelos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosActionPerformed(evt);
            }
        });
        sidePane.add(btnModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 40));

        btnVentas.setBackground(new java.awt.Color(227, 211, 163));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnVentas.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\ventas.png")); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setToolTipText("");
        btnVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        sidePane.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 40));

        btnEmpleados.setBackground(new java.awt.Color(227, 211, 163));
        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(0, 0, 0));
        btnEmpleados.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\empleados.png")); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setToolTipText("");
        btnEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        sidePane.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 220, 40));

        btnClientes.setBackground(new java.awt.Color(227, 211, 163));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 0, 0));
        btnClientes.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cliente.png")); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setToolTipText("");
        btnClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        sidePane.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 220, 40));

        btnDocumentacion.setBackground(new java.awt.Color(227, 211, 163));
        btnDocumentacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDocumentacion.setForeground(new java.awt.Color(0, 0, 0));
        btnDocumentacion.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\documento.png")); // NOI18N
        btnDocumentacion.setText("Docimentación");
        btnDocumentacion.setToolTipText("");
        btnDocumentacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDocumentacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDocumentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentacionActionPerformed(evt);
            }
        });
        sidePane.add(btnDocumentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 220, 40));

        bg.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 221, 615));

        internalHome.setBackground(new java.awt.Color(255, 255, 255));
        internalHome.setTitle("Home");
        internalHome.setToolTipText("");
        internalHome.setVisible(false);
        internalHome.getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(247, 227, 178));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hola Bienvenido a Autos Amistosos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 0, 370, 66);

        jLabel81.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\LOGO.png")); // NOI18N
        jPanel1.add(jLabel81);
        jLabel81.setBounds(270, 50, 200, 190);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(null);

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setText("Acciones Rápidas");
        jPanel21.add(jLabel82);
        jLabel82.setBounds(10, 10, 150, 30);

        btnHomeGrafica.setBackground(new java.awt.Color(122, 122, 63));
        btnHomeGrafica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomeGrafica.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeGrafica.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\grafica.png")); // NOI18N
        btnHomeGrafica.setText("Gráfica Ventas");
        jPanel21.add(btnHomeGrafica);
        btnHomeGrafica.setBounds(540, 70, 200, 60);

        btnHomeVista.setBackground(new java.awt.Color(122, 122, 63));
        btnHomeVista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomeVista.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeVista.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\vista.png")); // NOI18N
        btnHomeVista.setText("Vista Vehículos-Modelo");
        btnHomeVista.setToolTipText("");
        btnHomeVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeVistaActionPerformed(evt);
            }
        });
        jPanel21.add(btnHomeVista);
        btnHomeVista.setBounds(10, 70, 240, 60);

        btnHomeReporte.setBackground(new java.awt.Color(122, 122, 63));
        btnHomeReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomeReporte.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeReporte.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\reporte.png")); // NOI18N
        btnHomeReporte.setText("Reporte Ventas");
        jPanel21.add(btnHomeReporte);
        btnHomeReporte.setBounds(290, 70, 210, 60);

        btnHomeHistorialPrecios.setBackground(new java.awt.Color(122, 122, 63));
        btnHomeHistorialPrecios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomeHistorialPrecios.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeHistorialPrecios.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\ventas.png")); // NOI18N
        btnHomeHistorialPrecios.setText("Historial Precios");
        btnHomeHistorialPrecios.setToolTipText("");
        btnHomeHistorialPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeHistorialPreciosActionPerformed(evt);
            }
        });
        jPanel21.add(btnHomeHistorialPrecios);
        btnHomeHistorialPrecios.setBounds(450, 180, 240, 60);

        btnHomeVehiculosEliminados.setBackground(new java.awt.Color(122, 122, 63));
        btnHomeVehiculosEliminados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomeVehiculosEliminados.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeVehiculosEliminados.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\carro.png")); // NOI18N
        btnHomeVehiculosEliminados.setText("Vehículos Eliminados");
        btnHomeVehiculosEliminados.setToolTipText("");
        btnHomeVehiculosEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeVehiculosEliminadosActionPerformed(evt);
            }
        });
        jPanel21.add(btnHomeVehiculosEliminados);
        btnHomeVehiculosEliminados.setBounds(90, 180, 240, 60);

        jPanel1.add(jPanel21);
        jPanel21.setBounds(0, 240, 760, 330);

        internalHome.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 760, 570);

        jDesktopPane1.add(internalHome);
        internalHome.setBounds(0, 0, 770, 610);

        internalVehiculos.setTitle("Vehiculos");
        internalVehiculos.setVisible(false);
        internalVehiculos.getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(214, 198, 152));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Vehículos");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N

        btnModificarVehiculos.setBackground(new java.awt.Color(122, 122, 63));
        btnModificarVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificarVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarVehiculos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnModificarVehiculos.setText("Actualizar");
        btnModificarVehiculos.setEnabled(false);
        btnModificarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVehiculosActionPerformed(evt);
            }
        });

        btnAgregarVehiculos.setBackground(new java.awt.Color(122, 122, 63));
        btnAgregarVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarVehiculos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnAgregarVehiculos.setText("Agregar");
        btnAgregarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculosActionPerformed(evt);
            }
        });

        btnEliminarVehiculos.setBackground(new java.awt.Color(122, 122, 63));
        btnEliminarVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarVehiculos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\eliminar.png")); // NOI18N
        btnEliminarVehiculos.setText("Eliminar");
        btnEliminarVehiculos.setEnabled(false);
        btnEliminarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnAgregarVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarVehiculos)
                .addGap(43, 43, 43)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(0, 0, 760, 60);

        cajaNumVehiculoBuscar.setBackground(new java.awt.Color(255, 255, 255));
        cajaNumVehiculoBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaNumVehiculoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNumVehiculoBuscarActionPerformed(evt);
            }
        });
        cajaNumVehiculoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaNumVehiculoBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(cajaNumVehiculoBuscar);
        cajaNumVehiculoBuscar.setBounds(30, 100, 210, 30);

        groupBusquedaVehiculos.add(radioTipoBusqueda);
        radioTipoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioTipoBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioTipoBusqueda.setText("Tipo");
        radioTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipoBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(radioTipoBusqueda);
        radioTipoBusqueda.setBounds(510, 150, 200, 25);

        groupBusquedaVehiculos.add(radioModeloBusqueda);
        radioModeloBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioModeloBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioModeloBusqueda.setText("Modelo");
        radioModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioModeloBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(radioModeloBusqueda);
        radioModeloBusqueda.setBounds(510, 70, 170, 25);

        cajaNumSerieBuscar.setBackground(new java.awt.Color(255, 255, 255));
        cajaNumSerieBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaNumSerieBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNumSerieBuscarActionPerformed(evt);
            }
        });
        cajaNumSerieBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaNumSerieBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(cajaNumSerieBuscar);
        cajaNumSerieBuscar.setBounds(270, 100, 210, 30);

        comboModeloBusqueda.setBackground(new java.awt.Color(214, 198, 152));
        comboModeloBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        comboModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModeloBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(comboModeloBusqueda);
        comboModeloBusqueda.setBounds(510, 100, 210, 26);

        groupBusquedaVehiculos.add(radioNumSerieBusqueda);
        radioNumSerieBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioNumSerieBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioNumSerieBusqueda.setText("Número de Serie");
        radioNumSerieBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumSerieBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(radioNumSerieBusqueda);
        radioNumSerieBusqueda.setBounds(260, 70, 170, 25);

        comboEstadoBusqueda.setBackground(new java.awt.Color(214, 198, 152));
        comboEstadoBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        comboEstadoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(comboEstadoBusqueda);
        comboEstadoBusqueda.setBounds(30, 250, 210, 26);

        groupBusquedaVehiculos.add(radioNumVehiculoBusqueda);
        radioNumVehiculoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioNumVehiculoBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioNumVehiculoBusqueda.setText("Número de Vehículo");
        radioNumVehiculoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumVehiculoBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(radioNumVehiculoBusqueda);
        radioNumVehiculoBusqueda.setBounds(30, 70, 170, 25);

        comboTipoBusqueda.setBackground(new java.awt.Color(214, 198, 152));
        comboTipoBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        comboTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(comboTipoBusqueda);
        comboTipoBusqueda.setBounds(510, 180, 210, 26);

        groupBusquedaVehiculos.add(radioTodosBusqueda);
        radioTodosBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioTodosBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioTodosBusqueda.setSelected(true);
        radioTodosBusqueda.setText("Mostrar Todos los Vehículos");
        radioTodosBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(radioTodosBusqueda);
        radioTodosBusqueda.setBounds(290, 240, 230, 25);

        groupBusquedaVehiculos.add(radioPrecioBusqueda1);
        radioPrecioBusqueda1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioPrecioBusqueda1.setForeground(new java.awt.Color(0, 0, 0));
        radioPrecioBusqueda1.setText("Precio Menor A:");
        radioPrecioBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPrecioBusqueda1ActionPerformed(evt);
            }
        });
        jPanel2.add(radioPrecioBusqueda1);
        radioPrecioBusqueda1.setBounds(270, 150, 200, 25);

        comboPrecioBusqueda1.setBackground(new java.awt.Color(214, 198, 152));
        comboPrecioBusqueda1.setForeground(new java.awt.Color(0, 0, 0));
        comboPrecioBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPrecioBusqueda1ActionPerformed(evt);
            }
        });
        jPanel2.add(comboPrecioBusqueda1);
        comboPrecioBusqueda1.setBounds(270, 180, 210, 26);

        groupBusquedaVehiculos.add(radioAnioBusqueda1);
        radioAnioBusqueda1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioAnioBusqueda1.setForeground(new java.awt.Color(0, 0, 0));
        radioAnioBusqueda1.setText("Año de Fabricación");
        radioAnioBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAnioBusqueda1ActionPerformed(evt);
            }
        });
        jPanel2.add(radioAnioBusqueda1);
        radioAnioBusqueda1.setBounds(30, 150, 200, 25);

        comboAnioBusqueda1.setBackground(new java.awt.Color(214, 198, 152));
        comboAnioBusqueda1.setForeground(new java.awt.Color(0, 0, 0));
        comboAnioBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioBusqueda1ActionPerformed(evt);
            }
        });
        jPanel2.add(comboAnioBusqueda1);
        comboAnioBusqueda1.setBounds(30, 180, 210, 26);

        groupBusquedaVehiculos.add(radioEstadoBusqueda1);
        radioEstadoBusqueda1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioEstadoBusqueda1.setForeground(new java.awt.Color(0, 0, 0));
        radioEstadoBusqueda1.setText("Estado");
        radioEstadoBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEstadoBusqueda1ActionPerformed(evt);
            }
        });
        jPanel2.add(radioEstadoBusqueda1);
        radioEstadoBusqueda1.setBounds(30, 220, 200, 25);

        tablaVehiculos.setBackground(new java.awt.Color(247, 227, 178));
        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Vehiculo", "Numero_Serie", "ID_Modelo", "Fecha_Fabricacion", "Precio", "Kilometraje", "Fecha_Entrada", "Tipo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaVehiculos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 290, 720, 270);

        internalVehiculos.getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 760, 580);

        jDesktopPane1.add(internalVehiculos);
        internalVehiculos.setBounds(0, 0, 770, 610);

        internalModelos.setTitle("Modelos");
        internalModelos.setVisible(false);
        internalModelos.getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        tablaModelos.setBackground(new java.awt.Color(214, 198, 152));
        tablaModelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaModelos);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 260, 720, 280);

        jPanel11.setBackground(new java.awt.Color(214, 198, 152));
        jPanel11.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Modelos");
        jPanel11.add(jLabel3);
        jLabel3.setBounds(70, 130, 420, 90);

        btnEliminarModelos.setBackground(new java.awt.Color(122, 122, 63));
        btnEliminarModelos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarModelos.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarModelos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\eliminar.png")); // NOI18N
        btnEliminarModelos.setText("Eliminar");
        btnEliminarModelos.setEnabled(false);
        btnEliminarModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarModelosActionPerformed(evt);
            }
        });
        jPanel11.add(btnEliminarModelos);
        btnEliminarModelos.setBounds(520, 10, 120, 40);

        btnAgregarModelos.setBackground(new java.awt.Color(122, 122, 63));
        btnAgregarModelos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarModelos.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarModelos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnAgregarModelos.setText("Agregar");
        btnAgregarModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarModelosActionPerformed(evt);
            }
        });
        jPanel11.add(btnAgregarModelos);
        btnAgregarModelos.setBounds(230, 10, 120, 40);

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel11.add(jLabel20);
        jLabel20.setBounds(690, 0, 50, 58);

        btnActualizarModelos.setBackground(new java.awt.Color(122, 122, 63));
        btnActualizarModelos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarModelos.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizarModelos.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnActualizarModelos.setText("Actualizar");
        btnActualizarModelos.setEnabled(false);
        btnActualizarModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarModelosActionPerformed(evt);
            }
        });
        jPanel11.add(btnActualizarModelos);
        btnActualizarModelos.setBounds(370, 10, 130, 40);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Modelos");
        jPanel11.add(jLabel23);
        jLabel23.setBounds(10, 0, 140, 50);

        jPanel3.add(jPanel11);
        jPanel11.setBounds(0, 0, 760, 60);

        groupBusquedaModelos.add(radioNumeroCilindros);
        radioNumeroCilindros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioNumeroCilindros.setForeground(new java.awt.Color(0, 0, 0));
        radioNumeroCilindros.setText("Número Cilindros");
        radioNumeroCilindros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumeroCilindrosActionPerformed(evt);
            }
        });
        jPanel3.add(radioNumeroCilindros);
        radioNumeroCilindros.setBounds(590, 70, 130, 20);

        groupBusquedaModelos.add(radioidModeloBusqueda);
        radioidModeloBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioidModeloBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        radioidModeloBusqueda.setText("ID Modelo");
        radioidModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioidModeloBusquedaActionPerformed(evt);
            }
        });
        jPanel3.add(radioidModeloBusqueda);
        radioidModeloBusqueda.setBounds(30, 70, 83, 21);

        cajaNombreModeloBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaNombreModeloBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaNombreModeloBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaNombreModeloBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaNombreModeloBusqueda);
        cajaNombreModeloBusqueda.setBounds(160, 100, 120, 18);

        groupBusquedaModelos.add(radioNombreModelo);
        radioNombreModelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioNombreModelo.setForeground(new java.awt.Color(0, 0, 0));
        radioNombreModelo.setText("Nombre Modelo");
        radioNombreModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNombreModeloActionPerformed(evt);
            }
        });
        jPanel3.add(radioNombreModelo);
        radioNombreModelo.setBounds(160, 70, 130, 21);

        comboAnioModeloBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboAnioModeloBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboAnioModeloBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboAnioModeloBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioModeloBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(comboAnioModeloBuscar);
        comboAnioModeloBuscar.setBounds(310, 100, 90, 26);

        groupBusquedaModelos.add(radioAnioModeloBuscar);
        radioAnioModeloBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioAnioModeloBuscar.setForeground(new java.awt.Color(0, 0, 0));
        radioAnioModeloBuscar.setText("Año Modelo");
        radioAnioModeloBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAnioModeloBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(radioAnioModeloBuscar);
        radioAnioModeloBuscar.setBounds(310, 70, 100, 21);

        groupBusquedaModelos.add(radioFabricanteModelo);
        radioFabricanteModelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioFabricanteModelo.setForeground(new java.awt.Color(0, 0, 0));
        radioFabricanteModelo.setText("Fabricante");
        radioFabricanteModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFabricanteModeloActionPerformed(evt);
            }
        });
        jPanel3.add(radioFabricanteModelo);
        radioFabricanteModelo.setBounds(440, 70, 100, 21);

        comboNumeroCilindrosBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboNumeroCilindrosBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboNumeroCilindrosBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboNumeroCilindrosBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumeroCilindrosBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(comboNumeroCilindrosBuscar);
        comboNumeroCilindrosBuscar.setBounds(590, 100, 130, 26);

        groupBusquedaModelos.add(radioPais);
        radioPais.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioPais.setForeground(new java.awt.Color(0, 0, 0));
        radioPais.setText("País Fabricación");
        radioPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPaisActionPerformed(evt);
            }
        });
        jPanel3.add(radioPais);
        radioPais.setBounds(450, 150, 111, 20);

        groupBusquedaModelos.add(radioNumeroPuertas);
        radioNumeroPuertas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioNumeroPuertas.setForeground(new java.awt.Color(0, 0, 0));
        radioNumeroPuertas.setText("Número Puertas");
        radioNumeroPuertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumeroPuertasActionPerformed(evt);
            }
        });
        jPanel3.add(radioNumeroPuertas);
        radioNumeroPuertas.setBounds(20, 150, 130, 20);

        groupBusquedaModelos.add(radioPeso);
        radioPeso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioPeso.setForeground(new java.awt.Color(0, 0, 0));
        radioPeso.setText("Peso (KG)");
        radioPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPesoActionPerformed(evt);
            }
        });
        jPanel3.add(radioPeso);
        radioPeso.setBounds(170, 150, 130, 20);

        groupBusquedaModelos.add(radioPasajeros);
        radioPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioPasajeros.setForeground(new java.awt.Color(0, 0, 0));
        radioPasajeros.setText("Capacidad Pasajeros");
        radioPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPasajerosActionPerformed(evt);
            }
        });
        jPanel3.add(radioPasajeros);
        radioPasajeros.setBounds(300, 150, 140, 20);

        groupBusquedaModelos.add(radioTodosModelos);
        radioTodosModelos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioTodosModelos.setForeground(new java.awt.Color(0, 0, 0));
        radioTodosModelos.setSelected(true);
        radioTodosModelos.setText("Mostrar todos los Modelos");
        radioTodosModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosModelosActionPerformed(evt);
            }
        });
        jPanel3.add(radioTodosModelos);
        radioTodosModelos.setBounds(570, 150, 180, 20);

        cajaFabricanteModeloBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaFabricanteModeloBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaFabricanteModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaFabricanteModeloBusquedaActionPerformed(evt);
            }
        });
        cajaFabricanteModeloBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaFabricanteModeloBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaFabricanteModeloBusqueda);
        cajaFabricanteModeloBusqueda.setBounds(440, 100, 120, 18);

        cajaPaisModeloBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaPaisModeloBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaPaisModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPaisModeloBusquedaActionPerformed(evt);
            }
        });
        cajaPaisModeloBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaPaisModeloBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaPaisModeloBusqueda);
        cajaPaisModeloBusqueda.setBounds(450, 180, 120, 18);

        cajaIDModeloBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaIDModeloBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaIDModeloBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaIDModeloBusquedaActionPerformed(evt);
            }
        });
        cajaIDModeloBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaIDModeloBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaIDModeloBusqueda);
        cajaIDModeloBusqueda.setBounds(30, 100, 120, 18);

        cajaModeloPesoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaModeloPesoBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaModeloPesoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaModeloPesoBusquedaActionPerformed(evt);
            }
        });
        cajaModeloPesoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaModeloPesoBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaModeloPesoBusqueda);
        cajaModeloPesoBusqueda.setBounds(160, 180, 120, 18);

        cajaModeloPasajerosBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaModeloPasajerosBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaModeloPasajerosBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaModeloPasajerosBusquedaActionPerformed(evt);
            }
        });
        cajaModeloPasajerosBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaModeloPasajerosBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaModeloPasajerosBusqueda);
        cajaModeloPasajerosBusqueda.setBounds(310, 180, 120, 18);

        cajaModeloPuertasBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        cajaModeloPuertasBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaModeloPuertasBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaModeloPuertasBusquedaActionPerformed(evt);
            }
        });
        cajaModeloPuertasBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaModeloPuertasBusquedaKeyReleased(evt);
            }
        });
        jPanel3.add(cajaModeloPuertasBusqueda);
        cajaModeloPuertasBusqueda.setBounds(20, 180, 120, 18);

        internalModelos.getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 760, 580);

        jDesktopPane1.add(internalModelos);
        internalModelos.setBounds(0, 0, 770, 610);

        internalVentas.setTitle("Ventas");
        internalVentas.setVisible(false);
        internalVentas.getContentPane().setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jPanel16.setBackground(new java.awt.Color(214, 198, 152));
        jPanel16.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ventas");
        jPanel16.add(jLabel4);
        jLabel4.setBounds(10, 10, 90, 40);

        btnEliminarVentas.setBackground(new java.awt.Color(122, 122, 63));
        btnEliminarVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarVentas.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\eliminar.png")); // NOI18N
        btnEliminarVentas.setText("Eliminar");
        btnEliminarVentas.setEnabled(false);
        btnEliminarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentasActionPerformed(evt);
            }
        });
        jPanel16.add(btnEliminarVentas);
        btnEliminarVentas.setBounds(560, 10, 120, 40);

        btnAgregarVentas.setBackground(new java.awt.Color(122, 122, 63));
        btnAgregarVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarVentas.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnAgregarVentas.setText("Agregar");
        btnAgregarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVentasActionPerformed(evt);
            }
        });
        jPanel16.add(btnAgregarVentas);
        btnAgregarVentas.setBounds(290, 10, 120, 40);

        btnActualizarVentas.setBackground(new java.awt.Color(122, 122, 63));
        btnActualizarVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizarVentas.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnActualizarVentas.setText("Actualizar");
        btnActualizarVentas.setEnabled(false);
        btnActualizarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarVentasActionPerformed(evt);
            }
        });
        jPanel16.add(btnActualizarVentas);
        btnActualizarVentas.setBounds(420, 10, 130, 40);

        jLabel62.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel16.add(jLabel62);
        jLabel62.setBounds(700, 10, 50, 40);

        jPanel4.add(jPanel16);
        jPanel16.setBounds(0, 0, 760, 60);

        groupBusquedaVentas.add(radioIDVentaVentas);
        radioIDVentaVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioIDVentaVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioIDVentaVentas.setText("ID Venta");
        radioIDVentaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIDVentaVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioIDVentaVentas);
        radioIDVentaVentas.setBounds(20, 80, 90, 21);

        groupBusquedaVentas.add(radioTodosVentas);
        radioTodosVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioTodosVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioTodosVentas.setSelected(true);
        radioTodosVentas.setText("Mostrar Todas las Ventas");
        radioTodosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioTodosVentas);
        radioTodosVentas.setBounds(280, 180, 170, 21);

        cajaIDVentasBuscar.setBackground(new java.awt.Color(255, 255, 255));
        cajaIDVentasBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajaIDVentasBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaIDVentasBuscarKeyReleased(evt);
            }
        });
        jPanel4.add(cajaIDVentasBuscar);
        cajaIDVentasBuscar.setBounds(20, 110, 100, 18);

        comboVentasVehiculosBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasVehiculosBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasVehiculosBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasVehiculosBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasVehiculosBuscar);
        comboVentasVehiculosBuscar.setBounds(150, 180, 120, 26);

        groupBusquedaVentas.add(radioMesVentas);
        radioMesVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioMesVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioMesVentas.setText("Mes");
        radioMesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMesVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioMesVentas);
        radioMesVentas.setBounds(160, 80, 90, 21);

        comboVentasMesBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasMesBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasMesBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasMesBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasMesBuscar);
        comboVentasMesBuscar.setBounds(160, 110, 76, 26);

        groupBusquedaVentas.add(radioPrecioVentas);
        radioPrecioVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioPrecioVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioPrecioVentas.setText("Precio Menor A");
        radioPrecioVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPrecioVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioPrecioVentas);
        radioPrecioVentas.setBounds(260, 80, 130, 21);

        comboVentasPrecioBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasPrecioBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasPrecioBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasPrecioBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasPrecioBuscar);
        comboVentasPrecioBuscar.setBounds(260, 110, 120, 26);

        groupBusquedaVentas.add(radioIdClienteVentas);
        radioIdClienteVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioIdClienteVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioIdClienteVentas.setText("ID Cliente");
        radioIdClienteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIdClienteVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioIdClienteVentas);
        radioIdClienteVentas.setBounds(550, 80, 100, 21);

        comboVentasClienteBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasClienteBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasClienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasClienteBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasClienteBuscar);
        comboVentasClienteBuscar.setBounds(550, 110, 120, 26);

        groupBusquedaVentas.add(radioIDEmpleadoVentas);
        radioIDEmpleadoVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioIDEmpleadoVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioIDEmpleadoVentas.setText("ID Empleado");
        radioIDEmpleadoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIDEmpleadoVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioIDEmpleadoVentas);
        radioIDEmpleadoVentas.setBounds(10, 150, 100, 21);

        comboVentasEmpleadoBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasEmpleadoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasEmpleadoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasEmpleadoBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasEmpleadoBuscar);
        comboVentasEmpleadoBuscar.setBounds(10, 180, 120, 26);

        groupBusquedaVentas.add(radioIDVehiculoVentas);
        radioIDVehiculoVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioIDVehiculoVentas.setForeground(new java.awt.Color(0, 0, 0));
        radioIDVehiculoVentas.setText("ID Vehiculo");
        radioIDVehiculoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIDVehiculoVentasActionPerformed(evt);
            }
        });
        jPanel4.add(radioIDVehiculoVentas);
        radioIDVehiculoVentas.setBounds(160, 150, 100, 21);

        tablaVentas.setBackground(new java.awt.Color(214, 198, 152));
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaVentas);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(20, 310, 720, 240);

        groupBusquedaVentas.add(radioVentasPagoBuscar);
        radioVentasPagoBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioVentasPagoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        radioVentasPagoBuscar.setText("Forma de Pago");
        radioVentasPagoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVentasPagoBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(radioVentasPagoBuscar);
        radioVentasPagoBuscar.setBounds(410, 80, 110, 21);

        comboVentasPagoBuscar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasPagoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasPagoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasPagoBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(comboVentasPagoBuscar);
        comboVentasPagoBuscar.setBounds(410, 110, 120, 26);

        internalVentas.getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 760, 580);

        jDesktopPane1.add(internalVentas);
        internalVentas.setBounds(0, 0, 770, 620);

        internalProximamente.setTitle("Proximamente");
        internalProximamente.setVisible(false);
        internalProximamente.getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estamos trabajando en la construcción de esta página");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(60, 50, 640, 80);

        internalProximamente.getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 760, 580);

        jDesktopPane1.add(internalProximamente);
        internalProximamente.setBounds(0, 0, 770, 610);

        internalAgregarAutos.setClosable(true);
        internalAgregarAutos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalAgregarAutos.setTitle("Agregar Vehículo");
        internalAgregarAutos.setMinimumSize(new java.awt.Dimension(480, 550));
        internalAgregarAutos.setPreferredSize(new java.awt.Dimension(480, 550));
        internalAgregarAutos.setVisible(false);
        internalAgregarAutos.getContentPane().setLayout(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(214, 198, 152));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Agregar Vehículo");

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Número de Vehículo");

        cajaNumVehiculoAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaNumVehiculoAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaNumVehiculoAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaNumVehiculoAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Número de Serie");

        cajaNumSerieAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaNumSerieAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaNumSerieAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaNumSerieAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("ID Modelo");

        comboModeloAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboModeloAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboModeloAgregar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha de Fabricación");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Año");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Mes");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Dia");

        comboAnioAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboAnioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        comboAnioAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioAgregarActionPerformed(evt);
            }
        });

        comboMesAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboMesAgregar.setForeground(new java.awt.Color(0, 0, 0));
        comboMesAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesAgregarActionPerformed(evt);
            }
        });

        comboDiaAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboDiaAgregar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Precio");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Kilometraje");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Tipo");

        comboTipoAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboTipoAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboTipoAgregar.setForeground(new java.awt.Color(0, 0, 0));

        btnAgregarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnAgregarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnAgregarAgregar.setText("Agregar");
        btnAgregarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAgregarActionPerformed(evt);
            }
        });

        btnRestaurarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnRestaurarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRestaurarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnRestaurarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\restaurar.png")); // NOI18N
        btnRestaurarAgregar.setText("Restaurar");
        btnRestaurarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarAgregarActionPerformed(evt);
            }
        });

        btnCancelarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnCancelarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnCancelarAgregar.setText("Cancelar");
        btnCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgregarActionPerformed(evt);
            }
        });

        cajaPrecioAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaPrecioAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaPrecioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaPrecioAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cajaKilometrajeAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaKilometrajeAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaKilometrajeAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaKilometrajeAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(83, 83, 83)
                .addComponent(jLabel14)
                .addGap(93, 93, 93)
                .addComponent(jLabel15)
                .addGap(45, 45, 45))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cajaNumVehiculoAgregar)
                            .addComponent(cajaNumSerieAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(comboModeloAgregar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnAgregarAgregar)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRestaurarAgregar)
                                .addGap(35, 35, 35)
                                .addComponent(btnCancelarAgregar)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(comboAnioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboMesAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboDiaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cajaPrecioAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(comboTipoAgregar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaKilometrajeAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cajaNumVehiculoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cajaNumSerieAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboModeloAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAnioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(comboMesAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cajaPrecioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cajaKilometrajeAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(comboTipoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        internalAgregarAutos.getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 480, 520);

        jDesktopPane1.add(internalAgregarAutos);
        internalAgregarAutos.setBounds(200, 30, 490, 550);

        internalModificarAutos.setClosable(true);
        internalModificarAutos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalModificarAutos.setTitle("Modificar Vehículo");
        internalModificarAutos.setMinimumSize(new java.awt.Dimension(480, 550));
        internalModificarAutos.setPreferredSize(new java.awt.Dimension(480, 550));
        internalModificarAutos.setVisible(false);
        internalModificarAutos.getContentPane().setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(214, 198, 152));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Modificar Vehículo");

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Número de Serie");

        cajaNumSerieModificar.setBackground(new java.awt.Color(255, 255, 255));
        cajaNumSerieModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaNumSerieModificar.setForeground(new java.awt.Color(0, 0, 0));
        cajaNumSerieModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("ID Modelo");

        comboModeloModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboModeloModificar.setEditable(true);
        comboModeloModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboModeloModificar.setForeground(new java.awt.Color(0, 0, 0));
        comboModeloModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModeloModificarActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Fecha de Fabricación");

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Año");

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Mes");

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Dia");

        comboAnioModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboAnioModificar.setForeground(new java.awt.Color(0, 0, 0));
        comboAnioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioModificarActionPerformed(evt);
            }
        });

        comboMesModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboMesModificar.setForeground(new java.awt.Color(0, 0, 0));
        comboMesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesModificarActionPerformed(evt);
            }
        });

        comboDiaModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboDiaModificar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Precio");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Kilometraje");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Tipo");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Estado");

        comboTipoModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboTipoModificar.setEditable(true);
        comboTipoModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboTipoModificar.setForeground(new java.awt.Color(0, 0, 0));

        comboEstadoModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboEstadoModificar.setEditable(true);
        comboEstadoModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboEstadoModificar.setForeground(new java.awt.Color(0, 0, 0));

        btnActualizarModificar.setBackground(new java.awt.Color(122, 122, 63));
        btnActualizarModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizarModificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnActualizarModificar.setText("Actualizar");
        btnActualizarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarModificarActionPerformed(evt);
            }
        });

        btnCancelarModificar.setBackground(new java.awt.Color(122, 122, 63));
        btnCancelarModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarModificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnCancelarModificar.setText("Cancelar");
        btnCancelarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModificarActionPerformed(evt);
            }
        });

        comboAnioEntradaModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboAnioEntradaModificar.setForeground(new java.awt.Color(0, 0, 0));
        comboAnioEntradaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioEntradaModificarActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Fecha de Entrada");

        comboMesEntradaModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboMesEntradaModificar.setForeground(new java.awt.Color(0, 0, 0));
        comboMesEntradaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesEntradaModificarActionPerformed(evt);
            }
        });

        comboDiaEntradaModificar.setBackground(new java.awt.Color(214, 198, 152));
        comboDiaEntradaModificar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Dia");

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Mes");

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Año");

        cajaPrecioModificar.setBackground(new java.awt.Color(255, 255, 255));
        cajaPrecioModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaPrecioModificar.setForeground(new java.awt.Color(0, 0, 0));
        cajaPrecioModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cajaKilometrajeModificar.setBackground(new java.awt.Color(255, 255, 255));
        cajaKilometrajeModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cajaKilometrajeModificar.setForeground(new java.awt.Color(0, 0, 0));
        cajaKilometrajeModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(83, 83, 83)
                .addComponent(jLabel28)
                .addGap(87, 87, 87)
                .addComponent(jLabel29)
                .addGap(64, 64, 64))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addGap(308, 308, 308))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaNumSerieModificar)
                                    .addComponent(comboModeloModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTipoModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboEstadoModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaPrecioModificar)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(comboAnioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboMesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboDiaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(comboAnioEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboMesEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboDiaEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cajaKilometrajeModificar, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btnActualizarModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarModificar)
                                .addGap(49, 49, 49)))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35)
                        .addGap(65, 65, 65))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cajaNumSerieModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(comboModeloModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAnioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(comboMesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cajaPrecioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cajaKilometrajeModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAnioEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(comboMesEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiaEntradaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(comboTipoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstadoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        internalModificarAutos.getContentPane().add(jPanel9);
        jPanel9.setBounds(0, 0, 480, 540);

        jDesktopPane1.add(internalModificarAutos);
        internalModificarAutos.setBounds(140, 20, 490, 580);

        internalAgregarModelos.setClosable(true);
        internalAgregarModelos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalAgregarModelos.setTitle("Agregar Modelos");
        internalAgregarModelos.setVisible(false);
        internalAgregarModelos.getContentPane().setLayout(null);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(214, 198, 152));
        jPanel13.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Agregar Modelos");
        jPanel13.add(jLabel38);
        jLabel38.setBounds(20, 20, 140, 20);
        jPanel13.add(jLabel39);
        jLabel39.setBounds(330, 20, 0, 0);

        jLabel40.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel13.add(jLabel40);
        jLabel40.setBounds(370, 0, 60, 60);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(0, 0, 430, 60);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("País Fabricación");
        jPanel12.add(jLabel41);
        jLabel41.setBounds(10, 320, 150, 16);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Nombre Modelo:");
        jPanel12.add(jLabel42);
        jLabel42.setBounds(10, 80, 150, 16);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Año Modelo");
        jPanel12.add(jLabel43);
        jLabel43.setBounds(10, 110, 150, 16);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Fabricante");
        jPanel12.add(jLabel44);
        jLabel44.setBounds(10, 140, 150, 16);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Número Cilindros");
        jPanel12.add(jLabel45);
        jLabel45.setBounds(10, 170, 150, 16);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Número Puertas");
        jPanel12.add(jLabel46);
        jLabel46.setBounds(10, 200, 150, 16);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Peso (KG)");
        jPanel12.add(jLabel47);
        jLabel47.setBounds(10, 230, 150, 16);

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Capacidad Pasajeros");
        jPanel12.add(jLabel48);
        jLabel48.setBounds(10, 260, 150, 16);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Color Base");
        jPanel12.add(jLabel49);
        jLabel49.setBounds(10, 290, 150, 16);

        cajaModelosPaisAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPaisAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPaisAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosPaisAgregar);
        cajaModelosPaisAgregar.setBounds(160, 320, 250, 20);

        cajaModelosNombreAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosNombreAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosNombreAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosNombreAgregar);
        cajaModelosNombreAgregar.setBounds(160, 80, 250, 20);

        cajaModelosFabricanteAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosFabricanteAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosFabricanteAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosFabricanteAgregar);
        cajaModelosFabricanteAgregar.setBounds(160, 140, 250, 20);

        cajaModelosColorAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosColorAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosColorAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosColorAgregar);
        cajaModelosColorAgregar.setBounds(160, 290, 250, 20);

        comboModelosCilindrosAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboModelosCilindrosAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(comboModelosCilindrosAgregar);
        comboModelosCilindrosAgregar.setBounds(160, 170, 250, 26);

        comboModelosAnioAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboModelosAnioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(comboModelosAnioAgregar);
        comboModelosAnioAgregar.setBounds(160, 110, 250, 26);

        btnModelosCancelarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnModelosCancelarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModelosCancelarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnModelosCancelarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnModelosCancelarAgregar.setText("Cancelar");
        btnModelosCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosCancelarAgregarActionPerformed(evt);
            }
        });
        jPanel12.add(btnModelosCancelarAgregar);
        btnModelosCancelarAgregar.setBounds(290, 400, 120, 40);

        btnModelosAgregarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnModelosAgregarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModelosAgregarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnModelosAgregarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnModelosAgregarAgregar.setText("Agregar");
        btnModelosAgregarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosAgregarAgregarActionPerformed(evt);
            }
        });
        jPanel12.add(btnModelosAgregarAgregar);
        btnModelosAgregarAgregar.setBounds(10, 400, 120, 40);

        btnModelosRestaurarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnModelosRestaurarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModelosRestaurarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnModelosRestaurarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\restaurar.png")); // NOI18N
        btnModelosRestaurarAgregar.setText("Restaurar");
        btnModelosRestaurarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosRestaurarAgregarActionPerformed(evt);
            }
        });
        jPanel12.add(btnModelosRestaurarAgregar);
        btnModelosRestaurarAgregar.setBounds(150, 400, 120, 40);

        cajaModelosPasajerosAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPasajerosAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPasajerosAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosPasajerosAgregar);
        cajaModelosPasajerosAgregar.setBounds(160, 260, 250, 20);

        cajaModelosPuertasAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPuertasAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPuertasAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosPuertasAgregar);
        cajaModelosPuertasAgregar.setBounds(160, 200, 250, 20);

        cajaModelosPesoAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPesoAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPesoAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel12.add(cajaModelosPesoAgregar);
        cajaModelosPesoAgregar.setBounds(160, 230, 250, 20);

        internalAgregarModelos.getContentPane().add(jPanel12);
        jPanel12.setBounds(0, 0, 430, 510);

        jDesktopPane1.add(internalAgregarModelos);
        internalAgregarModelos.setBounds(150, 30, 440, 540);

        internalCambiosModelos.setClosable(true);
        internalCambiosModelos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalCambiosModelos.setTitle("Actualizar Modelos");
        internalCambiosModelos.setVisible(false);
        internalCambiosModelos.getContentPane().setLayout(null);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(214, 198, 152));
        jPanel15.setLayout(null);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Actualizar Modelos");
        jPanel15.add(jLabel50);
        jLabel50.setBounds(20, 20, 140, 20);
        jPanel15.add(jLabel51);
        jLabel51.setBounds(330, 20, 0, 0);

        jLabel52.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel15.add(jLabel52);
        jLabel52.setBounds(370, 0, 60, 60);

        jPanel14.add(jPanel15);
        jPanel15.setBounds(0, 0, 430, 60);

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("País Fabricación");
        jPanel14.add(jLabel53);
        jLabel53.setBounds(10, 320, 150, 16);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Nombre Modelo:");
        jPanel14.add(jLabel54);
        jLabel54.setBounds(10, 80, 150, 16);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Año Modelo");
        jPanel14.add(jLabel55);
        jLabel55.setBounds(10, 110, 150, 16);

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Fabricante");
        jPanel14.add(jLabel56);
        jLabel56.setBounds(10, 140, 150, 16);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Número Cilindros");
        jPanel14.add(jLabel57);
        jLabel57.setBounds(10, 170, 150, 16);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Número Puertas");
        jPanel14.add(jLabel58);
        jLabel58.setBounds(10, 200, 150, 16);

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Peso (KG)");
        jPanel14.add(jLabel59);
        jLabel59.setBounds(10, 230, 150, 16);

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Capacidad Pasajeros");
        jPanel14.add(jLabel60);
        jLabel60.setBounds(10, 260, 150, 16);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Color Base");
        jPanel14.add(jLabel61);
        jLabel61.setBounds(10, 290, 150, 16);

        cajaModelosPaisActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPaisActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPaisActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosPaisActualizar);
        cajaModelosPaisActualizar.setBounds(160, 320, 250, 20);

        cajaModelosNombreActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosNombreActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosNombreActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosNombreActualizar);
        cajaModelosNombreActualizar.setBounds(160, 80, 250, 20);

        cajaModelosFabricanteActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosFabricanteActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosFabricanteActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosFabricanteActualizar);
        cajaModelosFabricanteActualizar.setBounds(160, 140, 250, 20);

        cajaModelosColorActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosColorActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosColorActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosColorActualizar);
        cajaModelosColorActualizar.setBounds(160, 290, 250, 20);

        comboModelosCilindrosActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboModelosCilindrosActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(comboModelosCilindrosActualizar);
        comboModelosCilindrosActualizar.setBounds(160, 170, 250, 26);

        comboModelosAnioActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboModelosAnioActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(comboModelosAnioActualizar);
        comboModelosAnioActualizar.setBounds(160, 110, 250, 26);

        btnModelosCancelarActualizar.setBackground(new java.awt.Color(122, 122, 63));
        btnModelosCancelarActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModelosCancelarActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnModelosCancelarActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnModelosCancelarActualizar.setText("Cancelar");
        btnModelosCancelarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosCancelarActualizarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModelosCancelarActualizar);
        btnModelosCancelarActualizar.setBounds(260, 400, 120, 40);

        btnModelosActualizarActualizar.setBackground(new java.awt.Color(122, 122, 63));
        btnModelosActualizarActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModelosActualizarActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnModelosActualizarActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnModelosActualizarActualizar.setText("Actualizar");
        btnModelosActualizarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosActualizarActualizarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModelosActualizarActualizar);
        btnModelosActualizarActualizar.setBounds(50, 400, 120, 40);

        cajaModelosPasajerosActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPasajerosActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPasajerosActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosPasajerosActualizar);
        cajaModelosPasajerosActualizar.setBounds(160, 260, 250, 20);

        cajaModelosPuertasActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPuertasActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPuertasActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosPuertasActualizar);
        cajaModelosPuertasActualizar.setBounds(160, 200, 250, 20);

        cajaModelosPesoActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaModelosPesoActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaModelosPesoActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.add(cajaModelosPesoActualizar);
        cajaModelosPesoActualizar.setBounds(160, 230, 250, 20);

        internalCambiosModelos.getContentPane().add(jPanel14);
        jPanel14.setBounds(0, 0, 430, 510);

        jDesktopPane1.add(internalCambiosModelos);
        internalCambiosModelos.setBounds(150, 30, 440, 540);

        internalAltasVentas.setClosable(true);
        internalAltasVentas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalAltasVentas.setTitle("Altas Ventas");
        internalAltasVentas.setVisible(false);
        internalAltasVentas.getContentPane().setLayout(null);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(null);

        jPanel18.setBackground(new java.awt.Color(214, 198, 152));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Agregar Ventas");

        jLabel64.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel18);
        jPanel18.setBounds(0, 0, 440, 60);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("ID Vehiculo");
        jPanel17.add(jLabel65);
        jLabel65.setBounds(10, 210, 140, 20);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Precio Final                      $");
        jPanel17.add(jLabel66);
        jLabel66.setBounds(10, 90, 140, 20);

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Forma de Pago");
        jPanel17.add(jLabel67);
        jLabel67.setBounds(10, 120, 140, 20);

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("ID Cliente");
        jPanel17.add(jLabel68);
        jLabel68.setBounds(10, 150, 140, 20);

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("ID Empleado");
        jPanel17.add(jLabel69);
        jLabel69.setBounds(10, 180, 140, 20);

        cajaVentasPrecioAgregar.setBackground(new java.awt.Color(255, 255, 255));
        cajaVentasPrecioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cajaVentasPrecioAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel17.add(cajaVentasPrecioAgregar);
        cajaVentasPrecioAgregar.setBounds(170, 90, 170, 20);

        comboVentasvehiculoAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasvehiculoAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(comboVentasvehiculoAgregar);
        comboVentasvehiculoAgregar.setBounds(170, 210, 170, 26);

        comboVentasFormaAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasFormaAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(comboVentasFormaAgregar);
        comboVentasFormaAgregar.setBounds(170, 120, 170, 26);

        comboVentasClienteAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasClienteAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(comboVentasClienteAgregar);
        comboVentasClienteAgregar.setBounds(170, 150, 170, 26);

        comboVentasEmpleadoAgregar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasEmpleadoAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(comboVentasEmpleadoAgregar);
        comboVentasEmpleadoAgregar.setBounds(170, 180, 170, 26);

        btnVentasCancelarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnVentasCancelarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentasCancelarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasCancelarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnVentasCancelarAgregar.setText("Cancelar");
        btnVentasCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasCancelarAgregarActionPerformed(evt);
            }
        });
        jPanel17.add(btnVentasCancelarAgregar);
        btnVentasCancelarAgregar.setBounds(260, 280, 109, 50);

        btnVentasAgregarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnVentasAgregarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentasAgregarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasAgregarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\agregar.png")); // NOI18N
        btnVentasAgregarAgregar.setText("Agregar");
        btnVentasAgregarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasAgregarAgregarActionPerformed(evt);
            }
        });
        jPanel17.add(btnVentasAgregarAgregar);
        btnVentasAgregarAgregar.setBounds(10, 280, 110, 50);

        btnVentasRestaurarAgregar.setBackground(new java.awt.Color(122, 122, 63));
        btnVentasRestaurarAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentasRestaurarAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasRestaurarAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\restaurar.png")); // NOI18N
        btnVentasRestaurarAgregar.setText("Restaurar");
        btnVentasRestaurarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasRestaurarAgregarActionPerformed(evt);
            }
        });
        jPanel17.add(btnVentasRestaurarAgregar);
        btnVentasRestaurarAgregar.setBounds(130, 280, 116, 50);

        internalAltasVentas.getContentPane().add(jPanel17);
        jPanel17.setBounds(0, 0, 380, 350);

        jDesktopPane1.add(internalAltasVentas);
        internalAltasVentas.setBounds(180, 20, 390, 380);

        internalActualizarVentas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalActualizarVentas.setTitle("Actualizar Ventas");
        internalActualizarVentas.setVisible(false);
        internalActualizarVentas.getContentPane().setLayout(null);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(null);

        jPanel20.setBackground(new java.awt.Color(214, 198, 152));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setText("Actualizar Ventas");

        jLabel71.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.add(jPanel20);
        jPanel20.setBounds(0, 0, 440, 60);

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("ID Vehiculo");
        jPanel19.add(jLabel72);
        jLabel72.setBounds(10, 230, 140, 20);

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Dia");
        jPanel19.add(jLabel73);
        jLabel73.setBounds(380, 60, 30, 20);

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Forma de Pago");
        jPanel19.add(jLabel74);
        jLabel74.setBounds(10, 140, 140, 20);

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("ID Cliente");
        jPanel19.add(jLabel75);
        jLabel75.setBounds(10, 170, 140, 20);

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("ID Empleado");
        jPanel19.add(jLabel76);
        jLabel76.setBounds(10, 200, 140, 20);

        cajaVentasPrecioActualizar.setBackground(new java.awt.Color(255, 255, 255));
        cajaVentasPrecioActualizar.setForeground(new java.awt.Color(0, 0, 0));
        cajaVentasPrecioActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel19.add(cajaVentasPrecioActualizar);
        cajaVentasPrecioActualizar.setBounds(170, 110, 170, 20);

        comboVentasvehiculoActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasvehiculoActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(comboVentasvehiculoActualizar);
        comboVentasvehiculoActualizar.setBounds(170, 230, 170, 26);

        comboVentasDiaActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasDiaActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(comboVentasDiaActualizar);
        comboVentasDiaActualizar.setBounds(360, 80, 60, 26);

        comboVentasClienteActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasClienteActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(comboVentasClienteActualizar);
        comboVentasClienteActualizar.setBounds(170, 170, 170, 26);

        comboVentasEmpleadoActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasEmpleadoActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(comboVentasEmpleadoActualizar);
        comboVentasEmpleadoActualizar.setBounds(170, 200, 170, 26);

        btnVentasCancelarActualizar.setBackground(new java.awt.Color(122, 122, 63));
        btnVentasCancelarActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentasCancelarActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasCancelarActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\cancelar.png")); // NOI18N
        btnVentasCancelarActualizar.setText("Cancelar");
        btnVentasCancelarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasCancelarActualizarActionPerformed(evt);
            }
        });
        jPanel19.add(btnVentasCancelarActualizar);
        btnVentasCancelarActualizar.setBounds(240, 280, 109, 50);

        btnVentasActualizarActualizar.setBackground(new java.awt.Color(122, 122, 63));
        btnVentasActualizarActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentasActualizarActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasActualizarActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\actualizar.png")); // NOI18N
        btnVentasActualizarActualizar.setText("Actualizar");
        btnVentasActualizarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActualizarActualizarActionPerformed(evt);
            }
        });
        jPanel19.add(btnVentasActualizarActualizar);
        btnVentasActualizarActualizar.setBounds(40, 280, 120, 50);

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Precio Final                      $");
        jPanel19.add(jLabel77);
        jLabel77.setBounds(10, 110, 140, 20);

        comboVentasFormaActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasFormaActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(comboVentasFormaActualizar);
        comboVentasFormaActualizar.setBounds(170, 140, 170, 26);

        comboVentasAnioActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasAnioActualizar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasAnioActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasAnioActualizarActionPerformed(evt);
            }
        });
        jPanel19.add(comboVentasAnioActualizar);
        comboVentasAnioActualizar.setBounds(150, 80, 80, 26);

        comboVentasMesActualizar.setBackground(new java.awt.Color(214, 198, 152));
        comboVentasMesActualizar.setForeground(new java.awt.Color(0, 0, 0));
        comboVentasMesActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentasMesActualizarActionPerformed(evt);
            }
        });
        jPanel19.add(comboVentasMesActualizar);
        comboVentasMesActualizar.setBounds(230, 80, 130, 26);

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("Fecha de Venta");
        jPanel19.add(jLabel78);
        jLabel78.setBounds(10, 80, 110, 20);

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("Año");
        jPanel19.add(jLabel79);
        jLabel79.setBounds(180, 60, 30, 20);

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Mes");
        jPanel19.add(jLabel80);
        jLabel80.setBounds(280, 60, 30, 20);

        internalActualizarVentas.getContentPane().add(jPanel19);
        jPanel19.setBounds(0, 0, 430, 350);

        jDesktopPane1.add(internalActualizarVentas);
        internalActualizarVentas.setBounds(180, 20, 440, 380);

        internalVehiculosEliminados.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalVehiculosEliminados.setTitle("Historial de Vehiculos");
        internalVehiculosEliminados.setVisible(false);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(null);

        jPanel23.setBackground(new java.awt.Color(214, 198, 152));
        jPanel23.setLayout(null);

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Vehiculos Eliminados");
        jPanel23.add(jLabel83);
        jLabel83.setBounds(10, 10, 140, 30);

        jLabel84.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel23.add(jLabel84);
        jLabel84.setBounds(360, 0, 50, 50);

        jPanel22.add(jPanel23);
        jPanel23.setBounds(0, 0, 410, 50);

        tablaVehiculosEliminados.setBackground(new java.awt.Color(247, 227, 178));
        tablaVehiculosEliminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaVehiculosEliminados);

        jPanel22.add(jScrollPane4);
        jScrollPane4.setBounds(10, 60, 390, 220);

        btnVehiculosEliminadosCerrar.setBackground(new java.awt.Color(122, 122, 63));
        btnVehiculosEliminadosCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVehiculosEliminadosCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnVehiculosEliminadosCerrar.setText("Cerrar Ventana");
        btnVehiculosEliminadosCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculosEliminadosCerrarActionPerformed(evt);
            }
        });
        jPanel22.add(btnVehiculosEliminadosCerrar);
        btnVehiculosEliminadosCerrar.setBounds(130, 310, 140, 50);

        javax.swing.GroupLayout internalVehiculosEliminadosLayout = new javax.swing.GroupLayout(internalVehiculosEliminados.getContentPane());
        internalVehiculosEliminados.getContentPane().setLayout(internalVehiculosEliminadosLayout);
        internalVehiculosEliminadosLayout.setHorizontalGroup(
            internalVehiculosEliminadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        internalVehiculosEliminadosLayout.setVerticalGroup(
            internalVehiculosEliminadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jDesktopPane1.add(internalVehiculosEliminados);
        internalVehiculosEliminados.setBounds(120, 40, 420, 440);

        internalHistorialPrecios.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalHistorialPrecios.setTitle("Historial de Precios");
        internalHistorialPrecios.setVisible(false);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(null);

        jPanel25.setBackground(new java.awt.Color(214, 198, 152));
        jPanel25.setLayout(null);

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setText("Historial de Precios");
        jPanel25.add(jLabel85);
        jLabel85.setBounds(10, 10, 140, 30);

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel25.add(jLabel86);
        jLabel86.setBounds(360, 0, 50, 50);

        jPanel24.add(jPanel25);
        jPanel25.setBounds(0, 0, 410, 50);

        tablaHistorialPrecios.setBackground(new java.awt.Color(247, 227, 178));
        tablaHistorialPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaHistorialPrecios);

        jPanel24.add(jScrollPane5);
        jScrollPane5.setBounds(10, 60, 390, 220);

        btnHistorialPreciosCerrar.setBackground(new java.awt.Color(122, 122, 63));
        btnHistorialPreciosCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorialPreciosCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorialPreciosCerrar.setText("Cerrar Ventana");
        btnHistorialPreciosCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialPreciosCerrarActionPerformed(evt);
            }
        });
        jPanel24.add(btnHistorialPreciosCerrar);
        btnHistorialPreciosCerrar.setBounds(130, 310, 140, 50);

        javax.swing.GroupLayout internalHistorialPreciosLayout = new javax.swing.GroupLayout(internalHistorialPrecios.getContentPane());
        internalHistorialPrecios.getContentPane().setLayout(internalHistorialPreciosLayout);
        internalHistorialPreciosLayout.setHorizontalGroup(
            internalHistorialPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        internalHistorialPreciosLayout.setVerticalGroup(
            internalHistorialPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jDesktopPane1.add(internalHistorialPrecios);
        internalHistorialPrecios.setBounds(120, 40, 420, 440);

        internalHomeVista.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        internalHomeVista.setTitle("Vista Vehiculos-Modelo");
        internalHomeVista.setVisible(false);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(null);

        jPanel28.setBackground(new java.awt.Color(214, 198, 152));
        jPanel28.setLayout(null);

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setText("Vista Vehículos-Modelo");
        jPanel28.add(jLabel87);
        jLabel87.setBounds(10, 10, 170, 30);

        jLabel88.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\ITSJ\\5. Quinto Semestre\\Taller de bases de datos\\Proyecto final\\Proyecto_Final_TBD_Escritorio\\src\\main\\java\\img\\logo_oscuro.png")); // NOI18N
        jPanel28.add(jLabel88);
        jLabel88.setBounds(360, 0, 50, 50);

        jPanel27.add(jPanel28);
        jPanel28.setBounds(0, 0, 410, 50);

        tablaVista.setBackground(new java.awt.Color(247, 227, 178));
        tablaVista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaVista);

        jPanel27.add(jScrollPane6);
        jScrollPane6.setBounds(10, 60, 390, 220);

        btnVistaCerrar.setBackground(new java.awt.Color(122, 122, 63));
        btnVistaCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVistaCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnVistaCerrar.setText("Cerrar Ventana");
        btnVistaCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaCerrarActionPerformed(evt);
            }
        });
        jPanel27.add(btnVistaCerrar);
        btnVistaCerrar.setBounds(130, 310, 140, 50);

        javax.swing.GroupLayout internalHomeVistaLayout = new javax.swing.GroupLayout(internalHomeVista.getContentPane());
        internalHomeVista.getContentPane().setLayout(internalHomeVistaLayout);
        internalHomeVistaLayout.setHorizontalGroup(
            internalHomeVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        internalHomeVistaLayout.setVerticalGroup(
            internalHomeVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jDesktopPane1.add(internalHomeVista);
        internalHomeVista.setBounds(120, 40, 420, 440);

        bg.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 770, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

                CONTROLADOR_JDBC,
                URL,
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

        final String CONTROLADOR_JDBC = "org.postgresql.Driver";
        final String URL = "jdbc:postgresql://localhost:5432/autos_amistosos";
        final String CONSULTA = "SELECT * FROM " + tablaBaseDatos + ";";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(
                CONTROLADOR_JDBC,
                URL,
                CONSULTA
            );

            tabla.setModel(modelo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
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
                CONTROLADOR_JDBC,
                URL,
                CONSULTA
            );

            tabla.setModel(modelo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }

    

    
    private void ocultarInternal(JInternalFrame internalVisible, JInternalFrame... internals){
        
        for(JInternalFrame i : internals){
            
            i.setVisible(false);
            
        }
        
        internalVisible.setVisible(true);
        
    }
    
    private void cambiarColorBoton(JButton... btnMenu){
        
        for(JButton i : btnMenu){
            
            i.setBackground(new java.awt.Color(227,211,163));
            
        }
        
    }
    
    private void desabilitarComponenetes(JComponent componente_activo, JComponent... componente){
        
        for(JComponent c : componente){
            
            c.setEnabled(false);
            
        }
        
        componente_activo.setEnabled(true);
        
    }
    
    private void asignarFechas(JComboBox comboAnio, JComboBox comboMes){
        
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
    
    // ============================================== VENTANA VEHICULOS ================================================================
    
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new VentanaLogin();

            }
        });
        
        setVisible(false);
        
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        
        // Cambio de Colores de Botones
        
        cambiarColorBoton(btnCerrarSesion, btnVehiculos, btnModelos, btnVentas, btnEmpleados, btnClientes, btnDocumentacion);
        
        btnHome.setBackground(new java.awt.Color(214,198,152));
        
        // Abrir Frame
        
        ocultarInternal(internalHome, internalVehiculos, internalModelos); 
       
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculosActionPerformed

        actualizarTabla(tablaVehiculos, "vehiculos");
        
        actualizarTabla(tablaModelos, "modelos");
        
        actualizarTabla(tablaVentas, "ventas");
        
        //restablecer(caja);
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnModelos, btnVentas, btnEmpleados, btnClientes, btnDocumentacion);
        
        btnVehiculos.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalVehiculos, internalHome, internalModelos);
        
    }//GEN-LAST:event_btnVehiculosActionPerformed

    private void btnModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosActionPerformed

        actualizarTabla(tablaVehiculos, "vehiculos");
        
        actualizarTabla(tablaModelos, "modelos");
        
        actualizarTabla(tablaVentas, "ventas");
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnVehiculos, btnVentas, btnEmpleados, btnClientes, btnDocumentacion);
        
        btnModelos.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalModelos, internalHome, internalVehiculos);
        
    }//GEN-LAST:event_btnModelosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

        actualizarTabla(tablaVehiculos, "vehiculos");
        
        actualizarTabla(tablaModelos, "modelos");
        
        actualizarTabla(tablaVentas, "ventas");
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnModelos, btnVehiculos, btnEmpleados, btnClientes, btnDocumentacion);
        
        btnVentas.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalVentas, internalHome, internalModelos, internalVehiculos);
        
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnModelos, btnVentas, btnVehiculos, btnClientes, btnDocumentacion);
        
        btnEmpleados.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalProximamente, internalHome, internalModelos, internalVehiculos, internalVentas);
        
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnModelos, btnVentas, btnEmpleados, btnVehiculos, btnDocumentacion);
        
        btnClientes.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalProximamente, internalHome, internalModelos, internalVehiculos, internalVentas);
        
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnDocumentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentacionActionPerformed
        
        cambiarColorBoton(btnCerrarSesion, btnHome, btnModelos, btnVentas, btnEmpleados, btnClientes, btnVehiculos);
        
        btnDocumentacion.setBackground(new java.awt.Color(214,198,152));
        
        ocultarInternal(internalProximamente, internalHome, internalModelos, internalVehiculos, internalVentas);
        
    }//GEN-LAST:event_btnDocumentacionActionPerformed

    private void cajaNumVehiculoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNumVehiculoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNumVehiculoBuscarActionPerformed

    private void cajaNumSerieBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNumSerieBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNumSerieBuscarActionPerformed

    private void radioModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioModeloBusquedaActionPerformed
      
        desabilitarComponenetes(comboModeloBusqueda, cajaNumSerieBuscar, cajaNumVehiculoBuscar,  
                comboAnioBusqueda1, comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);    
        
    }//GEN-LAST:event_radioModeloBusquedaActionPerformed

    private void radioNumSerieBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumSerieBusquedaActionPerformed
       
        desabilitarComponenetes(cajaNumSerieBuscar, cajaNumVehiculoBuscar, 
                comboModeloBusqueda, comboAnioBusqueda1, comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);
        
    }//GEN-LAST:event_radioNumSerieBusquedaActionPerformed

    private void radioTodosBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosBusquedaActionPerformed
        
        desabilitarComponenetes(radioTodosBusqueda, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboAnioBusqueda1, comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);
        
        
        actualizarTabla(tablaVehiculos, "vehiculos");
        
    }//GEN-LAST:event_radioTodosBusquedaActionPerformed

    private void radioNumVehiculoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumVehiculoBusquedaActionPerformed
      
        
        desabilitarComponenetes(cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboAnioBusqueda1, comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);
        
        
    }//GEN-LAST:event_radioNumVehiculoBusquedaActionPerformed

    private void radioAnioBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAnioBusqueda1ActionPerformed
        
        desabilitarComponenetes(comboAnioBusqueda1, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboPrecioBusqueda1, comboTipoBusqueda, comboEstadoBusqueda);
        
    }//GEN-LAST:event_radioAnioBusqueda1ActionPerformed

    private void radioPrecioBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPrecioBusqueda1ActionPerformed
       
        desabilitarComponenetes(comboPrecioBusqueda1,comboAnioBusqueda1, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboTipoBusqueda, comboEstadoBusqueda);
        
    }//GEN-LAST:event_radioPrecioBusqueda1ActionPerformed

    private void radioTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipoBusquedaActionPerformed
        
        desabilitarComponenetes(comboTipoBusqueda, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboAnioBusqueda1, comboPrecioBusqueda1, comboEstadoBusqueda);
        
    }//GEN-LAST:event_radioTipoBusquedaActionPerformed

    private void radioEstadoBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEstadoBusqueda1ActionPerformed
        
        desabilitarComponenetes(comboEstadoBusqueda, comboTipoBusqueda, cajaNumVehiculoBuscar, cajaNumSerieBuscar, comboModeloBusqueda, 
                comboAnioBusqueda1, comboPrecioBusqueda1);
        
    }//GEN-LAST:event_radioEstadoBusqueda1ActionPerformed

    private void btnAgregarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAgregarActionPerformed

        String mes, dia;
        
        if(String.valueOf(comboMesAgregar.getSelectedIndex()+1).length() == 1){
           
            mes = "0"+String.valueOf(comboMesAgregar.getSelectedIndex()+1);
            
        }else{
            
            mes = String.valueOf(comboMesAgregar.getSelectedIndex()+1);
            
        }
        
        if(comboDiaAgregar.getSelectedItem().toString().length() == 1){
            
            dia = "0" + comboDiaAgregar.getSelectedItem().toString();
            
        }else{
            
            dia = comboDiaAgregar.getSelectedItem().toString();
            
        }
        
        String fechaFabricacion = comboAnioAgregar.getSelectedItem().toString() + "-" + mes + "-" + dia;
        

        
        Vehiculo vehiculo = new Vehiculo(
        
            cajaNumVehiculoAgregar.getText().toString().toUpperCase(),
            cajaNumSerieAgregar.getText().toString().toUpperCase(),
            Integer.parseInt(comboModeloAgregar.getSelectedItem().toString()),
            LocalDate.parse(fechaFabricacion),
            Double.parseDouble(cajaPrecioAgregar.getText()),
            Integer.parseInt(cajaKilometrajeAgregar.getText()),
            hoy,
            comboTipoAgregar.getSelectedItem().toString(),
            "Disponible"
         
        );
        
        if(vehiculoDAO.agregarVehiculo(vehiculo)){
            
            actualizarTabla(tablaVehiculos, "vehiculos");
            
            JOptionPane.showMessageDialog(this, "Registro agregado correctamente");
            
        }else{

            JOptionPane.showMessageDialog(this, "Error en la Insercción");

            con.mostrarError(this);
            
        }
        
    }//GEN-LAST:event_btnAgregarAgregarActionPerformed

    private void btnRestaurarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarAgregarActionPerformed
        
        restablecer(cajaNumVehiculoAgregar, cajaNumSerieAgregar, comboModeloAgregar, comboAnioAgregar, comboMesAgregar, comboDiaAgregar, cajaPrecioAgregar, cajaKilometrajeAgregar, comboTipoAgregar);
                
    }//GEN-LAST:event_btnRestaurarAgregarActionPerformed

    private void btnCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgregarActionPerformed
       
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de cancelar la agregación? Se perderan los cambios hechos");
         
        if(respuesta == JOptionPane.YES_OPTION){
            
            restablecer(cajaNumVehiculoAgregar, cajaNumSerieAgregar, comboModeloAgregar, comboAnioAgregar, comboMesAgregar, comboDiaAgregar, cajaPrecioAgregar, cajaKilometrajeAgregar, comboTipoAgregar);
            
            internalAgregarAutos.setVisible(false);
            
        }
        
        
    }//GEN-LAST:event_btnCancelarAgregarActionPerformed

    private void btnAgregarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculosActionPerformed
        
        internalAgregarAutos.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarVehiculosActionPerformed

    private void btnActualizarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarModificarActionPerformed
        
        String mes, dia, mes2, dia2;
        
        if(String.valueOf(comboMesModificar.getSelectedIndex()+1).length() == 1){
           
            mes = "0"+String.valueOf(comboMesModificar.getSelectedIndex()+1);
            
        }else{
            
            mes = String.valueOf(comboMesModificar.getSelectedIndex()+1);
            
        }
        
        if(comboDiaModificar.getSelectedItem().toString().length() == 1){
            
            dia = "0" + comboDiaModificar.getSelectedItem().toString();
            
        }else{
            
            dia = comboDiaModificar.getSelectedItem().toString();
            
        }
        
        //============================================================================================================
        
        if(String.valueOf(comboMesEntradaModificar.getSelectedIndex()+1).length() == 1){
           
            mes2 = "0"+String.valueOf(comboMesEntradaModificar.getSelectedIndex()+1);
            
        }else{
            
            mes2 = String.valueOf(comboMesEntradaModificar.getSelectedIndex()+1);
            
        }
        
        if(comboDiaEntradaModificar.getSelectedItem().toString().length() == 1){
            
            dia2 = "0" + comboDiaEntradaModificar.getSelectedItem().toString();
            
        }else{
            
            dia2 = comboDiaEntradaModificar.getSelectedItem().toString();
            
        }
        
        
        String fechaFabricacion = comboAnioModificar.getSelectedItem().toString() + "-" + mes + "-" + dia;
        
        String fechaEntrada = comboAnioEntradaModificar.getSelectedItem().toString() + "-" + mes2 + "-" +  dia2;
        
        Vehiculo vehiculo = new Vehiculo(
        
            tablaVehiculos.getValueAt(0, 0).toString(),    
            cajaNumSerieModificar.getText().toString().toUpperCase(),
            Integer.parseInt(comboModeloModificar.getSelectedItem().toString()),
            LocalDate.parse(fechaFabricacion),
            Double.parseDouble(cajaPrecioModificar.getText()),
            Integer.parseInt(cajaKilometrajeModificar.getText()),
            LocalDate.parse(fechaEntrada),
            comboTipoModificar.getSelectedItem().toString(),
            comboEstadoModificar.getSelectedItem().toString()
         
        );
        
        if(vehiculoDAO.editarVehiculo(vehiculo)){
            
            actualizarTabla(tablaVehiculos, "vehiculos");
            
            JOptionPane.showMessageDialog(this, "Se guardaron los cambios");
            
            btnModificarVehiculos.setEnabled(false);
            btnEliminarVehiculos.setEnabled(false);
            
        }else{
           
            
            con.mostrarError(this);
            
        }
        
    }//GEN-LAST:event_btnActualizarModificarActionPerformed

    private void btnCancelarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarModificarActionPerformed

    private void comboModeloModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModeloModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModeloModificarActionPerformed

    private void comboAnioAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioAgregarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboAnioAgregar.getSelectedItem().toString()), comboMesAgregar.getSelectedIndex(), comboDiaAgregar);
        
        //JOptionPane.showMessageDialog(this, comboAnioAgregar.getSelectedIndex());
        
    }//GEN-LAST:event_comboAnioAgregarActionPerformed

    private void comboMesAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesAgregarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboAnioAgregar.getSelectedItem().toString()), comboMesAgregar.getSelectedIndex(), comboDiaAgregar);
        
        //JOptionPane.showMessageDialog(this, comboMesAgregar.getSelectedIndex());
        
    }//GEN-LAST:event_comboMesAgregarActionPerformed

    private void cajaNumVehiculoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNumVehiculoBuscarKeyReleased

        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "id_vehiculo",
            cajaNumVehiculoBuscar.getText().toUpperCase(),
            'T'
        );
        
        if(tablaVehiculos.getRowCount() == 1 && radioNumVehiculoBusqueda.isSelected()){
            
            btnEliminarVehiculos.setEnabled(true);
            
            btnModificarVehiculos.setEnabled(true);
            
            //JOptionPane.showMessageDialog(this, tablaVehiculos.getValueAt(0, 0));
            
        }else{
            
            btnEliminarVehiculos.setEnabled(false);
            
            btnModificarVehiculos.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_cajaNumVehiculoBuscarKeyReleased

    private void cajaNumSerieBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNumSerieBuscarKeyReleased
       
        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "numero_serie",
            cajaNumSerieBuscar.getText().toUpperCase(),
            'T'
        );
        
    }//GEN-LAST:event_cajaNumSerieBuscarKeyReleased

    private void comboTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoBusquedaActionPerformed
        
        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "tipo",
            comboTipoBusqueda.getSelectedItem().toString(),
            'T'
        );
       
    }//GEN-LAST:event_comboTipoBusquedaActionPerformed

    private void comboEstadoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoBusquedaActionPerformed
       
        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "estado",
            comboEstadoBusqueda.getSelectedItem().toString(),
            'T'
        );
        
    }//GEN-LAST:event_comboEstadoBusquedaActionPerformed

    private void btnModificarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVehiculosActionPerformed
        
        internalModificarAutos.setVisible(true);
        
        String sql = "SELECT * FROM vehiculos WHERE id_vehiculo = ?;";
        
        rs = con.ejecutarInstruccionSQL(sql, tablaVehiculos.getValueAt(0, 0).toString());
        
        try {
            
            rs.next();
            
            cajaNumSerieModificar.setText(rs.getString(2));
            
            comboModeloModificar.setSelectedItem(rs.getString(3));
            
            String fechaFabricacion = rs.getString(4);
            
            String[] fechaSeparada = fechaFabricacion.split("-");
            
            comboAnioModificar.setSelectedItem(fechaSeparada[0]);
            
            comboMesModificar.setSelectedIndex(Integer.parseInt(fechaSeparada[1])-1);
            
            comboDiaModificar.setSelectedIndex(Integer.parseInt(fechaSeparada[2])-1);
            
            cajaPrecioModificar.setText(rs.getString(5));
            
            cajaKilometrajeModificar.setText(rs.getString(6));
           
            
            String fechaIngreso = rs.getString(7);
            
            String[] fechaEntradaSeparada = fechaIngreso.split("-");
            
            comboAnioEntradaModificar.setSelectedItem(fechaEntradaSeparada[0]);
            
            comboMesEntradaModificar.setSelectedIndex(Integer.parseInt(fechaEntradaSeparada[1])-1);
            
            comboDiaEntradaModificar.setSelectedIndex(Integer.parseInt(fechaEntradaSeparada[2])-1);
            
            comboTipoModificar.setSelectedItem(rs.getString(8));
            
            comboEstadoModificar.setSelectedItem(rs.getString(9));
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnModificarVehiculosActionPerformed

    private void btnEliminarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculosActionPerformed
        
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el registro?");
         
        if(respuesta == JOptionPane.YES_OPTION){
             
            if(vehiculoDAO.eliminarVehiculo(tablaVehiculos.getValueAt(0, 0).toString())){
                 
               actualizarTabla(tablaVehiculos, "vehiculos");
                 
               JOptionPane.showMessageDialog(this, "Registro eliminado con exito");
               
               btnModificarVehiculos.setEnabled(false);
               
               btnEliminarVehiculos.setEnabled(false);
                
            }else{
                 
                con.mostrarError(internalVehiculos);
                 
            }
             
        }
        
    }//GEN-LAST:event_btnEliminarVehiculosActionPerformed

    private void comboModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModeloBusquedaActionPerformed
        
       
        
        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "id_modelo",
            comboModeloBusqueda.getSelectedItem().toString(),
            'N'
        );
        
       
        
    }//GEN-LAST:event_comboModeloBusquedaActionPerformed

    private void comboPrecioBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPrecioBusqueda1ActionPerformed

        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "precio",
            comboPrecioBusqueda1.getSelectedItem().toString(),
            'O'
        );        
        
    }//GEN-LAST:event_comboPrecioBusqueda1ActionPerformed

    private void comboAnioBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioBusqueda1ActionPerformed
       
        actualizarTablaConFiltro(
            tablaVehiculos,
            "vehiculos",
            "fecha_fabricacion",
            comboAnioBusqueda1.getSelectedItem().toString(),
            'A'
        );   

    }//GEN-LAST:event_comboAnioBusqueda1ActionPerformed

    private void comboAnioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioModificarActionPerformed
       
        anioBisiesto(Integer.parseInt(comboAnioModificar.getSelectedItem().toString()), comboMesModificar.getSelectedIndex(), comboDiaModificar);
        
    }//GEN-LAST:event_comboAnioModificarActionPerformed

    private void comboMesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesModificarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboAnioModificar.getSelectedItem().toString()), comboMesModificar.getSelectedIndex(), comboDiaModificar);
        
    }//GEN-LAST:event_comboMesModificarActionPerformed

    private void comboAnioEntradaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioEntradaModificarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboAnioEntradaModificar.getSelectedItem().toString()), comboMesEntradaModificar.getSelectedIndex(), comboDiaEntradaModificar);
        
    }//GEN-LAST:event_comboAnioEntradaModificarActionPerformed

    private void comboMesEntradaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesEntradaModificarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboAnioEntradaModificar.getSelectedItem().toString()), comboMesEntradaModificar.getSelectedIndex(), comboDiaEntradaModificar);
    }//GEN-LAST:event_comboMesEntradaModificarActionPerformed

    
    
    
    //============================================== Modelos ============================================================
    
    
    private void btnEliminarModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarModelosActionPerformed
        
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el registro?");
         
        if(respuesta == JOptionPane.YES_OPTION){
             
            if(modeloDAO.eliminarModelo(Integer.parseInt(tablaModelos.getValueAt(0, 0).toString()))){
                 
               actualizarTabla(tablaModelos, "modelos");
                 
               JOptionPane.showMessageDialog(this, "Registro eliminado con exito");
               
               btnEliminarModelos.setEnabled(false);
               
               btnActualizarModelos.setEnabled(false);
                
            }else{
                 
                con.mostrarError(this);
                 
            }
             
        }
        
    }//GEN-LAST:event_btnEliminarModelosActionPerformed

    private void btnAgregarModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarModelosActionPerformed
        
        internalAgregarModelos.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarModelosActionPerformed

    private void btnActualizarModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarModelosActionPerformed
        internalCambiosModelos.setVisible(true);
        
        String sql = "SELECT * FROM modelos WHERE id_modelo = ?;";
        
        rs = con.ejecutarInstruccionSQL(sql, tablaModelos.getValueAt(0, 0));
       

        try {
            
            rs.next();
            
            cajaModelosNombreActualizar.setText(rs.getString(2));
            
            comboModelosAnioActualizar.setSelectedItem(rs.getString(3));
            
            cajaModelosFabricanteActualizar.setText(rs.getString(4));
            
            comboModelosCilindrosActualizar.setSelectedItem(rs.getString(5));
            
            cajaModelosPuertasActualizar.setText(rs.getString(6));
            
            cajaModelosPesoActualizar.setText(String.valueOf(rs.getDouble(7)));
            
            cajaModelosPasajerosActualizar.setText(rs.getString(8));
            
            cajaModelosColorActualizar.setText(rs.getString(9));
            
            cajaModelosPaisActualizar.setText(rs.getString(10));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
            
            System.out.println(e);
            
        }
     
    }//GEN-LAST:event_btnActualizarModelosActionPerformed

    private void radioNumeroCilindrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumeroCilindrosActionPerformed

        desabilitarComponenetes(comboNumeroCilindrosBuscar, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda,
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioNumeroCilindrosActionPerformed

    private void radioNombreModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNombreModeloActionPerformed
        
        desabilitarComponenetes( cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);

        
    }//GEN-LAST:event_radioNombreModeloActionPerformed

    private void radioAnioModeloBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAnioModeloBuscarActionPerformed


        desabilitarComponenetes(comboAnioModeloBuscar, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioAnioModeloBuscarActionPerformed

    private void radioFabricanteModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFabricanteModeloActionPerformed

        desabilitarComponenetes(cajaFabricanteModeloBusqueda, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar , comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFabricanteModeloActionPerformed

    private void radioPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPaisActionPerformed
        desabilitarComponenetes(cajaPaisModeloBusqueda, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioPaisActionPerformed

    private void radioNumeroPuertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumeroPuertasActionPerformed
        desabilitarComponenetes(cajaModeloPuertasBusqueda, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioNumeroPuertasActionPerformed

    private void radioPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPesoActionPerformed
        desabilitarComponenetes(cajaModeloPesoBusqueda, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioPesoActionPerformed

    private void radioPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPasajerosActionPerformed
        desabilitarComponenetes(cajaModeloPasajerosBusqueda, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioPasajerosActionPerformed

    private void radioTodosModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosModelosActionPerformed

        actualizarTabla(tablaModelos, "modelos");

        desabilitarComponenetes(radioTodosModelos, cajaNombreModeloBusqueda, cajaIDModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
               cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda, btnActualizarModelos, btnEliminarModelos);
        
    }//GEN-LAST:event_radioTodosModelosActionPerformed

    private void radioidModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioidModeloBusquedaActionPerformed
       
        desabilitarComponenetes(cajaIDModeloBusqueda, cajaNombreModeloBusqueda, comboAnioModeloBuscar, cajaFabricanteModeloBusqueda, comboNumeroCilindrosBuscar, 
                cajaModeloPuertasBusqueda, cajaModeloPesoBusqueda, cajaModeloPasajerosBusqueda, cajaPaisModeloBusqueda);
        
        if(tablaModelos.getRowCount() == 1){
            
            btnActualizarModelos.setEnabled(true);
                
            btnEliminarModelos.setEnabled(true);

        }
        

    }//GEN-LAST:event_radioidModeloBusquedaActionPerformed

    private void cajaFabricanteModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaFabricanteModeloBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaFabricanteModeloBusquedaActionPerformed

    private void cajaPaisModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPaisModeloBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPaisModeloBusquedaActionPerformed

    private void cajaIDModeloBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaIDModeloBusquedaActionPerformed
        
   
        
    }//GEN-LAST:event_cajaIDModeloBusquedaActionPerformed

    private void cajaIDModeloBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaIDModeloBusquedaKeyReleased
        
        if(cajaIDModeloBusqueda.getText().length() == 0){
            
            actualizarTabla(tablaModelos, "modelos");
            
            //JOptionPane.showMessageDialog(this, "Hola");
            
        }else{
            
            actualizarTablaConFiltro(
                tablaModelos,
                "modelos",
                "id_modelo",
                cajaIDModeloBusqueda.getText(),
                'N'
            );          
            
        }
        
        if(radioidModeloBusqueda.isSelected() && tablaModelos.getRowCount() == 1){
            
            btnActualizarModelos.setEnabled(true);
            
            btnEliminarModelos.setEnabled(true);
            
        }else{
            
            btnActualizarModelos.setEnabled(false);
            
            btnEliminarModelos.setEnabled(false);
            
        }

    }//GEN-LAST:event_cajaIDModeloBusquedaKeyReleased

    private void cajaNombreModeloBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreModeloBusquedaKeyReleased
        
        actualizarTablaConFiltro(
            tablaModelos,
            "modelos",
            "nombre_modelo",
            cajaNombreModeloBusqueda.getText().toUpperCase(),
            'T'
        );          
                    
        
    }//GEN-LAST:event_cajaNombreModeloBusquedaKeyReleased

    private void comboAnioModeloBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioModeloBuscarActionPerformed
      
        actualizarTablaConFiltro(
            tablaModelos,
            "modelos",
            "año_modelo",
            comboAnioModeloBuscar.getSelectedItem().toString(),
            'N'
        ); 
        
    }//GEN-LAST:event_comboAnioModeloBuscarActionPerformed

    private void cajaFabricanteModeloBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaFabricanteModeloBusquedaKeyReleased
        
        actualizarTablaConFiltro(
            tablaModelos,
            "modelos",
            "fabricante",
            cajaFabricanteModeloBusqueda.getText().toLowerCase(),
            'T'
        );       
        
    }//GEN-LAST:event_cajaFabricanteModeloBusquedaKeyReleased

    private void comboNumeroCilindrosBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumeroCilindrosBuscarActionPerformed
        
        actualizarTablaConFiltro(
            tablaModelos,
            "modelos",
            "numero_cilindros",
            comboNumeroCilindrosBuscar.getSelectedItem().toString(),
            'N'
        ); 
        
    }//GEN-LAST:event_comboNumeroCilindrosBuscarActionPerformed

    private void cajaModeloPesoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaModeloPesoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaModeloPesoBusquedaActionPerformed

    private void cajaModeloPasajerosBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaModeloPasajerosBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaModeloPasajerosBusquedaActionPerformed

    private void cajaModeloPuertasBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaModeloPuertasBusquedaActionPerformed
        
    }//GEN-LAST:event_cajaModeloPuertasBusquedaActionPerformed

    private void cajaModeloPuertasBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaModeloPuertasBusquedaKeyReleased
        if(cajaModeloPuertasBusqueda.getText().length() == 0){
             
            actualizarTabla(tablaModelos, "modelos");
             
         }else{
             
            actualizarTablaConFiltro(
                tablaModelos,
                "modelos",
                "numero_puertas",
                cajaModeloPuertasBusqueda.getText().toString(),
                'N'
            ); 
             
        }
        
        
        
    }//GEN-LAST:event_cajaModeloPuertasBusquedaKeyReleased

    private void cajaModeloPesoBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaModeloPesoBusquedaKeyReleased
        
        if(cajaModeloPesoBusqueda.getText().length() == 0){
             
            actualizarTabla(tablaModelos, "modelos");
             
         }else{
             
            actualizarTablaConFiltro(
                tablaModelos,
                "modelos",
                "peso_kg",
                cajaModeloPesoBusqueda.getText().toString(),
                'N'
            ); 
             
        }
        
    }//GEN-LAST:event_cajaModeloPesoBusquedaKeyReleased

    private void cajaModeloPasajerosBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaModeloPasajerosBusquedaKeyReleased
        
        if(cajaModeloPasajerosBusqueda.getText().length() == 0){
             
            actualizarTabla(tablaModelos, "modelos");
             
         }else{
             
            actualizarTablaConFiltro(
                tablaModelos,
                "modelos",
                "capacidad_pasajeros",
                cajaModeloPasajerosBusqueda.getText().toString(),
                'N'
            ); 
             
        }
        
    }//GEN-LAST:event_cajaModeloPasajerosBusquedaKeyReleased

    private void cajaPaisModeloBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPaisModeloBusquedaKeyReleased
        
        
        if(cajaPaisModeloBusqueda.getText().length() == 0){
             
            actualizarTabla(tablaModelos, "modelos");
             
         }else{
             
            actualizarTablaConFiltro(
                tablaModelos,
                "modelos",
                "pais_fabricacion",
                cajaPaisModeloBusqueda.getText().toString(),
                'T'
            ); 
             
        }
        
    }//GEN-LAST:event_cajaPaisModeloBusquedaKeyReleased

    private void btnModelosAgregarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosAgregarAgregarActionPerformed

        
        Modelo modelo = new Modelo(
        
                cajaModelosNombreAgregar.getText().toUpperCase(),
                Short.parseShort(comboModelosAnioAgregar.getSelectedItem().toString()),
                cajaModelosFabricanteAgregar.getText().toUpperCase(),
                Byte.parseByte(comboModelosCilindrosAgregar.getSelectedItem().toString()),
                Byte.parseByte(cajaModelosPuertasAgregar.getText()),
                Double.parseDouble(cajaModelosPesoAgregar.getText()),
                Byte.parseByte(cajaModelosPasajerosAgregar.getText()),
                cajaModelosColorAgregar.getText().toUpperCase(),
                cajaModelosPaisAgregar.getText().toUpperCase()
               
        );
        
        if(modeloDAO.agregarModelo(modelo)){
            
            actualizarTabla(tablaModelos, "modelos");
            
            JOptionPane.showMessageDialog(this, "El modelo se agrego correctamente");
            
            restablecer(cajaModelosNombreAgregar, comboModelosAnioAgregar, cajaModelosFabricanteAgregar, comboModelosCilindrosAgregar, cajaModelosPuertasAgregar, cajaModelosPesoAgregar, cajaModelosPasajerosAgregar, cajaModelosColorAgregar, cajaModelosPaisAgregar);
            
        }else{
            
            JOptionPane.showMessageDialog(this, modeloDAO.mostrarMensaje());
            
            System.out.println(modeloDAO.mostrarMensaje());
            
            
            
        }
        
    }//GEN-LAST:event_btnModelosAgregarAgregarActionPerformed

    private void btnModelosActualizarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosActualizarActualizarActionPerformed
        
        Modelo modelo = new Modelo(
        
            cajaModelosNombreActualizar.getText().toUpperCase(),
            Short.parseShort(comboModelosAnioActualizar.getSelectedItem().toString()),
            cajaModelosFabricanteActualizar.getText().toUpperCase(),
            Byte.parseByte(comboModelosCilindrosActualizar.getSelectedItem().toString()),
            Byte.parseByte(cajaModelosPuertasActualizar.getText()),
            Double.parseDouble(cajaModelosPesoActualizar.getText()),
            Byte.parseByte(cajaModelosPasajerosActualizar.getText()),
            cajaModelosColorActualizar.getText().toUpperCase(),
            cajaModelosPaisActualizar.getText().toUpperCase()
               
        );
        
        if(modeloDAO.actualizarModelo(modelo, Integer.parseInt(tablaModelos.getValueAt(0, 0).toString()))){
            
            actualizarTabla(tablaModelos, "modelos");
            
            JOptionPane.showMessageDialog(this, "El modelo se actualizo correctamente");
            
            btnEliminarModelos.setEnabled(false);
            
            btnActualizarModelos.setEnabled(false);
            
            restablecer(cajaModelosNombreActualizar, comboModelosAnioActualizar, cajaModelosFabricanteActualizar, comboModelosCilindrosActualizar, cajaModelosPuertasActualizar, cajaModelosPesoActualizar, cajaModelosPasajerosActualizar, cajaModelosColorActualizar, cajaModelosPaisActualizar);

            
        }else{
            
            con.mostrarError(this);
            
        }
        
        
    }//GEN-LAST:event_btnModelosActualizarActualizarActionPerformed

    
      //============================================ VENTAS ================================================
    
    private void radioTodosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosVentasActionPerformed
        
        desabilitarComponenetes(radioTodosVentas, comboVentasPagoBuscar, comboVentasMesBuscar, cajaIDVentasBuscar, comboVentasPrecioBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
        
        actualizarTabla(tablaVentas, "ventas");
        
    }//GEN-LAST:event_radioTodosVentasActionPerformed

    private void radioMesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMesVentasActionPerformed
        
         desabilitarComponenetes(comboVentasMesBuscar, comboVentasPagoBuscar, cajaIDVentasBuscar, comboVentasPrecioBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
        
    }//GEN-LAST:event_radioMesVentasActionPerformed

    private void radioPrecioVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPrecioVentasActionPerformed
       
       desabilitarComponenetes(comboVentasPrecioBuscar, comboVentasPagoBuscar, comboVentasMesBuscar, cajaIDVentasBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
        
    }//GEN-LAST:event_radioPrecioVentasActionPerformed

    private void radioIdClienteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIdClienteVentasActionPerformed
        
        desabilitarComponenetes(comboVentasClienteBuscar, comboVentasPagoBuscar, comboVentasPrecioBuscar,comboVentasMesBuscar, cajaIDVentasBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);

        
    }//GEN-LAST:event_radioIdClienteVentasActionPerformed

    private void radioIDEmpleadoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIDEmpleadoVentasActionPerformed
        
        desabilitarComponenetes(comboVentasEmpleadoBuscar, comboVentasPagoBuscar, comboVentasClienteBuscar, comboVentasPrecioBuscar,comboVentasMesBuscar, cajaIDVentasBuscar, comboVentasVehiculosBuscar);

    }//GEN-LAST:event_radioIDEmpleadoVentasActionPerformed

    private void radioIDVehiculoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIDVehiculoVentasActionPerformed
        
        desabilitarComponenetes(comboVentasVehiculosBuscar, comboVentasPagoBuscar, comboVentasEmpleadoBuscar, comboVentasClienteBuscar, comboVentasPrecioBuscar,comboVentasMesBuscar, cajaIDVentasBuscar);

    }//GEN-LAST:event_radioIDVehiculoVentasActionPerformed

    
    
    //============================================ MODELOS ================================================
    
    private void btnModelosRestaurarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosRestaurarAgregarActionPerformed
        
        restablecer(cajaModelosNombreAgregar, comboModelosAnioAgregar, cajaModelosFabricanteAgregar, comboModelosCilindrosAgregar, cajaModelosPuertasAgregar, cajaModelosPesoAgregar, cajaModelosPasajerosAgregar, cajaModelosColorAgregar, cajaModelosPaisAgregar);
        
    }//GEN-LAST:event_btnModelosRestaurarAgregarActionPerformed

    private void btnModelosCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosCancelarAgregarActionPerformed
       
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir sin guardar el registro? Se perderan los cambios");
         
        if(respuesta == JOptionPane.YES_OPTION){
            
            restablecer(cajaModelosNombreAgregar, comboModelosAnioAgregar, cajaModelosFabricanteAgregar, comboModelosCilindrosAgregar, cajaModelosPuertasAgregar, cajaModelosPesoAgregar, cajaModelosPasajerosAgregar, cajaModelosColorAgregar, cajaModelosPaisAgregar);
            
        }
        
                
    }//GEN-LAST:event_btnModelosCancelarAgregarActionPerformed

    private void btnModelosCancelarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosCancelarActualizarActionPerformed
       
        
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir sin guardar los cambios?");
         
        if(respuesta == JOptionPane.YES_OPTION){
        
            restablecer(cajaModelosNombreActualizar, comboModelosAnioActualizar, cajaModelosFabricanteActualizar, comboModelosCilindrosActualizar, cajaModelosPuertasActualizar, cajaModelosPesoActualizar, cajaModelosPasajerosActualizar, cajaModelosColorActualizar, cajaModelosPaisActualizar);

        } 
        
    }//GEN-LAST:event_btnModelosCancelarActualizarActionPerformed

      //============================================ VENTAS ================================================
    
    private void btnEliminarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentasActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el registro?");
         
        if(respuesta == JOptionPane.YES_OPTION){
            
            if(ventaDAO.eliminarVenta(Integer.parseInt(cajaIDVentasBuscar.getText().toString()))){
            
                JOptionPane.showMessageDialog(this, "El registro se elimino correctamente");
            
                actualizarTabla(tablaVentas, "ventas");
                
                btnEliminarVentas.setEnabled(false);
                
                btnActualizarVentas.setEnabled(false);
            
            }else{
                
                con.mostrarError(this);
                
            }
            
        }
           
    }//GEN-LAST:event_btnEliminarVentasActionPerformed

    private void btnAgregarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentasActionPerformed
        internalAltasVentas.setVisible(true);
    }//GEN-LAST:event_btnAgregarVentasActionPerformed

    private void btnActualizarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarVentasActionPerformed
        internalActualizarVentas.setVisible(true);
      
        
        String sql = "SELECT * FROM ventas WHERE id_venta = ?;";
        
        rs = con.ejecutarInstruccionSQL(sql, tablaVentas.getValueAt(0, 0));
       

        try {
            
            rs.next();
            
            String fechaVenta = rs.getString(2);
            
            String[] fechaSeparada = fechaVenta.split("-");
            
            System.out.println(fechaSeparada[0]);
            
            comboVentasAnioActualizar.setSelectedItem(fechaSeparada[0]);
            
            comboVentasMesActualizar.setSelectedIndex(Integer.parseInt(fechaSeparada[1]) - 1);
            
            comboVentasDiaActualizar.setSelectedIndex(Integer.parseInt(fechaSeparada[2]) - 1);
            
            cajaVentasPrecioActualizar.setText(rs.getString(3));
            
            comboVentasFormaActualizar.setSelectedItem(rs.getString(4));
            
            comboVentasClienteActualizar.setSelectedItem(rs.getString(5));
            
            comboVentasEmpleadoActualizar.setSelectedItem(rs.getString(6));
            
            comboVentasvehiculoActualizar.setSelectedItem(rs.getString(7));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
            
            System.out.println(e);
            
        }
             
    }//GEN-LAST:event_btnActualizarVentasActionPerformed

    private void radioIDVentaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIDVentaVentasActionPerformed
        desabilitarComponenetes(cajaIDVentasBuscar, comboVentasPagoBuscar, comboVentasMesBuscar, comboVentasPrecioBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
    }//GEN-LAST:event_radioIDVentaVentasActionPerformed

    private void btnVentasAgregarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasAgregarAgregarActionPerformed
       
        Venta venta = new Venta(
        
                hoy,
                Double.parseDouble(cajaVentasPrecioAgregar.getText()),
                comboVentasFormaAgregar.getSelectedItem().toString(),
                comboVentasClienteAgregar.getSelectedItem().toString(),
                comboVentasEmpleadoAgregar.getSelectedItem().toString(),
                comboVentasvehiculoAgregar.getSelectedItem().toString()
                
        );
        
        if(ventaDAO.agregarVenta(venta)){
            
            actualizarTabla(tablaVentas, "ventas");
            
            JOptionPane.showMessageDialog(this, "Se  agrego la venta con exito");
            
            restablecer(
                    
   
                    cajaVentasPrecioAgregar,
                    comboVentasFormaAgregar,
                    comboVentasClienteAgregar,
                    comboVentasEmpleadoAgregar,
                    comboVentasvehiculoAgregar
            
            );
            
            internalAltasVentas.setVisible(false);
            
        }else{
            
            JOptionPane.showMessageDialog(this, ventaDAO.mostrarMensaje());
            
           
            
        }
        
    }//GEN-LAST:event_btnVentasAgregarAgregarActionPerformed

    private void radioVentasPagoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioVentasPagoBuscarActionPerformed
       
        desabilitarComponenetes(comboVentasPagoBuscar, cajaIDVentasBuscar, comboVentasMesBuscar, comboVentasPrecioBuscar, comboVentasClienteBuscar, comboVentasEmpleadoBuscar, comboVentasVehiculosBuscar);
        
    }//GEN-LAST:event_radioVentasPagoBuscarActionPerformed

    private void comboVentasAnioActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasAnioActualizarActionPerformed
        anioBisiesto(Integer.parseInt(comboVentasAnioActualizar.getSelectedItem().toString()), comboVentasMesActualizar.getSelectedIndex(), comboVentasDiaActualizar);
    }//GEN-LAST:event_comboVentasAnioActualizarActionPerformed

    private void comboVentasMesActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasMesActualizarActionPerformed
        
        anioBisiesto(Integer.parseInt(comboVentasAnioActualizar.getSelectedItem().toString()), comboVentasMesActualizar.getSelectedIndex(), comboVentasDiaActualizar);
        
    }//GEN-LAST:event_comboVentasMesActualizarActionPerformed

    private void cajaIDVentasBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaIDVentasBuscarKeyReleased
        
        if(cajaIDVentasBuscar.getText().length() == 0){
             
            actualizarTabla(tablaVentas, "ventas");
             
         }else{
             
            actualizarTablaConFiltro(
                tablaVentas,
                "ventas",
                "id_venta",
                cajaIDVentasBuscar.getText().toString(),
                'N'
            ); 
             
        }
        
        if(radioIDVentaVentas.isSelected() && tablaVentas.getRowCount() == 1){
            
            
            btnActualizarVentas.setEnabled(true);
            
            btnEliminarVentas.setEnabled(true);
            
        }else{
            
            btnActualizarVentas.setEnabled(false);
            
            btnEliminarVentas.setEnabled(false);
            
        }
               
               
               
    }//GEN-LAST:event_cajaIDVentasBuscarKeyReleased

    private void btnVentasActualizarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActualizarActualizarActionPerformed
        
        String mes, dia;
        
        if(String.valueOf(comboVentasMesActualizar.getSelectedIndex() + 1).length() == 1){
           
            mes = "0"+String.valueOf(comboVentasMesActualizar.getSelectedIndex()+1);
            
        }else{
            
            mes = String.valueOf(comboVentasMesActualizar.getSelectedIndex()+1);
            
        }
        
        if(comboVentasDiaActualizar.getSelectedItem().toString().length() == 1){
            
            dia = "0" + comboVentasDiaActualizar.getSelectedItem().toString();
            
        }else{
            
            dia = comboVentasDiaActualizar.getSelectedItem().toString();
            
        }
        
        String fechaVenta = comboAnioModificar.getSelectedItem().toString() + "-" + mes + "-" + dia;
        
        Venta venta = new Venta(
        
                LocalDate.parse(fechaVenta),
                Double.parseDouble(cajaVentasPrecioActualizar.getText()),
                comboVentasFormaActualizar.getSelectedItem().toString(),
                comboVentasClienteActualizar.getSelectedItem().toString(),
                comboVentasEmpleadoActualizar.getSelectedItem().toString(),
                comboVentasvehiculoActualizar.getSelectedItem().toString()
                
        );
        
        if(ventaDAO.actualizarVenta(venta, Integer.parseInt(tablaVentas.getValueAt(0, 0).toString()))){
            
            JOptionPane.showMessageDialog(this, "Registro actualizado con exito");
            
            actualizarTabla(tablaVentas, "ventas");
            
            btnEliminarVentas.setEnabled(false);
            
            btnActualizarVentas.setEnabled(false);
            
            restablecer(
                    
                    comboVentasAnioActualizar,
                    comboVentasMesActualizar,
                    comboVentasDiaActualizar,
                    cajaVentasPrecioActualizar,
                    comboVentasFormaActualizar,
                    comboVentasClienteActualizar,
                    comboVentasEmpleadoActualizar,
                    comboVentasvehiculoActualizar
            
            );
            
            internalActualizarVentas.setVisible(false);
            
        }
        
    }//GEN-LAST:event_btnVentasActualizarActualizarActionPerformed

    private void btnVentasCancelarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasCancelarActualizarActionPerformed
        
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de cancelar?");
         
        if(respuesta == JOptionPane.YES_OPTION){
            
            restablecer(
                    
                    comboVentasAnioActualizar,
                    comboVentasMesActualizar,
                    comboVentasDiaActualizar,
                    cajaVentasPrecioActualizar,
                    comboVentasFormaActualizar,
                    comboVentasClienteActualizar,
                    comboVentasEmpleadoActualizar,
                    comboVentasvehiculoActualizar
            
            );
 
            internalActualizarVentas.setVisible(false);
            
        }
        
    }//GEN-LAST:event_btnVentasCancelarActualizarActionPerformed

    private void btnVentasCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasCancelarAgregarActionPerformed
        
            restablecer(
                    
   
                    cajaVentasPrecioAgregar,
                    comboVentasFormaAgregar,
                    comboVentasClienteAgregar,
                    comboVentasEmpleadoAgregar,
                    comboVentasvehiculoAgregar
            
            );
            
            internalAltasVentas.setVisible(false);
        
    }//GEN-LAST:event_btnVentasCancelarAgregarActionPerformed

    private void btnVentasRestaurarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasRestaurarAgregarActionPerformed
        
            restablecer(
                    
   
                    cajaVentasPrecioAgregar,
                    comboVentasFormaAgregar,
                    comboVentasClienteAgregar,
                    comboVentasEmpleadoAgregar,
                    comboVentasvehiculoAgregar
            
            );
            

        
    }//GEN-LAST:event_btnVentasRestaurarAgregarActionPerformed

    private void comboVentasMesBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasMesBuscarActionPerformed
        
        String mes;
        
        if(String.valueOf(comboVentasMesBuscar.getSelectedIndex()+1).length() == 1){
            
            mes = "0" + String.valueOf(comboVentasMesBuscar.getSelectedIndex()+1);
            
        }else{
            
            mes = String.valueOf(comboVentasMesBuscar.getSelectedIndex()+1);
            
        }
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "fecha_venta", 
                mes, 
                'M'
        );
        
    }//GEN-LAST:event_comboVentasMesBuscarActionPerformed

    private void comboVentasPrecioBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasPrecioBuscarActionPerformed
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "precio_final", 
                comboVentasPrecioBuscar.getSelectedItem().toString(), 
                'O'
        );
        
    }//GEN-LAST:event_comboVentasPrecioBuscarActionPerformed

    private void comboVentasPagoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasPagoBuscarActionPerformed
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "forma_pago", 
                comboVentasPagoBuscar.getSelectedItem().toString(), 
                'T'
        );
        
    }//GEN-LAST:event_comboVentasPagoBuscarActionPerformed

    private void comboVentasClienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasClienteBuscarActionPerformed
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "id_cliente", 
                comboVentasClienteBuscar.getSelectedItem().toString(), 
                'T'
        );
        
    }//GEN-LAST:event_comboVentasClienteBuscarActionPerformed

    private void comboVentasEmpleadoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasEmpleadoBuscarActionPerformed
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "id_empleado", 
                comboVentasEmpleadoBuscar.getSelectedItem().toString(), 
                'T'
        );
        
    }//GEN-LAST:event_comboVentasEmpleadoBuscarActionPerformed

    private void comboVentasVehiculosBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentasVehiculosBuscarActionPerformed
        
        actualizarTablaConFiltro(
                tablaVentas, 
                "ventas", 
                "id_vehiculo", 
                comboVentasVehiculosBuscar.getSelectedItem().toString(), 
                'T'
        );
        
    }//GEN-LAST:event_comboVentasVehiculosBuscarActionPerformed

    private void btnHomeVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeVistaActionPerformed
        
        
        recrearVista("view_vehiculos_modelos", "SELECT v.id_vehiculo, m.nombre_modelo FROM vehiculos v INNER JOIN modelos m ON v.id_modelo=m.id_modelo;");
 
        cargarVistaEnTabla(tablaVista, "view_vehiculos_modelos");
        
        internalHomeVista.setVisible(true);
        
    }//GEN-LAST:event_btnHomeVistaActionPerformed

    private void btnHomeHistorialPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeHistorialPreciosActionPerformed
        
        actualizarTabla(tablaHistorialPrecios, "historial_precios");
        
        internalHistorialPrecios.setVisible(true);
        
    }//GEN-LAST:event_btnHomeHistorialPreciosActionPerformed

    private void btnHomeVehiculosEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeVehiculosEliminadosActionPerformed
       
        actualizarTabla(tablaVehiculosEliminados, "vehiculos_elimminados");
        
        internalVehiculosEliminados.setVisible(true);
        
    }//GEN-LAST:event_btnHomeVehiculosEliminadosActionPerformed

    private void btnVehiculosEliminadosCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculosEliminadosCerrarActionPerformed
        
        internalVehiculosEliminados.setVisible(false);
        
    }//GEN-LAST:event_btnVehiculosEliminadosCerrarActionPerformed

    private void btnHistorialPreciosCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPreciosCerrarActionPerformed
        
        internalHistorialPrecios.setVisible(false);
        
        
    }//GEN-LAST:event_btnHistorialPreciosCerrarActionPerformed

    private void btnVistaCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaCerrarActionPerformed
        
        internalHomeVista.setVisible(false);
        
    }//GEN-LAST:event_btnVistaCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaInicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnActualizarModelos;
    private javax.swing.JButton btnActualizarModificar;
    private javax.swing.JButton btnActualizarVentas;
    private javax.swing.JButton btnAgregarAgregar;
    private javax.swing.JButton btnAgregarModelos;
    private javax.swing.JButton btnAgregarVehiculos;
    private javax.swing.JButton btnAgregarVentas;
    private javax.swing.JButton btnCancelarAgregar;
    private javax.swing.JButton btnCancelarModificar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDocumentacion;
    private javax.swing.JButton btnEliminarModelos;
    private javax.swing.JButton btnEliminarVehiculos;
    private javax.swing.JButton btnEliminarVentas;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnHistorialPreciosCerrar;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHomeGrafica;
    private javax.swing.JButton btnHomeHistorialPrecios;
    private javax.swing.JButton btnHomeReporte;
    private javax.swing.JButton btnHomeVehiculosEliminados;
    private javax.swing.JButton btnHomeVista;
    private javax.swing.JButton btnModelos;
    private javax.swing.JButton btnModelosActualizarActualizar;
    private javax.swing.JButton btnModelosAgregarAgregar;
    private javax.swing.JButton btnModelosCancelarActualizar;
    private javax.swing.JButton btnModelosCancelarAgregar;
    private javax.swing.JButton btnModelosRestaurarAgregar;
    private javax.swing.JButton btnModificarVehiculos;
    private javax.swing.JButton btnRestaurarAgregar;
    private javax.swing.JButton btnVehiculos;
    private javax.swing.JButton btnVehiculosEliminadosCerrar;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVentasActualizarActualizar;
    private javax.swing.JButton btnVentasAgregarAgregar;
    private javax.swing.JButton btnVentasCancelarActualizar;
    private javax.swing.JButton btnVentasCancelarAgregar;
    private javax.swing.JButton btnVentasRestaurarAgregar;
    private javax.swing.JButton btnVistaCerrar;
    private javax.swing.JTextField cajaFabricanteModeloBusqueda;
    private javax.swing.JTextField cajaIDModeloBusqueda;
    private javax.swing.JTextField cajaIDVentasBuscar;
    private javax.swing.JTextField cajaKilometrajeAgregar;
    private javax.swing.JTextField cajaKilometrajeModificar;
    private javax.swing.JTextField cajaModeloPasajerosBusqueda;
    private javax.swing.JTextField cajaModeloPesoBusqueda;
    private javax.swing.JTextField cajaModeloPuertasBusqueda;
    private javax.swing.JTextField cajaModelosColorActualizar;
    private javax.swing.JTextField cajaModelosColorAgregar;
    private javax.swing.JTextField cajaModelosFabricanteActualizar;
    private javax.swing.JTextField cajaModelosFabricanteAgregar;
    private javax.swing.JTextField cajaModelosNombreActualizar;
    private javax.swing.JTextField cajaModelosNombreAgregar;
    private javax.swing.JTextField cajaModelosPaisActualizar;
    private javax.swing.JTextField cajaModelosPaisAgregar;
    private javax.swing.JTextField cajaModelosPasajerosActualizar;
    private javax.swing.JTextField cajaModelosPasajerosAgregar;
    private javax.swing.JTextField cajaModelosPesoActualizar;
    private javax.swing.JTextField cajaModelosPesoAgregar;
    private javax.swing.JTextField cajaModelosPuertasActualizar;
    private javax.swing.JTextField cajaModelosPuertasAgregar;
    private javax.swing.JTextField cajaNombreModeloBusqueda;
    private javax.swing.JTextField cajaNumSerieAgregar;
    private javax.swing.JTextField cajaNumSerieBuscar;
    private javax.swing.JTextField cajaNumSerieModificar;
    private javax.swing.JTextField cajaNumVehiculoAgregar;
    private javax.swing.JTextField cajaNumVehiculoBuscar;
    private javax.swing.JTextField cajaPaisModeloBusqueda;
    private javax.swing.JTextField cajaPrecioAgregar;
    private javax.swing.JTextField cajaPrecioModificar;
    private javax.swing.JTextField cajaVentasPrecioActualizar;
    private javax.swing.JTextField cajaVentasPrecioAgregar;
    private javax.swing.JComboBox<String> comboAnioAgregar;
    private javax.swing.JComboBox<String> comboAnioBusqueda1;
    private javax.swing.JComboBox<String> comboAnioEntradaModificar;
    private javax.swing.JComboBox<String> comboAnioModeloBuscar;
    private javax.swing.JComboBox<String> comboAnioModificar;
    private javax.swing.JComboBox<String> comboDiaAgregar;
    private javax.swing.JComboBox<String> comboDiaEntradaModificar;
    private javax.swing.JComboBox<String> comboDiaModificar;
    private javax.swing.JComboBox<String> comboEstadoBusqueda;
    private javax.swing.JComboBox<String> comboEstadoModificar;
    private javax.swing.JComboBox<String> comboMesAgregar;
    private javax.swing.JComboBox<String> comboMesEntradaModificar;
    private javax.swing.JComboBox<String> comboMesModificar;
    private javax.swing.JComboBox<String> comboModeloAgregar;
    private javax.swing.JComboBox<String> comboModeloBusqueda;
    private javax.swing.JComboBox<String> comboModeloModificar;
    private javax.swing.JComboBox<String> comboModelosAnioActualizar;
    private javax.swing.JComboBox<String> comboModelosAnioAgregar;
    private javax.swing.JComboBox<String> comboModelosCilindrosActualizar;
    private javax.swing.JComboBox<String> comboModelosCilindrosAgregar;
    private javax.swing.JComboBox<String> comboNumeroCilindrosBuscar;
    private javax.swing.JComboBox<String> comboPrecioBusqueda1;
    private javax.swing.JComboBox<String> comboTipoAgregar;
    private javax.swing.JComboBox<String> comboTipoBusqueda;
    private javax.swing.JComboBox<String> comboTipoModificar;
    private javax.swing.JComboBox<String> comboVentasAnioActualizar;
    private javax.swing.JComboBox<String> comboVentasClienteActualizar;
    private javax.swing.JComboBox<String> comboVentasClienteAgregar;
    private javax.swing.JComboBox<String> comboVentasClienteBuscar;
    private javax.swing.JComboBox<String> comboVentasDiaActualizar;
    private javax.swing.JComboBox<String> comboVentasEmpleadoActualizar;
    private javax.swing.JComboBox<String> comboVentasEmpleadoAgregar;
    private javax.swing.JComboBox<String> comboVentasEmpleadoBuscar;
    private javax.swing.JComboBox<String> comboVentasFormaActualizar;
    private javax.swing.JComboBox<String> comboVentasFormaAgregar;
    private javax.swing.JComboBox<String> comboVentasMesActualizar;
    private javax.swing.JComboBox<String> comboVentasMesBuscar;
    private javax.swing.JComboBox<String> comboVentasPagoBuscar;
    private javax.swing.JComboBox<String> comboVentasPrecioBuscar;
    private javax.swing.JComboBox<String> comboVentasVehiculosBuscar;
    private javax.swing.JComboBox<String> comboVentasvehiculoActualizar;
    private javax.swing.JComboBox<String> comboVentasvehiculoAgregar;
    private javax.swing.ButtonGroup groupBusquedaModelos;
    private javax.swing.ButtonGroup groupBusquedaVehiculos;
    private javax.swing.ButtonGroup groupBusquedaVentas;
    private javax.swing.JInternalFrame internalActualizarVentas;
    private javax.swing.JInternalFrame internalAgregarAutos;
    private javax.swing.JInternalFrame internalAgregarModelos;
    private javax.swing.JInternalFrame internalAltasVentas;
    private javax.swing.JInternalFrame internalCambiosModelos;
    private javax.swing.JInternalFrame internalHistorialPrecios;
    private javax.swing.JInternalFrame internalHome;
    private javax.swing.JInternalFrame internalHomeVista;
    private javax.swing.JInternalFrame internalModelos;
    private javax.swing.JInternalFrame internalModificarAutos;
    private javax.swing.JInternalFrame internalProximamente;
    private javax.swing.JInternalFrame internalVehiculos;
    private javax.swing.JInternalFrame internalVehiculosEliminados;
    private javax.swing.JInternalFrame internalVentas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton radioAnioBusqueda1;
    private javax.swing.JRadioButton radioAnioModeloBuscar;
    private javax.swing.JRadioButton radioEstadoBusqueda1;
    private javax.swing.JRadioButton radioFabricanteModelo;
    private javax.swing.JRadioButton radioIDEmpleadoVentas;
    private javax.swing.JRadioButton radioIDVehiculoVentas;
    private javax.swing.JRadioButton radioIDVentaVentas;
    private javax.swing.JRadioButton radioIdClienteVentas;
    private javax.swing.JRadioButton radioMesVentas;
    private javax.swing.JRadioButton radioModeloBusqueda;
    private javax.swing.JRadioButton radioNombreModelo;
    private javax.swing.JRadioButton radioNumSerieBusqueda;
    private javax.swing.JRadioButton radioNumVehiculoBusqueda;
    private javax.swing.JRadioButton radioNumeroCilindros;
    private javax.swing.JRadioButton radioNumeroPuertas;
    private javax.swing.JRadioButton radioPais;
    private javax.swing.JRadioButton radioPasajeros;
    private javax.swing.JRadioButton radioPeso;
    private javax.swing.JRadioButton radioPrecioBusqueda1;
    private javax.swing.JRadioButton radioPrecioVentas;
    private javax.swing.JRadioButton radioTipoBusqueda;
    private javax.swing.JRadioButton radioTodosBusqueda;
    private javax.swing.JRadioButton radioTodosModelos;
    private javax.swing.JRadioButton radioTodosVentas;
    private javax.swing.JRadioButton radioVentasPagoBuscar;
    private javax.swing.JRadioButton radioidModeloBusqueda;
    private javax.swing.JPanel sidePane;
    private javax.swing.JTable tablaHistorialPrecios;
    private javax.swing.JTable tablaModelos;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTable tablaVehiculosEliminados;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTable tablaVista;
    // End of variables declaration//GEN-END:variables
}
