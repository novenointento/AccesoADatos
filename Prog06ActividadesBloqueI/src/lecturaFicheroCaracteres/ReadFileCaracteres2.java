//lectura fichero de texto de caracteres caracter a caracter
package lecturaFicheroCaracteres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCaracteres2 {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("c:/ficheros/datosCaracteres.txt");
            BufferedReader entrada = new BufferedReader(fr);
            int car = entrada.read();
            while (car != -1) {
                System.out.print((char) car);
                car = entrada.read(); //devuelve un int del caracter
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
