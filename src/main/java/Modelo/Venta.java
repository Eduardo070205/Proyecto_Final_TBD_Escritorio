/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Eduardo
 */
public class Venta {
    
    private LocalDate fechaVenta;
    
    private double precioFinal;
    
    private String formaPago;
    
    private String idCliente;
    
    private String idEmpleado;
    
    private String idVehiculo;

    public Venta(LocalDate fechaVenta, double precioFinal, String formaPago, String idCliente, String idEmpleado, String idVehiculo) {
        this.fechaVenta = fechaVenta;
        this.precioFinal = precioFinal;
        this.formaPago = formaPago;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idVehiculo = idVehiculo;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
    
    
    
    
}
