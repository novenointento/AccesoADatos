
package Comparator;

import Persona.PersonaEjemplo;
import java.util.Comparator;

/**
 *
 * @author silvia
 */
public class CompareMedia implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int numP1 = ((PersonaEjemplo) o1).media();
        int numP2 = ((PersonaEjemplo) o2).media();
        if (numP1>numP2){
            return 1;
        }else if (numP1<numP2){
            return -1;
        }else{
            return 0;
        }
    }
}
