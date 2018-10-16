/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Moneda;

/**
 *
 * @author gnord
 */
public class MainLanzardiezveces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Moneda peseta;

        peseta = new Moneda();
        byte numerodecaras = 0;

        Byte contador = 0;

        while (contador < 10) {
            peseta.tirarMoneda();
            if (peseta.getCara().equalsIgnoreCase("cara")) {
                numerodecaras++;
                contador++;
            } else {
                contador++;
            }
         
           
            
        }
 System.out.println("El juego a acabado han salido "+numerodecaras+" caras");
    }

}
