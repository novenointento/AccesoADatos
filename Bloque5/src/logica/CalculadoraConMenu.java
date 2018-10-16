/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import modelo.Calculadora;

/**
 *
 * @author gnord
 */
public class CalculadoraConMenu {

    Calculadora calculadora;
    float num1;
    float num2;
    float resultado;
    int opcionMenu;

   public void menu() {
        System.out.println("Menu calculadora \n");
        System.out.println("Selecciona una opcion: \n");
        System.out.println("Pulse 1 para introducir valores\n");
        System.out.println("Pulse 2 para sumar\n");
        System.out.println("Pulse 3 para restar\n");
        System.out.println("Pulse 4 para multiplicar\n");
        System.out.println("Pulse 5 para dividir\n");
        System.out.println("Pulse 6 para salir\n");
        opcionMenu = Leer.leerInt();
        calculadora=new Calculadora();
    }

   
    public float cuentas() {
        while (opcionMenu != 6) {
            switch (opcionMenu) {
                case 1:
                    System.out.println("introduzca primer numero\n");
                    num1 = Leer.leerFloat();
                    calculadora.setNum1(num1);
                    System.out.println("introduzca segundo numero\n");
                    num2 = Leer.leerFloat();
                    calculadora.setNum2(num2);
                    System.out.println("introduzca operacion a realizar\n");
                    opcionMenu = Leer.leerInt();
                    
                    break;
                case 2:
                    resultado=calculadora.sumar();
                   
                    System.out.println("El resultado de sumar es " + resultado);
                    System.out.println("Pulse 6 para finalizar o uno para introducir nuevos numeros");
                    opcionMenu=Leer.leerInt();
                    break;
                case 3:
                    resultado=calculadora.resta();
                    System.out.println("El resultado de restar es " + resultado);
                    System.out.println("Pulse 6 para finalizar o uno para introducir nuevos numeros");
                    opcionMenu=Leer.leerInt();
                    break;
                case 4:
                    resultado=calculadora.multi();
                    System.out.println("El resultado de multiplicar es " + resultado);
                    System.out.println("Pulse 6 para finalizar o uno para introducir nuevos numeros");
                    opcionMenu=Leer.leerInt();
                    break;
                case 5:
                    resultado=calculadora.div();
                    System.out.println("El resultado de dividir es " + resultado);
                    System.out.println("Pulse 6 para finalizar o uno para introducir nuevos numeros");
                    opcionMenu=Leer.leerInt();
                    break;

            }

        }

        return resultado;
    }

}
