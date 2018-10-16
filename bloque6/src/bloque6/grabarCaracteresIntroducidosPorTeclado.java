/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class grabarCaracteresIntroducidosPorTeclado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileOutputStream fos=null;
        char caracter;
        try {
            fos=new FileOutputStream ("ficheroCaracteresBytes.dat");
            System.out.println("Introduce caracteres por teclado pulsa intro para fin");
            while((caracter=(char)System.in.read())!='\n'){
            fos.write(caracter);
                System.out.print(caracter);
            
            }
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(grabarCaracteresIntroducidosPorTeclado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
