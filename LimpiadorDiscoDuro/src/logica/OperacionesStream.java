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
 *
 * @author daniel
 */
public class OperacionesStream {

    private FileInputStream in = null;
    private FileOutputStream out = null;

    /**
     * Metodo para leer el contenido de un fichero de texto
     *
     * @param archivo
     * @return string con el texto
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static String leerDeFile(File archivo) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        InputStreamReader in = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
        BufferedReader br = new BufferedReader(in);
        String texto = "";
        String linea = "";
        while ((linea = br.readLine()) != null) {
            texto = texto.concat(linea + "\n");
        }
        br.close();
        return texto;
    }

    public int contarChar(String cadena, char caracter) {
        int contador = 0;
        for (int x = 0; x < cadena.length(); x++) {

            contador++;

        }
        return contador;
    }

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

    public static Map<String, Integer> listarPalabras(String texto) {
        TreeMap<String, Integer> coleccion = new TreeMap<String, Integer>();
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

    public static String limpiadorTextos(String textoSucio) {
        String[] stringAlimpiar = {",", ".", ";", ":", "-", "¡", "¿", "'", "\""};
        for (String mierda : stringAlimpiar) {
            textoSucio.replace(mierda, " ");
        }
        return textoSucio;
    }

    public void codificadorTxt(File archivoCodificar, File archivoCodificado, String finaliza, int codificacion) throws FileNotFoundException, IOException {

        if (archivoCodificar.exists() && archivoCodificar.getName().endsWith(finaliza)) {
            try {
                in = new FileInputStream(archivoCodificar);
                out = new FileOutputStream(archivoCodificado);
                int c;

                while ((c = in.read()) != -1) {
                    out.write(c + codificacion);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        }
    }

    public void descodificadorTxt(File archivoCodificar, File archivoCodificado, String finaliza, int codificacion) throws IOException {

        codificacion = codificacion * -1;
        codificadorTxt(archivoCodificar, archivoCodificado, finaliza, codificacion);

    }

    public static Map contadorLetras(File archivo, String finaliza) throws FileNotFoundException, IOException {
        int k = 0;
        int v = 1;
        Map coleccion = new HashMap(k, v);
        InputStreamReader in = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
        if (archivo.exists() && archivo.getName().endsWith(finaliza)) {
            try {
                int c;
                while ((c = in.read()) != -1) {
                    if (coleccion.containsKey(c)) {
                        v = (int) coleccion.get(c);
                        v++;
                        coleccion.replace(c, v);
                        v = 1;
                    } else {
                        coleccion.put(c, v);
                    }
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
        return coleccion;
    }

    public void imprimirLetrasColeccion(File archivo, String finaliza) throws IOException {
        int k = 0;
        int v = 1;
        Map coleccion = new HashMap(k, v);
        coleccion = this.contadorLetras(archivo, finaliza);
        Iterator<Map.Entry<Integer, Integer>> it = coleccion.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();

            //  System.out.println(((char) (int) e.getKey()) + " " + e.getValue());
        }

    }

}
