/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para el manejo de directorios
 *
 * @author Daniel Regueiro
 */
public class OperacionesFicheros {
private ArrayList directorios= new ArrayList();
 
    /**
     *
     * @param ruta meto la ruta que quiero filtrar
     * @param pornombre parametro boolean que hace ordenar por nombre la lista
     * de files
     * @param soloDirectorios solo lista los directorios,ignorando los archivos
     * @return devuleve la lista ordenada y con o sin archivos
     *
     */
    public List<File> listarFicheros(List listaFicheros, boolean pornombre, boolean soloDirectorios) throws MisExceptions.RutaNoValida {
        
    if (pornombre && !soloDirectorios) {
    listaFicheros=listarFicherosNombre(listaFicheros);
    }  else if (!pornombre && soloDirectorios) {
    listaFicheros=listarSoloDirectorios(listarFicherosTamano(listaFicheros));
    } else if (pornombre && soloDirectorios) {
    listaFicheros=listarSoloDirectorios(listarFicherosNombre(listaFicheros));
    }
    
    return listaFicheros;
    }
    /**
     *
     *
     * @param lista
     * @return devuelve la lista ordenada por tamaño
     */
    public List<File> listarFicherosTamano(List<File> lista) {
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
    public  List<File> listarFicherosNombre(List<File> lista) {

        lista.sort((File fichero1, File fichero2) -> fichero1.getName().compareTo(fichero2.getName()));

        return lista;
    }
/**
     *metodo usado internamente por el metodo listar ficheros para listar solo directorios
     * @param lista
     * @return
     */
    public List<File> listarSoloDirectorios(List<File> lista) {
        List<File> directorios = new ArrayList<File>();
        for (File file : lista) {
            if (file.isDirectory()) {
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
    public  boolean cambiarExtensionFichero(String ruta, String extensionAntigua, String extensionNueva) throws MisExceptions.RutaNoValida {
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
    public  boolean cambiarExtensionFichero(File ruta, String extensionAntigua, String extensionNueva) throws MisExceptions.RutaNoValida {

        if (!ruta.exists()) {
            throw new MisExceptions.RutaNoValida();
        }
        if (ruta.getName().endsWith(extensionAntigua)) {
            ruta.getName().replace(extensionAntigua, extensionNueva);
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void limpiarDirectorios(){
   
   directorios=new ArrayList();
   
   }

    //ejercicio 2
    public  ArrayList<File> listarFicherosRecursivo(File fichero) throws MisExceptions.RutaNoValida, IOException {
        
        for (File ficheroLeido : fichero.listFiles()) {
            if (ficheroLeido.isFile()) {
                directorios.add(ficheroLeido);
            } else if (ficheroLeido.isDirectory()) {
                directorios.add(ficheroLeido);
                listarFicherosRecursivo(ficheroLeido);
            }
        }

        return directorios;
    }
    
    
    public static String fechaCreacionArchivo(File file){
  
   

		BasicFileAttributes attrs;
		try {
		    attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
		    FileTime time = attrs.creationTime();
		    
		    String pattern = "yyyy-MM-dd HH:mm:ss";
		    SimpleDateFormat formateadorFecha = new SimpleDateFormat(pattern);
			
		    String fechaFormateada = formateadorFecha.format( new Date( time.toMillis() ) );

		   return  fechaFormateada ;
		} catch (IOException e) {
		    e.printStackTrace();
		}
    
    return "error en la fecha";
    
    
    }
}
