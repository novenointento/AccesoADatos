/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class LeerObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Persona persona;
            FileInputStream lector = new FileInputStream("objetos.dat");
            ObjectInputStream pantalla= new ObjectInputStream(lector);
           do{ 
               
               persona =(Persona)pantalla.readObject();
               System.out.println(persona.toString());
                   
                   }while (persona!=null);
           
           lector.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe");
        } catch (IOException ex) {
            System.out.println("Se ha acabado de leer el fichero");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LeerObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
