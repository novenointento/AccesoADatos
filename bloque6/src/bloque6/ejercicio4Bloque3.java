/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gnord
 */
public class ejercicio4Bloque3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        FileOutputStream fos = null;

        File fichero = new File("caracteres.txt");
//creo el archivo
 
        //creo grabador de caracteres
        FileWriter grabador= new FileWriter(fichero);
        InputStreamReader entradaChar = new InputStreamReader(System.in);
        BufferedReader ent = new BufferedReader(entradaChar); 
        System.out.println("Introduzca la linea a leer");
        String cadena = ent.readLine();
        System.out.println(cadena);
        grabador.write(cadena);
        grabador.close();

    }
}
//alternativa
//creo un teclado con Scanner teclado=new Scanner.in();
    //creo un printwrite y le paso como parametro el archivo
// printwrtier.print(teclado.nextLine)