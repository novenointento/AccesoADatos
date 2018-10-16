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
public class Alumno {
    private String nombre;
    private Asignatura asig1;
    private Asignatura asig2;
    
    
    public void notaFinal(){
    double notaFinal;
    notaFinal=(asig1.media()+asig2.media())/2.0;
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getAsig1() {
        return asig1;
    }

    public void setAsig1(Asignatura asig1) {
        this.asig1 = asig1;
    }

    public Asignatura getAsig2() {
        return asig2;
    }

    public void setAsig2(Asignatura asig2) {
        this.asig2 = asig2;
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", asig1=" + asig1 + ", asig2=" + asig2 + '}';
    }
    
}
