/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lauda
 */
public class GestorCursos {

    public void AñadirCurso(String nombreCurso) {
        String rutaProyecto = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = rutaProyecto + separador + "datos";

        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        String rutaCarpetaCurso = rutaCarpeta + separador + nombreCurso;

        File carpetaCurso = new File(rutaCarpetaCurso);
        if (!carpetaCurso.exists()) {
            carpetaCurso.mkdir();
        }
    }

    public String[] RecuperarCursos() {
        String rutaProyecto = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = rutaProyecto + separador + "datos";
        File carpeta = new File(rutaCarpeta);
        return carpeta.list();

    }

    ;
    
    public void borrarCurso(String nombreCurso) {
        String rutaProyecto = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = rutaProyecto + separador + "datos";
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists()) {

            String rutaCarpetaCurso = rutaCarpeta + separador + nombreCurso;

            File carpetaCurso = new File(rutaCarpetaCurso);
            if (carpetaCurso.exists()) {

                File[] archivos = carpetaCurso.listFiles(); //creo lista de archivos dentro

                if (archivos != null) { //hasta que no queden
                    for (File f : archivos) { 
                        f.delete(); //  lo borra
                    }
                }
            }
            carpetaCurso.delete();
        }
    }

    public ArrayList SeleccionarCurso(String nombreCurso) {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        String rutaProyecto = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = rutaProyecto + separador + "datos";
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists()) {

            String rutaCarpetaCurso = rutaCarpeta + separador + nombreCurso;

            try {
                File newFile = new File(rutaCarpetaCurso + separador + "Students.txt");
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                FileReader fr = new FileReader(newFile);

                BufferedReader br = new BufferedReader(fr); //Buffer que almacena
                String linea = "";

                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    // Creamos el objeto Alumno con los datos de esa línea
                    Alumno alumno = new Alumno(
                            datos[0],
                            datos[1],
                            Integer.parseInt(datos[2]),
                            datos[3]
                    );
                    alumnos.add(alumno);
                    System.out.println(alumno.toString());
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return alumnos;
    }

}
