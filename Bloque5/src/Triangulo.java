/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gnord
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 4;
     
        for(int contador= 0; contador<=x; contador++)
        {
            for(int espacios = x - 1; espacios >=contador; espacios-- )
            {
                System.out.print(" ");
            }
            for(int asteriscos= 0; asteriscos<= (1*contador + contador); asteriscos++)
            {
                System.out.print("*");
            }
            System.out.println();
    }
    
}
}