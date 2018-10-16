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
public class MainJuegoDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creo las variables a usar
        Persona jugador1;
        Persona jugador2;
        DadoCarasMultiple dado;
        byte tiradajugador1;
        byte tiradajugador2;
        byte contador1=0 ;
        byte contador2=0 ;

        System.out.println("Introduzca nombre del jugador 1");
        jugador1 = new Persona(Leer.leerCadena());

        System.out.println("Introduzca nombre del jugador 2");
        jugador2 = new Persona(Leer.leerCadena());
        System.out.println("Introduce el numero de caras del dado");
        dado = new DadoCarasMultiple(Leer.leerByte());

        while (contador1 < 3 && contador2 < 3) {

            jugador1.setDado(dado);
            jugador1.getDado().tirarDado();
            tiradajugador1 = jugador1.getDado().getNumero();
            System.out.println(jugador1.getNombre() + " ha sacado un " + jugador1.getDado().getNumero());
            jugador2.setDado(dado);
            jugador2.getDado().tirarDado();
            tiradajugador2 = jugador2.getDado().getNumero();
            System.out.println(jugador2.getNombre() + " ha sacado un " + jugador1.getDado().getNumero());

            if (tiradajugador1 > tiradajugador2) {
                contador1++;
                System.out.println(jugador1.getNombre() + " suma un punto ");

            } else if (tiradajugador2 > tiradajugador1) {
                contador2++;
                System.out.println(jugador2.getNombre() + " suma un punto ");
            } else {
                System.out.println("los jugadores empatan");
            }

        }
        if (contador1 > contador2) {
            System.out.println("Gana " + jugador1.getNombre());
        } else {
            System.out.println("Gana " + jugador2.getNombre());
        }
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
    }

}
