/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para el manejo de ficheros
 *
 * @author Daniel Regueiro
 */
public class OperacionesFicheros {

    private File fichero;
    private PrintWriter escritorEndisco;
    private ArrayList directorios = new ArrayList();
    private FileOutputStream escritorFlujoDatos = null;
    private FileInputStream lectorEntradaDatos = null;

    public OperacionesFicheros(File fichero) {
        this.fichero = fichero;
    }

    public OperacionesFicheros() {
    }

    /**
     * lista los ficheros en una coleccion y los ordena por nombre
     *
     * @param listaFicheros
     * @param ordenarPornombre parametro boolean que hace ordenar por nombre la
     * lista de files
     * @param listarSoloDirectorios solo lista los directorios,ignorando los
     * archivos
     * @return devuleve la lista ordenada y con o sin archivos
     * @throws logica.MisExceptiones.RutaNoValida
     *
     */
    public List<File> listarFicheros(List listaFicheros,  boolean listarSoloDirectorios) throws MisExceptiones.RutaNoValida {
         if (listarSoloDirectorios) {
            listaFicheros = listarSoloDirectorios(listaFicheros);
        }
        return listaFicheros;
    }

    /**
     * metodo usado internamente por el metodo listar ficheros para listar solo
     * directorios
     *
     * @param lista
     * @return
     */
    public List<File> listarSoloDirectorios(List<File> lista) {
        List<File> listaDirectorios = new ArrayList<>();
        for (File file : lista) {
            if (file.isDirectory()) {
                listaDirectorios.add(file);
            }
        }
        return listaDirectorios;
    }

  

    /**
     * metodo que cambia la extension de un archivo recibiendo un string con la
     * ruta
     *
     * @param ruta String con la ruta donde queremos modificar el archivo
     * @param extensionAntigua
     * @param extensionNueva String de la extension que queremos
     * @return true si lo cambia, false si no lo hace
     * @throws logica.MisExceptiones.RutaNoValida
     */
    public boolean cambiarExtensionFichero(String ruta, String extensionAntigua, String extensionNueva) throws MisExceptiones.RutaNoValida {
        return cambiarExtensionFichero(new File(ruta), extensionAntigua, extensionNueva);
    }

    /**
     * metodo que cambia la extension de un fichero recibiendo un file
     *
     * @param rutaArchivoACambiar File con la ruta donde queremos buscar el
     * archivo a modificar
     * @param extensionAntigua String con la extension a cambiar
     * @param extensionNueva String con la extension final
     * @return true si ha podido cambiarlo y false si no
     * @throws MisExceptiones.RutaNoValida
     */
    public boolean cambiarExtensionFichero(File rutaArchivoACambiar, String extensionAntigua, String extensionNueva) throws MisExceptiones.RutaNoValida {

        if (!rutaArchivoACambiar.exists()) {
            throw new MisExceptiones.RutaNoValida();
        }
        if (rutaArchivoACambiar.getName().endsWith(extensionAntigua)) {
            rutaArchivoACambiar.getName().replace(extensionAntigua, extensionNueva);
            return true;
        }
        return false;
    }

    /**
     * metodo que crea un array vacio de directorios, usado para limpiar la
     * tabla
     */
    public void limpiarDirectorios() {
        directorios = new ArrayList();
    }

    /**
     *
     * @param fichero
     * @return
     * @throws MisExceptiones.RutaNoValida
     * @throws IOException
     */
    public ArrayList<File> listarFicherosRecursivo(File fichero) throws MisExceptiones.RutaNoValida, IOException {
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

    /**
     * metodo que devuelve la fecha de creacion de un archivo
     *
     * @param file
     * @return string con la fecha formateada del archivo introducido
     */
    public static String fechaCreacionArchivo(File file) {
        BasicFileAttributes atributosDelFile;
        try {
            atributosDelFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime fechaDeCreacion = atributosDelFile.creationTime();
            String modeloDeLaFecha = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat formateadorFecha = new SimpleDateFormat(modeloDeLaFecha);
            String fechaFormateada = formateadorFecha.format(new Date(fechaDeCreacion.toMillis()));

            return fechaFormateada;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error en la fecha";
    }

    /**
     * copia un archivo de una ruta a otra
     *
     * @param rutaOrigen
     * @param rutaDestino
     * @return
     */
    public static boolean copiarArchivo(String rutaOrigen, String rutaDestino) {
        File origen = new File(rutaOrigen);
        File destino = new File(rutaDestino);
        if (origen.exists()) {
            try {
                InputStream lectorEntradaDatos = new FileInputStream(origen);
                OutputStream escritorSalidaDatos = new FileOutputStream(destino);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = lectorEntradaDatos.read(buffer)) > 0) {
                    escritorSalidaDatos.write(buffer, 0, len);
                }
                lectorEntradaDatos.close();
                escritorSalidaDatos.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Abre el flujo para grabar en el fichero. Si el fichero no existe lo crea,
     * si no puede devuelve un mensaje,
     *
     * @param anadir True para escribir la informacion al final de la existente,
     * False para sobrescribir.
     */
    public void abrirEscritorFlujoDatos(boolean anadir) {
        try {
            escritorEndisco = new PrintWriter(new FileWriter(fichero, anadir), true);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException ex) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }
    /**
     * Graba como caracteres en el fichero el valor del String introducido.
     * @param cadena El String que se quiere grabar en el fichero.
     */
    public void grabarEnDisco(String cadena) {
        escritorEndisco.print(cadena);
        escritorEndisco.flush();
    }

    /**
     * codifica un archivo de texto moviento el valor de cada char con un numero
     * generado por con la palabra que se use como contraseña
     *
     * @param archivoCodificar
     * @param contasenya
     * @param decodificar
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void codificadorArchivosTexto(File archivoCodificar, String contasenya, boolean decodificar) throws FileNotFoundException, IOException {
        String rutaOriginal;
        rutaOriginal = archivoCodificar.getAbsolutePath();
        int claveCodificacion = 0;
        for (int i = 0; i < contasenya.length(); i++) {
            claveCodificacion = claveCodificacion + contasenya.charAt(i);
        }
        if (decodificar) {
            claveCodificacion = claveCodificacion * -1;
        }
        File archivoCodificado = new File(archivoCodificar.getParent() + "/codificado " + archivoCodificar.getName());
        if (archivoCodificar.exists()) {
            try {
                lectorEntradaDatos = new FileInputStream(archivoCodificar);
                escritorFlujoDatos = new FileOutputStream(archivoCodificado);
                int c;
                while ((c = lectorEntradaDatos.read()) != -1) {
                    escritorFlujoDatos.write(c + claveCodificacion);
                }
            } finally {
                if (lectorEntradaDatos != null) {
                    lectorEntradaDatos.close();
                }
                if (escritorFlujoDatos != null) {
                    escritorFlujoDatos.close();
                }
            }
        }
        archivoCodificar.delete();
        archivoCodificado.renameTo(new File(rutaOriginal));
    }
}
