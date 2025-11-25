/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

/**
 *
 * @author Eduardo
 */
import Controlador.IPrecioDAO;
import Controlador.IPrecioService;
import java.util.ArrayList;
import java.util.List;

public class PrecioService implements IPrecioService {

    private final IPrecioDAO precioDAO;

    public PrecioService(IPrecioDAO precioDAO) {
        this.precioDAO = precioDAO;
    }

    @Override
    public List<Double> obtenerPrecios(List<String> vehiculos) {

        List<Double> precios = new ArrayList<>();

        for (String idVehiculo : vehiculos) {
            precios.add(precioDAO.obtenerPrecioSugerido(idVehiculo));
        }

        return precios;
    }
}