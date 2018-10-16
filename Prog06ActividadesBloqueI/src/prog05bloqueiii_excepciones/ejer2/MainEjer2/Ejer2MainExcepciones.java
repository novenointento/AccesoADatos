/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05bloqueiii_excepciones.ejer2.MainEjer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import prog05bloqueiii_excepciones.ejer2.MainEjer2.MiExcepcionErrorEntradaNumero;

/**
 *
 * @author rpe
 */
public class Ejer2MainExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      boolean continuar = true;
        String cadenaDatos=null;
        InputStreamReader datosInsertados = new InputStreamReader(System.in);
        BufferedReader datos = new BufferedReader(datosInsertados);
        
        while (continuar) {
            try {
                System.out.print("Introduce un número entero entre 0  y 10,  F para finalizar: ");
                cadenaDatos = datos.readLine();

//convertimos la cadena en su correspondiente numero
                int numero = Integer.parseInt(cadenaDatos);

                if (numero < 0 || numero > 10) {
                    throw new MiExcepcionErrorEntradaNumero("numero fuera de rango");
                }

                System.out.println("El número está dentro del rango [0 - 10] : " + numero);

            } catch (MiExcepcionErrorEntradaNumero ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException e) {
                if (cadenaDatos.equals("Z")) {
                    System.out.println("Se finaliza el programa");
                    continuar = false;
                } else {
                    System.out.println("Error no es un valor numerico");
                }
            } catch (IOException ex) {
                Logger.getLogger(Ejer2MainExcepciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                System.out.println("se ha producir error no esperado " + ex.getMessage());
            }
        }

    }
    
}
