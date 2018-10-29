/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daniel
 */
public class ControladorLimpiador {
private OperacionesFicheros opFich=new OperacionesFicheros();
    private File archivo;
    private List<File> coleccionArchivos;
    private static ControladorLimpiador gestor = null;

    private ControladorLimpiador() {

    }

    private synchronized static void createInstance() {
        if (gestor == null) {
            gestor = new ControladorLimpiador(); //crea una instance para llamar solo a un objeto de esta clase desde cualquier jdialog

        }
    }

    public static ControladorLimpiador getInstance() {
        if (gestor == null) {
            createInstance();
        }
        return gestor;
    }

    public void recogerColeccionFiles(File entrada) {
        archivo = entrada;

    }

    public void reiniciarBusqueda(){
   opFich.limpiarDirectorios();
    
    }
    public List<File> devolverColeccionArchivos(){
     return coleccionArchivos;
    }
public List<File>ordenarFiles(List archivos,boolean nombre,boolean directorio) {
    try {
        List<File> listaOrdenada;
        return listaOrdenada=opFich.listarFicheros(archivos, nombre, directorio);
    } catch (MisExceptions.RutaNoValida ex) {
        System.out.println("Error en el metodo ordenarFiles, clase controlador");
        return null;
    }


}
    public List<File> SeleccionarFilesRecursivamente() {

        try {
            coleccionArchivos=opFich.listarFicherosRecursivo(archivo);
            
            return coleccionArchivos;
        } catch (MisExceptions.RutaNoValida ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }

    }

}
