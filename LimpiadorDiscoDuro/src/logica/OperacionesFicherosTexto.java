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

}
