/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import PaqueteLeer.LeerTeclado;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class lineasAleatorias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File numeros= new File("numerosAleatorios.txt");
        String linea;
        try {
            FileWriter escritor= new FileWriter(numeros);
            
            System.out.println("escribir");
            linea=LeerTeclado.leerCadena();
            System.out.println(linea);
            escritor.write(linea);
            escritor.flush();
            escritor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(lineasAleatorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
