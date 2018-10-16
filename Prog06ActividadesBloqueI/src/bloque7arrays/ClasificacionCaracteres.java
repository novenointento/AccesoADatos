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
public class ClasificacionCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena;
        int vocales = 0;
        int consonantes = 0;
        int caracteres = 0;
        int numeros = 0;
        char lectura;

        System.out.println("introduzca la cadena a analizar ");
        cadena = LeerTeclado.leerCadena();
        cadena.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            lectura = cadena.charAt(i);

            if (lectura == 'a' || lectura == 'e' || lectura == 'i' || lectura == 'o' || lectura == 'u') {
                vocales++;
                System.out.println(lectura + " se suma una vocal");

            } else if (lectura > 'a' && lectura < 'z') {
                consonantes++;

                System.out.println(lectura + " se suma una consonante");

            } else if (lectura >= '0' && lectura <= '9') {

                numeros++;

                System.out.println(numeros + " se suma un numero");

            } else {
                caracteres++;
                System.out.println("se suma un caracter");
            }

        }

        System.out.println("hay " + vocales + " vocales");
        System.out.println("hay " + consonantes + " consonantes");
        System.out.println("hay " + numeros + " numeros");
        System.out.println("hay " + caracteres + " caracteres");
    }

}
