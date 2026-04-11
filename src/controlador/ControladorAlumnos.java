/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.GestorAlumnos;
import vista.CursosView;
import vista.HomeView;

/**
 *
 * @author lauda
 */
public class ControladorAlumnos {

    private CursosView vistaCursos;
    GestorAlumnos gestor;
    ArrayList<Alumno> alumnos;

    public ControladorAlumnos(CursosView vistaCursos, ArrayList<Alumno> alumnos) {
        this.vistaCursos = vistaCursos;
        this.gestor = new GestorAlumnos();
        this.alumnos = alumnos;
    }

    public void cargarMensaje() {
        String[] alumnosTexto = new String[alumnos.size()];

        for (int i = 0; i < alumnos.size(); i++) {
            alumnosTexto[i] = alumnos.get(i).toString();
        }
        vistaCursos.mostrarTexto(alumnosTexto);
    }

    public void añadirAlumno(String nombre, String apell, int edad, String dni) {
        
        Alumno alumnoNuevo = new Alumno(nombre, apell, edad, dni);
        alumnos.add(alumnoNuevo);
    }

    public void borrarAlumno(String alumno) {
        String[] datos = alumno.split(",");
        Alumno alumnoBorrar = new Alumno(datos[0], datos[1], parseInt(datos[2]), datos[3]);
        System.out.println(alumnoBorrar.toString());

        for (Alumno a : alumnos) {
            if (a.getDni().equals(alumnoBorrar.getDni())) {
                alumnos.remove(a);
                break; 
            }
        }
    }

    public void actualizarAlumnos() {
        gestor.actualizarAlumnos(alumnos, vistaCursos.getNombreCurso());
        HomeView cv = new HomeView();
        ControladorCursos c = new ControladorCursos(cv);
        cv.setControlador(c);
        cv.setVisible(true);
        c.cargarMensaje();
    }
;

}
