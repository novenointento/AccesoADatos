package GrabaryLeerArchivoLibros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Biblioteca {

    public static void main(String[] args) {
        String fichero = "\\prog06BloqueIII\\Libros.txt";

        Libro libro=null;
        boolean fin = false;

        DataInputStream ficheroEntrada;
        DataOutputStream ficheroSalida;

        try {
            //creando flujo de salida
            ficheroSalida = new DataOutputStream(new FileOutputStream(fichero));
            //creando libros para grabar
            libro = new Libro(11111111, "Rimas y Leyendas", "Gustavo Adolfo Becker");
            libro.grabarLibro(ficheroSalida);
            System.out.println("Grabado libro1");

            libro = new Libro(22222222, "El Quijote", "Miguel de Cervantes");
            libro.grabarLibro(ficheroSalida);
            System.out.println("Grabado libro2");

            libro = new Libro(33333333, "La Colmena", "Camilo Jose Cela");
            libro.grabarLibro(ficheroSalida);
            System.out.println("Grabado libro3");

            ficheroSalida.flush(); //garantiza que se envia lo ultimo que habia en el filtro
            ficheroSalida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Leyendo fichero ");
        try {
            // bloque que lee los datos del libro
            //creamos el flujo de entrada
            ficheroEntrada = new DataInputStream(new FileInputStream(fichero));
            while (!fin){
                try {
                    libro.leerLibro(ficheroEntrada);
                } catch(EOFException ex){
                    System.out.println("fin de fichero");
                    fin=true;
                }
                catch (IOException ex) {
                    Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!fin) libro.mostarLibro();;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }

}
