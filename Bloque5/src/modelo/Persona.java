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
public class Persona {
    String nombre;
    String adivinar;
    DadoCarasMultiple dado;
    DadoCarasMultiple dado2;

    public DadoCarasMultiple getDado2() {
        return dado2;
    }

    public void setDado2(DadoCarasMultiple dado2) {
        this.dado2 = dado2;
    }
    

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getAdivinar() {
        return adivinar;
    }

    public void setAdivinar(String adivinar) {
        this.adivinar = adivinar;
    }

    public DadoCarasMultiple getDado() {
        return dado;
    }

    public void setDado(DadoCarasMultiple dado) {
        this.dado = dado;
    }
   

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", adivinar=" + adivinar + ", dado=" + dado + '}';
    }

    
    
    
}
