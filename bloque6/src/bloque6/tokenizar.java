/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class tokenizar {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Persona persona;
        String cadena;
        File archivo = new File("c:/ficheros/personas.csv");

        //sirve para leer del archivo de entrada
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
        //sirve para escribir en el fichero de salida
        File salidaPersonas = new File("Personas_salida.dat");

        FileOutputStream fos = new FileOutputStream("C:/ficheros/Personas_salida.dat");

        ObjectOutputStream escritor = new ObjectOutputStream(fos);

        try {
            while ((cadena = buffer.readLine()) != null) {

                // System.out.println(cadena);
                persona = tokenizar(cadena);
                System.out.println(persona.toString());
                int contador = 0;
                if (contador == 0) {
                    escritor.writeObject(persona);
                    contador++;
                } else {

                    grabar(persona);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(tokenizar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Persona tokenizar(String linea) {
        Persona persona = null;
        StringTokenizer tokens = new StringTokenizer(linea, ",");
        //como sabemos la estructura de la linea no nos hace falta el while
        String nom = tokens.nextToken();
        String apel = tokens.nextToken();
        int edad = Integer.parseInt(tokens.nextToken());
        //si tenemos problemas con una cifra por tener espacios la guaradamos en un string
        // y usamos el metodo string.trim que quita espacios delante y detras de la cadena
        persona = new Persona(nom, apel, edad);

        return persona;

    }

    public static void grabar(Persona persona) {

        FileOutputStream fos;
        try {
            fos = new FileOutputStream("C:/ficheros/Personas_salida.dat", true);
            AddObject escritor = new AddObject(fos);
            escritor.writeObject(persona);

        } catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("no se pudo grabar el archivo");
        }

    }

}
