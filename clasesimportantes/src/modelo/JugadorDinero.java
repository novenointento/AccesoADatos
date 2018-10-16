/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import PaqueteLeer.LeerTeclado;

/**
 *
 * @author gnord
 */
public class JugadorDinero {

    private final String nombre;
    private long dinero;

    /**
     *Crea a un jugador y le da una cantidad de dinero aleatoria entre 20 y 40
     */
    public JugadorDinero() {
        System.out.println("Introduzca el nombre del jugador");
        nombre = LeerTeclado.leerCadena();
        dinero = (byte) (Math.random() * 20 + 20);

    }

    /**
     *Resta uno por cada jugada que realiza
     */
    public void restardinero(){
    dinero=dinero-1;
    System.out.println("has gastado 1 euro, tienes "+dinero);
    }

    /**
     *Suma la cuantia del premio a la cantidad de dinero del jugador
     * @param premio
     */
    public void sumarpremio(byte premio){
    dinero=dinero+premio;
        System.out.println("Acumulas  "+dinero);
    }
}
