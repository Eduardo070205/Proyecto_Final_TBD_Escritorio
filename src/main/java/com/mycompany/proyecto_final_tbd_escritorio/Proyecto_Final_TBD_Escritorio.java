

package com.mycompany.proyecto_final_tbd_escritorio;

import Ventanas.VentanaLogin;
import javax.swing.SwingUtilities;


public class Proyecto_Final_TBD_Escritorio {

    public static void main(String[] args) {
        
       SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new VentanaLogin();

            }
        });
        
       
    }
}
