/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author gnord
 */
public class DesgloseBilletes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float ingreso;
        byte billete500=0;
        byte billete200=0;
        byte billete100=0;
        byte billete50=0;
        byte billete20=0;
        byte billete10=0;
        byte billete5=0;
        byte moneda2e=0;
        byte moneda1e=0;
        byte moneda50ct=0;
        byte moneda20ct=0;
        byte moneda10ct=0;
        byte moneda5ct=0;
        byte moneda2ct=0;
        byte moneda1ct=0;
        double resto=0;
        boolean continuar = true;
        byte opcion=0;
        String cadena;

        while (continuar == true) {
            System.out.println("Introduzca la cantidad a desglosar");
            ingreso = Leer.leerFloat();
if(ingreso>0){
            billete500 = (byte) (ingreso / 500);
            resto = ingreso % 500;
            billete200 = (byte) (resto / 200);
            resto = resto % 200;
            billete100 = (byte) (resto / 100);
            resto = resto % 100;
            billete50 = (byte) (resto / 50);
            resto = resto % 50;
            billete20 = (byte) (resto / 20);
            resto = resto % 20;
            billete10 = (byte) (resto / 10);
            resto = resto % 10;
            billete5 = (byte) (resto / 5);
            resto = resto % 5;
            moneda2e = (byte) (resto / 2);
            resto = resto % 2;
            moneda1e = (byte) (resto / 1);
            resto = resto % 1;
            moneda50ct = (byte) (resto / 0.5);
            resto = (double) (resto % 0.5);
            moneda20ct = (byte) (resto / 0.2);
            resto = (double) (resto % 0.2);
            moneda10ct = (byte) (resto / 0.1);
            resto = (double) (resto % 0.1);
            moneda5ct = (byte) (resto / 0.05);
            resto = (double) (resto % 0.05);
            moneda2ct = (byte) (resto / 0.02);
            resto = (double) (resto % 0.02);
            moneda1ct = (byte) (resto / 0.01);
            
             //todo lo de las monedas
            System.out.println("Para introducir otra cantidad pulse 1");
            System.out.println("Para salir pulse 2");
            opcion = Leer.leerByte();
            continuar = opcion == 1;
            
            }else{
    System.out.println("La cantidad introducida es incorrecta, meta una cifra positiva");
}

            System.out.println("billetes de 500: " + billete500);
            System.out.println("billetes de 200: " + billete200);
            System.out.println("billetes de 100: " + billete100);
            System.out.println("billetes de 50: " + billete50);
            System.out.println("billetes de 20: " + billete20);
            System.out.println("billetes de 10: " + billete10);
            System.out.println("billetes de 5: " + billete5);
            System.out.println("monedas de 2€: " + moneda2e);
            System.out.println("monedas de 1€: " + moneda1e);
            System.out.println("monedas de 50ct: " + moneda50ct);
            System.out.println("monedas de 20ct: " + moneda20ct);
            System.out.println("monedas de 10ct: " + moneda10ct);
            System.out.println("monedas de 5ct: " + moneda5ct);
            System.out.println("monedas de 2ct: " + moneda2ct);
            System.out.println("monedas de 1ct: " + moneda1ct);

            System.out.println("resto " + resto);
//pintar asteriscos

}
           

        }
public static String pintarAsteriscos(byte numAsteriscosPintar){
String cadena="";
for (byte i=0;i<numAsteriscosPintar;i++){cadena+="*";}
return cadena;}

    

}
