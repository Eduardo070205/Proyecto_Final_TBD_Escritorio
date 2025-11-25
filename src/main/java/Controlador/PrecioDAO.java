/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrecioDAO implements IPrecioDAO {

    private final ConexionBD con = ConexionBD.getInstancia();

    @Override
    public double obtenerPrecioSugerido(String idVehiculo) {

        double precio = 0;

        String sql = "SELECT precio_sugerido_vehiculo(?) AS precio;";

        try {
        
            con.reconectar();

            PreparedStatement ps = con.getConexion().prepareStatement(sql);
            ps.setString(1, idVehiculo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble("precio");
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return precio;
    }
}