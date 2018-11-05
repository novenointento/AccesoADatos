/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *clase para el manejo de ficheros de texto
 * @author Daniel Regueiro
 */
public class OperacionesFicherosTexto {

    private FileInputStream lectorEntradaDatos = null;
    private FileOutputStream escritorFlujoDatos = null;

    /**
     * Metodo para leer el contenido de un fichero de texto
     *
     * @param archivo
     * @return string con el texto del archivo
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static String leerDeFile(File archivo) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        InputStreamReader in = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
        BufferedReader br = new BufferedReader(in);
        String texto = ""; //inicializo las variables sin nada dentro
        String linea = "";
        while ((linea = br.readLine()) != null) {
            texto = texto.concat(linea + "\n");
        }
        br.close();
        return texto;
    }

    /**
     * cuenta los char que tiene una cadena especificada
     *
     * @param cadenaAContar string donde queremos contar la letra especifica
     * @param caracter que queremos saber cuantas veces se repite en el texto
     * @return int con el numero de veces que se repite
     */
    public int contarChar(String cadenaAContar, char caracter) {
        int contadorletras = 0;
        for (int x = 0; x < cadenaAContar.length(); x++) {

            contadorletras++;

        }
        return contadorletras;
    }

    /**
     * lee frase a frase el contenido de un archivo de texto
     *
     * @param file de donde queremos leer el texto
     * @return
     */
    public static String leercadena(File file) {
        String cadena = null;
        try {
            FileInputStream lector = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(lector);

            cadena = dis.readUTF();

        } catch (IOException ex) {
            System.out.println("No se ha podido leer el archivo");
        }

        return cadena;
    }

    /**
     * metodo que lista el numero de palabras diferentes que aperece en un texto
     * y las veces que se repite cada una
     *
     * @param texto que queremos contar
     * @return map con las palabras y las veces que se repite
     */
    public static Map<String, Integer> listarPalabras(String texto) {
        TreeMap<String, Integer> coleccion = new TreeMap<>();
        texto = limpiadorTextos(texto);
        StringTokenizer troceador = new StringTokenizer(texto);

        while (troceador.hasMoreTokens()) {
            String palabra = troceador.nextToken().trim().toLowerCase();
            if (coleccion.containsKey(palabra)) {
                coleccion.replace(palabra, coleccion.get(palabra) + 1);
            } else {
                coleccion.put(palabra, 1);
            }

        }

        return coleccion;
    }

    /**
     * metodo para quitar de un texto simbolos que no pertenezcan a palabras,
     * para despues usar en el silabador o separador por palabras
     *
     * @param textoSucio con los simbolos que no queremos
     * @return string con el texto sin los simbolos
     */
    public static String limpiadorTextos(String textoSucio) {
        String[] stringAlimpiar = {",", ".", ";", ":", "-", "¡", "¿", "'", "\""};
        for (String mierda : stringAlimpiar) {
            textoSucio.replace(mierda, " ");
        }
        return textoSucio;
    }

    /**
     * codifica un archivo de texto moviento el valor de cada char con un numero
     * generado por con la palabra que se use como contraseña
     *
     * @param archivoCodificar
     * @param contasenya
     * @param decodificar
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void codificadorArchivosTexto(File archivoCodificar, String contasenya, boolean decodificar) throws FileNotFoundException, IOException {
        String rutaOriginal;
        rutaOriginal = archivoCodificar.getAbsolutePath();
        int claveCodificacion = 0;
        for (int i = 0; i < contasenya.length(); i++) {
            claveCodificacion = claveCodificacion + contasenya.charAt(i);
        }
        if (decodificar) {
            claveCodificacion = claveCodificacion * -1;
        }
        File archivoCodificado = new File(archivoCodificar.getParent() + "/codificado " + archivoCodificar.getName());
        if (archivoCodificar.exists()) {
            try {
                lectorEntradaDatos = new FileInputStream(archivoCodificar);
                escritorFlujoDatos = new FileOutputStream(archivoCodificado);
                int c;

                while ((c = lectorEntradaDatos.read()) != -1) {
                    escritorFlujoDatos.write(c + claveCodificacion);
                }
            } finally {
                if (lectorEntradaDatos != null) {
                    lectorEntradaDatos.close();
                }
                if (escritorFlujoDatos != null) {
                    escritorFlujoDatos.close();
                }
            }
        }
        archivoCodificar.delete();
        archivoCodificado.renameTo(new File(rutaOriginal));
    }

    /**
     * metodo que cuenta cuantas veces se repite cada letra en un texto
     *
     * @param archivoAContarLetras tipo texto
     * @param finaliza
     * @return coleccion map de letras y veces que se repite en el texto que le
     * metimos por parametro
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Map contadorLetras(File archivoAContarLetras, String finaliza) throws FileNotFoundException, IOException {
        int clave = 0;
        int valor = 1;
        Map coleccionLetrasYRepeticiones = new HashMap(clave, valor);
        InputStreamReader in = new InputStreamReader(new FileInputStream(archivoAContarLetras), "UTF-8");
        if (archivoAContarLetras.exists() && archivoAContarLetras.getName().endsWith(finaliza)) {
            try {
                int c;
                while ((c = in.read()) != -1) {
                    if (coleccionLetrasYRepeticiones.containsKey(c)) {
                        valor = (int) coleccionLetrasYRepeticiones.get(c);
                        valor++;
                        coleccionLetrasYRepeticiones.replace(c, valor);
                        valor = 1;
                    } else {
                        coleccionLetrasYRepeticiones.put(c, valor);
                    }
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
        return coleccionLetrasYRepeticiones;
    }

    /**
     * metodo para imprimir por consola las letras y veces que se repiten en el
     * metodo contador de letras
     *
     * @param archivo
     * @param finaliza
     * @throws IOException
     */
    public void imprimirLetrasColeccion(File archivo, String finaliza) throws IOException {
        int k = 0;
        int v = 1;
        Map coleccion = new HashMap(k, v);
        coleccion = this.contadorLetras(archivo, finaliza);
        Iterator<Map.Entry<Integer, Integer>> it = coleccion.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();
            System.out.println(((char) (int) e.getKey()) + " " + e.getValue());
        }

    }

}
