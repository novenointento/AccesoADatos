/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque7arrays;



/**
 *
 * @author gnord
 */
public class MainArrayEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] cadenas = new String[4];
   int largo=0;
        String larga = "";

        for (int i = 0; i < cadenas.length; i++) {

            System.out.println("introduzca la cadena");
            cadenas[i] = LeerTeclado.leerCadena();

        }
        for (int i = 0; i < cadenas.length; i++) {

            System.out.println(cadenas[i]);
           
            if (cadenas[i].length() > cadenas[largo].length()) {

                largo=i;
            }

        }
        System.out.println(cadenas[largo]);
    }

}
