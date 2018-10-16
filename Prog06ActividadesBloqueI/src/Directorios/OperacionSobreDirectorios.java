package Directorios;

import java.io.File;


/**
 * Programa que contiene métodos para comprobar, crear o borrar un directorio
 *
 */
public class OperacionSobreDirectorios {

    public boolean crearDirectorio(File fileNewDirectorio) {
        return fileNewDirectorio.mkdir();
    }

    public boolean comprobarSiExisteDirectorio(File fileDirectorio) {
        return fileDirectorio.isDirectory();
    }

    public boolean borrarDirectorio(File fileDirectorio) {
        return fileDirectorio.delete();
    }

    public int mostrarMenuOpcionesDirectorio() {
        int opcionMenu;
        do {
            System.out.println("1. Crear directorio");
            System.out.println("2. Comprobar si existe directorio");
            System.out.println("3. Borrar directorio");
            System.out.println("4. Salir");
            System.out.print("Introduce opción: ");
            opcionMenu = LeerTeclado.leerInt();
        } while (opcionMenu < 1 && opcionMenu > 43);
        return opcionMenu;
    }
}
