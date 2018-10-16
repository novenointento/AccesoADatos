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
public class DadoCarasMultiple {

    private byte numero;
    private byte numcaras;
 

    public void tirarDado() {
        this.numero = (byte) (Math.random() * numcaras + 1);
     
    }

    public byte getNumero() {
        return numero;
    }

    public void setNumcaras(byte numcaras) {
        this.numcaras = numcaras;
    }

    public DadoCarasMultiple(byte numcaras) {
        this.numcaras = numcaras;
    }

    @Override
    public String toString() {
        return "DadoCarasMultiple{" + "numero=" + numero + ", numcaras=" + numcaras + '}';
    }

   
}
