/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import PaqueteLeer.LeerTeclado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class Bloque6_2_1_GrabarObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        char continuar = 's';
       
        try {
            FileOutputStream fos = new FileOutputStream("C:/ficheros/Personas_mascotas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(fos);
            do {
                System.out.println("Introduzca el nombre");
                String nombre = LeerTeclado.leerCadena();
                System.out.println("Introduzca el apellido");
                String apellido = LeerTeclado.leerCadena();
                System.out.println("Introduzca la edad");
                int edad = LeerTeclado.leerInt();
                Persona uno = new Persona(nombre, apellido, edad);
                Mascota animal = new Mascota();
                System.out.println("Introduce el nombre de la mascota");
                animal.setNombre(LeerTeclado.leerCadena());
                System.out.println("Introduce el tipo de mascota");
                animal.setTipo_mascota(LeerTeclado.leerCadena());
                uno.setMascota(animal);
                System.out.println(uno.toString());
                escritor.writeObject(uno);
                System.out.println("Quieres continuar (s/n):");

            } while (((continuar = (char) System.in.read()) != 'n')
                    && ((continuar = (char) System.in.read()) != 'N'));
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido crear el archivo");
        } catch (IOException ex) {
            System.out.println("No se ha podido encapsular el objeto");

        }

    }

}
