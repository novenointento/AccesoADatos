package ficherosAleatorios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* programa que cree un fichero aleatorio y permita ir grabando números 
*al final del fichero
 */
public class FicheroAleatorioCadenaLeer {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void mostrarFichero() {
        try {
            String txt;
            fichero.seek(0);
            txt = fichero.readUTF(); //leemos la primera línea
            while(!txt.equalsIgnoreCase(null)){         //mientras no lleguemos al final del fichero
                System.out.println(txt );  //se muestra en pantalla
                txt = fichero.readUTF();  //se lee una palabra del fichero
            }                    
            
        } 
        catch (EOFException ex){
            System.out.println("");
        }
        catch (IOException ex) {
            System.out.println("Fichero no existe");
        }

    }
  

    public static void main(String[] args) {
        String txt = null;
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile("/ficheros/FileRandomAccesCadena.txt", "rw");
            mostrarFichero(); //muestra el contenido original del fichero
           
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
