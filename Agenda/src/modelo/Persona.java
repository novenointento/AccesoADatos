/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;


/**
 *
 * @author gnord
 */
public class Persona implements Serializable, Comparable<Persona>  {

    private String nombre;
    private String apellidos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

    @Override
    public int compareTo(Persona t) {
      return  (nombre.compareTo(t.getNombre())) + (apellidos.compareTo(t.getApellidos()));
    }

  
    
}
