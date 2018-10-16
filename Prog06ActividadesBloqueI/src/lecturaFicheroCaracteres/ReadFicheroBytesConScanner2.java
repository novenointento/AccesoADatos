
/*
* lectura de un fichero de bytes con Scanner
*/
package lecturaFicheroCaracteres;
   import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFicheroBytesConScanner2 {

    public static void main(String[] args) {
        File f = new File("c:/ficheros/datos2.txt");
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
        } finally{
            entrada.close();
        }  
    }
}  
