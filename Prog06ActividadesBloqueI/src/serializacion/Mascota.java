package serializacion;
import java.io.Serializable;

public class Mascota implements Serializable
{
    public String nombre;
    public String tipo;

    public Mascota(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
    
}
