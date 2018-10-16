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
public class Timbregenerico {

    private boolean sonido;

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }
    
    /**
     * si se cumple la condicion activa lo que esta dentro del if, sino imprime que no se pudo hacer
     * @param peso
     * @return
     */
    public boolean alarma(int valorAcomprobar) {
        if (valorAcomprobar>= 150) {
            sonido = true;
            System.out.println("Salta la alarma");
            return true;
            
        } else {
            sonido = false;
            System.out.println("El timbre no suena");
            return false;
        }

    }
}
