/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

/**
 *
 * @author gnord
 */
public class MisExcepciones  {
    
    
    
    public static class ErrorAceleracion extends Exception{
    
        {System.out.println("No se ha podido realizar la aceleracion");}
    
    }
    
    
   public static  class ErrorRepostaje extends Exception{

        public ErrorRepostaje(float litrosDeMas, float litrosRepostados) {
            super("no puedes hechar tanto, has repostado "+litrosRepostados);
        }
    
    
 
        
        
        
  }
       
   public static  class ErrorCombustible extends Exception{

        public ErrorCombustible() {
          //  super("el combustible no es el correcto");
        }
    
    
 
        
        
        
  }
   
    
}
