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
public class Slot {
    private byte numero;
    
    /**
     *crea un numero aleatorio que podemos usar en lo que necesitemos entre 0 y 3
     * devuelve un byte
     * @return
     */
    public byte tirada(){
    numero= (byte) (Math.random() * 3 );
     return numero;}



    public Slot() {
    }

    public byte getNumero() {
        return numero;
    }
     
     
}
