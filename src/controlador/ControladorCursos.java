/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.File;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.GestorCursos;
import vista.CursosView;
import vista.HomeView;

/**
 *
 * @author lauda
 */
public class ControladorCursos {

    private HomeView vista;
    GestorCursos gestor;

    public ControladorCursos(HomeView vista) {
        this.vista = vista;
        this.gestor = new GestorCursos();

    }

    public void cargarMensaje() {
        vista.mostrarTexto(gestor.RecuperarCursos());
    }

    public void crearCurso(String nombreCurso) {
        gestor.AñadirCurso(nombreCurso);
    }
    
    public void borrarCurso(String nombreCurso) {
        gestor.borrarCurso(nombreCurso);
    }
    
   public void SeleccionCurso(String curso){
        ArrayList<Alumno> alumnos = gestor.SeleccionarCurso(curso);
        CursosView cv = new CursosView(curso);
        ControladorAlumnos c = new ControladorAlumnos(cv, alumnos);
        vista.setVisible(false);
        cv.setControlador(c);  
        cv.setVisible(true);
        c.cargarMensaje();
    }

}
