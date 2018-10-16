/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaEscritura;

import java.util.StringTokenizer;
import modelo.Persona;

/**
 *
 * @author gnord
 */
public class Tokenizar {
    
    /**
     *Le metemos una linea y nos devuelve un objeto
     * @param linea
     * @return
     */
    public  Persona tokenizar(String linea) {
        Persona persona = null;
        StringTokenizer tokens = new StringTokenizer(linea, ",");
        //como sabemos la estructura de la linea no nos hace falta el while
       
        String nom = tokens.nextToken();
        String apel = tokens.nextToken();
        String edad= tokens.nextToken();
        int edadnum = Integer.parseInt(edad.trim());
         //si tenemos problemas con una cifra por tener espacios la guaradamos en un string
        // y usamos el metodo string.trim que quita espacios delante y detras de la cadena
        persona = new Persona(nom, apel, edadnum);
        
        return persona;
//hay que acordarse de cerrar despues el archivo con un close
    }
    
}
//codigo para sumar los nueros de una linea, no se usan para objetos
// while (tokens.hasMoreTokens()){
//sumatokens+= Integer.parseInt(tokens.nextToken().trim());



