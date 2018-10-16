/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import PaqueteLeer.LeerTeclado;

/**
 *
 * @author gnord
 */
public class Adivinarnumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numerorad;
        int numero = 101;
        numerorad = (int) (Math.random() * 100 + 1);
        System.out.println("Intenta adivinar un numero entre 1 y 100");

        while (numero != numerorad) {
            System.out.println("Introduce tu numero");
            numero = LeerTeclado.leerInt();
            if (numero < numerorad) {
                System.out.println("El numero que has ingresado es menor");
            } else if (numero > numerorad) {
                System.out.println("El numero ingresado es mayor");
            }

        }
        System.out.println("Has acertado el numero");
        System.out.println("El numero a adivinar era" + numerorad);

    }

}
