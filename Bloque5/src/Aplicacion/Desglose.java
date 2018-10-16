/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import logica.Leer;

/**
 *
 * @author gnord
 */
public class Desglose {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero,unidades,decenas,centenas,millares;
        

        System.out.println("Introduzca un numero menor a 10000 para descomponer");
        numero = Leer.leerInt();

        if (numero <= 9999) {
            unidades=numero%10;
            decenas=((numero%100)-unidades)/10;
            centenas=((numero%1000)-decenas-unidades)/100;
            millares=((numero%10000)-centenas-decenas-unidades)/1000;
            System.out.println("el numero tiene:");
            System.out.println(unidades+" unidades");
            System.out.println(decenas+" decenas");
            System.out.println(centenas+" centenas");
            System.out.println(millares+" millares");

        } else {
            System.out.println("La cantidad introducida es incorrecta");
        }
    }

}
