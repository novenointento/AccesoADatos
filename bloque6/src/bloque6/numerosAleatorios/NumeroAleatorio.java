/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6.numerosAleatorios;

/**
 *
 * @author gnord
 */
public class NumeroAleatorio {

    int numero;

    public NumeroAleatorio() {

    }

    /**
     * genera un numero aleatorio entre 1 y 50
     *
     * @return int
     */
    public int generarNum() {

        numero = (int) (Math.random() * 49 + 1);

        return numero;

    }

    /**
     * genera un numero aleatorio entre 1 y 20
     *
     * @return int
     */
    public int generarFilas() {

        numero = (int) (Math.random() * 19 + 1);

        return numero;

    }

    /**
     * genera un numero aleatorio entre 1 y 10
     *
     * @return int
     */
    public int generarLargoFilas() {

        numero = (int) (Math.random() * 9 + 1);

        return numero;

    }
}
