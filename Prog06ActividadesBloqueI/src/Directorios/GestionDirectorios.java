/**
 * Programa qeu comprueba si existe el directorio
 *  C:\FICHERO y si no existe lo crea
 */
package Directorios;

import java.io.File;


public class GestionDirectorios {

    public static void main(String[] args) {
        String nombreDirectorio;
        int opcionMenu;

        OperacionSobreDirectorios objOperDirect = new OperacionSobreDirectorios();
        //otra opcion sería en vez de definir un objeto de esa clase, para trabajar con sus métodos
        //definir los métodos en la case como estáticos

        System.out.print("Introducir la ruta completa del directorio c:\\path -recordar poner \\\\ - :");
        nombreDirectorio = LeerTeclado.leerCadena();
        File fc = new File(nombreDirectorio);

        do {
            opcionMenu = objOperDirect.mostrarMenuOpcionesDirectorio();
            switch (opcionMenu) {
                case 1:
                    if (objOperDirect.crearDirectorio(fc)) {
                        System.out.println("directorio creado en " + nombreDirectorio);
                    }
                    else
                        System.out.println("directorio " + nombreDirectorio+" no se ha podido crear");
                    break;
                case 2:
                    if (objOperDirect.comprobarSiExisteDirectorio(fc)) {
                        System.out.println("El directorio " + nombreDirectorio + " existe");
                    } else {
                        System.out.println("El directorio " + nombreDirectorio + " NO existe");
                    }
                    break;
                case 3:
                    if (objOperDirect.comprobarSiExisteDirectorio(fc)) {
                        if (objOperDirect.borrarDirectorio(fc)) {
                            System.out.println("el directorio se ha borrado");
                        } else {
                            System.out.println("El directorio " + nombreDirectorio + " NO existe");
                        }
                    }
                    break;
            }
        }
            while (opcionMenu != 4);
        }

    }
