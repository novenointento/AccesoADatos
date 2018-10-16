/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import Persona.PersonaEjemplo;
import java.util.Comparator;

/**
 *
 * @author silvia
 */
public class CompareTotalMayorAMenor implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int numP1 = ((PersonaEjemplo) o1).total();
        int numP2 = ((PersonaEjemplo) o2).total();
        if (numP1>numP2){
            return -1;
        }else if (numP1<numP2){
            return 1;
        }else{
            return 0;
        }
    }
}
