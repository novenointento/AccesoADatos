/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonaConArray;

import java.util.ArrayList;

/**
 *
 * @author gnord
 */
public class PersonaConArray {

    private ArrayList<Integer> array;
    private String nombre;
    private String apellido;
    
    
    

    public PersonaConArray() {
        this.array = array;
        array = new ArrayList();
        nombre= new String();
        apellido= new String();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return nombre + apellido + array + ",";
    }

    public void verListaNum() {
        for (Integer elemento : array) {
            System.out.print(elemento + ",");
        }
    }

}
