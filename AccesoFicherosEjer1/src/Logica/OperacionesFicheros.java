/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para el manejo de directorios
 *
 * @author Daniel Regueiro
 */
public class OperacionesFicheros {

    /**
     *
     * @param ruta meto la ruta que quiero filtrar, me falta hacer que busque en
     * raiz si la ruta es null
     * @param pornombre parametro boolean que hace ordenar por nombre la lista
     * de files
     * @param soloDirectorios solo lista los directorios,ignorando los archivos
     * @return devuleve la lista ordenada y con o sin archivos
     *
     */
    public static List<File> listarFicheros(String ruta, boolean pornombre, boolean soloDirectorios) throws MisExceptions.RutaNoValida {
        if ((ruta == null) || (ruta.equals(""))) {
            ruta = (File.separator.equals("/")) ? ("/") : ("c:");
        }
        File directorio = new File(ruta); // meto la ruta del file
        if (!directorio.exists()) {
            throw new MisExceptions.RutaNoValida("la Ruta no existe");
        }
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

    /**
     * metodo que usa internamente el metodo listarFicheros para ordenar por
     * tamaño
     *
     * @param lista
     * @return devuelve la lista ordenada por tamaño
     */
    public static List<File> listarFicherosTamano(List<File> lista) {
        lista.sort((File fichero1, File fichero2) -> fichero1.length() < fichero2.length() ? 1 : -1);
        return lista;
    }

    /**
     * metodo usado internamente por el metodo listarFicheros para ordenar por
     * nombre
     *
     * @param lista
     * @return una lista ordenada por nombre
     */
    public static List<File> listarFicherosNombre(List<File> lista) {

        lista.sort((File fichero1, File fichero2) -> fichero1.getName().compareTo(fichero2.getName()));

        return lista;
    }

    /**
     *
     * @param lista
     * @return
     */
    public static List<File> listarSoloDirectorios(List<File> lista) {
        List<File> directorios = new ArrayList<File>();
        for (File file : lista) {
            if (file.isFile()) {
                directorios.add(file);
            }
        }

        return directorios;
    }

    /**
     *
     * @param rutaOrigen ruta donde queremos crear la lista de directorios
     * @param listaDirectorios list con los directorios a crear
     * @return int numero de directorios creados
     * @throws MisExceptions.RutaYaExiste
     * @throws MisExceptions.RutaNoValida
     */
    public int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios) throws MisExceptions.RutaYaExiste, MisExceptions.RutaNoValida {
        int numero = 0;

        if (!rutaOrigen.exists()) {
            throw new MisExceptions.RutaNoValida("ruta no valida");

        } else {

            for (String listaDirectorio : listaDirectorios) {

                File directorio = new File(rutaOrigen.getPath() + listaDirectorio);
                if (!directorio.exists()) {
                    directorio.mkdir();
                    numero = numero + 1;
                }
            }
        }
        return numero;
    }

    /**
     *
     * @param ruta String con la ruta donde queremos buscar
     * @param extensionAntiguac String de la extension antigua
     * @param extensionNueva String de la extension que queremos
     * @return true si lo cambia, false si no lo hace
     * @throws MisExceptions.RutaNoValida
     */
    public boolean cambiarExtensionFichero(String ruta, String extensionAntigua, String extensionNueva) throws MisExceptions.RutaNoValida {
        return cambiarExtensionFichero(new File(ruta), extensionAntigua, extensionNueva);
    }

    /**
     *
     * @param ruta File con la ruta donde queremos buscar el archivo a modificar
     * @param extensionAntigua String con la extension a cambiar
     * @param extensionNueva String con la extension final
     * @return true si ha podido cambiarlo y false si no
     * @throws MisExceptions.RutaNoValida
     */
    public boolean cambiarExtensionFichero(File ruta, String extensionAntigua, String extensionNueva) throws MisExceptions.RutaNoValida {

        if (!ruta.exists()) {
            throw new MisExceptions.RutaNoValida();
        }
        if (ruta.getName().endsWith(extensionAntigua)) {
            ruta.getName().replace(extensionAntigua, extensionNueva);       
            return true;
        }
        return false;
    }

}
