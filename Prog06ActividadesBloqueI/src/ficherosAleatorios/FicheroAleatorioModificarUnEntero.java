/*
 * Programa qeu permita introducir la posición de un número a modificar
 * se mostrar el numero antiguo y se pedira el nuevo por el que se sustituirá
 * grabándose posteriormente
 */
package ficherosAleatorios;

import deteccionTipoFichero.LeerTeclado;
import static ficherosAleatorios.FicheroAleatorioEnterosCrear.fichero;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class FicheroAleatorioModificarUnEntero {

    public static Scanner sc = new Scanner(System.in);
    public static RandomAccessFile fichero = null;

    public static void mostrarFichero() {
        int n;
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero
                System.out.print(n + " ");  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        int pos, numero;
        long size;
        char opcion;

        try {

            fichero = new RandomAccessFile("/ficheros/FileRandomAccesEnteros.txt", "rw");
            do {
                mostrarFichero();
                //calcular cuántos enteros tiene el fichero
                size = fichero.length();
                size = size / 4;
                System.out.println("El fichero tiene " + size + " enteros");

                //Modificar el entero que se encuentra en una posición determinada
                do {
                    System.out.println("Introduce una posición (>=1 y <= " + size + "): ");
                    pos = sc.nextInt();
                } while (pos < 1 || pos > size);

                pos--;  //la posición 1 realmente es la 0

                //nos situamos en la posición (byte de inicio) del entero a modificar
                //en Java un entero ocupa 4 bytes
                fichero.seek(pos * 4);

                //leemos y mostramos el valor actual
                System.out.println("Valor actual: " + fichero.readInt());

                //pedimos que se introduzca el nuevo valor
                System.out.println("Introduce nuevo valor: ");
                numero = sc.nextInt();

                //nos situamos de nuevo en la posición del entero a modificar
                //esto es necesario porque después de la lectura que hemos realizado para mostrar
                //el valor el puntero de lectura/escritura ha avanzado al siguiente entero del fichero.
                //si no hacemos esto escribiremos sobre el siguiente entero
                fichero.seek(pos * 4);

                //escribimos el entero
                fichero.writeInt(numero);
                mostrarFichero();
                System.out.println("Quieres continuar (s/n)");
                opcion = LeerTeclado.leerCaracter();
            } while (opcion != 'n');

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
