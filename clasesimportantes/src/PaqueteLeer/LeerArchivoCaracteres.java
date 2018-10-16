/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteLeer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class LeerArchivoCaracteres {

    private BufferedReader lector;

    /**
     * constructor: crea el objeto buffer desde el cual vamos a leer manteniendo
     * el puntero hasta usar el metodo cerrar
     *
     * @param file metemos el archivo del que vamos a leer los datos tenemos el
     * puntero al principio del archivo
     */
    public LeerArchivoCaracteres(File file) {

        try {
            FileReader fl = new FileReader(file);
            lector = new BufferedReader(fl);
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        }

    }

    /**
     * Cierra el buffer, perdemos la posicion del puntero
     */
    public void CerrarArchivo() {

        try {
            lector.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido cerrar el buffer, fallo metodo CerrarArchivo");
        }
    }

    /**
     * metodo que lee una linea del archivo y te devuelve un string devuelve un
     * null cuando ya no haya mas lineas
     * 
     * para leer todo el archivo: while ((cadena=lector.LeerLinea())!=null){
      orden a ejecutar con lo leido:  System.out.println(cadena);}
      * 
     * @return String el puntero al no cerrar el buffer se mantiene
     */
    public String LeerLinea() {
        String linea = "";
        try {
            linea = lector.readLine();
          return linea;
        } catch (IOException ex) {
            System.out.println("No se puede leer el archivo. Error en el metodo LeerLinea");
              return null;

        }

    }

    /**
     * metodo para leer numeros enteros que esten guardados uno por linea
     * 
     *  while((cadena=lector.LeerEntero())!=Integer.MIN_VALUE){
        
            System.out.println("cadena");
        }
     *
     * @return int
     */
    public int LeerEntero() {
        int numero;
        try {
            numero = Integer.parseInt(lector.readLine());
            return numero;
        } catch (IOException ex) {
            System.out.println("no se puede leer el archivo,error en el metodo LeerEntero");
            return Integer.MIN_VALUE;
        } catch (NumberFormatException ex) {
            System.out.println("se ha acabado de leer el archivo");
            return Integer.MIN_VALUE;
        }

    }

    /**
     * comprueba el largo del archivo y repite el bucle ese numero de veces
     * int i;
       * for (i = 0; i < archivo.length(); i++) {
            System.out.print(lector.LeerChar());
        }
        System.out.println("");
     * @return caracter
     */
    public char LeerChar() {
        char caracter = '\0';

        try {
            caracter = (char) lector.read();
              return caracter;
        } catch (IOException ex) {
            System.out.println("fallo al leer el archivo, error en el metodo LeerChar");
           return  '\0'; 
        }
       

    }

    /**
     * 
     *
     * @return float
     */
    public float LeerFloat() {
        float numero;
        try {

            numero = Float.parseFloat(lector.readLine());
            return numero;
        } catch (IOException ex) {
            System.out.println("no se puede leer el archivo,error en el metodo LeerEntero");
            return Float.MIN_VALUE;
        } catch (NumberFormatException ex) {
            System.out.println("El dato leido no puede convertirse en float");
            return Float.MIN_VALUE;
        }

    }

    /**
     * 
     *
     * @return double
     */
    public double leerDouble() {
        String cadena;
        double numero;

        try {
            cadena = lector.readLine();
            numero = Double.parseDouble(cadena);
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("error al introducir dato");
            return Double.MIN_VALUE; // valor más pequeño
        } catch (IOException ex) {
            System.out.println("Fallo al leer el archivo, error en el metodo leerdouble");
            return Double.MIN_VALUE;
        }
    }

    /**
     * metodo para leer numeros byte que esten guardados uno por linea devuelve
     * un -1 al final del archivo.
     *
     * @return byte
     */
    public byte leerbyte() {
        String cadena;
        byte numero;

        try {
            cadena = lector.readLine();
            numero = Byte.parseByte(lector.readLine());
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("error al introducir dato");
            return Byte.MIN_VALUE; // valor más pequeño
        } catch (IOException ex) {
            System.out.println("Fallo al leer el archivo, error en el metodo leerByte");
            return Byte.MIN_VALUE;
        }
    }

    /**
     * metodo para leer numeros long que esten guardados uno por linea devuelve
     * un -1 al final del archivo.
     *
     * @return long
     */
    public long leerLong() {
        String cadena;
        byte numero;

        try {
            cadena = lector.readLine();
            numero = Byte.parseByte(cadena);
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("error al introducir dato");
            return Byte.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Fallo al leer el archivo, error en el metodo leerByte");
            return Byte.MIN_VALUE;
        }
    }

    /**
     * metodo para leer numeros double que esten guardados uno por linea
     * devuelve un -1 al final del archivo.
     *
     * @return short
     */
    public short leerShort() {
        String cadena;
        short numero;

        try {
            cadena = lector.readLine();
            numero = Short.parseShort(cadena);
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("error al introducir dato");
            return Short.MIN_VALUE; // valor más pequeño
        } catch (IOException ex) {
            System.out.println("Fallo al leer el archivo, error en el metodo leerdouble");
            return Short.MIN_VALUE;
        }
    }
}
