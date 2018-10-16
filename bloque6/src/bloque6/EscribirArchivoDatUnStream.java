/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import PaqueteLeer.LeerTeclado;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class EscribirArchivoDatUnStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File ejer9=new File("ejer9.dat");
         String cadena;
        try { 
            FileOutputStream escritor = new FileOutputStream(ejer9);
            DataOutputStream dat= new DataOutputStream(escritor);
            System.out.println("Introduzca la frase a guardar");
            cadena=LeerTeclado.leerCadena();
            dat.writeUTF(cadena);
         
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscribirArchivoDatUnStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscribirArchivoDatUnStream.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
                
        
    }
    
}
