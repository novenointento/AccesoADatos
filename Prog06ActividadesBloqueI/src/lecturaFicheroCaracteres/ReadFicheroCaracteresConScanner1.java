
/*
* lectura de un fichero de caracteres con Scanner
*/
package lecturaFicheroCaracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFicheroCaracteresConScanner1 {

    public static void main(String[] args) {
        File f = new File("c:/ficheros/datosCaracteres.txt");
        String cadena;
        Scanner entrada = null;
        try {
            entrada = new Scanner(f);//abre el fichero
            while (entrada.hasNext()) { //devuelve true si hay un elemento
                cadena = entrada.nextLine(); //lee la linea completa
                System.out.println(cadena);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
    }
}
