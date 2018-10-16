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
public class Asignatura {
    private String nombre;
    private double eval1;
    private double eval2;
    private double eval3;
    

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEval1() {
        return eval1;
    }

    public void setEval1(double eval1) {
        this.eval1 = eval1;
    }

    public double getEval2() {
        return eval2;
    }

    public void setEval2(double eval2) {
        this.eval2 = eval2;
    }

    public double getEval3() {
        return eval3;
    }

    public void setEval3(double eval3) {
        this.eval3 = eval3;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", eval1=" + eval1 + ", eval2=" + eval2 + ", eval3=" + eval3 + '}';
    }
    public double media(){
        double media;
    return media=(eval1+eval2+eval3)/3.0;
    
    }
    
    
}
