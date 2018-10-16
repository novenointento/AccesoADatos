
package GrabaryLeerArchivoLibros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Clase Libro para leer y grabar de un archivo sin usar serialización
 * @author J
 */
public class Libro {
    private long ISBN;
    private String titulo;
    private String autor;

    public Libro(long ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public void grabarLibro(DataOutputStream fichero) throws IOException{
        //las excepciones las cedemos al padre para que las gestione
        fichero.writeLong(ISBN);
        fichero.writeUTF(titulo);
        fichero.writeUTF(autor);
    }
    
     public void leerLibro(DataInputStream fichero) throws IOException{
        //las excepciones las cedemos al padre para que las gestione
        ISBN=fichero.readLong();
        titulo=fichero.readUTF();
        autor=fichero.readUTF();
    }
     
     public void mostarLibro(){
         System.out.println('\n');  
         System.out.println("ISBN: "+ISBN);  
         System.out.println("Titulo:"+ titulo);          
         System.out.println("Autor:"+ autor);     
     }

    public long getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
     
     
}
