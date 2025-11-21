/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eduardo
 */
public class Modelo {
    

    private String nombreModelo;
    private short anioModelo;
    private String fabricante;
    private byte numeroCilindros;
    private byte numeroPuertas;
    private double peso;
    private byte catidadPasajeros;
    private String color;
    private String paisFabricacion;

    public Modelo(String nombreModelo, short anioModelo, String fabricante, byte numeroCilindros, byte numeroPuertas, double peso, byte catidadPasajeros, String color, String paisFabricacion) {
        this.nombreModelo = nombreModelo;
        this.anioModelo = anioModelo;
        this.fabricante = fabricante;
        this.numeroCilindros = numeroCilindros;
        this.numeroPuertas = numeroPuertas;
        this.peso = peso;
        this.catidadPasajeros = catidadPasajeros;
        this.color = color;
        this.paisFabricacion = paisFabricacion;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public short getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(short anioModelo) {
        this.anioModelo = anioModelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public byte getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(byte numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public byte getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(byte numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public byte getCatidadPasajeros() {
        return catidadPasajeros;
    }

    public void setCatidadPasajeros(byte catidadPasajeros) {
        this.catidadPasajeros = catidadPasajeros;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

  
    
   
    
}
