/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eduardo
 */
public class Vehiculo {
    
    private String idVehiculo;
    
    private String numSerie;
    
    private int idModelo;
    
    private String fechaFabricacion;

    private double precio;
    
    private int kilometraje;
    
    private String fehcaEntrada;
    
    private String tipo;
    
    private String entrada;

    public Vehiculo(String idVehiculo, String numSerie, int idModelo, String fechaFabricacion, double precio, int kilometraje, String fehcaEntrada, String tipo, String entrada) {
        this.idVehiculo = idVehiculo;
        this.numSerie = numSerie;
        this.idModelo = idModelo;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.fehcaEntrada = fehcaEntrada;
        this.tipo = tipo;
        this.entrada = entrada;
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

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
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

    public String getFehcaEntrada() {
        return fehcaEntrada;
    }

    public void setFehcaEntrada(String fehcaEntrada) {
        this.fehcaEntrada = fehcaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", numSerie=" + numSerie + ", idModelo=" + idModelo + ", fechaFabricacion=" + fechaFabricacion + ", precio=" + precio + ", kilometraje=" + kilometraje + ", fehcaEntrada=" + fehcaEntrada + ", tipo=" + tipo + ", entrada=" + entrada + '}';
    }
    
    
    
}
