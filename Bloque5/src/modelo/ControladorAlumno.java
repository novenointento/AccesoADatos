/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import PaqueteLeer.LeerTeclado;

/**
 *
 * @author gnord
 */
public class ControladorAlumno {
   private Alumno alumno1;
   private Asignatura asig1;
   private Asignatura asig2;
   
   
   public void crearalumno(){
       
       System.out.println("Introduzca nombre del alumno");
       alumno1.setNombre(LeerTeclado.leerCadena());
   
       System.out.println("Introduzca nombre de la primera asignatura");
   asig1.setNombre(LeerTeclado.leerCadena());
       System.out.println("Introduzca nota de la 1ª evaluacion");
       asig1.setEval1(LeerTeclado.leerDouble());
       System.out.println("Introduzca nota de la 2ª evaluacion");
       asig1.setEval2(LeerTeclado.leerDouble());
   System.out.println("Introduzca nota de la 3ª evaluacion");
       asig1.setEval3(LeerTeclado.leerDouble());
   
   
    System.out.println("Introduzca nombre de la segunda asignatura");
   asig2.setNombre(LeerTeclado.leerCadena());
       System.out.println("Introduzca nota de la 1ª evaluacion");
       asig1.setEval1(LeerTeclado.leerDouble());
       System.out.println("Introduzca nota de la 2ª evaluacion");
       asig2.setEval2(LeerTeclado.leerDouble());
   System.out.println("Introduzca nota de la 3ª evaluacion");
       asig2.setEval3(LeerTeclado.leerDouble());
   
   }
   
   public void calcularMedia(){
       System.out.println("La nota media del curso es "+( alumno1.getAsig1().media()+alumno1.getAsig2().media())/2.0);

   }
}
