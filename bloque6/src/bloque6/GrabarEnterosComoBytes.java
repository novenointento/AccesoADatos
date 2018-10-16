/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class GrabarEnterosComoBytes {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File numeros = new File("fichero.dat");
          FileOutputStream escritor = new FileOutputStream(numeros);  // si ponemos (numeros, true) abre el fichero ya existente y añade mas numeros
          
          
                
        for (int i = 0; i < 10; i++) {
           int num;
            num = (int) (Math.random() * 100);
            System.out.println("El numero es "+num);
            escritor.write(num);
        }
        escritor.close();
        
    }
    
}
