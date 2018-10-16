/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author gnord
 */
public class leer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int numAl = 0;
         
        try {
            // TODO code application logic here
            Persona persona;
            String nombreF;
           
            int opcionMenu;
          
          MenuConComprobacion menu = new MenuConComprobacion();

            menu.menu();

            opcionMenu = menu.Seguridad();

            if (opcionMenu == 1) {
                nombreF = "c:/ficheros/aprobados.dat";

            } else {
                nombreF = "c:/ficheros/suspensos.dat";
            }

            File archivo = new File(nombreF);
            FileInputStream lector = new FileInputStream(archivo);
            ObjectInputStream pantalla = new ObjectInputStream(lector);
            do {

                persona = (Persona) pantalla.readObject();
                System.out.println(persona.toString());
                numAl++;

            } while (persona != null);
          
            lector.close();

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("el numero de alumnos es "+numAl);
            System.out.println("Se ha acabado de leer el fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("fallo raro");
        }
    }

}
