/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonaConArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author gnord
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<PersonaConArray> array = new ArrayList<PersonaConArray>();
        PersonaConArray p = new PersonaConArray();
        try {
            FileReader fr = null;

            fr = new FileReader("numero4.csv");
            BufferedReader registro = new BufferedReader(fr);

            String cadena = registro.readLine();

            while (cadena != null) {
                tokenizar(cadena, array);

                cadena = registro.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("no se puede leer el fichero");
        }
        for (PersonaConArray elemento : array) {
            System.out.print(elemento.getNombre());
            System.out.print(" ");
            System.out.print(elemento.getApellido());
            System.out.print(" ");
            elemento.verListaNum();
            System.out.println("");
        }

        
        
        FileWriter fw = null;
        try {
            fw = new FileWriter("nombres.csv");
            BufferedWriter fsalida = new BufferedWriter(fw);

            Iterator objetoIterator = array.iterator();
            while (objetoIterator.hasNext()) {
                p = (PersonaConArray) objetoIterator.next();

                fsalida.write(p.getNombre());
                fsalida.write(',' + p.getApellido());

                Iterator objIterator = p.getArray().iterator();
                while (objIterator.hasNext()) {
                    fsalida.write(',' + objIterator.next().toString());

                }
                fsalida.write("\n");
            }

        } catch (IOException ex) {
            System.out.println("No se ha podido grabar el archivo");
        }

    }

    public static void tokenizar(String linea, ArrayList array) {
        StringTokenizer tokens = new StringTokenizer(linea, ",");
        PersonaConArray gn = new PersonaConArray();
        gn.setNombre(tokens.nextToken());
        gn.setApellido(tokens.nextToken());
        while (tokens.hasMoreTokens()) {

            gn.getArray().add(Integer.parseInt(tokens.nextToken()));

        }
        array.add(gn);
    }

}
