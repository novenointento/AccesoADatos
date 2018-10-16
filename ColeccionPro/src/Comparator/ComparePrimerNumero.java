
package Comparator;

import Persona.PersonaEjemplo;
import java.util.Comparator;

/**
 *
 * @author silvia
 */
public class ComparePrimerNumero implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int numP1 = Integer.parseInt(((PersonaEjemplo) o1).getNumeros().get(0).toString());
        int numP2 = Integer.parseInt(((PersonaEjemplo) o2).getNumeros().get(0).toString());
        if (numP1>numP2){
            return 1;
        }else if (numP1<numP2){
            return -1;
        }else{
            return 0;
        }
    }
}
