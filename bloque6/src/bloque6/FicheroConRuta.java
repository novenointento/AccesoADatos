/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author gnord
 */
public class FicheroConRuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File archivo= new File("\\C:\\Users\\gnord\\Desktop\\datos.dat");
        FileInputStream lector = new FileInputStream(archivo);
    }
    
}
