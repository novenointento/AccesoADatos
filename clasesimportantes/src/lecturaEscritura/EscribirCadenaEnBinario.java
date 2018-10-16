/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaEscritura;

import PaqueteLeer.LeerTeclado;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author gnord
 */
public class EscribirCadenaEnBinario {

    public void EscribirPrimeraLinea(File file) {

        String cadena;
        try {
            FileOutputStream escritor = new FileOutputStream(file);
            DataOutputStream dat = new DataOutputStream(escritor);
            System.out.println("Introduzca la frase a guardar");
            cadena = LeerTeclado.leerCadena();
            dat.writeUTF(cadena);

        } catch (FileNotFoundException ex) {
            System.out.println("Error al buscar el archivo, falla el metodo escribirprimeralinea");
        } catch (IOException ex) {
            System.out.println("Error al leer/escribir el archivo, falla el metodo escribirprimeralinea ");
        }

    }

    public void EscribirMasLineas(File file) {

        String cadena;
        try {
            FileOutputStream escritor = new FileOutputStream(file, true);
            DataOutputStream dat = new DataOutputStream(escritor);
            System.out.println("Introduzca la frase a guardar");
            cadena = LeerTeclado.leerCadena();
            dat.writeUTF(cadena);

        } catch (FileNotFoundException ex) {
            System.out.println("Error al buscar el archivo, falla el metodo escribirmaslineas");
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo, falla el metodo escribirmaslinea");
        }

    }

}
