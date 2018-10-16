/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaEscritura;

import PaqueteLeer.LeerTeclado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//quitar por el objeto a usar
import modelo.Persona;

/**
 *
 * @author gnord
 */
public class CrearArchivoDatygrabarObjetos {
    
    /**
     *Crea un archivo y guarda datos en forma de objetos por primera vez,añade cabecera al archivo
     * para continuar grabando en el mismo archivo se usa despues la clase AnadirObjetosenDat
     * @param file
     * @param persona
     * */
    
      public void crearArchivoYGrabarObjetos(File file, Persona persona) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream escritor = new ObjectOutputStream(fos);

            escritor.writeObject(persona);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo, fallo en la clase crearArchivosYGrabarObjetos");
        } catch (IOException ex) {
            System.out.println("No se puede escribir el archivo, fallo en la clase crearArchivosYGrabarObjetos");
        }

    }

}
