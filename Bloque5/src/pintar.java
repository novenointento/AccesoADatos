/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gnord
 */
public class pintar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int altura = 5;
        int base = 7;

        for (int a = 1; a <= altura; a++) {
            for (int b = 1; b <= base; b++) {
                System.out.print("*");
            }
            System.out.println("");

        }

        for (int a = 1; a <= altura; a++) {
            for (int b = 1; b <= base; b++) {
                if ((b == 1) || (a == 1) || (b == base) || (a == altura)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
        
        
        
        
        

    }

}
