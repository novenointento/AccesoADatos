
package serializacion;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class SerializarGrabarObjetosEnFichero {
/**
 * Grabar informacion de objetos en un archivo
 */
  
    public static void main(String[] args)
    {
        SerializarGrabarObjetosEnFichero eyl = new SerializarGrabarObjetosEnFichero();
        eyl.escribeFichero("c:/ficheros/mascotas.dat");       
    }

    /**
     * Escribe en el fichero que se le pasa y empezandolo desde cero, 5 objetos
     * de la clase Persona.
     * @param fichero Path completo del fichero que se quiere escribir
     */
    public void escribeFichero(String fichero)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero,true)) ;
                for (int i = 0; i <3; i++)
                {
                    // ojo, se hace un new por cada Persona. El new dentro
                    // del bucle.
                    System.out.println("Persona"+i);
                    System.out.print("introduce nombre mascota:");
                    String nomMascota = LeerTeclado.leerCadena();
                    System.out.print("introduce tipo de mascota:");
                    String tipoMascota = LeerTeclado.leerCadena();
                    
                    Persona p = new Persona("nombre"+i, "apellido"+i, new Mascota(nomMascota,tipoMascota), i);
                    oos.writeObject(p);
                }
            
        }    catch (EOFException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
        
}
