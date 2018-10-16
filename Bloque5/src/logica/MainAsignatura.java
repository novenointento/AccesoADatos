/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Asignatura;

/**
 *
 * @author gnord
 */
public class MainAsignatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Asignatura asig1;
        Asignatura asig2;
        double media1;
        double media2;

        System.out.println("Introduce el nombre de la asignatura");
        asig1 = new Asignatura(Leer.leerCadena());

        System.out.println("Introduce la nota de la 1ª evaluacion");
        asig1.setEval1(Leer.leerDouble());
        System.out.println("Introduce la nota de la 2ª evaluacion");
        asig1.setEval2(Leer.leerDouble());
        System.out.println("Introduce la nota de la 3ª evaluacion");
        asig1.setEval3(Leer.leerDouble());

        media1 = asig1.media();
        System.out.println("LA media de " + asig1.getNombre() + " es " + media1);

        
        System.out.println("Introduce el nombre de la asignatura");
        asig2 = new Asignatura(Leer.leerCadena());

        System.out.println("Introduce la nota de la 1ª evaluacion");
        asig2.setEval1(Leer.leerDouble());
        System.out.println("Introduce la nota de la 2ª evaluacion");
        asig2.setEval2(Leer.leerDouble());
        System.out.println("Introduce la nota de la 3ª evaluacion");
        asig2.setEval3(Leer.leerDouble());

        media2 = asig2.media();
        System.out.println("LA media de " + asig2.getNombre() + " es " + media2);
        
        
     if (media1>media2){
         System.out.println("La mejor nota la tienes en "+asig1.getNombre());
     }else if(media2>media1){
     System.out.println("La mejor nota la tienes en "+asig2.getNombre());
     
     
     }else{System.out.println("Sacaste la misma nota en las dos asignaturas");}
    }

}
