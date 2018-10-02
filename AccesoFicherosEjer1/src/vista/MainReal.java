/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Logica.MisExcepciones;
import Logica.OperacionesFicheros;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
   boolean ordenPorNombre=true;
   boolean soloDirectorios=true;
   
        try {
         
            System.out.println("Introduzca la ruta");
            ruta = LeerDesdeTeclado.leerString();
            List<File> archivo = new ArrayList();

            archivo = OperacionesFicheros.listarFicheros(ruta, true, true);

            for (File file1 : archivo) {
                System.out.println(file1.getName());
            }

        } catch (MisExcepciones.NoEsDirectorioNoSePuedeListar ex) {
            System.out.println("No se encuentra la ruta");
        }
    }

}
