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
public class LeerDatosComoByte {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int numero = 0;
        try ( // TODO code application logic here
                FileInputStream lector = new FileInputStream("fichero.dat")) {
            while ((numero = lector.read()) != -1) {

                System.out.println("el numero es " + numero);
            }
            lector.close();
        }

    }

}
