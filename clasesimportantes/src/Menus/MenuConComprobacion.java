/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import PaqueteLeer.LeerTeclado;


/**
 *
 * @author gnord
 */
public class MenuConComprobacion {

    /**
     *Imprime las opciones del menu que queremos en el programa principal
     */
    public void menu() {
        System.out.println("Menu GESTION  \n");
        System.out.println("Selecciona una opcion: \n");
        System.out.println("Pulse 1 para ______\n");
        System.out.println("Pulse 2 para ______\n");
        System.out.println("Pulse 3 para ______\n");
        System.out.println("Pulse 0 para salir\n");
    }

    /**
     *comprueba que el valor introducido por teclado sea correcto y este entre los ofrecidos en el metodo menu
     * devuelve un byte que usaremos en el bucle del controlador para activar las distintas opciones
     * @return byte 
     */
    public byte Seguridad(){
      byte  menu=LeerTeclado.leerByte();
    do{
            if (menu <0&& menu > 3) {
                System.out.println("El numero introducido no es correcto");
                System.out.println("Intentelo de nuevo");
                menu=LeerTeclado.leerByte();
            }
        }while (menu <0&& menu > 3) ;
        return menu;
    
    }


}

