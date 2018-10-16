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
public class Ejerc13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File objetos = new File("objetos.dat");
        char continuar = 's';
        
        

        try {
            FileOutputStream fos = new FileOutputStream(objetos);
            ObjectOutputStream escritor = new ObjectOutputStream(fos);

            do {
                System.out.println("Introduzca el nombre");
               String nombre = LeerTeclado.leerCadena();
                System.out.println("Introduzca el apellido");
               String apellido = LeerTeclado.leerCadena();
                System.out.println("Introduzca la edad");
               int edad = LeerTeclado.leerInt();
               Persona uno = new Persona(nombre, apellido, edad);
                System.out.println(uno.toString());
                escritor.writeObject(uno);
                System.out.println("Quieres continuar (s/n):");

            } while (((continuar = (char) System.in.read()) != 'n')
                    && ((continuar = (char) System.in.read()) != 'N'));
            fos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("No se ha podido escribir el fichero");
        }

    }

}
