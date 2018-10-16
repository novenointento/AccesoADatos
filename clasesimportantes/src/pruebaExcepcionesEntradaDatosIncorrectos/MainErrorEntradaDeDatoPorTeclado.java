/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaExcepcionesEntradaDatosIncorrectos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rpe
 */
public class MainErrorEntradaDeDatoPorTeclado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int numero;
       
        try{
        System.out.println("Introduce un número :");
        numero = teclado.nextInt();
        //si introducimos letras dará una excepción InputMismatchException y rompe
        //para evitar esto usamos try ... catch ... gestionando esa excepción 
        //o alguna de nivel superior
        }
        catch (InputMismatchException  entrada){
            System.err.println("el número introducido es incorrecto, tiene valores no validos");
        }
    }
    
}
