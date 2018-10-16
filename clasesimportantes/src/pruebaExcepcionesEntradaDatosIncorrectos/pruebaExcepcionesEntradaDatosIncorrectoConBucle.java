/*
 * si queremos obligarle a que si mete un número mal con caracteres
 * y que vuelva a intentarlo hasta que sea correcto el dato introducido
 */
package pruebaExcepcionesEntradaDatosIncorrectos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rpe
 */
public class pruebaExcepcionesEntradaDatosIncorrectoConBucle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num;
        
        do {
            Scanner teclado = new Scanner(System.in);

            try {
                System.out.println("Introduzca un numero");
                num = teclado.nextInt();
                break;
            } catch (InputMismatchException objetoExcepcion) {
                System.out.println("Exception que ha saltado: "+objetoExcepcion);
                System.out.println("El numero introducido es incorrecto!!!, intentelo de nuevo");
            }
        } while (true);


    }
}
