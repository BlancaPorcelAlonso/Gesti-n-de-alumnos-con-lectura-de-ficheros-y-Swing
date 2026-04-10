/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author lauda
 */
public class GestorAlumnos {
      
    public void actualizarAlumnos(ArrayList<Alumno> alumnos, String nombreCurso)
      {
          String rutaProyecto = System.getProperty("user.dir");
          String separador = File.separator;
          try{
          File archivo = new File(rutaProyecto + separador + "datos" + separador + nombreCurso + separador + "Students.txt");
          FileWriter fw = new FileWriter(archivo);
          BufferedWriter bw = new BufferedWriter(fw);
          for(Alumno a: alumnos){
            bw.write(a.toString());
            bw.newLine();
          }
          bw.flush();
          bw.close();
          }catch(IOException e){ 
              System.out.println("Error");
          }
          
          
      }
}
