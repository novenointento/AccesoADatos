package Lecturas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa que grabe caracteres que se leen por teclado y los lea despues y los
 * cuente diciendo cuantos num, letras y caract espec.
 *
 * @author J
 */
public class GrabaryLeeryContarNumLetrCarctEsp {

    /**
     * @param args the command line arguments
     */
    public static void grabar(String nomFichero) {
        Scanner sc = new Scanner(System.in);
        FileOutputStream ficheroSalida = null;
        DataOutputStream filtroFicheroSalida = null;
        int n;

        try {
            //leemos datos de entrada por teclado y los escribimos en un fichero del objeto fos
            ficheroSalida = new FileOutputStream(nomFichero);
            filtroFicheroSalida = new DataOutputStream(ficheroSalida);
            
            System.out.print("Introduce número entero. INTRO para acabar: ");
            do {
                n = System.in.read();
                if ((char)n != '\n') {
                    filtroFicheroSalida.writeChar(n); //se escribe el número entero en el fichero
                }
            } while (n != '\n');
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ficheroSalida != null) {
                    ficheroSalida.close();
                }
                if (filtroFicheroSalida != null) {
                    filtroFicheroSalida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void leer(String nomFichero) {

        int n;
        FileInputStream ficheroEntrada = null;
        DataInputStream filtroFicheroEntrada = null;
        int totalCaracteres = 0;
        int totalNumeros = 0;
        int totalCaracterEspeciales = 0;
        boolean salir = false;
        try {
            ficheroEntrada = new FileInputStream(nomFichero);
            filtroFicheroEntrada = new DataInputStream(ficheroEntrada);//filtro

            //lectura del fichero
            while (!salir) {
                try {
                    n = filtroFicheroEntrada.readChar();
                    System.out.print(n);
                    if (n >= '0' && n <= '9') {
                        totalNumeros++;
                    } else if (((char) n >= 'a' && (char) n <= 'z') || ((char) n >= 'A' && (char) n <= 'Z')) {
                        totalCaracteres++;
                    } else {
                        totalCaracterEspeciales++;
                    }
                } catch (EOFException ex) {
                    salir = true;
                } catch (IOException ex) {
                    Logger.getLogger(GrabaryLeeryContarNumLetrCarctEsp.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GrabaryLeeryContarNumLetrCarctEsp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Finaliza accion de leer de archivo");
        System.out.println("Numeros " + totalNumeros);
        System.out.println("Letras " + totalCaracteres);
        System.out.println("Caracteres Especiales " + totalCaracterEspeciales);

    }

    public static void main(String[] args) throws IOException {

        String nomFichero = "\\prog06BloqueIII\\caracteres.txt";
        grabar(nomFichero);
        leer(nomFichero);

    }

}
