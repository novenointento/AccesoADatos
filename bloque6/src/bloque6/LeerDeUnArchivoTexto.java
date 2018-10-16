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
public class LeerDeUnArchivoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int numero;
        char letra;
        String cadena="";
        FileInputStream lector = new FileInputStream("ejer10.txt");
        
       while ((numero =  lector.read()) != -1) {
          letra=(char)numero;
           System.out.print(letra);
           
       cadena=cadena+letra;
       }
        System.out.println("");
        System.out.println(cadena);
       
    }
    
}
