package ficherosAleatorios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
* programa que cree un fichero aleatorio y permita ir grabando números 
*al final del fichero
 */
public class FicheroAleatorioEnterosCrear {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void mostrarFichero() {
        int n;
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero
                System.out.print(n+" ");  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        int numero=0;
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile("/ficheros/FileRandomAccesEnteros.txt", "rw");
            mostrarFichero(); //muestra el contenido original del fichero
            while (numero != -1){            
            System.out.print("Introduce un número entero para añadir al final del fichero (-1 finaliza): ");
            numero = sc.nextInt(); //se lee el entero a añadir en el fichero
            fichero.seek(fichero.length()); //nos situamos al final del fichero
            fichero.writeInt(numero);       //se escribe el entero
            mostrarFichero();//muestra el contenido del fichero después de añadir el número
            }
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
