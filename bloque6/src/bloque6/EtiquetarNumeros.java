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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class EtiquetarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        int numero;
        int numeroPares = 0;
        int numeroImpares = 0;
        int sumaPares = 0;
        int sumaImpares = 0;
        File fichpares = new File("pares.dat");
        File fichimpares = new File("impares.dat");
        try {

            FileInputStream lector = new FileInputStream("fichero.dat");
            FileInputStream lectorpares = new FileInputStream("pares.dat");
            FileInputStream lectorimpares = new FileInputStream("impares.dat");
            FileOutputStream pares = new FileOutputStream(fichpares);
            FileOutputStream impares = new FileOutputStream(fichimpares);

            while ((numero = lector.read()) != -1) {

                System.out.println("el numero es " + numero);
                if (numero % 2 == 0) {
                    numeroPares++;
                    sumaPares += numero;
                    pares.write(numero);
                }
                if (numero % 2 != 0) {

                    numeroImpares++;
                    sumaImpares += numero;
                    impares.write(numero);
                }
            }
            System.out.println("Los pares son: ");
            while ((numero = lectorpares.read()) != -1) {

                System.out.println(numero);
            }
            System.out.println("Los impares son: ");
            while ((numero = lectorimpares.read()) != -1) {

                System.out.println(numero);
            }
            lectorpares.close();
            lectorimpares.close();
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero no existe");

        } catch (IOException ex) {
            Logger.getLogger(EtiquetarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("el numero de pares es " + numeroPares);
        System.out.println("el numero de impares es " + numeroImpares);
        System.out.println("La suma de los pares es " + sumaPares);
        System.out.println("La suma de los impares es " + sumaImpares);

    }

}
