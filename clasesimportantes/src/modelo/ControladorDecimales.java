/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author gnord
 */
public class ControladorDecimales {
    
    /**
     *Le das de entrada un float y lo devuelve con dos decimales
     * @param num
     * @return float
     */
    public static float DosDecimales(float num){
    DecimalFormat decimales = new DecimalFormat("0.00");
    String numeroC=decimales.format(num);
   float numero=Float.parseFloat(numeroC);
    
    
    return numero;
    }
    
}
