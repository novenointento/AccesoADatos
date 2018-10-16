/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author gnord
 */
public class CopiarFile {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
      
        File fichOriginal = new File("descarga.png");
        File fichCopia =new File("destino.png");
        
        if(!fichOriginal.exists()){
            System.out.println("no existe el fichero"+fichOriginal.getName());
        }else{
        try{
            
        FileInputStream lector= new FileInputStream(fichOriginal);
        FileOutputStream escritor = new FileOutputStream(fichCopia);
        
        int byteAuxiliar;
            System.out.println("\n\tel fichero esta siendo copiado");
            while((byteAuxiliar=lector.read())!=-1){
            escritor.write(byteAuxiliar);
            }
            System.out.println("Se ha copiado con exito");
           lector.close();
           escritor.close();
        }catch (IOException ex){
     
        }
        
        
        
        
        
        
        } 
      
    }
    
}
