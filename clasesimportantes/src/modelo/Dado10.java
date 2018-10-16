/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gnord
 */
public class Dado10 {

    private byte numero;
 
    /**
     *genera un numero aleatorio entre 1 y diez.
     */
    public void tirarDado() {
        this.numero = (byte) (Math.random() * 10 + 1);
    
    }

    public byte getNumero() {
        return numero;
    }

    
}
