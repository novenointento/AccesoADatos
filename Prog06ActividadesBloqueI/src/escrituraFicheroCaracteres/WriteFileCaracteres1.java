package escrituraFicheroCaracteres;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class WriteFileCaracteres1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter("c:/ficheros/datosCaracteres.txt");
            //tambien podríamos hacerlo con 
            //FileWriter file_character = new FileWriter("c:/ficheros/datosCaracteres.txt");
            //salida = new PrintWriter(file_character);
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
        } finally {         
            salida.close();
        }
    }
}
