/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

import java.io.File;
import lecturaEscritura.AddObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author gnord
 */
public class AnadirObjetoenDat {
    
     public  void grabar(Persona persona,File archivo) {

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(archivo, true);
            AddObject escritor = new AddObject(fos);
            escritor.writeObject(persona);

        } catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("no se pudo grabar el archivo");
        }

    }
    
}
