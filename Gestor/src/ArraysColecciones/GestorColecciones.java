package ArraysColecciones;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author silvia
 */
public class GestorColecciones {

    /**
     * Muestra todos los elementos de la coleccion (llamando a su metodo toString()), tantos en cada linea como se
     * indique, separados por la cadena de texto que se introduce como parametro.
     *
     * @param coleccion de tipo Collection, cuyos elementos se quieren visualizar por pantalla
     * @param separador de tipo String, que se mostrara entre los elementos.
     * @param elementosPorLinea de tipo int, el numero de elementos que se quieren visualizar en cada linea.
     */
    public void verColeccion(Collection coleccion, String separador, int elementosPorLinea) {
        int contador = 0;
        for (Object objeto : coleccion) {
            System.out.print(objeto.toString() + separador);
            contador++;
            if ((contador % elementosPorLinea) == 0) {
                System.out.print("\n");
            }
        }
    }

    /**
     * Convierte los elementos de una colleccion en Integer y los devuelve
     * dentro de otra coleccion en el orden en que estaban.
     *
     * @param coleccion de tipo List, con los elementos que se quieren convertir
     * a Integer.
     * @return de tipo List, con los elementos de tipo Integer.
     */
    public List convertirInteger(List coleccion) {
        List coleccionInt = new LinkedList();
        for (Object numero : coleccion) {
            coleccionInt.add(Integer.parseInt(numero.toString()));
        }
        return coleccionInt;
    }

    /**
     * Convierte los elementos de una colleccion en Float y los devuelve dentro
     * de otra coleccion en el orden en que estaban.
     *
     * @param coleccion de tipo List, con los elementos que se quieren convertir
     * a Float.
     * @return de tipo List, con los elementos de tipo Float.
     */
    public List convertirFloat(List coleccion) {
        List coleccionInt = new LinkedList();
        for (Object numero : coleccion) {
            coleccionInt.add(Float.parseFloat(numero.toString()));
        }
        return coleccionInt;
    }

    
    
    
}
