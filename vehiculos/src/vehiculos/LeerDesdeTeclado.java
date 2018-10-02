package vehiculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que gestiona la entrada de caracteres AscII desde teclado. Abre un
 * flujo de bytes con System.in que envuelve con InputStreamReader, almacenando
 * la informacion en el buffer mediante un BufferedReader, para devolverla
 * convertida en caracteres o lineas completas segun el metodo de lectura.
 *
 * @author Silvia Leon
 */
public class LeerDesdeTeclado {

    /**
     * Lee el primer char introducido cuando se pulsa Enter y lo devuelve. Si
     * hay algun problema muestra un mensaje de error y devuelve '\0'.
     *
     * @return El char que ha leido por teclado.
     */
    public static char leerChar() {
        char c = '\0';
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            c = (char) br.read();
        } catch (IOException e) {
            System.out.println("Error al leer el caracter: " + e.getMessage());
        }
        return c;
    }

    /**
     * Lee una cadena de texto hasta que se pulsa Enter y la devuelve.
     *
     * @return El String que ha leido por teclado.
     */
    public static String leerString() {
        String cadena = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            cadena = br.readLine();
            return cadena;
        } catch (IOException e) {
            System.out.println("Error al introducir el dato");
            return null;
        }
    }

    /**
     * Lee el int introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Integer.
     *
     * @return El int que ha leido por teclado.
     */
    public static int leerInt() {
        int numInt = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numInt = Integer.parseInt(br.readLine());
            return numInt;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al introducir el entero.");
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Lee el short introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Short.
     *
     * @return El short que ha leido por teclado.
     */
    public static short leerShort() {
        short numShort;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numShort = Short.parseShort(br.readLine());
            return numShort;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al introducir el número.");
            return Short.MIN_VALUE;
        }
    }

    /**
     * Lee el byte introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Byte.
     *
     * @return El byte que ha leido por teclado.
     */
    public static byte leerByte() {
        byte numByte;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numByte = Byte.parseByte(br.readLine());
            return numByte;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al introducir el número");
            return Byte.MIN_VALUE;
        }
    }

    /**
     * Lee el long introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Long.
     *
     * @return El long que ha leido por teclado.
     */
    public static long leerLong() {
        long numLong;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numLong = Long.parseLong(br.readLine());
            return numLong;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al introducir el número");
            return Long.MIN_VALUE;
        }
    }

    /**
     * Lee el float introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Float.
     *
     * @return El float que ha leido por teclado.
     */
    public static float leerFloat() {
        float numFloat = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numFloat = Float.parseFloat(br.readLine());
            return numFloat;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al introducir el número.");
            return Float.MIN_VALUE;
        }
    }

    /**
     * Lee el double introducido cuando se pulsa Enter y lo devuelve. Si hay algun
     * problema muestra un mensaje de error y devuelve el MIN_VALUE de Double.
     *
     * @return El double que ha leido por teclado.
     */
    public static double leerDouble() {
        double numDouble = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            numDouble = Double.parseDouble(br.readLine());
            return numDouble;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al introducir el número.");
            return Double.MIN_VALUE;
        }
    }

}
