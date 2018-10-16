package escrituraFicheroCaracteres;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WriteFileCaracteres2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;
        try {
            FileWriter file_character = new FileWriter("c:/ficheros/datosCaracteres.txt",true);
            salida = new PrintWriter(file_character);
            String cadena;
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
            salida.flush();//graba lo que queda en el buffer
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(WriteFileCaracteres2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {         
            salida.close();
        }
    }
}
