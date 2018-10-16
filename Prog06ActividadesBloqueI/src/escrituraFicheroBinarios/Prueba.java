package escrituraFicheroBinarios;

import deteccionTipoFichero.LeerTeclado;
import java.io.*;


public class Prueba {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        DataOutputStream salida = null;
        char n;

        try {
            //leemos datos de entrada por teclado y los escribimos en un fichero del objeto fos
            fos = new FileOutputStream("/ficheros/datos3.txt");
            salida = new DataOutputStream(fos);

            System.out.print("Introduce caracteres. INTRO para acabar: ");

           while ((n = LeerTeclado.leerCaracter())!= '\n') {
                //n = Leer.datoCaracter();
                System.out.println("has metido un "+n);
                //if (n !='\n'){
                    salida.writeChar(n); //se escribe el número entero en el fichero
                //}
            } ;
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
