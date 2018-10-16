/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import PaqueteLeer.LeerTeclado;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class BuscarPorNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Persona persona;
        String consulta;
        int coincidencias = 0;
        try {
            FileInputStream lector = new FileInputStream("c:/ficheros/Personas_mascotas.dat");
            ObjectInputStream pantalla = new ObjectInputStream(lector);

            System.out.println("Introduzca el dato a buscar");
            consulta = LeerTeclado.leerCadena();

            do {

                persona = (Persona) pantalla.readObject();
                if (persona.getNombre().equals(consulta)) {
                    System.out.println(persona.toString());
                }
                if (persona.getNombre().equals(consulta)) {
                    coincidencias++;
                }

            } while (persona != null);
            lector.close();

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no exite");
        } catch (IOException ex) {
            System.out.println("Se han encontrado " + coincidencias + " coincidencias");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarPorNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
