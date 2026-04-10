/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controlador.ControladorCursos;
import vista.CursosView;
import vista.HomeView;

/**
 *
 * @author lauda
 */
public class RegistroAlumnosSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HomeView home = new HomeView();
        
        ControladorCursos c = new ControladorCursos(home);
        home.setControlador(c);  
        home.setVisible(true);
        c.cargarMensaje();
    }

}
