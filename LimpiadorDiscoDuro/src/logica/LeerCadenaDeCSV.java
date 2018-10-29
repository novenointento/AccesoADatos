/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gnord
 */
public class LeerCadenaDeCSV {

    public static String Leercadenacsv(File file) {
        String cadena = null;
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            cadena = buffer.readLine();
            buffer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo, falla el metodo leercadenacsv");;
        } catch (IOException ex) {
            System.out.println("No se puede leer/escribir en el archivo, falla el metodo leercadenacsv");
        }

        return cadena;
    }
}
