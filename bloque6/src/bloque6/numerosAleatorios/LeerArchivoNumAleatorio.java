/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6.numerosAleatorios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author gnord
 */
public class LeerArchivoNumAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            FileReader lc = new FileReader("numeros.csv");
            BufferedReader lector = new BufferedReader(lc);
            int sumaLinea = 0;
            int cifra;
            int sumaTotal = 0;
            
            
            
            String linea = lector.readLine(); //leo la primera linea

            System.out.println(linea);// la imprimo

            while (linea != null) { // compruebo y ejecuto mientras queden lineas
                StringTokenizer tokens = new StringTokenizer(linea, ","); //trocea la linea y le dice la separacion es por coma
                while (tokens.hasMoreTokens()) { //se ejecuta mientras queden tokens en la linea
                    cifra = Integer.parseInt(tokens.nextToken()); //pasa el trozo de string a un int
                    sumaLinea = cifra + sumaLinea; //suma los int para conseguir el total de la linea

                }

                System.out.println("la linea suma " + sumaLinea); 
                linea = lector.readLine(); //leo una nueva linea
                if (linea != null) { //si no es null la imprimo y sigue el bucle, si es null sale 
                    System.out.println(linea);
                }
                sumaTotal += sumaLinea; //sumo la linea al total
                sumaLinea = 0; //pongo la linea a cero para guardar el valor de la nueva linea

            }
            System.out.println("La suma total es " + sumaTotal);
        } catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("no se puede leer el archivo");
        }

    }

}
