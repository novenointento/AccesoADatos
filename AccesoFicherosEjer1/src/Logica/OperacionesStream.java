/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.util.Arrays.stream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class OperacionesStream {

    FileInputStream in = null;
    FileOutputStream out = null;

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

    public HashMap contadorLetras(File archivo, String finaliza) throws FileNotFoundException, IOException {
        int k = 0;
        int v = 1;
        HashMap coleccion = new HashMap(k, v);
        if (archivo.exists() && archivo.getName().endsWith(finaliza)) {
            try {
                in = new FileInputStream(archivo);
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

    public void imprimirLetrasCodificadas(File archivo, String finaliza) throws IOException {
        int k = 0;
        int v = 1;
        HashMap coleccion = new HashMap(k, v);

        coleccion = this.contadorLetras(archivo, finaliza);
        Iterator<Map.Entry<Integer, Integer>> it = coleccion.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();

            System.out.println(((char) (int) e.getKey()) + " " + e.getValue());
        }

    }

}
