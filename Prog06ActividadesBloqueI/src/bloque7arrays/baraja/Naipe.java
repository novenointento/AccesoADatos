/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque7arrays.baraja;

/**
 *
 * @author gnord
 */
public class Naipe {

    private char palo;
    private String valor;
    private int valornum;

    public Naipe(char palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Naipe{" + "palo=" + palo + ", valor=" + valor + '}';
    }
    
    

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getValornum() {
        return valornum;
    }

    public void setValornum(int valornum) {
        this.valornum = valornum;
    }
    
    
}
