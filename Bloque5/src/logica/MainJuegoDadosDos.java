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
public class MainJuegoDadosDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    Persona jugador1;
        Persona jugador1;
        Persona jugador2;
        DadoCarasMultiple dadoj11;
        DadoCarasMultiple dadoj12;
        DadoCarasMultiple dadoj21;
        DadoCarasMultiple dadoj22;

        System.out.println("Introduzca el nombre del jugador uno");
        jugador1 = new Persona(Leer.leerCadena());

        System.out.println("Introduzca el nombre del jugador dos");
        jugador2 = new Persona(Leer.leerCadena());

        System.out.println("Introduzca el numero de caras del dado");
        Byte carasdado = Leer.leerByte();
        dadoj11 = new DadoCarasMultiple(carasdado);
        dadoj12 = new DadoCarasMultiple(carasdado);
        dadoj21 = new DadoCarasMultiple(carasdado);
        dadoj22 = new DadoCarasMultiple(carasdado);

        jugador1.setDado(dadoj11);
        jugador1.setDado2(dadoj12);
        jugador2.setDado(dadoj21);
        jugador2.setDado2(dadoj22);

        jugador1.getDado().tirarDado();
        jugador1.getDado2().tirarDado();
        jugador2.getDado().tirarDado();
        jugador2.getDado2().tirarDado();
        System.out.println("El jugador 1 a sacado " + jugador1.getDado().getNumero() + " y un " + jugador1.getDado2().getNumero());
        System.out.println("El jugador 2 a sacado " + jugador2.getDado().getNumero() + " y un " + jugador2.getDado2().getNumero());

        if (jugador1.getDado().getNumero() == jugador1.getDado2().getNumero() && jugador2.getDado().getNumero() != jugador2.getDado2().getNumero()) {
            System.out.println("\nGana el jugador 1");
        } else if (jugador2.getDado().getNumero() == jugador2.getDado2().getNumero() && jugador1.getDado().getNumero() != jugador1.getDado2().getNumero()) {
            System.out.println("\nGana el jugador2");
        } else if (jugador1.getDado().getNumero() != jugador1.getDado2().getNumero() && jugador2.getDado().getNumero() != jugador2.getDado2().getNumero()) {
            System.out.println("\nlos jugadores empatan");
        } else if (jugador1.getDado().getNumero() == jugador1.getDado2().getNumero() && jugador2.getDado().getNumero() == jugador2.getDado2().getNumero() && jugador1.getDado().getNumero() > jugador2.getDado().getNumero()) {
            System.out.println("Gana el jugador 1");
        } else if (jugador1.getDado().getNumero() == jugador1.getDado2().getNumero() && jugador2.getDado().getNumero() == jugador2.getDado2().getNumero() && jugador1.getDado().getNumero() < jugador2.getDado().getNumero()) {
            System.out.println("Gana el jugador 2");
        } else {
            System.out.println("\nLos jugadores empatan");
        }

    }

}
