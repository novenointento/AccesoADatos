

import Comparator.CompareTotalMayorAMenor;
import Persona.ListaDeObjetos;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author silvia
 */
public class Main {

    public static void main(String[] args) {

        File ruta = new File("ArchivoDeTexto.csv");
        if (!ruta.exists()) {
            try {
                ruta.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ListaDeObjetos listaPersonas = new ListaDeObjetos();
        ListaDeObjetos listaAux = new ListaDeObjetos();
        
        // Leo las personas del fichero y las guardo en la coleccion
        listaPersonas.anadirObjetosDeFicheroCSV(ruta, ",");
        
        // Muestro  por pantalla las personas de la coleccion
        listaPersonas.verObjetosDeLista("\t");
        
        
        // busco las personas con nombre "pepe" y las guardo en la lista auxiliar
        System.out.println("\nBuscando...");
        listaAux.setLista(listaPersonas.buscarTodosConApellido("fernandez"));
        
        // Si la lista auxiliar no esta vacia (hay algun pepe), la muestro por pantalla 
        if(!listaAux.estaVacia()){
            System.out.println("Lista de Fernandez:");
            listaAux.verObjetosDeLista("\t");
        }else{
            System.out.println("No hay Fernandez");
        }
        
        // Ordeno los numeros de las personas y luego ordeno la lista por el primer numero
        listaPersonas.ordenarNumerosDePersonas();
        listaPersonas.ordenarLista(new CompareTotalMayorAMenor());
        
        System.out.println();
        listaPersonas.verObjetosDeLista("\t");
                
        // Grabo la coleccion en el fichero        
        listaPersonas.grabarObjetosEnFicheroCSV(ruta, ", ", false);

        
        
    }

}
