/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6.numerosAleatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gnord
 */
public class NumAleatorioMain {

    public static void main(String[] args) {

        File archivocsv = new File("numeros.csv");//creo el archivo
        NumeroAleatorio numAl = new NumeroAleatorio();//clase numeros aleatorio
        int numero;
        String cadena;
        try {
            FileWriter escritor = new FileWriter(archivocsv);
            for (int i = 1; i <= numAl.generarFilas(); i++) {//genero el numero de filas
                for (int j = 1; j <= numAl.generarLargoFilas(); j++) { //genero que se imprime en cada fila

                    numero = numAl.generarNum();
                    System.out.print(numero); //lo visualizo
                    System.out.print(",");
                    cadena = String.valueOf(numero);
                    escritor.write(cadena);// lo guardo como cadena en el archivo
                    escritor.write(",");
                }
                escritor.write("\n"); //guardo el salto de linea de cada fila
                System.out.println("");//imprimo el salto entre las lineas

            }
            escritor.flush();//termino de grabar lo que quede en el buffer
            escritor.close();//cierro el archivo
            System.out.println("Se acabo de grabar el fichero");
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo");
        }

    }

}
