/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class BuscarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileInputStream lector = null;
        try {
            // TODO code application logic here
            int numero;
            lector = new FileInputStream("fichero.dat");
            
            
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } finally {
            try {
                lector.close();
            } catch (IOException ex) {
                System.out.println("No se puede escribir\\leer el archivo");
            }
        }
    }
    
}
