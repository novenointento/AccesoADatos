/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensores;

import java.util.ArrayList;

/**
 *
 * @author gnord
 */
public class Sensor {

    protected boolean encendido = false;
    protected int medicionInicial = 0;
    protected double medicionFinal;
    protected ArrayList<Integer> mediciones;

    public Sensor() {
        this.mediciones = new ArrayList<Integer>(10);
    }

    public void activar() {
        encendido = true;

    }

    public void desactivar() {
        encendido = false;
    }

    public int calcularValorInicial(int n, int m) {

        medicionInicial = (int) (Math.random() * m) + n;
        return medicionInicial;
    }

    public void calcularValores() {
    }

    public double calcularMedia() {
        double numero = 0;

        for (int i = 0; i < 10; i++) {
            numero = numero + mediciones.get(i);
        }
        medicionFinal = numero / 10;
        return medicionFinal;
    }

}
