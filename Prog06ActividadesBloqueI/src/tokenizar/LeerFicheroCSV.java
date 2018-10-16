package tokenizar;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LeerFicheroCSV {

    /**
     * Programa que lee un fichero csv con titulo,autor, editorial
     * y muestre para cada línea del fichero dichos valores
     */
    
    public static void tokenizar(String linea){
        StringTokenizer tokens = new StringTokenizer(linea, ",");

        while(tokens.hasMoreTokens()){
            String titulo = tokens.nextToken() ;
            String autor = tokens.nextToken();
            String editorial = tokens.nextToken();
            String anio = tokens.nextToken();  //nextToken() siempre devuelve un String
            System.out.println("Titulo: "+titulo+"  Autor: "+ autor+" Editorial:" +editorial+" Año: "+anio);
        }
        
        
    }
   
    public static void main(String[] args) {
      
        FileReader fr = null;
        try {
            fr = new FileReader("c:/ficheros/libros.csv");
            BufferedReader registro = new BufferedReader(fr);
            //BufferedReader registro = new BufferedReader(new FileReader("c:/ficheros/libros.csv"));
            //leemos el primer registro
            String cadena = registro.readLine();
            while (cadena != null) {
                tokenizar(cadena);
                //leemos el siguiente registro
                cadena = registro.readLine();
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
