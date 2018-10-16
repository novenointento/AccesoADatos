/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque7arrays.baraja;

/**
 *
 * @author gnord
 */
public class MainBaraja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Baraja naipes= new Baraja();
       Naipe carta;
       naipes.barajaFrancesa();
      
      carta= naipes.getBaraja()[(int)(Math.random()*52)];
        
        System.out.println(carta.toString());
        
    }
    
}
