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
public class Vehiculo {
    
    private String idVehiculo;
    
    private String numSerie;
    
    private int idModelo;
    
    private LocalDate fechaFabricacion;

    private double precio;
    
    private int kilometraje;
    
    private LocalDate fehcaEntrada;
    
    private String tipo;
    
    private String estado;

    public Vehiculo(String idVehiculo, String numSerie, int idModelo, LocalDate fechaFabricacion, double precio, int kilometraje, LocalDate fehcaEntrada, String tipo, String estado) {
        this.idVehiculo = idVehiculo;
        this.numSerie = numSerie;
        this.idModelo = idModelo;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.fehcaEntrada = fehcaEntrada;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public LocalDate getFehcaEntrada() {
        return fehcaEntrada;
    }

    public void setFehcaEntrada(LocalDate fehcaEntrada) {
        this.fehcaEntrada = fehcaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String entrada) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", numSerie=" + numSerie + ", idModelo=" + idModelo + ", fechaFabricacion=" + fechaFabricacion + ", precio=" + precio + ", kilometraje=" + kilometraje + ", fehcaEntrada=" + fehcaEntrada + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
    
    
}
