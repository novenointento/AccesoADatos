/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

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
        System.out.println("Pulse 1 para leer alumnos aprobados\n");
        System.out.println("Pulse 2 para leer alumnos suspensos\n");
       
       
    }

    /**
     *comprueba que el valor introducido por teclado sea correcto y este entre los ofrecidos en el metodo menu
     * devuelve un byte que usaremos en el bucle del controlador para activar las distintas opciones
     * @return byte 
     */
    public int Seguridad(){
      int  menu=LeerTeclado.leerInt();
    do{
            if (menu != 1 && menu != 2) {
                System.out.println("El numero introducido no es correcto");
                System.out.println("Intentelo de nuevo");
                menu=LeerTeclado.leerInt();
            }
        }while (menu != 1 && menu != 2) ;
        return menu;
    
    }
/* menu
    
    while (menu >= 1 && menu <= 3) {
            controlador1.menu();
            menu = controlador1.Seguridad();
            System.out.println("menu seleccionado " + menu);
            switch (menu) {
                case 1:
                    controlador1.subir();

                    break;
                case 2:
                    controlador1.bajar();
                    break;
                case 3:
                    controlador1.vercesta();
                    break;
                case 0:
                    System.out.println("Ha salido del programa");

            }*/

}

