/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class LeerAlumnos {

    BufferedReader buffer;

    public LeerAlumnos(File file) {

      
        try {
            
              InputStreamReader isr;
       
            isr = new InputStreamReader(new FileInputStream(file));
              buffer = new BufferedReader(isr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

    public String Leercadenacsv() {
        
        try {
String cadena = null;
            cadena = buffer.readLine();
            
            return cadena;
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo, falla el metodo leercadenacsv");
            return null;
        } catch (IOException ex) {
            System.out.println("No se puede leer/escribir en el archivo, falla el metodo leercadenacsv");
            return null;
        }

    }
    
    public  Persona tokenizar(String linea) {
        Persona persona = null;
        StringTokenizer tokens = new StringTokenizer(linea, ",");
        //como sabemos la estructura de la linea no nos hace falta el while
       
        String nom = tokens.nextToken();
        String apel = tokens.nextToken();
        String not1= tokens.nextToken();
        String not2= tokens.nextToken();
        String not3= tokens.nextToken();
        int nota1 = Integer.parseInt(not1.trim());
        int nota2 = Integer.parseInt(not2.trim());
        int nota3 = Integer.parseInt(not3.trim());
         //si tenemos problemas con una cifra por tener espacios la guaradamos en un string
        // y usamos el metodo string.trim que quita espacios delante y detras de la cadena
        persona = new Persona(nom, apel, nota1, nota2, nota3);
        
        return persona;
//hay que acordarse de cerrar despues el archivo con un close
}
}