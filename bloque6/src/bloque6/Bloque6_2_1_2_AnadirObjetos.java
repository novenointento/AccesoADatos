/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import PaqueteLeer.LeerTeclado;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class Bloque6_2_1_2_AnadirObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char continuar = 's';

        try {
            FileOutputStream fos = new FileOutputStream("C:/ficheros/Personas_mascotas.dat", true);
            AddObject escritor = new AddObject(fos);
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
