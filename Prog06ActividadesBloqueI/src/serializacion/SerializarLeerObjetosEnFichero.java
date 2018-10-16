
package serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class SerializarLeerObjetosEnFichero {
/**
 * Grabar informacion de objetos en un archivo
 */
  
    public static void main(String[] args)
    {
        SerializarLeerObjetosEnFichero eyl = new SerializarLeerObjetosEnFichero();
        eyl.leeFichero("c:/ficheros/mascotas.dat");
    }

       
    /**
     * Se leen todas las Persona en el fichero y se escriben por pantalla.
     * @param fichero El path completo del fichero que contiene las Persona.
     */
   
    public void leeFichero(String fichero)
    {
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            
            // Mientras haya objetos
            while (aux!=null)
            {
                if (aux instanceof Persona)
                    System.out.println(aux);
                aux = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException e1)
        {
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }
}


