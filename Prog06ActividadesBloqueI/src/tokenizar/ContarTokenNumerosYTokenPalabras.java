
package tokenizar;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import sun.applet.Main;

public class ContarTokenNumerosYTokenPalabras {

/**
 * Contabilizar cuantas palabras y cuantos números hay en 
 * el fichero libros.csv
 */
    public static void contarPalabrasyNumeros(String nombre_fichero) {
        StreamTokenizer sTokenizer = null;
        int contapal = 0, numNumeros = 0;

        try {

            sTokenizer = new StreamTokenizer(new FileReader(nombre_fichero));

            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {

                if (sTokenizer.ttype == StreamTokenizer.TT_WORD)
                    contapal++;
                else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER)
                    numNumeros++;
            }

            System.out.println("Número de palabras en el fichero: " + contapal);
            System.out.println("Número de números en el fichero: " + numNumeros);

        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage()) ;
        } catch (IOException ex) {
           System.out.println(ex.getMessage()) ;
        }

    }

 
    public static void main(String[] args) {
         contarPalabrasyNumeros("c:/ficheros/libros.csv");
    }
}

    

