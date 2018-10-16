/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaEscritura;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class LeerCadenaDeBinario {
    
    //metodo para leer una cadena de un archivo binario que le pasaremos previamente
    public static String leercadena(File file){
        String cadena=null;
        try {
        FileInputStream lector = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(lector);
        
            cadena=dis.readUTF();
            
        } catch (IOException ex) {
            System.out.println("No se ha podido leer el archivo");
        }
        
        return cadena;
    }    
}
