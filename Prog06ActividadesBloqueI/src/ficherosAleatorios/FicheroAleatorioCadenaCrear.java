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
public class FicheroAleatorioCadenaCrear {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void mostrarFichero() {
        try {
            String txt;
            fichero.seek(0);
            txt = fichero.readUTF(); //leemos la primera línea
            while(!txt.equalsIgnoreCase(null)){         //mientras no lleguemos al final del fichero
                System.out.print(txt + " ");  //se muestra en pantalla
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
           do {
                System.out.print("Introduce una palabra para añadir al final del fichero (FIN finaliza): ");
                txt = sc.nextLine(); //se lee la palabra a añadir en el fichero
                System.out.println(txt);
                if (!txt.equalsIgnoreCase("fin")) {
                    fichero.seek(fichero.length()); //nos situamos al final del fichero
                    fichero.writeUTF(txt);       //se escribe la palabra
                    System.out.println("grabado");
                }  
                mostrarFichero();//muestra el contenido del fichero después de añadir la palabra
            }while (!txt.equalsIgnoreCase("fin"));
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
