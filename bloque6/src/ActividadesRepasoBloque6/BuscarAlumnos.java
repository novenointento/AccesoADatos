/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

import PaqueteLeer.LeerTeclado;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author gnord
 */
public class BuscarAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String nombre;
        String apellido;
        Persona persona;
        String nombreF;
        int contador = 0;

        try {
            // TODO code application logic here
            System.out.println("introduzca el nombre de la persona a buscar");
            nombre = LeerTeclado.leerCadena();
            System.out.println("introduzca el apellido de la persona a buscar");
            apellido = LeerTeclado.leerCadena();
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
                if (persona.getNombre().equals(nombre) && persona.getApellido().equals(apellido)) {
                    contador++;
                    System.out.println(persona.toString());
                    System.out.println("no hay mas personas con ese nombre");

                }

            } while (persona != null);

            lector.close();

        }catch (EOFException ex) {
            if (contador==0)System.out.println("No se han encontrado resultados");
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
           
            System.out.println("Se ha acabado de leer el fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("fallo raro");
        }
    }

}
