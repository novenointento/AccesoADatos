package serializacion;

import java.io.Serializable;

public class Persona implements Serializable
{
    public String nombre;
    public String apellido;
    public Mascota mascota;
    public int edad;

    public Persona(String nombre, String apellido, Mascota mascota, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mascota = mascota;
        this.edad = edad;
    }

   
    /** Método para que al meter esta clase en un System.out.println() salga
     * algo legible.
     */
    
   

    public String toString() {
        return nombre+" "+
                apellido+" de "+
                edad+" años tiene como mascota a "+
                mascota.nombre+" y es un "+
                mascota.tipo;
    }
}
