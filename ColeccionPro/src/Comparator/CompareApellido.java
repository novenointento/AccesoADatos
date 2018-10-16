package Comparator;

import Persona.PersonaEjemplo;
import java.util.Comparator;

/**
 *
 * @author silvia
 */
public class CompareApellido implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        PersonaEjemplo p1 = (PersonaEjemplo) o1;
        PersonaEjemplo p2 = (PersonaEjemplo) o2;
        return p1.getApellido().compareToIgnoreCase(p2.getApellido());
    }

}