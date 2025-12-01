/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficador;

import Controlador.IGraficador;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import java.util.List;
import javax.swing.JFrame;

public class GraficadorPrecios implements IGraficador {

    @Override
    public void graficar(List<String> vehiculos, List<Double> precios) {

        CategoryChart chart = new CategoryChartBuilder()
                .width(1000)
                .height(600)
                .title("Precio Sugerido por ID de Modelo")
                .xAxisTitle("ID Modelo")
                .yAxisTitle("Precio Sugerido")
                .build();

        // Convertir modelos de Integer a String para graficar
        List<String> modelosTexto = vehiculos.stream()
                .map(String::valueOf)
                .toList();

        chart.addSeries("Precio Sugerido", modelosTexto, precios);

        new Thread(() -> {
            SwingWrapper<CategoryChart> wrapper = new SwingWrapper<>(chart);
            JFrame frame = wrapper.displayChart();  
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }).start();
    }
}
