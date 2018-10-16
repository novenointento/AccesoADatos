/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;

import java.io.IOException;

/**
 *
 * @author gnord
 */
public class CifradoDelCesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        OperacionesStream stream = new OperacionesStream();
        String finaliza = ".txt";
        File ficheroDesencriptado = new File("textoDesencriptado.txt");
        int numeroCodificacion = 15;
     
  stream.imprimirLetrasCodificadas(ficheroDesencriptado, finaliza);

    }

}
