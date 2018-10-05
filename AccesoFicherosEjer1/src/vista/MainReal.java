/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Logica.MisExceptions;
import Logica.OperacionesFicheros;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class MainReal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = null;
        boolean ordenPorNombre = true;
        boolean soloDirectorios = true;

        List<File> archivo = new ArrayList();
        while (true) {
            try {
                System.out.println("Introduzca la ruta");
                ruta = LeerDesdeTeclado.leerString();
                archivo = OperacionesFicheros.listarFicheros(ruta, true, true);
                for (File file1 : archivo) {
                    System.out.println(file1.getName());
                }
            } catch (MisExceptions.RutaNoValida ex) {
               continue;
            } 
            break;
        }

    }

}
