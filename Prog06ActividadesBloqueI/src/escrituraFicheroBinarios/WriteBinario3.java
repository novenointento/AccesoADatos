package escrituraFicheroBinarios;

import java.io.*;
import java.util.*;

public class WriteBinario3 {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            //leemos datos de entrada por teclado y los escribimos en un fichero del objeto fos
            fos = new FileOutputStream("/ficheros/datos2.txt",true);
            salida = new DataOutputStream(fos);

            System.out.print("Introduce caracteres. INTRO para acabar: ");

            do {
                n = (char) System.in.read();
                if (n !='\n'){
                    salida.writeChar(n); //se escribe el número entero en el fichero
                }
            } while (n != '\n');
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
