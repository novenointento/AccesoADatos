package deteccionTipoFichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * programa para detectar el tipo de fichero bien binario o de texto
 */
public class DetectarTipoFichero {

    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            // new input stream reader is created
            String nombreFichero;
            System.out.println("Introduce el nombre del fichero con la extension");
            nombreFichero = LeerTeclado.leerCadena();
            fis = new FileInputStream("C:/ficheros/"+nombreFichero);
            InputStreamReader isr = new InputStreamReader(fis);
            // the name of the character encoding returned
            String s = isr.getEncoding();
            System.out.print("Character Encoding: " + s);
            isr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DetectarTipoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DetectarTipoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DetectarTipoFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    

