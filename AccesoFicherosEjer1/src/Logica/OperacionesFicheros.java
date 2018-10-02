/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import static java.io.File.separatorChar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gnord
 */
public class OperacionesFicheros {

    /*
    i.	Si la ruta está vacia buscara en la raíz en función del  OS.
    ii.	Si ordenadosPorNombre es True  retornará los nombres y tamaño ordenados por tamaño.
    iii.	Si soloDirectorios es True  retornará solo los nombres de los directorios.
    iv.	Crear dos excepciones personalizadas CarpetaVacia y NoEsUnDirectorioNoSePuedeListar
    v.	Probar el correcto funcionamiento desde un método main().
    vi.	Generar Javadoc.*/
    public static List<File> listarFicheros(String ruta, boolean pornombre, boolean soloDirectorios) throws MisExcepciones.NoEsDirectorioNoSePuedeListar {
        if (ruta == null) {
            ruta = Character.toString(separatorChar);
        }
        File directorio = new File(ruta); // meto la ruta del file
        File[] arrayFicheros = directorio.listFiles(); //creo un array de files para guardar todos los file que tenga un directorio
        List<File> listaFicheros = Arrays.asList(arrayFicheros); //paso el array de files a una coleccion para ordenarla

        if (pornombre && !soloDirectorios) {
            listarFicherosNombre(listaFicheros);
        } else if (!pornombre && !soloDirectorios) {
            listarFicherosTamano(listaFicheros);
        } else if (!pornombre && soloDirectorios) {
            listarSoloDirectorios(listarFicherosTamano(listaFicheros));
        } else if (pornombre && soloDirectorios) {
            listarSoloDirectorios(listarFicherosNombre(listaFicheros));
        }

        return listaFicheros;

    }

    public static List<File> listarFicherosTamano(List<File> lista) {
        lista.sort((File fichero1, File fichero2) -> fichero1.length() < fichero2.length() ? 1 : -1);
        return lista;
    }

    public static List<File> listarFicherosNombre(List<File> lista) {

        lista.sort((File fichero1, File fichero2) -> fichero1.getName().compareTo(fichero2.getName()));

        return lista;
    }

    public static List<File> listarSoloDirectorios(List<File> lista) {
        List<File> directorios = new ArrayList<File>();
        for (File file : lista) {
            if (file.isFile()) {
                directorios.add(file);
            }
        }

        return directorios;
    }


    /*i.	Si la ruta de origen no existe salta una excepción.
ii.	Si el directorio existe salta una excepción.
iii.	Retorna el total de directorios creados.
iv.	Probar el correcto funcionamiento desde un método main().
v.	Generar Javadoc.*/
    public int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios) {

        int numero = 0;

        return numero;
    }

    /*i.	Si la ruta de origen existe salta una excepción.
ii.	Retorna el numero de ficheros modificados.
iii.	Probar el correcto funcionamiento desde un método main().
iv.	Generar Javadoc.*/
    public int cambiarExtensionFicheros(String ruta, String extensionAntigua, String extensionNueva) {

        int numero = 0;

        return numero;

    }

    public int cambiarExtensionFicheros(File ruta, String extensionAntigua, String extensionNueva) {

        int numero = 0;

        return numero;
    }

}
