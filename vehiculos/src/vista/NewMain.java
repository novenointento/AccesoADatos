/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import vehiculos.Coche;
import vehiculos.MisExcepciones;

/**
 *
 * @author gnord
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        
        Coche coche=new Coche(50,"matricula","diesel");
        while(true){
            try {
                coche.repostar(10, "diesel");
                System.out.println(coche.getLitrosDeposito());
                coche.repostar(11, "diesel");
                System.out.println(coche.toString());
                break;
            } catch (MisExcepciones.ErrorRepostaje ex) {
                System.out.println("No puedes :=C");
               
            }
        
        }
      
    }
    
}
