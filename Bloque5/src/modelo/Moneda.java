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
public class Moneda {

    private String cara;

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
