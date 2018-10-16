
package Lecturas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa que lea cuantos caracteres se han leido por teclado
 * @author J
 */
public class CaracteresLeidosPorTeclado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int totalCaracteresLeidos = 0;
            int caracter;
            
            System.out.print("Empieza a escribir caracteres (INTRO para acabar): ");
            while ((caracter = (char) (System.in.read()))!='\n'){            
                totalCaracteresLeidos++;
            }
            System.out.println("Has introducido "+ totalCaracteresLeidos);
        } catch (IOException ex) {
            Logger.getLogger(CaracteresLeidosPorTeclado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
