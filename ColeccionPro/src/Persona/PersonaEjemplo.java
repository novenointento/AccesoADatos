package Persona;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author silvia
 */
public class PersonaEjemplo {

    private String nombre;
    private String apellido;
    private List numeros;

    
    public PersonaEjemplo() {
        numeros = new LinkedList();
    }
    
    public PersonaEjemplo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

public PersonaEjemplo(String nombre, String apellido, List  numeros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeros = numeros;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaEjemplo other = (PersonaEjemplo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.apellido);
        return hash;
    }

    @Override
    public String toString() {
        return "PersonaEjemplo{" + "nombre=" + nombre + ", apellido=" + apellido + ", numeros=" + numeros + '}';
    }

    public void setNumeros(List numeros) {
        this.numeros = numeros;
    }

    public List  getNumeros() {
        return numeros;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // NUMEROS
    
    public Integer total() {
        int total = 0;
        for (Object numero : numeros) {
            total += (Integer) numero;
        }
        return total;
    }

    public Integer media() {
        int total = 0;
        for (Object numero : numeros) {
            total += (Integer) numero;
        }
        return total / numeros.size();
    }

    public Integer mayor() {
        Integer mayor = (Integer) numeros.get(0);
        for (Object numero : numeros) {
            if (mayor < (Integer) numero) {
                mayor = (Integer) numero;
            }
        }
        return mayor;
    }
    
    public Integer menor() {
        Integer menor = (Integer) numeros.get(0);
        for (Object numero : numeros) {
            if (menor > (Integer) numero) {
                menor = (Integer) numero;
            }
        }
        return menor;
    }
    
    public void ordenarNumeros(){
        numeros.sort(null);
    }

}
