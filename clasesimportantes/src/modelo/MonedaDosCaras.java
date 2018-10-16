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
public class MonedaDosCaras {

    private String cara;

    /**
     *guarda en la variable cara la cadena cara o cruz que podemos comparar con un 
     * moneda.getCara.equals() a la cadena que necesitemos
     */
    public void tirarMoneda() {
        byte numero = (byte) (Math.random() * 2);
        if (numero == 1) {
            cara = "cara";
            
        } else {
            cara = "cruz";
        }
    }

    public String getCara() {
        return cara;
    }

}
