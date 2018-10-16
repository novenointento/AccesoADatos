/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.DadoCarasMultiple;
import modelo.Persona;

/**
 *
 * @author gnord
 */
public class MainAdivinar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona jugador1;
        Persona jugador2;
        DadoCarasMultiple dado;
        byte apuesta1;
        byte apuesta2;
        byte tirada;
        byte diferencia1 = 0;
        byte diferencia2 = 0;

        System.out.println("Introduzca nombre del jugador 1");
        jugador1 = new Persona(Leer.leerCadena());

        System.out.println("Introduzca nombre del jugador 2");
        jugador2 = new Persona(Leer.leerCadena());
        System.out.println("Intente adivinar el numero del uno al cien");
        dado = new DadoCarasMultiple((byte) 100);

        dado.tirarDado();
        System.out.println(jugador1.getNombre() + " introduce tu numero");
        apuesta1 = Leer.leerByte();
        System.out.println(jugador2.getNombre() + " introduce tu numero");
        apuesta2 = Leer.leerByte();
        System.out.println("El numero era " + dado.getNumero());
        tirada = dado.getNumero();

        if (tirada > apuesta1) {
            diferencia1 = (byte) (tirada - apuesta1);
        } else if (tirada < apuesta1) {
            diferencia1 = (byte) (apuesta1 - tirada);
        } else if (tirada == apuesta1) {
            diferencia1 = 0;
        }

        if (tirada > apuesta2) {
            diferencia2 = (byte) (tirada - apuesta2);
        } else if (tirada < apuesta2) {
            diferencia2 = (byte) (apuesta2 - tirada);
        } else if (tirada == apuesta2) {
            diferencia2 = 0;
        }

        if (diferencia1 < diferencia2) {
            System.out.println("Gana " + jugador1.getNombre());
        } else if (diferencia2 < diferencia1) {
            System.out.println("Gana " + jugador2.getNombre());
        } else {
            System.out.println("Los jugadores empatan");
        }
    }

}
