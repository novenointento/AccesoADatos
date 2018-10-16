/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class LeerArchivoDatUnString {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String cadena;
        FileInputStream lector = new FileInputStream("ejer9.dat");
        DataInputStream dis = new DataInputStream(lector);
        try {
            cadena=dis.readUTF();
            System.out.println(cadena);
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivoDatUnString.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
