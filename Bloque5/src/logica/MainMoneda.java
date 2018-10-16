/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Moneda;
import modelo.Persona;

/**
 *
 * @author gnord
 */
public class MainMoneda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Moneda peseta;
        Persona jugador1;
        byte contadorpj = 0;
        byte contadorpc = 0;
        String apuesta;

        peseta = new Moneda();

        System.out.println("Introduzca nombre del jugador");
        jugador1 = new Persona(Leer.leerCadena());

        while (contadorpj < 3 && contadorpc < 3) {
            peseta.tirarMoneda();
            
            System.out.println(jugador1.getNombre() + " Intenta adivinar la moneda, escriba cara o cruz!!!");
            apuesta = Leer.leerCadena();

            if (apuesta.equalsIgnoreCase(peseta.getCara())) {
                contadorpj++;
            } else {
                contadorpc++;
            }

        }
        if (contadorpj == 3) {
            System.out.println("Gana el jugador");
        } else {
            System.out.println("Gana el pc");
        }

    }

}
