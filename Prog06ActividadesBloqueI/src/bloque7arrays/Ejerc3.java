/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloque7arrays;



/**
 *
 * @author gnord
 */
public class Ejerc3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena;
        StringBuffer lineas;
        char lectura;
        char busqueda;
        int contador = 0;

        System.out.println("introduzca la cadena a analizar ");
        cadena = LeerTeclado.leerCadena();
        cadena.toLowerCase();
        System.out.println("Introduzca la letra a buscar");
        busqueda = LeerTeclado.leerCaracter();
        lineas = new StringBuffer(cadena);

        for (int i = 0; i < cadena.length(); i++) {
            lineas.setCharAt(i, '-');
        }
        System.out.println(lineas);

        for (int w = 0; w < cadena.length(); w++) {
            lectura = cadena.charAt(w);
            System.out.println("esto es lo que lee el buffer " + lectura);
            if (lectura == busqueda) {

                lineas.setCharAt(contador, busqueda);

            }
            contador++;
        }
        System.out.println(lineas);
    }

}
