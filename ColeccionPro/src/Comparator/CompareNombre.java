package Comparator;

import Persona.PersonaEjemplo;
import java.util.Comparator;

/**
 *
 * @author silvia
 */
public class CompareNombre implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        PersonaEjemplo p1 = (PersonaEjemplo) o1;
        PersonaEjemplo p2 = (PersonaEjemplo) o2;
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }

}
