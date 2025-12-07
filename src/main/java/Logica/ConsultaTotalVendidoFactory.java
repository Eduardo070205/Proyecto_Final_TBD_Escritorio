/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Eduardo
 */
public class ConsultaTotalVendidoFactory extends ConsultaFactory {

    @Override
    public PreparedStatement createStatement(Connection cn, Object modelo) throws Exception {
        PreparedStatement ps = cn.prepareStatement(
            "SELECT total_vendido_modelo(?) AS total_vendido"
        );
        ps.setInt(1, Integer.parseInt(modelo.toString()));
        return ps;
    }
}
