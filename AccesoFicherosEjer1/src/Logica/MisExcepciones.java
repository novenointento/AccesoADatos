/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author gnord
 */
public class MisExcepciones  {
    
    
    
    public static class NoEsDirectorioNoSePuedeListar extends Exception{
    
        {System.out.println("No es un directorio");}
    
    }
    public static class CarpetaVacia extends Exception{}
    
 
        
     
   
    
}
