/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05bloqueiii_excepciones;

/**
 *
 * @author rpe
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Ejer1MainExcepciones {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {

            try {
                System.out.print("Introduce un número entero, producirá error si metes un dato no numerico: ");
                InputStreamReader datosInsertados = new InputStreamReader(System.in);
                BufferedReader datos = new BufferedReader(datosInsertados);
                String cadenaDatos = datos.readLine();
                
                int numero = Integer.parseInt(cadenaDatos);
                int cuadrado = numero * numero;
                System.out.println("El cuadrado de " + numero + " = " + cuadrado);
                continuar = false;
            } catch (Exception e) {
                System.out.println("error en el dato de entrada " +e.getMessage());
            }
        };
    }
}

    

