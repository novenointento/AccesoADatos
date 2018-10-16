/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.Serializable;

/**
 *
 * @author gnord
 */
public class Mascota implements Serializable {

    private String nombre;
    private String tipo_mascota;

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", tipo_mascota=" + tipo_mascota + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo_mascota() {
        return tipo_mascota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo_mascota(String tipo_mascota) {
        this.tipo_mascota = tipo_mascota;
    }

}
